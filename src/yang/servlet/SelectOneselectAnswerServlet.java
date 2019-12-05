package yang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import yang.dao.OneselectDao;
import yang.dao.impl.OneselectDaoImpl;
import yang.vo.OneselectAnswerVO;

public class SelectOneselectAnswerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private List<OneselectAnswerVO> list_vOneselectAnswerVOs;
	private OneselectDao dao;
	public SelectOneselectAnswerServlet() {
		super();  
		dao=new OneselectDaoImpl();
	}
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);   
	   }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
				
			//System.out.println("接收之前");
				Integer question_id =Integer.valueOf(request.getParameter("question_id"));
				// System.out.println("接收成功");
				list_vOneselectAnswerVOs=dao.selectOneselectAnswer(question_id);
				// System.out.println("查询成功");
				
			               JSONArray json = new JSONArray(); 
			           json = JSONArray.fromObject(list_vOneselectAnswerVOs);
				   response.getWriter().write(json.toString());
				// System.out.println("1111");
				  // System.out.println(json);
				   //System.out.println("danxuan");
					
		 }
	

}
