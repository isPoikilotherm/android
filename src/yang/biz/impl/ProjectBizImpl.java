package yang.biz.impl;

import java.util.List;

import yang.biz.ProjectBiz;
import yang.dao.ProjectDao;
import yang.dao.impl.ProjectDaoImpl;
import yang.vo.ProjectVO;

public class ProjectBizImpl implements ProjectBiz {
	private ProjectDao dao;
	
	 public ProjectBizImpl() {
		super();
		dao=new ProjectDaoImpl();
	}

	@Override
	public List<ProjectVO> SelectByUserId(int userId) {
		
		return this.dao.SelectByUserId(userId);
	}

	@Override
	public boolean AddProject(int user_id, String name, String direction, String end_time) {
		if (this.dao.InsertProject(user_id, name, direction, end_time)==1) {
			return true;
		}
		return false;
	}

	@Override
	public List<ProjectVO> SelectByProjectName(String projectName) {
		
		return this.dao.SelectByProjectName(projectName);
		
	}

	@Override
	public boolean DeleteProject(int project_id) {
		
		if (this.dao.DeleteProject(project_id)>0) {
			return true;
			
		}
		return false;
	}

	@Override
	public boolean UpdateProject(int project_id, String name, String direction, String end_time) {
		if (this.dao.UpdateProject(project_id, name, direction, end_time)>0) {
			return true;		
		}
		return false;
	}


}
