package yang.biz.impl;

import yang.biz.AddProjectBiz;
import yang.dao.AddProjectDao;
import yang.dao.impl.AddProjectDaoImpl;
import yang.vo.ProjectVO;

public class AddProjectBizImpl implements AddProjectBiz {
	private AddProjectDao dao;
	
	public AddProjectBizImpl(){
		super();
		dao=new AddProjectDaoImpl();
	}

	@Override
	public boolean AddProject(Integer user_id, String project_name, String direction, String end_time,
			Integer can_answer) {
		ProjectVO pVo=this.dao.SelectByName(project_name);
		if (pVo== null || pVo.equals("null")) {
		this.dao.InsertProject(user_id, project_name, direction, end_time, can_answer);
		return  true;
		}
		return false;
	}

}
