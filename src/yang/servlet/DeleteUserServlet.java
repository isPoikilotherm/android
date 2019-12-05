package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.dao.LoginDao;
import yang.dao.impl.LoginDaoImpl;

public class DeleteUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private LoginDao dao;
	
	public DeleteUserServlet() {
		super();
		dao=new LoginDaoImpl();
	}

	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	   }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	
	   	request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String name =request.getParameter("name");
			
			
			
			int  tag=dao.DeleteUser(name);
			if (tag>0) {
					
				JSONObject json = new JSONObject();
				json.put("msg", true);
				response.getWriter().write(json.toString());
				
			}else {
				
				JSONObject json = new JSONObject();
				json.put("msg", false);
				response.getWriter().write(json.toString());
				}
			
				
			}

	
}
