package yang.biz;

import yang.vo.UserVO;

public interface LoginBiz {

	
	//≤È’“
		UserVO SelectByName(String name);
		//≤Â»Î
		boolean AddUser(String name, String pwd);
		//–ﬁ∏ƒ
		
}
