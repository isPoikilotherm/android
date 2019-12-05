package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.ScoringBiz;
import yang.biz.impl.ScoringBizImpl;

public class UpdateScoringServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ScoringBiz scoringBiz;
	public UpdateScoringServlet() {
		super();
		scoringBiz=new ScoringBizImpl();
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
			String question_name=request.getParameter("question_name");
			
			boolean type=false;
			boolean tag=scoringBiz.UpdateScoring(question_id, question_name);
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
