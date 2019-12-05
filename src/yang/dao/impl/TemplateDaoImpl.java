package yang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yang.dao.TemplateDao;
import yang.util.DBUtil;
import yang.vo.ManyselectVO;
import yang.vo.OneselectVO;
import yang.vo.ProjectVO;
import yang.vo.ScoringVO;
import yang.vo.ShortanswerVO;
import yang.vo.TemplateVO;

public class TemplateDaoImpl implements TemplateDao {
	private DBUtil db;

	@Override
	public List<TemplateVO> SelecTemplate() {
		db = new DBUtil();
		ResultSet rs = null;
		List<TemplateVO> list_mTemplateVOs=new ArrayList<TemplateVO>();
		String sql = "select * from template";
		
		try {
			rs = db.query(sql);
			while (rs.next()) {
				TemplateVO tVo = new TemplateVO();
				tVo.setTemplate_id(rs.getInt("template_id"));
				tVo.setTemplate_name(rs.getString("template_name"));
				tVo.setTemplate_direction(rs.getString("template_direction"));
				list_mTemplateVOs.add(tVo);
			}
			return list_mTemplateVOs;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				db.closeAll();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<OneselectVO> selectTemplateOneselect(int project_id) {
		

		db = new DBUtil();
		ResultSet rs = null;
		List<OneselectVO> list_oVO=new ArrayList<OneselectVO>();
		String sql = "select * from template_oneselect where project_id='" + project_id + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				OneselectVO oVO = new OneselectVO();
				oVO.setQuestion_id(rs.getInt("question_id"));
				oVO.setProject_id(rs.getInt("project_id"));
				oVO.setQuestion_name(rs.getString("question_name"));
				oVO.setOption_a(rs.getString("option_a"));
				oVO.setOption_b(rs.getString("option_b"));
				oVO.setOption_c(rs.getString("option_c"));
				oVO.setOption_d(rs.getString("option_d"));					
				list_oVO.add(oVO);
			}
			return list_oVO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				db.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return null;
	}

	@Override
	public List<ManyselectVO> selectTemplateManyselect(int project_id) {
		db = new DBUtil();
		ResultSet rs = null;
		List<ManyselectVO> list_mVO=new ArrayList<ManyselectVO>();
		String sql = "select * from template_manyselect where project_id='" + project_id + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				ManyselectVO mVO = new ManyselectVO();
				mVO.setQuestion_id(rs.getInt("question_id"));
				mVO.setProject_id(rs.getInt("project_id"));
				mVO.setQuestion_name(rs.getString("question_name"));
				mVO.setOption_a(rs.getString("option_a"));
				mVO.setOption_b(rs.getString("option_b"));
				mVO.setOption_c(rs.getString("option_c"));
				mVO.setOption_d(rs.getString("option_d"));					
				list_mVO.add(mVO);
			}
			return list_mVO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				db.closeAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public List<ScoringVO> selectTemplateScoring(int project_id) {
		db = new DBUtil();
		ResultSet rs = null;
		List<ScoringVO> list_sVO=new ArrayList<ScoringVO>();
		String sql = "select * from template_scoring where project_id='" + project_id + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				ScoringVO sVO = new ScoringVO();
				sVO.setQuestion_id(rs.getInt("question_id"));
				sVO.setProject_id(rs.getInt("project_id"));
				sVO.setQuestion_name(rs.getString("question_name"));		
				list_sVO.add(sVO);
			}
			return list_sVO;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				db.closeAll();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		
		return null;
	}

	@Override
	public List<ShortanswerVO> selectTemplateShortanswer(int project_id) {
		db = new DBUtil();
		ResultSet rs = null;
		List<ShortanswerVO> list_sVO=new ArrayList<ShortanswerVO>();
		String sql = "select * from template_shortanswer where project_id='" + project_id + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				ShortanswerVO sVO = new ShortanswerVO();
				sVO.setQuestion_id(rs.getInt("question_id"));
				sVO.setProject_id(rs.getInt("project_id"));
				sVO.setQuestion_name(rs.getString("question_name"));		
				list_sVO.add(sVO);
			}
			return list_sVO;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				db.closeAll();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public TemplateVO SelectTemplatebyID(int template_id) {

		db = new DBUtil();
		ResultSet rs = null;
		TemplateVO tVo=new TemplateVO();
		String sql = "select * from template where template_id=?";
		
		try {
			rs = db.query(sql,template_id);
			while (rs.next()) {
				tVo.setTemplate_id(rs.getInt("template_id"));
				tVo.setTemplate_name(rs.getString("template_name"));
				tVo.setTemplate_direction(rs.getString("template_direction"));
			}
			return tVo;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				db.closeAll();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		

		return null;
	}

}
