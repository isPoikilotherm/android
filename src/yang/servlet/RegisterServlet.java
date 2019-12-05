package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.LoginBiz;
import yang.biz.impl.LoginBizImpl;

public class RegisterServlet extends HttpServlet{
	
    private static final long serialVersionUID = 1L;
    
    private LoginBiz loginBiz;
   // private UserVO userVO;
  
   public RegisterServlet() {
       super();
      
       loginBiz=new LoginBizImpl();
      
     
   }
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
   }
   
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	
   	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("ID");
		String pwd = request.getParameter("PW");
		//System.out.println(username);
		boolean type=false;
		boolean tag=loginBiz.AddUser(username, pwd);
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
