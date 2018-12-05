package com.tamdongtam.java.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tamdongtam.java.model.BankAccountInfo;

public class BankAccountMapper implements RowMapper<BankAccountInfo> {
//	public static final String BASE_SQL= ""
//			+ "select ba.Id, ba.Full_Name,ba.Balance from Bank_Account ba";
	@Override
	public BankAccountInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		long id = rs.getLong("Id");
		String fullName = rs.getString("Full_Name");
		double balance = rs.getDouble("Balance");
		return new BankAccountInfo(id, fullName, balance);
	}

}
