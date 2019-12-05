package yang.dao;

import yang.vo.UserVO;

public interface LoginDao {
	
	
		UserVO SelectByName(String name);
		
		void InsertUser(String name, String pwd);
		
		int DeleteUser(String name);
		
	
}
