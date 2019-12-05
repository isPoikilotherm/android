package yang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import yang.biz.OneselectBiz;
import yang.biz.impl.OneselectBizImpl;
import yang.vo.OneselectVO;

public class SelectOneQuestionByProjectIdServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
    private List<OneselectVO> list_oVos;
	private OneselectBiz oneselectBiz;
	public SelectOneQuestionByProjectIdServlet(){
		super();  
		oneselectBiz=new OneselectBizImpl();
		//System.out.println("访问了");
		
	}

	
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	       
	   }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
				
			//System.out.println("接收之前");
				Integer project_id =Integer.valueOf(request.getParameter("project_id"));
				// System.out.println("接收成功");
				list_oVos=oneselectBiz.SelectByProjectId(project_id);
				// System.out.println("查询成功");
				
			               JSONArray json = new JSONArray(); 
			           json = JSONArray.fromObject(list_oVos);
				   response.getWriter().write(json.toString());
				  // System.out.println("发送成功");
				  // System.out.println(json);
				   //System.out.println("danxuan");
					
		 }
	
	

}
