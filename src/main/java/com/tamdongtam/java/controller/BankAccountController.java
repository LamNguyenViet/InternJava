package com.tamdongtam.java.controller;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tamdongtam.java.model.BankAccountInfo;
import com.tamdongtam.java.service.IAccountService;

@Controller
public class BankAccountController {
	@Autowired
	private IAccountService accountService;
	@GetMapping("account/{id}")
	public ResponseEntity<BankAccountInfo> getAccountById(@PathVariable("id") int id){
		BankAccountInfo accountInfo = accountService.getAccountById(id);
		return new ResponseEntity<>(accountInfo,HttpStatus.OK);
	}
	@GetMapping(value = {"accounts","/"})
	public ResponseEntity<List<BankAccountInfo>> getAllAccount(){
		List<BankAccountInfo> list = accountService.getAllAccount();
		return new ResponseEntity<List<BankAccountInfo>>(list,HttpStatus.OK);
	}
	@PostMapping("account/add")
	public ResponseEntity<BankAccountInfo> addAccount(@RequestBody BankAccountInfo accountInfo){
		accountService.addAccount(accountInfo);
		return new ResponseEntity<BankAccountInfo>(accountInfo,HttpStatus.OK);
	}
	@PutMapping("account/update")
	public ResponseEntity<BankAccountInfo> updateAccount(@RequestBody BankAccountInfo accountInfo){
		accountService.updateAccount(accountInfo);
		return new ResponseEntity<>(accountInfo, HttpStatus.OK);
	}
	@DeleteMapping("account/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable("id") int id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
