package com.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Account;
import com.spring.entity.SavingAccount;
import com.spring.entity.TermAccount;
import com.spring.entity.Transaction;
import com.spring.exception.DetailsNotFoundException;
import com.spring.exception.InvalidAccountException;
import com.spring.exception.InvalidAmountException;
import com.spring.exception.InvalidDetailsException;
import com.spring.exception.LowBalanceException;
import com.spring.repository.AccountRepository;

@Service
public class AccountServiceImp implements IAccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Transaction transferMoney(long senderAccounId, long receiverAccountId, double amount, String username,
			String password) throws LowBalanceException, InvalidAccountException {
		Account account=accountRepository.findById(senderAccounId).orElse(null);
		return accountRepository.transferMoney(senderAccounId, receiverAccountId, amount, username, password);
	}

	@Override
	public Transaction withdraw(long accounId, double amount, String username, String password)
			throws LowBalanceException {

		return accountRepository.withdraw(accounId, amount, username, password);
	}

	@Override
	public Transaction deposit(long accounId, double amount) throws InvalidAccountException, InvalidAmountException {

		return accountRepository.deposit(accounId, amount);
	}

	@Override
	public SavingAccount addSavingsAccount(SavingAccount saving) throws InvalidDetailsException {

		return accountRepository.addSavingsAccount(saving);
	}

	@Override
	public TermAccount addTermAccount(TermAccount term) throws InvalidDetailsException {

		return accountRepository.addTermAccount(term);
	}

	@Override
	public SavingAccount updateSavingsAccount(SavingAccount saving) throws InvalidDetailsException {

		return accountRepository.updateSavingsAccount(saving);
	}

	@Override
	public TermAccount updateTermAccount(TermAccount term) throws InvalidDetailsException {

		return accountRepository.updateTermAccount(term);
	}

	@Override
	public boolean closeSavingsAccount(SavingAccount accountNo) throws InvalidAccountException {

		return accountRepository.closeSavingsAccount(accountNo);
	}

	@Override
	public boolean closeTermAccount(TermAccount accountNo) throws InvalidAccountException {

		return accountRepository.closeTermAccount(accountNo);
	}

	@Override
	public Account findAccountById(long account_id) throws InvalidAccountException {

		return accountRepository.findAccountById(account_id);
	}

	@Override
	public Set<Account> viewAccounts(long customerId) throws DetailsNotFoundException {

		return accountRepository.viewAccounts(customerId);
	}

	@Override
	public SavingAccount viewSavingAcc(long customerId) throws DetailsNotFoundException {

		return accountRepository.viewSavingAcc(customerId);
	}

	@Override
	public TermAccount viewTermAcc(long customerId) throws DetailsNotFoundException {

		return accountRepository.viewTermAcc(customerId);
	}
}
