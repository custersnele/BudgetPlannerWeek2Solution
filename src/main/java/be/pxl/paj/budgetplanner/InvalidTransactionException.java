package be.pxl.paj.budgetplanner;

public class InvalidTransactionException extends Exception {
	public InvalidTransactionException(String message) {
		super(message);
	}

	public InvalidTransactionException(String message, Throwable cause) {
		super(message, cause);
	}
}
