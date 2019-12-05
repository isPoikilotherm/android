package yang.dao;

import java.util.List;

import yang.vo.ScoringAnswerVO;
import yang.vo.ScoringVO;

public interface ScoringDao {

	int InsertScoring (Integer project_id,String question_name);
	
	List<ScoringVO> SelectByProjectId (int project_id);
	int DeleteScoring(int question_id);
	int DeleteScorings(int project_id);
	int UpdateScoring(int question_id,String question_name);
	

	
	//存入结果
		int InsertScoringAnswer(int question_id);
		int UpdateScoringAnswerA(int question_id);
		int UpdateScoringAnswerB(int question_id);
		int UpdateScoringAnswerC(int question_id);
		int UpdateScoringAnswerD(int question_id);
		int UpdateScoringAnswerE(int question_id);
	
	
	
	//查询结果
	List<ScoringAnswerVO> selectScoringAnswer(int question_id);
}
