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

public class SelectOneQuestionByQuestionIdServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
    private List<OneselectVO> list_oVos;
	private OneselectBiz oneselectBiz;
	public SelectOneQuestionByQuestionIdServlet(){
		super();  
		oneselectBiz=new OneselectBizImpl();
	}
	
	
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doPost(req, resp);
	   }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
				
				
				Integer question_id =Integer.valueOf(request.getParameter("question_id"));
				list_oVos=oneselectBiz.SelectByPQuestionId(question_id);	
				
			               JSONArray json = new JSONArray(); 
			           json = JSONArray.fromObject(list_oVos);
				   response.getWriter().write(json.toString());
					
		 }
	
	
	

}
