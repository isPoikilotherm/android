package yang.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.ManyselectBiz;
import yang.biz.OneselectBiz;
import yang.biz.ProjectBiz;
import yang.biz.ScoringBiz;
import yang.biz.ShortanswerBiz;
import yang.biz.impl.ManyselectBizImpl;
import yang.biz.impl.OneselectBizImpl;
import yang.biz.impl.ProjectBizImpl;
import yang.biz.impl.ScoringBizImpl;
import yang.biz.impl.ShortanswerBizImpl;
import yang.dao.ProjectDao;
import yang.dao.impl.ProjectDaoImpl;
import yang.vo.ManyselectVO;
import yang.vo.OneselectVO;
import yang.vo.ProjectVO;
import yang.vo.ScoringVO;
import yang.vo.ShortanswerVO;

public class QuestionnaireServlet extends HttpServlet {
	
	private ProjectDao mProjectDao;
	private OneselectBiz mOneselectBiz;
	private ManyselectBiz mManyselectBiz;
	private ScoringBiz mScoringBiz;
	private ShortanswerBiz mShortanswerBiz;
	private ProjectVO mProjectVO;
	private List<OneselectVO> list_oVos;
	private List<ManyselectVO> list_mVos;
	private List<ScoringVO> list_scVos;
	private List<ShortanswerVO> list_shVos;
	SimpleDateFormat mFormat=new SimpleDateFormat("yyyy-MM-dd");
    Date curdate=new Date(System.currentTimeMillis());
    private String time;
	
	public QuestionnaireServlet() {
		super();
		mProjectDao=new ProjectDaoImpl();
		mOneselectBiz=new OneselectBizImpl();
		mManyselectBiz=new ManyselectBizImpl();
		mScoringBiz=new ScoringBizImpl();
		mShortanswerBiz=new ShortanswerBizImpl();
	}
	
	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String ID=request.getParameter("id");
		int project_id=Integer.valueOf(ID);

		
		mProjectVO=mProjectDao.SelectByProjectId(project_id);
		list_oVos=mOneselectBiz.SelectByProjectId(project_id);
		list_mVos=mManyselectBiz.SelectByProjectId(project_id);
		list_scVos=mScoringBiz.SelectByProjectId(project_id);
		list_shVos=mShortanswerBiz.SelectByProjectId(project_id);
		
		time=mFormat.format(curdate);
		int i=mProjectVO.getEnd_time().compareTo(time);
	if (i<0) {
		JSONObject json = new JSONObject();
		json.put("错误", "连接已失效！");
		response.getWriter().write(json.toString());
		
	}else {
		
		// request.setAttribute("mProjectVO", mProjectVO);
				request.setAttribute("name",mProjectVO.getName());
				request.setAttribute("direction",mProjectVO.getDirection());
				request.setAttribute("time",mProjectVO.getEnd_time());
				 request.setAttribute("list_oVos", list_oVos);
				 request.setAttribute("oVos_size", list_oVos.size());
				 request.setAttribute("list_mVos", list_mVos);
				 request.setAttribute("mVos_size", list_mVos.size());
				 request.setAttribute("list_scVos", list_scVos);
				 request.setAttribute("scVos_size", list_scVos.size());
				 
				 request.setAttribute("list_shVos", list_shVos);
				 request.setAttribute("shVos_size", list_shVos.size());
				 request.getRequestDispatcher("questionnaire.jsp").forward(request, response);
	}
		
	
	
	}

	
	
	
	
	
	
}
