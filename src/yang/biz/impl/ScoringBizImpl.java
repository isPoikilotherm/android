package yang.biz.impl;

import java.util.List;

import yang.biz.ScoringBiz;
import yang.dao.ScoringDao;
import yang.dao.impl.ScoringDaoImpl;
import yang.vo.ScoringVO;

public class ScoringBizImpl implements ScoringBiz {
	private ScoringDao dao;
	
	public ScoringBizImpl() {
		
		super();
		dao=new ScoringDaoImpl();
	}

	
	
	@Override
	public boolean AddScoring(Integer project_id, String question_name) {
		if (this.dao.InsertScoring(project_id, question_name)==1) {
			return true;
			
		}else {
			return false;
			
		}
		
	}

	@Override
	public List<ScoringVO> SelectByProjectId(int project_id) {
		
		
		return this.dao.SelectByProjectId(project_id);
	}



	@Override
	public boolean DeleteScoring(int question_id) {
		if (this.dao.DeleteScoring(question_id)>0) {
			return true;
			
		}
		return false;
	}



	@Override
	public boolean UpdateScoring(int question_id, String question_name) {
		if (this.dao.UpdateScoring(question_id, question_name)>0) {
			return true;
			
		}
		return false;
	}

}
