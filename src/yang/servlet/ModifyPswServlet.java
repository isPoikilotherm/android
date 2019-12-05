package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.ModifyPswBiz;
import yang.biz.impl.ModifyPswBizImpl;

public class ModifyPswServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
private ModifyPswBiz modifyPswBiz;
	
	public ModifyPswServlet(){
		super();
		modifyPswBiz=new ModifyPswBizImpl();
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
				String psw=request.getParameter("psw");

				
				
				boolean type=false;
				boolean tag=modifyPswBiz.ModifyPsw(username, psw);
				if(tag==false){
					JSONObject json = new JSONObject();
					json.put("msg", type);
					response.getWriter().write(json.toString());
				}else {
					type=true;
							JSONObject json = new JSONObject();
							json.put("msg", type);
							response.getWriter().write(json.toString());
						}
				
					
				}


}
