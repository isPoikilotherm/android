package yang.dao;



import java.util.List;

import yang.vo.ProjectVO;

public interface ProjectDao {
	List<ProjectVO> SelectByUserId (int userId);
	List<ProjectVO> SelectByProjectName (String projectName);
	ProjectVO SelectByProjectId (int project_id);
	
	
	int InsertProject(int user_id,String name,String direction,String end_time);
	int DeleteProject(int project_id);
	int UpdateProject(int project_id,String name,String direction,String end_time);
	
}
