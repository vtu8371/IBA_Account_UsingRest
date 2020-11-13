package com.spring.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "AccountType")
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accounId;

	private double interestRate;
	private double balance;
	private LocalDate dateOfOpening;

	@ManyToOne(targetEntity = Customer.class)
	private Set<Customer> customers;

	@OneToMany(targetEntity = Nominee.class)
	private Set<Nominee> nominees;

	@OneToMany(targetEntity = Beneficiary.class)
	private Set<Beneficiary> beneficiaries;

	public long getAccounId() {
		return accounId;
	}

	public void setAccounId(long accounId) {
		this.accounId = accounId;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getDateOfOpening() {
		return dateOfOpening;
	}

	public void setDateOfOpening(LocalDate dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<Nominee> getNominees() {
		return nominees;
	}

	public void setNominees(Set<Nominee> nominees) {
		this.nominees = nominees;
	}

	public Set<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
}
