package com.tamdongtam.java.service;

import java.util.List;

import com.tamdongtam.java.model.BankAccountInfo;

public interface IAccountService {
	List<BankAccountInfo> getAllAccount();
	BankAccountInfo getAccountById(int id);
	void addAccount(BankAccountInfo accountInfo);
	void updateAccount(BankAccountInfo accountInfo);
	void deleteAccount(int id);
}
