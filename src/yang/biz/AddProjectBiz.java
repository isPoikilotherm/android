package yang.biz;

public interface AddProjectBiz {
	
	boolean AddProject(Integer user_id,String project_name,String direction,String end_time,Integer can_answer);

}
