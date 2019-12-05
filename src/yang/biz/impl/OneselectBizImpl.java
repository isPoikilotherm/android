package yang.biz.impl;

import java.util.List;

import yang.biz.OneselectBiz;
import yang.dao.OneselectDao;
import yang.dao.impl.OneselectDaoImpl;
import yang.vo.OneselectVO;

public class OneselectBizImpl implements OneselectBiz {
	private OneselectDao dao;
	
	
	 public OneselectBizImpl() {
			super();
			dao=new OneselectDaoImpl();
		}

	@Override
	public boolean AddOneselect(Integer project_id, String question_name, String option_a, String option_b,
			String option_c, String option_d) {
		if (this.dao.InsertOneselect(project_id, question_name, option_a, option_b, option_c, option_d)==1) {
			return true;
			
		}
		return false;
	}

	@Override
	public List<OneselectVO> SelectByProjectId(int project_id) {
		
		return this.dao.SelectByProjectId(project_id);
	}

	@Override
	public List<OneselectVO> SelectByPQuestionId(int question_id) {
		
		 return this.dao.SelectByPQuestionId(question_id);
	}

	@Override
	public boolean DeleteOneselect(int question_id) {
		if (this.dao.DeleteOneselect(question_id)>0) {
			return true;
			
		}
		return false;
	}

	@Override
	public boolean UpdateOneselect(int question_id, String question_name, String option_a, String option_b,
			String option_c, String option_d) {
		
		if (this.dao.UpdateOneselect(question_id, question_name, option_a, option_b, option_c, option_d)>0) {
			return true;
			
		}
		return false;
	}

	

}
