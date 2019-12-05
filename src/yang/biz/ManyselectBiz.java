package yang.biz;

import java.util.List;

import yang.vo.ManyselectVO;

public interface ManyselectBiz {
	
	
	boolean Addmanyselect(Integer project_id,
			String question_name,
			String option_a,
			String option_b,
			String option_c,
			String option_d);
	
	List<ManyselectVO> SelectByProjectId (int project_id);
	List<ManyselectVO> SelectByPQuestionId(int question_id);
	boolean DeleteManyselect(int question_id);
	boolean UpdateManyselect(int question_id,String question_name,
			String option_a,
			String option_b,
			String option_c,
			String option_d);

}
