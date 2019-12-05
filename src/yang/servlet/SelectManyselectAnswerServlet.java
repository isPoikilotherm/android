package yang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import yang.dao.ManyselectDao;
import yang.dao.impl.ManyselectDaoImpl;
import yang.vo.ManyselectAnswerVO;

public class SelectManyselectAnswerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private List<ManyselectAnswerVO> list_mManyselectAnswerVOs;
	private ManyselectDao dao;
	public SelectManyselectAnswerServlet() {
		super();
		dao=new ManyselectDaoImpl();
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
				list_mManyselectAnswerVOs=dao.selectManyselectAnswer(question_id);
				// System.out.println("查询成功");
				
			               JSONArray json = new JSONArray(); 
			           json = JSONArray.fromObject(list_mManyselectAnswerVOs);
				   response.getWriter().write(json.toString());
				  // System.out.println("发送成功");
				  // System.out.println(json);
				   //System.out.println("danxuan");
					
		 }
	

}
