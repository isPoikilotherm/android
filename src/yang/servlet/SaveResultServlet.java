package yang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import yang.biz.ManyselectBiz;
import yang.biz.OneselectBiz;
import yang.biz.ScoringBiz;
import yang.biz.ShortanswerBiz;
import yang.biz.impl.ManyselectBizImpl;
import yang.biz.impl.OneselectBizImpl;
import yang.biz.impl.ScoringBizImpl;
import yang.biz.impl.ShortanswerBizImpl;
import yang.dao.ManyselectDao;
import yang.dao.OneselectDao;
import yang.dao.ScoringDao;
import yang.dao.ShortanswerDao;
import yang.dao.impl.ManyselectDaoImpl;
import yang.dao.impl.OneselectDaoImpl;
import yang.dao.impl.ProjectDaoImpl;
import yang.dao.impl.ScoringDaoImpl;
import yang.dao.impl.ShortanswerDaoImpl;
import yang.vo.ManyselectAnswerVO;
import yang.vo.OneselectAnswerVO;
import yang.vo.ScoringAnswerVO;
import yang.vo.ShortanswerAnswerVO;

public class SaveResultServlet extends HttpServlet {
	
	private OneselectDao mOneselectDao;
	private ManyselectDao mManyselectDao;
	private ScoringDao mScoringDao;
	private ShortanswerDao mShortanswerDao;
	
	public SaveResultServlet() {
		super();
		mOneselectDao=new OneselectDaoImpl();
		mManyselectDao=new ManyselectDaoImpl();
		mScoringDao=new ScoringDaoImpl();
		mShortanswerDao=new ShortanswerDaoImpl();
	}
	
	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String questionnaire=request.getParameter("data");
		
		
		
		JSONObject jsonObject=JSONObject.fromObject(questionnaire);
		Object oneselect = jsonObject.get("oneselect");
		Object manyselect = jsonObject.get("manyselect");
		Object scoring = jsonObject.get("scoring");
		Object shortanswer = jsonObject.get("shortanswer");
		
		//System.out.println(manyselect.toString());
		//System.out.println(oneselect.toString());
		JSONArray oneArray = JSONArray.fromObject(oneselect.toString());
		for(Object item:oneArray) {
			Map<?, ?> qua_one = (Map<?, ?>) item;
			String quaId = (String) qua_one.get("questionId");
		    int question_id=Integer.valueOf(quaId);
			String answer = (String) qua_one.get("answer");
			List<OneselectAnswerVO> mOneselectAnswerVOs=mOneselectDao.selectOneselectAnswer(question_id);
			if (mOneselectAnswerVOs.size()==0) {
				mOneselectDao.InsertOneselectAnswer(question_id);
			}
			if (answer.equals("a")) {
				mOneselectDao.UpdateOneselectAnswerA(question_id);
			}else if (answer.equals("b")) {
				mOneselectDao.UpdateOneselectAnswerB(question_id);
				
			}else if (answer.equals("c")) {
				mOneselectDao.UpdateOneselectAnswerC(question_id);
				
			}else if (answer.equals("d")) {
				mOneselectDao.UpdateOneselectAnswerD(question_id);
				
			}
		}
		
		JSONArray manyArray = JSONArray.fromObject(manyselect.toString());
		for(Object item:manyArray) {
			Map<?,?> qua_many = (Map<?,?>) item;
			String quaId = (String) qua_many.get("questionId");
			int question_id=Integer.valueOf(quaId);
			JSONArray answer = (JSONArray) qua_many.get("answer");
			List<ManyselectAnswerVO> mManyselectAnswerVOs=mManyselectDao.selectManyselectAnswer(question_id);
			if (mManyselectAnswerVOs.size()==0) {
				mManyselectDao.InsertManyselectAnswer(question_id);	
			}
			for (int i = 0; i < answer.size(); i++) {
				String answer1=(String) answer.get(i);
				if (answer1=="a"||answer1.equals("a")) {
					mManyselectDao.UpdateManyselectAnswerA(question_id);					
				}else if (answer1=="b"||answer1.equals("b")) {
					mManyselectDao.UpdateManyselectAnswerB(question_id);			
				}else if (answer1=="c"||answer1.equals("c")) {
					mManyselectDao.UpdateManyselectAnswerC(question_id);			
				}else if (answer1=="d"||answer1.equals("d")) {
					mManyselectDao.UpdateManyselectAnswerD(question_id);			
				}
			}			
		}
		
		
			JSONArray scoringArray = JSONArray.fromObject(scoring.toString());
			for(Object item:scoringArray) {
				Map<?, ?> qua_scoring = (Map<?, ?>) item;
				String quaId = (String) qua_scoring.get("questionId");
				int question_id=Integer.valueOf(quaId);
				String answer = (String) qua_scoring.get("answer");
				List<ScoringAnswerVO> mScoringAnswerVOs=mScoringDao.selectScoringAnswer(question_id);
				if (mScoringAnswerVOs.size()==0) {
					mScoringDao.InsertScoringAnswer(question_id);
				}
				if (answer.equals("1")) {
					mScoringDao.UpdateScoringAnswerA(question_id);
				}else if (answer.equals("2")) {
					mScoringDao.UpdateScoringAnswerB(question_id);
					
				}else if (answer.equals("3")) {
					mScoringDao.UpdateScoringAnswerC(question_id);
					
				}else if (answer.equals("4")) {
					mScoringDao.UpdateScoringAnswerD(question_id);
					
				}else if (answer.equals("5")) {
					mScoringDao.UpdateScoringAnswerE(question_id);
					
				}
			}
			
			JSONArray shArray = JSONArray.fromObject(shortanswer.toString());
			for(Object item:shArray) {
				Map<?, ?> qua_sh = (Map<?, ?>) item;
				String quaId = (String) qua_sh.get("questionId");
				int question_id=Integer.valueOf(quaId);
				String answer = (String) qua_sh.get("answer");
				mShortanswerDao.InsertShortanswerAnswer(question_id, answer);								
			}
		
			JSONObject json = new JSONObject();
			json.put("stats","ok");
			response.getWriter().write(json.toString());
		
		
		
		
	}
	
	
	
}



