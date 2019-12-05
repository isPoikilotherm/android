package yang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import yang.dao.AddProjectDao;
import yang.util.DBUtil;
import yang.vo.ProjectVO;



public class AddProjectDaoImpl implements AddProjectDao{
	private DBUtil db;

	@Override
	public void InsertProject(Integer user_id, String project_name, String direction,  String end_time,
			Integer can_answer) {
		
		db = new DBUtil();
		String sql = "insert into project(user_id,project_name,direction,end_time,can_answer) values(?,?,?,?,?)";
		try {
			db.update(sql, user_id,project_name,direction,end_time,can_answer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		
	}

	@Override
	public ProjectVO SelectByName(String name) {
		
		db = new DBUtil();
		ResultSet rs = null;
		ProjectVO pVo = new ProjectVO();
		
		String sql = "select * from project where project_name='" + name + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				pVo.setProject_id(rs.getInt("project_id"));
				pVo.setUser_id(rs.getInt("user_id"));
				pVo.setName(rs.getString("project_name"));
				pVo.setDirection(rs.getString("direction"));
				pVo.setEnd_time(rs.getString("end_time"));
				pVo.setCan_answer(rs.getInt("can_answer"));
				return pVo;
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

}
