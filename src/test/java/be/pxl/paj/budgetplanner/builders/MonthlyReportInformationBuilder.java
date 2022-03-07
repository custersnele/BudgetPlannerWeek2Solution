package be.pxl.paj.budgetplanner.builders;

import be.pxl.paj.budgetplanner.MonthlyReportInformation;
import be.pxl.paj.budgetplanner.Transaction;

import java.time.Month;
import java.util.List;

public final class MonthlyReportInformationBuilder {

	private String fullName;
	private Month month;
	private int year;
	private List<Transaction> incoming;
	private List<Transaction> outgoing;

	private MonthlyReportInformationBuilder() {}

	public static MonthlyReportInformationBuilder aMonthlyReportInformation() {return new MonthlyReportInformationBuilder();}

	public MonthlyReportInformationBuilder withFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public MonthlyReportInformationBuilder withMonth(Month month) {
		this.month = month;
		return this;
	}

	public MonthlyReportInformationBuilder withYear(int year) {
		this.year = year;
		return this;
	}

	public MonthlyReportInformationBuilder withIncoming(List<Transaction> incoming) {
		this.incoming = incoming;
		return this;
	}

	public MonthlyReportInformationBuilder withOutgoing(List<Transaction> outgoing) {
		this.outgoing = outgoing;
		return this;
	}

	public MonthlyReportInformation build() {
		MonthlyReportInformation monthlyReportInformation = new MonthlyReportInformation();
		monthlyReportInformation.setFullName(fullName);
		monthlyReportInformation.setMonth(month);
		monthlyReportInformation.setYear(year);
		monthlyReportInformation.setIncoming(incoming);
		monthlyReportInformation.setOutgoing(outgoing);
		return monthlyReportInformation;
	}
}
