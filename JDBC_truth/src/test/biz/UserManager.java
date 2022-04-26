package test.biz;

import test.user;
import test.Impl.UserService;
import test.dao.IUser;

public class UserManager {
	IUser userDao = new UserService();
	/**
	 * 用户登陆方法
	 * @param userName 账号
	 * @param passWord 密码
	 * @return 返回user实体，登陆失败，返回null
	 */
	public user login(String userName,String passWord) {
		user user =  userDao.getUserByName(userName);
		if (user!=null) {
			if(user.getPassWord().equals(passWord)) {
				return user;
			}
		}
		
		return null;
	}
}
