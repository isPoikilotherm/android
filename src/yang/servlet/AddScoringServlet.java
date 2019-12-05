package yang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import yang.biz.ScoringBiz;
import yang.biz.impl.ScoringBizImpl;

public class AddScoringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScoringBiz scoringBiz;
	public AddScoringServlet() {
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
			
			Integer project_id =Integer.valueOf(request.getParameter("project_id"));
			String question_name = request.getParameter("scoring_name");
			
			
			boolean type=false;
			boolean tag=scoringBiz.AddScoring(project_id, question_name);
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
