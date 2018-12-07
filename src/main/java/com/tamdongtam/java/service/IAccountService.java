package com.tamdongtam.java.service;

import java.util.List;

import com.tamdongtam.java.exception.BankTransactionException;
import com.tamdongtam.java.model.BankAccountInfo;
import com.tamdongtam.java.model.SendMoney;

public interface IAccountService {
	List<BankAccountInfo> getAllAccount();
	BankAccountInfo getAccountById(int id);
	void addAccount(BankAccountInfo accountInfo);
	void updateAccount(BankAccountInfo accountInfo);
	void deleteAccount(int id);
	public void addAmount(int id, double amount) throws BankTransactionException;
	public void sendMoney(SendMoney sendMoney) throws BankTransactionException;
}
