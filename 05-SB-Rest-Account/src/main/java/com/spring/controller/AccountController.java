package com.spring.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Account;
import com.spring.entity.SavingAccount;
import com.spring.entity.TermAccount;
import com.spring.entity.Transaction;
import com.spring.exception.DetailsNotFoundException;
import com.spring.exception.InvalidAccountException;
import com.spring.exception.InvalidAmountException;
import com.spring.exception.InvalidDetailsException;
import com.spring.exception.LowBalanceException;
import com.spring.services.IAccountService;

@RestController
public class AccountController 
{
	@Autowired
	IAccountService accountRepository;

	@SuppressWarnings("unused")
	@GetMapping("/transferMoney")
	public Transaction transferMoney(long senderAccounId, long receiverAccountId, double amount, String username,
			String password) {
		Transaction transfer = null;
		try {
			transfer = accountRepository.transferMoney(senderAccounId, receiverAccountId, amount, username, password);
			SavingAccount account = (SavingAccount) accountRepository.findAccountById(senderAccounId);

			if ((account.getBalance() - amount) < account.getMinBalance()) {
				throw new LowBalanceException("Minimum balance should be maintained = " + account.getMinBalance());
			}
			if (account == null) {
				throw new InvalidAccountException("Sender Account Id is Invalid = " + senderAccounId);
			}

		} catch (LowBalanceException lowBalanceException) {
			System.out.println(lowBalanceException.getMessage());
		} catch (InvalidAccountException invalidAccountException) {
			System.out.println(invalidAccountException.getMessage());
		}
		return transfer;
	}

	@SuppressWarnings("unused")
	@GetMapping("/withdraw")
	public Transaction withdraw(long accounId, double amount, String username, String password)

	{
		Transaction transfer = null;
		try {
			transfer = accountRepository.withdraw(accounId, amount, username, password);
			SavingAccount account = (SavingAccount) accountRepository.findAccountById(accounId);

			if ((account.getBalance() - amount) < account.getMinBalance()) {
				throw new LowBalanceException("Minimum balance should be maintained = " + account.getMinBalance());
			}

			if (account == null) {
				throw new InvalidAccountException("Account Id is Invalid = " + accounId);
			}
		} catch (LowBalanceException lowBalanceException) {
			System.out.println(lowBalanceException.getMessage());
		} catch (InvalidAccountException invalidAccountException) {
			System.out.println(invalidAccountException.getMessage());
		}
		return transfer;
	}

	@PostMapping("/deposit")
	public Transaction deposit(long accounId, double amount) {
		Transaction transfer = null;
		try {
			transfer = accountRepository.deposit(accounId, amount);
			Account account = accountRepository.findAccountById(accounId);

			if (account == null) {
				throw new InvalidAccountException("Account Id is Invalid = " + accounId);
			}
			if (amount == 0.0) {
				throw new InvalidAccountException("Amount for Deposit is not valid = " + amount);
			}

		} catch (InvalidAccountException invalidAccountException) {
			System.out.println(invalidAccountException.getMessage());

		} catch (InvalidAmountException invalidAmountException) {
			System.out.println(invalidAmountException.getMessage());
		}
		return transfer;
	}

	@PostMapping("/addSaving")
	public SavingAccount addSavingsAccount(SavingAccount saving) {
		SavingAccount savingAccount = null;
		try {
			savingAccount = accountRepository.addSavingsAccount(saving);

			if (savingAccount == null) {
				throw new InvalidDetailsException("Null value can not add");
			}
		} catch (InvalidDetailsException invalidDetailsException) {
			System.out.println(invalidDetailsException.getMessage());
		}
		return savingAccount;
	}

	@PostMapping("/addTerm")
	public TermAccount addTermAccount(TermAccount term) {
		TermAccount termAccount = null;
		try {
			termAccount = accountRepository.addTermAccount(term);

			if (termAccount == null) {
				throw new InvalidDetailsException("Null value can not add");
			}
		} catch (InvalidDetailsException invalidDetailsException) {
			System.out.println(invalidDetailsException.getMessage());
		}
		return termAccount;
	}

	@PutMapping("/updateSaving")
	public SavingAccount updateSavingsAccount(SavingAccount saving) {
		SavingAccount savingAccount = null;
		try {
			savingAccount = accountRepository.updateSavingsAccount(saving);

			if (savingAccount == null) {
				throw new InvalidDetailsException("Null value can not add");
			}
		} catch (InvalidDetailsException invalidDetailsException) {
			System.out.println(invalidDetailsException.getMessage());
		}
		return savingAccount;
	}

	@PutMapping("/updateTerm")
	public TermAccount updateTermAccount(TermAccount term) {
		TermAccount termAccount = null;
		try {
			termAccount = accountRepository.addTermAccount(term);

			if (termAccount == null) {
				throw new InvalidDetailsException("Null value can not add");
			}
		} catch (InvalidDetailsException invalidDetailsException) {
			System.out.println(invalidDetailsException.getMessage());
		}
		return termAccount;
	}

	@DeleteMapping("/closeSaving")
	public boolean closeSavingsAccount(SavingAccount accountNo) {
		try {
			if (accountNo == null) {
				throw new InvalidAccountException("Invalid SavingAccount Number Can Not Be Closed");
			}
		} catch (InvalidAccountException invalidAccountException) {
			return false;
		}
		return true;
	}

	@DeleteMapping("/closeTerm")
	public boolean closeTermAccount(TermAccount accountNo) {
		try {
			if (accountNo == null) {
				throw new InvalidAccountException("Invalid TermAccount Number Can Not Be Closed");
			}
		} catch (InvalidAccountException invalidAccountException) {
			return false;
		}
		return true;
	}

	@GetMapping("/accountById")
	public Account findAccountById(long account_id) {
		Account account = null;
		try {
			account = accountRepository.findAccountById(account_id);

			if (account == null) {
				throw new InvalidAccountException("Invalid Account Id = " + account_id);
			}
		} catch (InvalidAccountException invalidAccountException) {
			System.out.println(invalidAccountException.getMessage());
		}
		return account;
	}

	@GetMapping("/accounts")
	public Set<Account> viewAccounts(long customerId) throws DetailsNotFoundException {
		return accountRepository.viewAccounts(customerId);
	}

	@GetMapping("/saving")
	public SavingAccount viewSavingAcc(long customerId) throws DetailsNotFoundException {
		return accountRepository.viewSavingAcc(customerId);
	}

	@GetMapping("/term")
	public TermAccount viewTermAcc(long customerId) throws DetailsNotFoundException {
		return accountRepository.viewTermAcc(customerId);
	}
}
