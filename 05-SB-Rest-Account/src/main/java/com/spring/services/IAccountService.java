package com.spring.services;

import java.util.Set;

import com.spring.entity.Account;
import com.spring.entity.SavingAccount;
import com.spring.entity.TermAccount;
import com.spring.entity.Transaction;
import com.spring.exception.DetailsNotFoundException;
import com.spring.exception.InvalidAccountException;
import com.spring.exception.InvalidAmountException;
import com.spring.exception.InvalidDetailsException;
import com.spring.exception.LowBalanceException;

public interface IAccountService 
{
	public Transaction transferMoney(long senderAccounId, long receiverAccountId, double amount, String username,
			String password) throws LowBalanceException, InvalidAccountException;

	public Transaction withdraw(long accounId, double amount, String username, String password)
			throws LowBalanceException;

	public Transaction deposit(long accounId, double amount) throws InvalidAccountException, InvalidAmountException;

	public SavingAccount addSavingsAccount(SavingAccount saving) throws InvalidDetailsException;

	public TermAccount addTermAccount(TermAccount term) throws InvalidDetailsException;

	public SavingAccount updateSavingsAccount(SavingAccount saving) throws InvalidDetailsException;

	public TermAccount updateTermAccount(TermAccount term) throws InvalidDetailsException;

	public boolean closeSavingsAccount(SavingAccount accountNo) throws InvalidAccountException;

	public boolean closeTermAccount(TermAccount accountNo) throws InvalidAccountException;

	public Account findAccountById(long account_id) throws InvalidAccountException;

	public Set<Account> viewAccounts(long customerId) throws DetailsNotFoundException;

	public SavingAccount viewSavingAcc(long customerId) throws DetailsNotFoundException;

	public TermAccount viewTermAcc(long customerId) throws DetailsNotFoundException;
}
