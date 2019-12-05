package yang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yang.dao.ManyselectDao;
import yang.util.DBUtil;
import yang.vo.ManyselectAnswerVO;
import yang.vo.ManyselectVO;
import yang.vo.OneselectAnswerVO;

public class ManyselectDaoImpl implements ManyselectDao {
	private DBUtil db;

	@Override
	public int InsertManyselect(Integer project_id, String question_name, String option_a, String option_b,
			String option_c, String option_d) {
		int n=0;
		db = new DBUtil();
		String sql = "insert into manyselect(project_id,question_name,option_a,option_b,option_c,option_d) values(?,?,?,?,?,?)";
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
	public List<ManyselectVO> SelectByProjectId(int project_id) {
		
		
		db = new DBUtil();
		ResultSet rs = null;
		List<ManyselectVO> list_mVO=new ArrayList<ManyselectVO>();
		String sql = "select * from manyselect where project_id='" + project_id + "'";
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
	public List<ManyselectVO> SelectByPQuestionId(int question_id) {
		
		
		db = new DBUtil();
		ResultSet rs = null;
		List<ManyselectVO> list_mVO=new ArrayList<ManyselectVO>();
		// ����name�����û�
		String sql = "select * from manyselect where question_id='" + question_id + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				ManyselectVO mVO = new ManyselectVO();
				mVO.setQuestion_id(rs.getInt("qiestion_id"));
				mVO.setProject_id(rs.getInt("question_id"));
				mVO.setQuestion_name(rs.getString("qouetion_name"));
				mVO.setOption_a(rs.getString("option_a"));
				mVO.setOption_b(rs.getString("option_b"));
				mVO.setOption_c(rs.getString("option_c"));
				mVO.setOption_d(rs.getString("option_d"));	
				return list_mVO;
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
	public int DeleteManyselect(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from manyselect where question_id='" + question_id + "'";
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
	public int UpdateManyselect(int question_id, String question_name, String option_a, String option_b,
			String option_c, String option_d) {
		int n=0;
		db = new DBUtil();
		String sql="update manyselect set question_name=?,option_a=?,option_b=?,option_c=?,option_d=? where question_id=?";
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
	public List<ManyselectAnswerVO> selectManyselectAnswer(int question_id) {
		
		db = new DBUtil();
		ResultSet rs = null;
		List<ManyselectAnswerVO> list_mAnswerVOs=new ArrayList<ManyselectAnswerVO>();
		String sql="select * from manyselect_answer where question_id=?";
		try {
			rs = db.query(sql,question_id);
			while (rs.next()) {
				ManyselectAnswerVO vo=new ManyselectAnswerVO();
				vo.setOption_a_number(rs.getInt("option_a_number"));
				vo.setOption_b_number(rs.getInt("option_b_number"));
				vo.setOption_c_number(rs.getInt("option_c_number"));
				vo.setOption_d_number(rs.getInt("option_d_number"));
				list_mAnswerVOs.add(vo);	
			}
			return list_mAnswerVOs;
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
	public int DeleteManyselects(int project_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from manyselect where project_id='" + project_id + "'";
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
	public int InsertManyselectAnswer(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql = "insert into manyselect_answer(question_id) values(?)";
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
	public int UpdateManyselectAnswerA(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update manyselect_answer set option_a_number=option_a_number+1 where question_id=?";
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
	public int UpdateManyselectAnswerB(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update manyselect_answer set option_b_number=option_b_number+1 where question_id=?";
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
	public int UpdateManyselectAnswerC(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update manyselect_answer set option_c_number=option_c_number+1 where question_id=?";
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
	public int UpdateManyselectAnswerD(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql="update manyselect_answer set option_d_number=option_d_number+1 where question_id=?";
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
