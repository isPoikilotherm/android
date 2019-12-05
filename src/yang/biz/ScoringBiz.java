package yang.biz;

import java.util.List;
import yang.vo.ScoringVO;

public interface ScoringBiz {

	
	boolean AddScoring(Integer project_id,String question_name);
	
	List<ScoringVO> SelectByProjectId (int project_id);
	
	boolean DeleteScoring(int question_id);
	boolean UpdateScoring(int question_id,String question_name);
}
