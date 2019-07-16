/*package account;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IAccountDao;
import entity.Account;

*//**
 * 单元测试
 * @author RanJi
 *
 *//*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class TestAccount {
	@Autowired
	private IAccountDao actDao;
	
	@Test
	public void testFindAll(){
		//List<Account> acts = actDao.findAll();
		List<Account> acts = actDao.findPaged(0, 10);
		for (Account account : acts) {
			System.out.println(account);
		}
	}
	
	@Test
	public void testFind(){
		Account act = actDao.findByActNo("act1");
		System.out.println(act);
	}
	
	@Test
	public void testSave(){
		Account act = new Account("uek000","123",false,new Date(),2000);
		//actDao.saveOrUpdate(act);
		act.setId(106096);
		act.setBalance(50000);
		actDao.saveOrUpdate(act);
	}
}
*/