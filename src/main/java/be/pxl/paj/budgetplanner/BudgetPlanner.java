package be.pxl.paj.budgetplanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BudgetPlanner {

	private static final Logger LOGGER = LogManager.getLogger(BudgetPlanner.class);

	public static void main(String[] args) {
		if (args.length != 3) {
			LOGGER.error("Arguments expected: path month year");
			LOGGER.error("Arguments not correct.");
			System.exit(-1);
		}
		String file = args[0];
		int month = Integer.parseInt(args[1]);
		int year = Integer.parseInt(args[2]);

		List<Account> accounts = BudgetPlannerImporter.readCsv(Paths.get(file));
		if (accounts.isEmpty()) {
			LOGGER.error("No data loaded.");
			System.exit(-1);
		}
		LOGGER.debug("Bestand geladen...");
		for (Account account : accounts) {

			MonthlyReportInformation monthlyReportInformation = new MonthlyReportInformation();
			Month monthOfYear = Month.of(month);
			monthlyReportInformation.setFullName(account.getFullName());
			monthlyReportInformation.setMonth(monthOfYear);
			monthlyReportInformation.setYear(year);
			monthlyReportInformation.setIncoming(account.getIncome(monthOfYear, year));
			monthlyReportInformation.setOutgoing(account.getExpenses(monthOfYear, year));
			String filename = "reports/" + account.getFullName() + "_" + month + "_" + year + ".pdf";
			MontlyReportPdfWriter.createAndSaveDocument(monthlyReportInformation, Path.of(filename));
		}
	}

}
