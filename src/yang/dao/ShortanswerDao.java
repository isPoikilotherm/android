package yang.dao;

import java.util.List;

import yang.vo.ShortanswerAnswerVO;
import yang.vo.ShortanswerVO;

public interface ShortanswerDao {
	
	int InsertShortanswer(Integer project_id,String question_name);
	List<ShortanswerVO> SelectByProjectId (int project_id);

	
	int DeleteShortanswer(int question_id);
	int DeleteShortanswers(int project_id);
	int UpdateShoranswer(int question_id,String question_name);
	
	
	//存储结果
	int InsertShortanswerAnswer(int question_id,String answer);
	
	//查询结果
	List<ShortanswerAnswerVO> SelectShortanswerAnswer(int question_id);
}
