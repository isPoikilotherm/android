package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.ProjectBiz;
import yang.biz.impl.ProjectBizImpl;

public class UpdateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectBiz projectBiz;
	public UpdateProjectServlet() {
		super();
		projectBiz=new ProjectBizImpl();
	}
	
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	   }
	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   	
		   	request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				Integer project_id =Integer.valueOf(request.getParameter("project_id"));
				String project_name = request.getParameter("project_name");
				String direction=request.getParameter("direction");
				String end_time=request.getParameter("end_time");
				
				
				boolean type=false;
				boolean tag=projectBiz.UpdateProject(project_id, project_name, direction, end_time);
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
