package com.spring.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import com.spring.exception.InvalidAmountException;
import com.spring.entity.TermAccount;
import com.spring.entity.Account;
import com.spring.entity.Customer;
import com.spring.entity.SavingAccount;
import com.spring.exception.InvalidDetailsException;
import com.spring.entity.Transaction;
import com.spring.exception.DetailsNotFoundException;
import com.spring.exception.InvalidAccountException;
import com.spring.exception.LowBalanceException;
import com.spring.services.IAccountService;
import com.spring.services.IAccountServiceUtility;

public class TestClass {

	Transaction transfer = new Transaction();
	SavingAccount savingAccount = new SavingAccount();
	TermAccount termAccount = new TermAccount();
	Account account = new Account();
	Customer customer = new Customer();

	IAccountServiceUtility proxy = new IAccountServiceUtility();
	IAccountService iAccountService = EasyMock.createMock(IAccountService.class); // Creating mock

	@Test
	public void transferTest() throws LowBalanceException, InvalidAccountException {

		// setting logic
		EasyMock.expect(iAccountService.transferMoney(12345, 23456, 500.0, "vikas", "123")).andReturn(transfer);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		Transaction transferMoney = proxy.transferMoney(12345, 23456, 500.0, "vikas", "123");

		assertNotNull(transferMoney);
	}

	@Test
	public void transferMoneyTest() throws LowBalanceException, InvalidAccountException {

		// setting logic
		EasyMock.expect(iAccountService.transferMoney(12345, 23456, 500.0, "vikas", "123")).andReturn(transfer);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		Transaction transferMoney = proxy.transferMoney(12345, 23456, 500.0, "vikas", "123");

		assertEquals(transferMoney, transfer);
	}

	@Test
	public void withdrawTest() throws LowBalanceException {
		// Setting proxy logic
		EasyMock.expect(iAccountService.withdraw(12345, 600.0, "vikas", "123")).andReturn(transfer);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		Transaction transferMoney = proxy.withdrawMoney(12345, 600.0, "vikas", "123");

		assertNotNull(transferMoney);
	}

	@Test
	public void withdrawMoneyTest() throws LowBalanceException {
		// Setting proxy logic
		EasyMock.expect(iAccountService.withdraw(12345, 600.0, "vikas", "123")).andReturn(transfer);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		Transaction transferMoney = proxy.withdrawMoney(12345, 600.0, "vikas", "123");

		assertEquals(transferMoney, transfer);
	}

	@Test
	public void depositTest() throws InvalidAccountException, InvalidAmountException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.deposit(12345, 1000.0)).andReturn(transfer);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		Transaction transaction = proxy.deposit(12345, 1000.0);

		assertNotNull(transaction);
	}

	@Test
	public void depositMoneyTest() throws InvalidAccountException, InvalidAmountException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.deposit(12345, 1000.0)).andReturn(transfer);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		Transaction transaction = proxy.deposit(12345, 1000.0);

		assertEquals(transaction, transfer);
	}

	@Test
	public void addSavingTest() throws InvalidDetailsException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.addSavingsAccount(savingAccount)).andReturn(savingAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		SavingAccount saveAccount = proxy.addSavingsAccount(savingAccount);

		assertNotNull(saveAccount);
	}

	@Test
	public void addSavingAccountTest() throws InvalidDetailsException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.addSavingsAccount(savingAccount)).andReturn(savingAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		SavingAccount saveAccount = proxy.addSavingsAccount(savingAccount);

		assertEquals(saveAccount, savingAccount);
	}

	@Test
	public void addTermTest() throws InvalidDetailsException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.addTermAccount(termAccount)).andReturn(termAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		TermAccount termAccountValue = proxy.addTermAccount(termAccount);

		assertNotNull(termAccountValue);
	}

	@Test
	public void addTermAccountTest() throws InvalidDetailsException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.addTermAccount(termAccount)).andReturn(termAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		TermAccount termAccountValue = proxy.addTermAccount(termAccount);

		assertEquals(termAccountValue, termAccount);
	}

	@Test
	public void updateSavingTest() throws InvalidDetailsException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.updateSavingsAccount(savingAccount)).andReturn(savingAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		SavingAccount saveAccount = proxy.updateSavingsAccount(savingAccount);

		assertEquals(saveAccount, savingAccount);
	}

	@Test
	public void updateSavingAccountTest() throws InvalidDetailsException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.updateSavingsAccount(savingAccount)).andReturn(savingAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		SavingAccount saveAccount = proxy.updateSavingsAccount(savingAccount);

		assertNotNull(saveAccount);
	}

	@Test
	public void updateTermTest() throws InvalidDetailsException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.updateTermAccount(termAccount)).andReturn(termAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		TermAccount termAccountValue = proxy.updateTermAccount(termAccount);

		assertNotNull(termAccountValue);
	}

	@Test
	public void updateTermAccountTest() throws InvalidDetailsException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.updateTermAccount(termAccount)).andReturn(termAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		TermAccount termAccountValue = proxy.updateTermAccount(termAccount);

		assertEquals(termAccountValue, termAccount);
	}

	@Test
	public void closeSavingTest() throws InvalidAccountException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.closeSavingsAccount(savingAccount)).andReturn(true);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		boolean bol = proxy.closeSavingsAccount(savingAccount);

		assertEquals(bol, true);
	}

	@Test
	public void closeTermTest() throws InvalidAccountException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.closeTermAccount(termAccount)).andReturn(true);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		boolean bol = proxy.closeTermAccount(termAccount);

		assertEquals(bol, true);
	}

	@Test
	public void findByIdAccountTest() throws InvalidAccountException {
		// Setting Proxy logic
		EasyMock.expect(iAccountService.findAccountById(account.getAccounId())).andReturn(account);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		Account accountNumber = proxy.findAccountById(account.getAccounId());

		assertEquals(accountNumber, account);
	}

	@Test
	public void findByIdAccountNumberTest() throws InvalidAccountException {
		// Setting Proxy logic
		EasyMock.expect(iAccountService.findAccountById(account.getAccounId())).andReturn(account);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		Account accountNumber = proxy.findAccountById(account.getAccounId());

		assertNotNull(accountNumber);
	}

	@Test
	public void viewSavingTest() throws DetailsNotFoundException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.viewSavingAcc(customer.getCustomerId())).andReturn(savingAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		SavingAccount saveAccount = proxy.viewSavingAcc(customer.getCustomerId());

		assertNotNull(saveAccount);
	}

	@Test
	public void viewSavingAccountTest() throws DetailsNotFoundException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.viewSavingAcc(customer.getCustomerId())).andReturn(savingAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		SavingAccount saveAccount = proxy.viewSavingAcc(customer.getCustomerId());

		assertEquals(saveAccount, savingAccount);
	}

	@Test
	public void viewTermTest() throws DetailsNotFoundException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.viewTermAcc(customer.getCustomerId())).andReturn(termAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		TermAccount termAccountValue = proxy.viewTermAcc(customer.getCustomerId());
		
		assertEquals(termAccountValue,termAccount);
	}
	
	@Test
	public void viewTermAccountTest() throws DetailsNotFoundException {
		// Setting Proxy Logic
		EasyMock.expect(iAccountService.viewTermAcc(customer.getCustomerId())).andReturn(termAccount);

		EasyMock.replay(iAccountService);

		proxy.setiAccountService(iAccountService);

		TermAccount termAccountValue = proxy.viewTermAcc(customer.getCustomerId());
		
		assertNotNull(termAccountValue);
	}
}
