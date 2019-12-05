package yang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yang.dao.OneselectDao;
import yang.util.DBUtil;
import yang.vo.OneselectAnswerVO;
import yang.vo.OneselectVO;

public class OneselectDaoImpl implements OneselectDao {
	private DBUtil db;

	@Override
	public int InsertOneselect(Integer project_id, String question_name, String option_a, String option_b,
			String option_c, String option_d) {
		int n=0;
		db = new DBUtil();
		String sql = "insert into oneselect(project_id,question_name,option_a,option_b,option_c,option_d) values(?,?,?,?,?,?)";
		try {
			n=db.update(sql,project_id,question_name,option_a,option_b,option_c,option_d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		return n;

		
	}

	@Override
	public List<OneselectVO> SelectByProjectId(int project_id) {
		
		
		
		db = new DBUtil();
		ResultSet rs = null;
		List<OneselectVO> list_oVO=new ArrayList<OneselectVO>();
		String sql = "select * from oneselect where project_id='" + project_id + "'";
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
	public List<OneselectVO> SelectByPQuestionId(int question_id) {
		

		db = new DBUtil();
		ResultSet rs = null;
		List<OneselectVO> list_oVO=new ArrayList<OneselectVO>();
		//
		String sql = "select * from oneselect where question_id='" + question_id + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				OneselectVO oVO = new OneselectVO();
				oVO.setQuestion_id(rs.getInt("qiestion_id"));
				oVO.setProject_id(rs.getInt("question_id"));
				oVO.setQuestion_name(rs.getString("qouetion_name"));
				oVO.setOption_a(rs.getString("option_a"));
				oVO.setOption_b(rs.getString("option_b"));
				oVO.setOption_c(rs.getString("option_c"));
				oVO.setOption_d(rs.getString("option_d"));	
				return list_oVO;
			}
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
	public int DeleteOneselect(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from oneselect where question_id='" + question_id + "'";
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
	public int UpdateOneselect(int question_id, String question_name, String option_a, String option_b, String option_c,
			String option_d) {
		int n=0;
		db = new DBUtil();
		String sql="update oneselect set question_name=?,option_a=?,option_b=?,option_c=?,option_d=? where question_id=?";
		try {
			n=db.update(sql,question_name,option_a,option_b,option_c,option_d,question_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		
		
		return n;
	}

	@Override
	public List<OneselectAnswerVO> selectOneselectAnswer(int question_id) {
		db = new DBUtil();
		ResultSet rs = null;
		List<OneselectAnswerVO> list_oAnswerVOs=new ArrayList<OneselectAnswerVO>();
		String sql="select * from oneselect_answer where question_id=?";
		
		try {
			rs = db.query(sql,question_id);
			while (rs.next()) {
				OneselectAnswerVO vo=new OneselectAnswerVO();
				
				vo.setOption_a_number(rs.getInt("option_a_number"));
				vo.setOption_b_number(rs.getInt("option_b_number"));
				vo.setOption_c_number(rs.getInt("option_c_number"));
				vo.setOption_d_number(rs.getInt("option_d_number"));
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
	public int DeleteOneselects(int project_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from oneselect where project_id='" + project_id + "'";
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
	public int InsertOneselectAnswer(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql = "insert into oneselect_answer(question_id) values(?)";
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
	public int UpdateOneselectAnswerA(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update oneselect_answer set option_a_number=option_a_number+1 where question_id=?";
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
	public int UpdateOneselectAnswerB(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update oneselect_answer set option_b_number=option_b_number+1 where question_id=?";
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
	public int UpdateOneselectAnswerC(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update oneselect_answer set option_c_number=option_c_number+1 where question_id=?";
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
	public int UpdateOneselectAnswerD(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update oneselect_answer set option_d_number=option_d_number+1 where question_id=?";
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
