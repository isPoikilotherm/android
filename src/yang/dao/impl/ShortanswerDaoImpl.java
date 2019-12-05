package yang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yang.dao.ShortanswerDao;
import yang.util.DBUtil;
import yang.vo.ScoringAnswerVO;
import yang.vo.ScoringVO;
import yang.vo.ShortanswerAnswerVO;
import yang.vo.ShortanswerVO;

public class ShortanswerDaoImpl implements ShortanswerDao {
	private DBUtil db;

	@Override
	public int InsertShortanswer(Integer project_id, String question_name) {
		int n=0;
		db = new DBUtil();
		String sql = "insert into shortanswer(project_id,question_name) values(?,?)";
		try {
			n=db.update(sql,project_id,question_name);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		return n;
	}

	@Override
	public List<ShortanswerVO> SelectByProjectId(int project_id) {
		
		db = new DBUtil();
		ResultSet rs = null;
		List<ShortanswerVO> list_sVO=new ArrayList<ShortanswerVO>();
		String sql = "select * from shortanswer where project_id='" + project_id + "'";
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
	public int DeleteShortanswer(int question_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from shortanswer where question_id='" + question_id + "'";
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
	public int UpdateShoranswer(int question_id, String question_name) {
		int n=0;
		db = new DBUtil();
		String sql="update shortanswer set question_name= ? where question_id= ? ";
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
	public List<ShortanswerAnswerVO> SelectShortanswerAnswer(int question_id) {
		db = new DBUtil();
		ResultSet rs = null;
		List<ShortanswerAnswerVO> mList=new ArrayList<ShortanswerAnswerVO>();
		String sql = "select answer from shortanswer_answer where question_id='" + question_id + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				ShortanswerAnswerVO vo=new ShortanswerAnswerVO();
				vo.setAnswer(rs.getString("answer"));
				mList.add(vo);
			}
			return mList;
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
	public int DeleteShortanswers(int project_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from shortanswer where project_id='" + project_id + "'";
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
	public int InsertShortanswerAnswer(int question_id, String answer) {
		int n=0;
		db = new DBUtil();
		String sql = "insert into shortanswer_answer(question_id,answer) values(?,?)";
		try {
			n=db.update(sql,question_id,answer);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			db.closeAll();
		}
		return n;
	}

}
