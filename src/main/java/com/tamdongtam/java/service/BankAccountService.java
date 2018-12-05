package com.tamdongtam.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamdongtam.java.dao.IBankAccountDAO;
import com.tamdongtam.java.model.BankAccountInfo;

@Service
public class BankAccountService implements IAccountService{
	
	@Autowired
	private IBankAccountDAO accountDao;
	
	@Override
	public List<BankAccountInfo> getAllAccount() {
		// TODO Auto-generated method stub
		return accountDao.getAllAccount();
	}

	@Override
	public BankAccountInfo getAccountById(int id) {
		// TODO Auto-generated method stub
		return accountDao.getAccountById(id);
	}

	@Override
	public void addAccount(BankAccountInfo accountInfo) {
		// TODO Auto-generated method stub
		accountDao.addAccount(accountInfo);
	}

	@Override
	public void updateAccount(BankAccountInfo accountInfo) {
		// TODO Auto-generated method stub
		accountDao.updateAccount(accountInfo);
		
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		accountDao.deleteAccount(id);
		
	}
	
}
