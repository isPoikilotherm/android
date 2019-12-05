package yang.dao;

import java.util.List;

import yang.vo.ManyselectAnswerVO;
import yang.vo.ManyselectVO;

public interface ManyselectDao {
	
	
	int InsertManyselect(Integer project_id,
			String question_name,
			String option_a,
			String option_b,
			String option_c,
			String option_d);
	
	List<ManyselectVO> SelectByProjectId (int project_id);
	List<ManyselectVO> SelectByPQuestionId(int question_id);
	int DeleteManyselect(int question_id);
	int DeleteManyselects(int project_id);
	int UpdateManyselect(int question_id,String question_name,
			String option_a,
			String option_b,
			String option_c,
			String option_d);
	
	//存入结果
		int InsertManyselectAnswer(int question_id);
		int UpdateManyselectAnswerA(int question_id);
		int UpdateManyselectAnswerB(int question_id);
		int UpdateManyselectAnswerC(int question_id);
		int UpdateManyselectAnswerD(int question_id);
	
	//查询结果
	List<ManyselectAnswerVO> selectManyselectAnswer(int question_id);

}
