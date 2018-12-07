package com.tamdongtam.java.dao;

import java.util.List;

import com.tamdongtam.java.exception.BankTransactionException;
import com.tamdongtam.java.model.BankAccountInfo;
import com.tamdongtam.java.model.SendMoney;

public interface IBankAccountDAO {
	List<BankAccountInfo> getAllAccount();
	BankAccountInfo getAccountById(int id);
	void addAccount(BankAccountInfo accountInfo);
	void updateAccount(BankAccountInfo accountInfo);
	void deleteAccount(int id);
}
