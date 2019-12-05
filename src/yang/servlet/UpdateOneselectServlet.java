package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.OneselectBiz;
import yang.biz.impl.OneselectBizImpl;

public class UpdateOneselectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OneselectBiz oneselectBiz;
	public UpdateOneselectServlet() {
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
				String question_name = request.getParameter("question_name");
				String option_a=request.getParameter("option_a");
				String option_b=request.getParameter("option_b");
				String option_c=request.getParameter("option_c");
				String option_d=request.getParameter("option_d");
				
				
				boolean type=false;
				boolean tag=oneselectBiz.UpdateOneselect(question_id, question_name, option_a, option_b, option_c, option_d);
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
