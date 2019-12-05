package yang.biz.impl;

import yang.biz.LoginBiz;
import yang.dao.LoginDao;
import yang.dao.impl.LoginDaoImpl;
import yang.vo.UserVO;

public class LoginBizImpl implements LoginBiz {
	private LoginDao dao;

	public LoginBizImpl() {
		super();
		dao = new LoginDaoImpl();
	}

	@Override
	public UserVO SelectByName(String name) {

		return this.dao.SelectByName(name);
	}

	@Override
	public boolean AddUser(String name, String pwd) {

		UserVO u = this.dao.SelectByName(name);
		if (u == null || u.equals("null")) {
			this.dao.InsertUser(name, pwd);
			return true;
		}

		return false;
	}
		
}
