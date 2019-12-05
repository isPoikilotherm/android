package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.AddProjectBiz;
import yang.biz.impl.AddProjectBizImpl;


public class AddProjectServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private AddProjectBiz addProjectBiz;
	public AddProjectServlet(){
		super();
	      
		addProjectBiz=new AddProjectBizImpl();
	}
	
	 @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	   }
	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   	
		   	request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				Integer user_id =Integer.valueOf(request.getParameter("user_id"));
				String project_name = request.getParameter("project_name");
				String direction=request.getParameter("direction");
				String end_time=request.getParameter("end_time");
				Integer can_answer=Integer.valueOf(request.getParameter("can_answer"));
				
				
				boolean type=false;
				boolean tag=addProjectBiz.AddProject(user_id, project_name, direction, end_time, can_answer);
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
