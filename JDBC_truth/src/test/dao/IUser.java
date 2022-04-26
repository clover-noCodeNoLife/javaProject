package test.dao;

import test.user;

/**
 * 用于提供impl.userService实现提供接口
 * @author Clover
 *
 */
public interface IUser {
	/*
	 * 该接口方法，用于获取用户实体
	 * */
	public user getUserByName(String username);
	
}
