package be.pxl.paj.budgetplanner.builders;

import be.pxl.paj.budgetplanner.Account;
import be.pxl.paj.budgetplanner.Transaction;

import java.util.ArrayList;
import java.util.List;

public final class AccountBuilder {

	private List<Transaction> transactions = new ArrayList<>();
	private String iban;
	private String firstName;
	private String name;

	private AccountBuilder() {}

	public static AccountBuilder anAccount() { return new AccountBuilder(); }

	public AccountBuilder withTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
		return this;
	}

	public AccountBuilder withIban(String iban) {
		this.iban = iban;
		return this;
	}

	public AccountBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public AccountBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public Account build() {
		Account account = new Account(iban, firstName, name);
		account.setTransactions(transactions);
		return account;
	}
}
