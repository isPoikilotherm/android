package yang.biz;

import java.util.List;

import yang.vo.OneselectVO;

public interface OneselectBiz {

	
	
	boolean AddOneselect(Integer project_id,
			String question_name,
			String option_a,
			String option_b,
			String option_c,
			String option_d);
	
	List<OneselectVO> SelectByProjectId (int project_id);
	List<OneselectVO> SelectByPQuestionId(int question_id);
	boolean DeleteOneselect(int question_id);
	boolean UpdateOneselect(int question_id,String question_name,
			String option_a,
			String option_b,
			String option_c,
			String option_d);
	
}
