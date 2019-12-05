package yang.biz.impl;

import yang.biz.ModifyPswBiz;
import yang.dao.ModifyPswDao;
import yang.dao.impl.ModifyPswDaoImpl;

public class ModifyPswBizImpl implements ModifyPswBiz{
	private ModifyPswDao dao;
	
	public ModifyPswBizImpl(){
		super();
		dao=new ModifyPswDaoImpl();
	}

	@Override
	public boolean ModifyPsw(String username, String psw) {
		int n;
		n=this.dao.ModifyPsw(username,psw);
		System.out.println("Biz层");
		System.out.println(username);
		System.out.println(psw);
		System.out.println(n);
		if (n==1) {
			return true;
			
		}else {
		return false;
		}
		}
}
