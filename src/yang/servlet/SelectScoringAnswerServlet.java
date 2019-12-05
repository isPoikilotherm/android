package yang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import yang.dao.ScoringDao;
import yang.dao.impl.ScoringDaoImpl;
import yang.vo.ManyselectAnswerVO;
import yang.vo.ScoringAnswerVO;

public class SelectScoringAnswerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private List<ScoringAnswerVO> list_mScoringAnswerVOs;
	private ScoringDao dao;
	public SelectScoringAnswerServlet() {
		super();
		dao=new ScoringDaoImpl();
	}
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);   
	   }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
				
			
				Integer question_id =Integer.valueOf(request.getParameter("question_id"));
				list_mScoringAnswerVOs=dao.selectScoringAnswer(question_id);
			JSONArray json = new JSONArray(); 
			json = JSONArray.fromObject(list_mScoringAnswerVOs);
		     response.getWriter().write(json.toString());
				  
					
		 }
	
	
	
	
	

}
