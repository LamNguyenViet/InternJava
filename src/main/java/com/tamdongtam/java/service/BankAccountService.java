package com.tamdongtam.java.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tamdongtam.java.dao.IBankAccountDAO;
import com.tamdongtam.java.exception.BankTransactionException;
import com.tamdongtam.java.model.BankAccountInfo;
import com.tamdongtam.java.model.SendMoney;

@Service
@Transactional
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

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	
	public void addAmount(int id, double amount) throws BankTransactionException {
		BankAccountInfo accountInfo = this.getAccountById(id);
		if(accountInfo == null) {
			throw new BankTransactionException("Account not found "+id);
		}
		double newBalance =  accountInfo.getBalance() + amount;
		if(newBalance< 0) {
			throw new BankTransactionException("Money in this account is not enough!!!");
		}
		accountInfo.setBalance(newBalance);
		this.updateAccount(accountInfo);
		
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW , rollbackFor = BankTransactionException.class)
	public void sendMoney(SendMoney sendMoney) throws BankTransactionException {
		addAmount(sendMoney.getToAccount(), sendMoney.getAmount());
		addAmount(sendMoney.getFromAccount(), -sendMoney.getAmount());
		
		
	}

}
