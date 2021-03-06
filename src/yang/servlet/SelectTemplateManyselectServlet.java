package yang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import yang.dao.TemplateDao;
import yang.dao.impl.TemplateDaoImpl;
import yang.vo.ManyselectVO;

public class SelectTemplateManyselectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ManyselectVO> list_mVos;
	private TemplateDao dao;
	public SelectTemplateManyselectServlet() {
		super();
		dao=new TemplateDaoImpl();
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
				list_mVos=dao.selectTemplateManyselect(project_id);	
				
			               JSONArray json = new JSONArray(); 
			           json = JSONArray.fromObject(list_mVos);
				   response.getWriter().write(json.toString());
					
		}
}
