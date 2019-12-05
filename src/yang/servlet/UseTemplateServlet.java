package yang.servlet;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import yang.biz.AddProjectBiz;
import yang.biz.ManyselectBiz;
import yang.biz.OneselectBiz;
import yang.biz.ProjectBiz;
import yang.biz.ScoringBiz;
import yang.biz.ShortanswerBiz;
import yang.biz.impl.AddProjectBizImpl;
import yang.biz.impl.ManyselectBizImpl;
import yang.biz.impl.OneselectBizImpl;
import yang.biz.impl.ProjectBizImpl;
import yang.biz.impl.ScoringBizImpl;
import yang.biz.impl.ShortanswerBizImpl;
import yang.dao.TemplateDao;
import yang.dao.impl.TemplateDaoImpl;
import yang.vo.ManyselectVO;
import yang.vo.OneselectVO;
import yang.vo.ProjectVO;
import yang.vo.ScoringVO;
import yang.vo.ShortanswerVO;
import yang.vo.TemplateVO;

public class UseTemplateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//存储从模板库中查询的四种题目的list
	private TemplateVO tVo;
	private List<OneselectVO> list_oVos;
	private List<ManyselectVO> list_mVos;
	private List<ScoringVO> list_scVos;
	private List<ShortanswerVO> list_shVos;
	
	
	//模板Dao和五个项目Biz
	private TemplateDao dao;
	private AddProjectBiz mAddProjectBiz;
	private ProjectBiz mProjectBiz;
	private OneselectBiz mOneselectBiz;
	private ManyselectBiz mManyselectBiz;
	private ScoringBiz mScoringBiz;
	private ShortanswerBiz mShortanswerBiz;
	
	
	
	//初始化
	public UseTemplateServlet() {
		super();
		dao=new TemplateDaoImpl();
		mAddProjectBiz=new AddProjectBizImpl();
		mProjectBiz=new ProjectBizImpl();
		mOneselectBiz=new OneselectBizImpl();
		mManyselectBiz=new ManyselectBizImpl();
		mScoringBiz=new ScoringBizImpl();
		mShortanswerBiz=new ShortanswerBizImpl();
		}
	
	
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	   }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
				
				
				Integer template_id =Integer.valueOf(request.getParameter("template_id"));
				Integer user_id =Integer.valueOf(request.getParameter("user_id"));
				Integer can_answer =Integer.valueOf(request.getParameter("can_answer"));
			
							
			    tVo=dao.SelectTemplatebyID(template_id);
			    list_oVos=dao.selectTemplateOneselect(template_id);
			    list_mVos=dao.selectTemplateManyselect(template_id);
			    list_scVos=dao.selectTemplateScoring(template_id);
			    list_shVos=dao.selectTemplateShortanswer(template_id);
			    
			    
			    
			    String name=tVo.getTemplate_name();
			    String direction=tVo.getTemplate_direction();
			    Boolean tag1=mAddProjectBiz.AddProject(user_id, name, direction, "2019-06-05", can_answer);
			    
			   if (tag1==true) {
				
			
			    List<ProjectVO> list_pVo=mProjectBiz.SelectByProjectName(name);
			    Integer project_id=list_pVo.get(0).getProject_id();
			    
			    //遍历插入单选
			    for (int i = 0; i < list_oVos.size(); i++) {
			    	String question_name=list_oVos.get(i).getQuestion_name();
			    	String option_a=list_oVos.get(i).getOption_a();
			    	String option_b=list_oVos.get(i).getOption_b();
			    	String option_c=list_oVos.get(i).getOption_c();
			    	String option_d=list_oVos.get(i).getOption_d();
			    	
			    	mOneselectBiz.AddOneselect(project_id, question_name, option_a, option_b, option_c, option_d);
					
				}
			  //遍历插入多选
			    for (int i = 0; i < list_mVos.size(); i++) {
			    	String question_name=list_mVos.get(i).getQuestion_name();
			    	String option_a=list_mVos.get(i).getOption_a();
			    	String option_b=list_mVos.get(i).getOption_b();
			    	String option_c=list_mVos.get(i).getOption_c();
			    	String option_d=list_mVos.get(i).getOption_d();
			    	
			    	mManyselectBiz.Addmanyselect(project_id, question_name, option_a, option_b, option_c, option_d);
					
				}
			    //遍历插入打分
			    for (int i = 0; i < list_scVos.size(); i++) {
			    	String question_name=list_scVos.get(i).getQuestion_name();
			    	
			    	mScoringBiz.AddScoring(project_id, question_name);					
				}
			  //遍历插入简答
			    for (int i = 0; i < list_shVos.size(); i++) {
			    	String question_name=list_shVos.get(i).getQuestion_name();
			    	
			    	mShortanswerBiz.AddShortanswer(project_id, question_name);					
				}
				
			    JSONObject json = new JSONObject();
				json.put("msg", tag1);
				response.getWriter().write(json.toString());
			   }else {
				   JSONObject json = new JSONObject();
					json.put("msg", tag1);
					response.getWriter().write(json.toString());
			}
					
				
//			               JSONArray json = new JSONArray(); 
//			           json = JSONArray.fromObject(list_sVos);
//				   response.getWriter().write(json.toString());
					
		 }

}
