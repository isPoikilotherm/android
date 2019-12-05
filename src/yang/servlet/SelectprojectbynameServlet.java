package yang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import yang.biz.ProjectBiz;
import yang.biz.impl.ProjectBizImpl;
import yang.vo.ProjectVO;

public class SelectprojectbynameServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private List<ProjectVO> list_proProjectVO;
	private ProjectBiz projectBiz;
	
	public SelectprojectbynameServlet() {
		super();
		projectBiz=new ProjectBizImpl();
		list_proProjectVO=new ArrayList<ProjectVO>();
	}

	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
 request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
		
		
		String project_name =request.getParameter("project_name");
		list_proProjectVO=projectBiz.SelectByProjectName(project_name);	
		
	
	               JSONArray json = new JSONArray(); 
	           json = JSONArray.fromObject(list_proProjectVO);

			   response.getWriter().write(json.toString());
			
	
 }
	
	
	
}
