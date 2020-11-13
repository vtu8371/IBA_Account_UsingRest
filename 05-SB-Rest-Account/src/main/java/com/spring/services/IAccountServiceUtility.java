package com.spring.services;

import com.spring.entity.TermAccount;
import com.spring.entity.Account;
import com.spring.entity.SavingAccount;
import com.spring.exception.InvalidDetailsException;
import com.spring.entity.Transaction;
import com.spring.exception.DetailsNotFoundException;
import com.spring.exception.InvalidAccountException;
import com.spring.exception.InvalidAmountException;
import com.spring.exception.LowBalanceException;

public class IAccountServiceUtility 
{
	IAccountService iAccountService;
	
	public IAccountService getiAccountService() {
		return iAccountService;
	}
	public void setiAccountService(IAccountService iAccountService) {
		this.iAccountService = iAccountService;
	}
	
	public Transaction transferMoney(long senderAccounId, long receiverAccountId, double amount, String username,
			String password) throws LowBalanceException, InvalidAccountException 
	{
		Transaction transfer = iAccountService.transferMoney(senderAccounId, receiverAccountId, amount, username,
				password);
		
		return transfer;
	}
	
	public Transaction withdrawMoney(long accounId, double amount, String username, String password)
			throws LowBalanceException 
	{
		Transaction transfer = iAccountService.withdraw(accounId, amount, username, password);
		return transfer;
	}
	
	public Transaction deposit(long accounId, double amount) throws InvalidAccountException, InvalidAmountException 
	{
		Transaction transfer = iAccountService.deposit(accounId, amount);
		return transfer;
	}
	
	public SavingAccount addSavingsAccount(SavingAccount saving) throws InvalidDetailsException
	{
		SavingAccount savingAccount=iAccountService.addSavingsAccount(saving);
		return savingAccount;
	}
	public TermAccount addTermAccount(TermAccount term) throws InvalidDetailsException
	{
		TermAccount termAccount=iAccountService.addTermAccount(term);
		return termAccount;
	}
	public SavingAccount updateSavingsAccount(SavingAccount saving) throws InvalidDetailsException
	{
		SavingAccount savingAccount=iAccountService.updateSavingsAccount(saving);
		return savingAccount;
	}
	public TermAccount updateTermAccount(TermAccount term) throws InvalidDetailsException
	{
		TermAccount termAccount=iAccountService.updateTermAccount(term);
		return termAccount;
	}
	public boolean closeSavingsAccount(SavingAccount accountNo) throws InvalidAccountException
	{
		boolean bol=iAccountService.closeSavingsAccount(accountNo);
		return bol;
	}
	public boolean closeTermAccount(TermAccount accountNo) throws InvalidAccountException
	{
		boolean bol=iAccountService.closeTermAccount(accountNo);
		return bol;
	}
	public Account findAccountById(long account_id) throws InvalidAccountException
	{
		Account account=iAccountService.findAccountById(account_id);
		return account;
	}
	public SavingAccount viewSavingAcc(long customerId) throws DetailsNotFoundException
	{
		SavingAccount savingAccount=iAccountService.viewSavingAcc(customerId);
		return savingAccount;
	}
	public TermAccount viewTermAcc(long customerId) throws DetailsNotFoundException
	{
		TermAccount termAccount=iAccountService.viewTermAcc(customerId);
		return termAccount;
	}
}
