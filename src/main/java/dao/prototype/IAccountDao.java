package dao.prototype;

import java.util.List;
import entity.Account;

/**
 * 账户DAO接口
 * @author RanJi
 *
 */
public interface IAccountDao {
	/**
	 * 
	 * @param act
	 */
	void saveOrUpdate(Account act);
	
	void saveAccounts(List<Account> acts);
	void saveAccounts2(List<Account> acts);
	
	//-- void saveOrUpdate(Connection con, Account act);
	/**
	 * 
	 * @param id
	 */
	void delete(int id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	Account findByID(int id);
	/**
	 * 
	 * @param actNo
	 * @return
	 */
	Account findByActNo(String actNo);
	/**
	 * 
	 * @return
	 */
	List<Account> findAll();	//-- 特例
	/**
	 * 分页查找账户对象
	 * @param offset  	偏移量
	 * @param pageSize  页大小 
	 * @return  账户类的集合
	 */
	List<Account> findPaged(int offset, int pageSize);
	
	
	
}
