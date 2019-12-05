package yang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import yang.dao.LoginDao;
import yang.util.DBUtil;
import yang.vo.UserVO;

public class LoginDaoImpl implements LoginDao {
	private DBUtil db;

	@Override
	public UserVO SelectByName(String name) {
		// TODO Auto-generated method stub

		db = new DBUtil();
		ResultSet rs = null;
		UserVO u = new UserVO();
		
		String sql = "select * from user where user_name='" + name + "'";
		try {
			rs = db.query(sql);
			while (rs.next()) {
				u.setId(rs.getInt("user_id"));
				u.setName(rs.getString("user_name"));
				u.setPsw(rs.getString("user_psw"));
				u.setPet_name(rs.getString("user_pet_name"));
				return u;
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
	public void InsertUser(String name, String pwd) {

		db = new DBUtil();
		String sql = "insert into user(user_name,user_psw,user_pet_name) values(?,?,?)";
		try {
			db.update(sql, name, pwd, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.closeAll();

		}

	}

	@Override
	public int DeleteUser(String name) {
		
		int n=0;
		db = new DBUtil();
		String sql = "delete from user where user_name='" + name + "'";
		try {
			n=db.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		
		
		return n;
	}

}
