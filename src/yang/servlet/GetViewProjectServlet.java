package yang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.*;
import yang.biz.ProjectBiz;
import yang.biz.impl.ProjectBizImpl;
import yang.vo.ProjectVO;

public class GetViewProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<ProjectVO> list_proProjectVO;
	private ProjectBiz projectBiz;
	
	public GetViewProjectServlet() {
		super();
		projectBiz=new ProjectBizImpl();
		list_proProjectVO=new ArrayList<ProjectVO>();
	}
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        doPost(req, resp);
	    }
	 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	 request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

			int user_id =Integer.parseInt(request.getParameter("user_id"));
			list_proProjectVO=projectBiz.SelectByUserId(user_id);
		
		
		JSONArray json = new JSONArray(); 
		json = JSONArray.fromObject(list_proProjectVO);

				response.getWriter().write(json.toString());
				
		
	 }

}
