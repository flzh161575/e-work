package service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAccountDao;
import entity.Account;
import service.prototype.IAccountService;

@Service
public class AccountServiceDaoImpl implements IAccountService{
	
	@Autowired
	private IAccountDao actDao;
	
	@Override
	public void openAccount(Account act) {
		
	}

	@Override
	public void cancelAccount(int id) {
		
	}

	@Override
	public boolean transfer(int fromID, int toID, double money) {
		// TODO Auto-generated method stub
		return false;
	}

}
