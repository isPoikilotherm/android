package yang.biz.impl;

import java.util.List;

import yang.biz.ManyselectBiz;
import yang.dao.ManyselectDao;
import yang.dao.impl.ManyselectDaoImpl;
import yang.vo.ManyselectVO;

public class ManyselectBizImpl implements ManyselectBiz {
	private ManyselectDao dao;
	
	 public ManyselectBizImpl() {
			super();
			dao=new ManyselectDaoImpl();
		}
	

	@Override
	public boolean Addmanyselect(Integer project_id, String question_name, String option_a, String option_b,
			String option_c, String option_d) {
		
		
		
		if (this.dao.InsertManyselect(project_id, question_name, option_a, option_b, option_c, option_d)==1) {
			return true;
			
		}
		return false;
	}

	@Override
	public List<ManyselectVO> SelectByProjectId(int project_id) {
		
		return this.dao.SelectByProjectId(project_id);
	}

	@Override
	public List<ManyselectVO> SelectByPQuestionId(int question_id) {
		
		return this.dao.SelectByPQuestionId(question_id);
	}


	@Override
	public boolean DeleteManyselect(int question_id) {
		if (this.dao.DeleteManyselect(question_id)>0) {
			return true;
			
		}
		return false;
	}


	@Override
	public boolean UpdateManyselect(int question_id, String question_name, String option_a, String option_b,
			String option_c, String option_d) {
		if (this.dao.UpdateManyselect(question_id, question_name, option_a, option_b, option_c, option_d)>0) {
			return true;
			
		}
		return false;
	}

}
