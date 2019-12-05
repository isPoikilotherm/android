package yang.biz.impl;

import java.util.List;

import yang.biz.ShortanswerBiz;
import yang.dao.ShortanswerDao;
import yang.dao.impl.ShortanswerDaoImpl;
import yang.vo.ShortanswerVO;

public class ShortanswerBizImpl implements ShortanswerBiz{
	private ShortanswerDao dao;
	
	public ShortanswerBizImpl() {
		super();
		dao=new ShortanswerDaoImpl();
	}

	@Override
	public boolean AddShortanswer(Integer project_id, String question_name) {
		if (this.dao.InsertShortanswer(project_id, question_name)==1) {
			return true;		
		}
		return false;
	}

	@Override
	public List<ShortanswerVO> SelectByProjectId(int project_id) {
		
		return this.dao.SelectByProjectId(project_id);
	}

	@Override
	public boolean DeleteShortanswer(int question_id) {
		if (this.dao.DeleteShortanswer(question_id)>0) {
			return true;	
		}
		return false;
	}

	@Override
	public boolean UpdateShortanswer(int question_id, String question_name) {
		if (this.dao.UpdateShoranswer(question_id, question_name)>0) {
			return true;	
		}
		return false;
	}

}
