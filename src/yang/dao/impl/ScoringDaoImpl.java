package yang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yang.dao.ScoringDao;
import yang.util.DBUtil;
import yang.vo.OneselectAnswerVO;
import yang.vo.ScoringAnswerVO;
import yang.vo.ScoringVO;

public class ScoringDaoImpl implements ScoringDao {
	private DBUtil db;

	@Override
	public int InsertScoring(Integer project_id, String question_name) {
		int n=0;
		db = new DBUtil();
		String sql = "insert into scoring(project_id,question_name) values(?,?)";
		try {
			n=db.update(sql,project_id,question_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		return n;
	}

	@Override
	public List<ScoringVO> SelectByProjectId(int project_id) {

		db = new DBUtil();
		ResultSet rs = null;
		List<ScoringVO> list_sVO=new ArrayList<ScoringVO>();
		String sql = "select * from scoring where project_id='" + project_id + "'";
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
	public int DeleteScoring(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from scoring where question_id='" + question_id + "'";
		try {
			n=db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		
		
		return n;
	}

	@Override
	public int UpdateScoring(int question_id, String question_name) {
		int n=0;
		db = new DBUtil();
		String sql="update scoring set question_name= ? where question_id=?";
		try {
			n=db.update(sql,question_name,question_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		
		
		return n;
	}

	@Override
	public List<ScoringAnswerVO> selectScoringAnswer(int question_id) {
		db = new DBUtil();
		ResultSet rs = null;
		List<ScoringAnswerVO> list_oAnswerVOs=new ArrayList<ScoringAnswerVO>();
		String sql="select * from scoring_answer where question_id=?";
		try {
			rs = db.query(sql,question_id);
			while (rs.next()) {
				ScoringAnswerVO vo=new ScoringAnswerVO();
				
				vo.setOne(rs.getInt("one"));
				vo.setTwo(rs.getInt("two"));
				vo.setThree(rs.getInt("three"));
				vo.setFour(rs.getInt("four"));
				vo.setFive(rs.getInt("five"));
				list_oAnswerVOs.add(vo);
			}
			return list_oAnswerVOs;
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
	public int DeleteScorings(int project_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from scoring where project_id='" + project_id + "'";
		try {
			n=db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();
		}		
		return n;
	}

	@Override
	public int InsertScoringAnswer(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql = "insert into scoring_answer(question_id) values(?)";
		try {
			n=db.update(sql,question_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeAll();
		}
		return n;
	}

	@Override
	public int UpdateScoringAnswerA(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update scoring_answer set one=one+1 where question_id=?";
		try {
			n=db.update(sql,question_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();
		}
		return n;
	}

	@Override
	public int UpdateScoringAnswerB(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update scoring_answer set two=two+1 where question_id=?";
		try {
			n=db.update(sql,question_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();
		}
		return n;
	}

	@Override
	public int UpdateScoringAnswerC(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update scoring_answer set three=three+1 where question_id=?";
		try {
			n=db.update(sql,question_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();
		}
		return n;
	}

	@Override
	public int UpdateScoringAnswerD(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update scoring_answer set four=four+1 where question_id=?";
		try {
			n=db.update(sql,question_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();
		}
		return n;
	}

	@Override
	public int UpdateScoringAnswerE(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update scoring_answer set five=five+1 where question_id=?";
		try {
			n=db.update(sql,question_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();
		}
		return n;
	}

}
