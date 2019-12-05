package yang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import yang.dao.ShortanswerDao;
import yang.dao.impl.ShortanswerDaoImpl;
import yang.vo.ShortanswerAnswerVO;

public class SelectShortanswerAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ShortanswerAnswerVO> mList;
	private ShortanswerDao dao;
	public SelectShortanswerAnswerServlet() {
		super();
		dao=new ShortanswerDaoImpl();
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
				mList=dao.SelectShortanswerAnswer(question_id);
			JSONArray json = new JSONArray(); 
			json = JSONArray.fromObject(mList);
		     response.getWriter().write(json.toString());
		    // System.out.println(json);
				  
					
		 }
	
	

}
