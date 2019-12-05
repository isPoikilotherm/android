package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.OneselectBiz;
import yang.biz.ProjectBiz;
import yang.biz.impl.OneselectBizImpl;
import yang.biz.impl.ProjectBizImpl;
import yang.dao.ManyselectDao;
import yang.dao.OneselectDao;
import yang.dao.ScoringDao;
import yang.dao.ShortanswerDao;
import yang.dao.impl.ManyselectDaoImpl;
import yang.dao.impl.OneselectDaoImpl;
import yang.dao.impl.ScoringDaoImpl;
import yang.dao.impl.ShortanswerDaoImpl;

public class DeleteProjectbyIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectBiz projectBiz;
	private OneselectDao mOneselectDao;
	private ManyselectDao mManyselectDao;
	private ScoringDao mScoringDao;
	private ShortanswerDao mShortanswerDao;
	
	
	
	public DeleteProjectbyIdServlet() {
		super();
		projectBiz=new ProjectBizImpl();
		mOneselectDao=new OneselectDaoImpl();
		mManyselectDao=new ManyselectDaoImpl();
		mScoringDao=new ScoringDaoImpl();
		mShortanswerDao=new ShortanswerDaoImpl();
		
	}
	
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	   }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	
	   	request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			Integer project_id =Integer.valueOf(request.getParameter("project_id"));
			
			
			
			boolean tag=projectBiz.DeleteProject(project_id);
			if (tag==true) {
				//删除对应的四种题目
				int n1=mOneselectDao.DeleteOneselects(project_id);
				int n2=mManyselectDao.DeleteManyselects(project_id);
				int n3=mScoringDao.DeleteScorings(project_id);
				int n4=mShortanswerDao.DeleteShortanswers(project_id);
				
				JSONObject json = new JSONObject();
				json.put("msg", tag);
				response.getWriter().write(json.toString());
				
			}else {
				
						JSONObject json = new JSONObject();
						json.put("msg", tag);
						response.getWriter().write(json.toString());
					}
			
				
			}

	
	
	
	
	
	
	
	
	
	
}
