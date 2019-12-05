package yang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import yang.dao.ProjectDao;
import yang.util.DBUtil;
import yang.vo.ProjectVO;


public class ProjectDaoImpl implements ProjectDao{
	private DBUtil db;

	@Override
	public List<ProjectVO> SelectByUserId(int userId) {
		
		db = new DBUtil();
		ResultSet rs = null;
		List<ProjectVO> list_proProjectVO=new ArrayList<ProjectVO>();
		String sql = "select * from project where user_id='" + userId + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				ProjectVO pVo = new ProjectVO();
				pVo.setProject_id(rs.getInt("project_id"));
				pVo.setUser_id(rs.getInt("user_id"));
				pVo.setName(rs.getString("project_name"));
				pVo.setDirection(rs.getString("direction"));
				pVo.setEnd_time(rs.getString("end_time"));
				pVo.setCan_answer(rs.getInt("can_answer"));
				list_proProjectVO.add(pVo);
			}
			return list_proProjectVO;
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
	public int InsertProject(int user_id, String name, String direction, String end_time) {
		
		int n=0;
		db = new DBUtil();
		String sql = "insert into project(user_id,project_name,direction,star_time,end_time) values(?,?,?,?,?)";
		try {
			n=db.update(sql,user_id,name,direction,end_time);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		return n;

		
	}


	@Override
	public List<ProjectVO> SelectByProjectName(String projectName) {
		
		
		db = new DBUtil();
		ResultSet rs = null;
		List<ProjectVO> list_proProjectVO=new ArrayList<ProjectVO>();
		String sql = "select * from project where project_name='" + projectName + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				ProjectVO pVo = new ProjectVO();
				pVo.setProject_id(rs.getInt("project_id"));
				pVo.setUser_id(rs.getInt("user_id"));
				pVo.setName(rs.getString("project_name"));
				pVo.setDirection(rs.getString("direction"));
				pVo.setEnd_time(rs.getString("end_time"));
				pVo.setCan_answer(rs.getInt("can_answer"));
				list_proProjectVO.add(pVo);
			}
			return list_proProjectVO;
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
	public int DeleteProject(int project_id) {
		int n=0;
		db = new DBUtil();
		String sql = "delete from project where project_id='" + project_id + "'";
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
	public int UpdateProject(int project_id,String name,String direction,String end_time) {
		int n=0;
		db = new DBUtil();
		String sql="update project set project_name=?,direction=?,end_time=?where project_id=?";
		try {
			n=db.update(sql,name,direction,end_time,project_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		
		
		return n;
	}


	@Override
	public ProjectVO SelectByProjectId(int project_id) {
		db = new DBUtil();
		ResultSet rs = null;
		ProjectVO pVo = new ProjectVO();
		String sql = "select * from project where project_id='" + project_id + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				pVo.setProject_id(rs.getInt("project_id"));
				pVo.setUser_id(rs.getInt("user_id"));
				pVo.setName(rs.getString("project_name"));
				pVo.setDirection(rs.getString("direction"));
				pVo.setEnd_time(rs.getString("end_time"));
				pVo.setCan_answer(rs.getInt("can_answer"));
			}
			return pVo;
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
