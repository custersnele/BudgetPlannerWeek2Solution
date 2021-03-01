package be.pxl.paj.budgetplanner;

public class AccountMapper {

	public static Account map(String validLine) throws InvalidTransactionException {
		String[] split = validLine.split(";");
		if (split.length != 8) {
			throw new InvalidTransactionException("Invalid number of fields in line.");
		}
	    return new Account(split[2], split[1], split[0]);
	}
}
