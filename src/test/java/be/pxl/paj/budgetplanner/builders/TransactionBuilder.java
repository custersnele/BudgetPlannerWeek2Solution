package be.pxl.paj.budgetplanner.builders;

import be.pxl.paj.budgetplanner.Transaction;

import java.time.LocalDate;

public final class TransactionBuilder {

	public static final double DEFAULT_AMOUNT = 1000;
	private LocalDate date;
	private String name;
	private double amount = DEFAULT_AMOUNT;
	private String detail;
	private String category;

	private TransactionBuilder() {}

	public static TransactionBuilder aTransaction() { return new TransactionBuilder(); }

	public TransactionBuilder withDate(LocalDate date) {
		this.date = date;
		return this;
	}

	public TransactionBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public TransactionBuilder withAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public TransactionBuilder withDetail(String detail) {
		this.detail = detail;
		return this;
	}

	public TransactionBuilder withCategory(String category) {
		this.category = category;
		return this;
	}

	public Transaction build() { return new Transaction(date, amount, category, name, detail); }
}
