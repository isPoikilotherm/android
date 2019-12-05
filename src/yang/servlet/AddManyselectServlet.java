package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.ManyselectBiz;
import yang.biz.impl.ManyselectBizImpl;

public class AddManyselectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ManyselectBiz manyselectBiz;
	public AddManyselectServlet() {
		super();
		manyselectBiz=new ManyselectBizImpl();		
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
			String question_name = request.getParameter("manyselect_name");
			String option_a=request.getParameter("option_a");
			String option_b=request.getParameter("option_b");
			String option_c=request.getParameter("option_c");
			String option_d=request.getParameter("option_d");
			//System.out.println(question_name);
			
			boolean type=false;
			boolean tag=manyselectBiz.Addmanyselect(project_id, question_name, option_a, option_b, option_c, option_d);
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
