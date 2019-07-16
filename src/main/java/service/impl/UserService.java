package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.User;
import mapper.prototry.IUserDao;
import service.prototype.IUserService;

/**
 * 用户业务实现类
 * @author Administrator
 *
 */
@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Override  //业务方法
	@Transactional  //--加事物处理标注表示是告诉Spring框架该方法需要事物处理
	public void testTransaction() {
		//1.
		User user = new User();
		userDao.save(user);
		
		//-- 构造一个异常
		int i=3/0;
		//2.
		userDao.toString();
	}

}
