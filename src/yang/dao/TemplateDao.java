package yang.dao;

import java.util.List;

import yang.vo.ManyselectVO;
import yang.vo.OneselectVO;
import yang.vo.ScoringVO;
import yang.vo.ShortanswerVO;
import yang.vo.TemplateVO;

public interface TemplateDao {
	
	//查询模板基本信息
	List<TemplateVO> SelecTemplate(); 
	
	//查询单个模板信息（通过ID）
	TemplateVO SelectTemplatebyID(int template_id);
	
	//查询中的单选
	List<OneselectVO> selectTemplateOneselect (int project_id);
	
	
	//查询中的多选
	List<ManyselectVO> selectTemplateManyselect (int project_id);
	
	
	//查询中的打分
	List<ScoringVO> selectTemplateScoring (int project_id);
	
	
	//查询中的简答
	List<ShortanswerVO> selectTemplateShortanswer (int project_id);
	

}
