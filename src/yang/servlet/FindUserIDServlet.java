package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.LoginBiz;
import yang.biz.impl.LoginBizImpl;
import yang.vo.UserVO;

public class FindUserIDServlet  extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    
	    private LoginBiz loginBiz;
	    private UserVO userVO;
	    
	    public FindUserIDServlet() {
	        super();
	       
	        loginBiz=new LoginBizImpl();
	        userVO=new UserVO();
	      
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
			userVO=loginBiz.SelectByName(username);	
			JSONObject json = new JSONObject();
			json.put("msg", userVO.getId());
			response.getWriter().write(json.toString());
	    }
			
			
}
