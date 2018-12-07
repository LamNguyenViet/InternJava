package com.tamdongtam.java.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.tamdongtam.java.exception.BankTransactionException;
import com.tamdongtam.java.mapper.BankAccountMapper;
import com.tamdongtam.java.model.BankAccountInfo;
import com.tamdongtam.java.model.SendMoney;

@Repository
@Transactional
public class BankAccountDAO implements IBankAccountDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<BankAccountInfo> getAllAccount() {
		String sql = "select Id, Full_Name, Balance from bank_account"; 
	    Object[] params = new Object[] {};
	    BankAccountMapper mapper = new BankAccountMapper();
	    List<BankAccountInfo> list = this.jdbcTemplate.query(sql, params, mapper);
//	    List<BankAccountInfo> list = new ArrayList<>();
	    return list;
	}
	@Override
	public BankAccountInfo getAccountById(int id) {
		String sql = "Select id, full_name, balance from bank_account where id = ?";
		Object[] params = new Object[] { id };
        BankAccountMapper mapper = new BankAccountMapper();
        BankAccountInfo bankAccount = this.jdbcTemplate.queryForObject(sql, params, mapper);
        return bankAccount;
	}

	@Override
	public void addAccount(BankAccountInfo accountInfo) {
		String sql = "insert into bank_account(id, full_name, balance) values (?,?,?)";
		jdbcTemplate.update(sql,accountInfo.getId(),accountInfo.getFullName(),accountInfo.getBalance());
	}

	@Override
	public void updateAccount(BankAccountInfo accountInfo) {
		String sql = "update bank_account set full_name = ?, balance =? where id = ?";
		jdbcTemplate.update(sql, accountInfo.getFullName(),accountInfo.getBalance(),accountInfo.getId());
		
	}

	@Override
	public void deleteAccount(int id) {
		String sql = "delete from bank_account where id = ?";
		jdbcTemplate.update(sql,id);		
	}
	
}
