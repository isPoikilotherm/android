package yang.biz;

import java.util.List;

import yang.vo.ProjectVO;

public interface ProjectBiz {
	
	List<ProjectVO> SelectByUserId(int userId);
	List<ProjectVO> SelectByProjectName (String projectName);
	boolean AddProject(int user_id, String name, String direction,String end_time);
	boolean DeleteProject(int project_id);
	boolean UpdateProject(int project_id,String name,String direction,String end_time);

}
