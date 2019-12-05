package yang.dao;

import yang.vo.ProjectVO;

public interface AddProjectDao {
	
	void InsertProject(Integer user_id,String project_name,String direction,String end_time,Integer can_answer);
	ProjectVO SelectByName(String name);

}
