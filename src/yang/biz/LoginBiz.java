package yang.biz;

import yang.vo.UserVO;

public interface LoginBiz {

	
	//����
		UserVO SelectByName(String name);
		//����
		boolean AddUser(String name, String pwd);
		//�޸�
		
}
