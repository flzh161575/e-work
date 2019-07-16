package service.prototype;

import entity.Account;

/**
 * 业务接口
 * @author RanJi
 *
 */
public interface IAccountService {
	//-- 1. 开户
	void openAccount(Account act);
	//-- 2. 销户
	void cancelAccount(int id);
	//-- 3. 转账
	boolean transfer(int fromID, int toID, double money);
	//-- 4. 存钱 | 取钱
}
