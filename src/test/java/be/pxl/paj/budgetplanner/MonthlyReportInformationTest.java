package be.pxl.paj.budgetplanner;

import be.pxl.paj.budgetplanner.builders.MonthlyReportInformationBuilder;
import be.pxl.paj.budgetplanner.builders.TransactionBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthlyReportInformationTest {

	private MonthlyReportInformation monthlyReportInformation;

	@BeforeEach
	public void init() {
		List<Transaction> incoming = Arrays.asList(
				TransactionBuilder.aTransaction().withAmount(1200).build(),
				TransactionBuilder.aTransaction().withAmount(300).build()
		);
		List<Transaction> outgoing = Arrays.asList(
				TransactionBuilder.aTransaction().withAmount(-500).build(),
				TransactionBuilder.aTransaction().withAmount(-125).build()
		);
		monthlyReportInformation = MonthlyReportInformationBuilder.aMonthlyReportInformation()
				.withIncoming(incoming)
				.withOutgoing(outgoing)
				.build();
	}

	@Test
	public void getTotalIncomingReturnsTheSumOfTheAmountsOfTheIncomingTransactions() {
		double totalIncoming = monthlyReportInformation.getTotalIncoming();
		assertEquals(1500, totalIncoming);
	}

	@Test
	public void getTotalOutgoingReturnsTheSumOfTheAmountsOfTheOutgoingTransactions() {
		double totalOutgoing = monthlyReportInformation.getTotalOutgoing();
		assertEquals(-625, totalOutgoing);
	}

}
