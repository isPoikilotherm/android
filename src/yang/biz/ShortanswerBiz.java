package yang.biz;

import java.util.List;

import yang.vo.ShortanswerVO;

public interface ShortanswerBiz {

    boolean AddShortanswer(Integer project_id,String question_name);
	
	List<ShortanswerVO> SelectByProjectId (int project_id);
	
	boolean DeleteShortanswer(int question_id);
	boolean UpdateShortanswer(int question_id,String question_name);
	
}
