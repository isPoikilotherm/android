package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.ShortanswerBiz;
import yang.biz.impl.ShortanswerBizImpl;

public class DeleteShortanswerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ShortanswerBiz shortanswerBiz;
	public DeleteShortanswerServlet() {
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
			
			Integer question_id =Integer.valueOf(request.getParameter("question_id"));
			
			
			boolean type=false;
			boolean tag=shortanswerBiz.DeleteShortanswer(question_id);
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
