package yang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import yang.biz.ShortanswerBiz;
import yang.biz.impl.ScoringBizImpl;
import yang.biz.impl.ShortanswerBizImpl;
import yang.vo.ShortanswerVO;

public class SelectShortanswerByProjectIdServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private List<ShortanswerVO> list_sVos;
	private ShortanswerBiz shortanswerBiz;
	public SelectShortanswerByProjectIdServlet() {
		super();
		shortanswerBiz=new ShortanswerBizImpl();
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
				list_sVos=shortanswerBiz.SelectByProjectId(project_id);	
				
			               JSONArray json = new JSONArray(); 
			           json = JSONArray.fromObject(list_sVos);
				   response.getWriter().write(json.toString());
					
		 }
	
	
	
}
