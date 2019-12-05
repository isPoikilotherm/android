package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.dao.ModifyPswDao;
import yang.dao.impl.ModifyPswDaoImpl;

public class ModifyPetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModifyPswDao dao;
	
	public ModifyPetNameServlet() {
		super();
		dao=new ModifyPswDaoImpl();
	}

	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	   }
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   	
		   	request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				
				String username = request.getParameter("username");
				String petname=request.getParameter("petname");
				
				
				int  n=dao.ModifyPetName(username, petname);
				if(n>0){
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
