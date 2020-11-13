package com.spring.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entity.Account;
import com.spring.entity.SavingAccount;
import com.spring.entity.TermAccount;
import com.spring.entity.Transaction;
import com.spring.exception.DetailsNotFoundException;
import com.spring.exception.InvalidAccountException;
import com.spring.exception.InvalidAmountException;
import com.spring.exception.InvalidDetailsException;
import com.spring.exception.LowBalanceException;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>
{
	@Query("select t from Transaction t where t.bankAccount=?1 and t.amount=?3")
	public Transaction transferMoney(long senderAccounId, long receiverAccountId, double amount, String username,
			String password) throws LowBalanceException, InvalidAccountException;
	
	@Query("select t from Transaction t where t.bankAccount=?1 and t.amount=?2")
	public Transaction withdraw(long accounId, double amount, String username, String password)
			throws LowBalanceException;
	
	@Query("select t from Transaction t where t.bankAccount=?1 and t.amount=?2")
	public Transaction deposit(long accounId, double amount) throws InvalidAccountException, InvalidAmountException;
	
	@Query("select s from SavingAccount")
	public SavingAccount addSavingsAccount(SavingAccount saving) throws InvalidDetailsException;
	
	@Query("select t from TermAccount")
	public TermAccount addTermAccount(TermAccount term) throws InvalidDetailsException;
	
	@Query("select s from SavingAccount")
	public SavingAccount updateSavingsAccount(SavingAccount saving) throws InvalidDetailsException;
	
	@Query("select t from TermAccount")
	public TermAccount updateTermAccount(TermAccount term) throws InvalidDetailsException;

	public boolean closeSavingsAccount(SavingAccount accountNo) throws InvalidAccountException;
	
	public boolean closeTermAccount(TermAccount accountNo) throws InvalidAccountException;
	
	@Query("select a from Account a where a.accounId =?1")
	public Account findAccountById(long account_id) throws InvalidAccountException;
	
	@Query("select a from Account a where a.customerId=?1")
	public Set<Account> viewAccounts(long customerId) throws DetailsNotFoundException;
	
	@Query("select s from Account where a.customerId=?1")
	public SavingAccount viewSavingAcc(long customerId) throws DetailsNotFoundException;
	
	@Query("select t from Account where a.customerId=?1")
	public TermAccount viewTermAcc(long customerId) throws DetailsNotFoundException;
}
