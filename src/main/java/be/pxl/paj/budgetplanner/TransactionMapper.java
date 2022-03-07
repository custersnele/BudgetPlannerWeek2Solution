package be.pxl.paj.budgetplanner;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionMapper {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/MM/yyyy");
	private static final NumberFormat DECIMAL_FORMAT = DecimalFormat.getInstance();

	public static Transaction map(String validLine) throws InvalidTransactionException {
		String[] split = validLine.split(";");
		if (split.length != 8) {
			throw new InvalidTransactionException("Invalid number of fields in line.");
		}
		try {
			return new Transaction(LocalDate.parse(split[7], FORMATTER), DECIMAL_FORMAT.parse(split[4]).doubleValue(), split[3], split[5], split[6]);
		} catch (ParseException e) {
			throw new InvalidTransactionException("Invalid data in line.", e);
		}
	}
}
