package yang.dao;

import java.util.List;

import yang.vo.OneselectAnswerVO;
import yang.vo.OneselectVO;

public interface OneselectDao {
	
	int InsertOneselect(Integer project_id,
			String question_name,
			String option_a,
			String option_b,
			String option_c,
			String option_d);
	
	List<OneselectVO> SelectByProjectId (int project_id);
	List<OneselectVO> SelectByPQuestionId(int question_id);
	int DeleteOneselect(int question_id);
	int DeleteOneselects(int project_id);
	int UpdateOneselect(int question_id,
			String question_name,
			String option_a,
			String option_b,
			String option_c,
			String option_d);
	//存入结果
	int InsertOneselectAnswer(int question_id);
	int UpdateOneselectAnswerA(int question_id);
	int UpdateOneselectAnswerB(int question_id);
	int UpdateOneselectAnswerC(int question_id);
	int UpdateOneselectAnswerD(int question_id);
	//查询结果
	List<OneselectAnswerVO> selectOneselectAnswer(int question_id);
}
