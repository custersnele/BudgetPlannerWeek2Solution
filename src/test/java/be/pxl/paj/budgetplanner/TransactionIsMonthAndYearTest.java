package be.pxl.paj.budgetplanner;

import be.pxl.paj.budgetplanner.builders.TransactionBuilder;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionIsMonthAndYearTest {

	@Test
	public void returnsTrueIfTransactionIsInGivenMonthAndYear() {
		Transaction transaction = TransactionBuilder.aTransaction().withDate(LocalDate.of(2021, 5, 14)).build();
		assertTrue(transaction.isMonthAndYear(Month.MAY, 2021));
	}

	@Test
	public void returnsFalseIfTransactionIsInGivenMonthButOtherYear() {
		Transaction transaction = TransactionBuilder.aTransaction().withDate(LocalDate.of(2021, 5, 14)).build();
		assertFalse(transaction.isMonthAndYear(Month.MAY, 2020));
	}

	@Test
	public void returnsFalseIfTransactionIsInGivenYearButOtherMonth() {
		Transaction transaction = TransactionBuilder.aTransaction().withDate(LocalDate.of(2021, 5, 14)).build();
		assertFalse(transaction.isMonthAndYear(Month.APRIL, 2021));
	}

	@Test
	public void returnsFalseIfTransactionIsInOtherMonthAndYear() {
		Transaction transaction = TransactionBuilder.aTransaction().withDate(LocalDate.of(2021, 5, 14)).build();
		assertFalse(transaction.isMonthAndYear(Month.APRIL, 2020));
	}

}
