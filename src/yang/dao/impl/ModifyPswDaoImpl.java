package yang.dao.impl;

import java.sql.SQLException;

import yang.dao.ModifyPswDao;
import yang.util.DBUtil;

public class ModifyPswDaoImpl implements ModifyPswDao {
	private DBUtil db;

	@Override
	public int ModifyPsw(String username, String psw) {
		int n=0;
		db = new DBUtil();
		String sql="update user set user_psw='"+psw+"' where user_name ='"+username+"'";
		try {
			n=db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			db.closeAll();

		}
		return n;

	}

	@Override
	public int ModifyPetName(String username, String PetName) {
		int n=0;
		db = new DBUtil();
		String sql="update user set user_pet_name='"+PetName+"' where user_name ='"+username+"'";
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
