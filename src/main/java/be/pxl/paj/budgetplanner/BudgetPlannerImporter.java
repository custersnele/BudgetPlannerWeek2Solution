package be.pxl.paj.budgetplanner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.*;

public class BudgetPlannerImporter {
	private static final Logger LOGGER = LogManager.getLogger(BudgetPlannerImporter.class);
	private static final PathMatcher CSV_MATCHER = FileSystems.getDefault().getPathMatcher("glob:**/*.csv");

	public static List<Account> readCsv(Path path) {
		Map<String, Account> accounts = new HashMap<>();

		if (!CSV_MATCHER.matches(path)) {
			LOGGER.debug("Invalid file: .csv expected. Provided: {}", path);
			return new ArrayList<>();
		}
		if (!Files.exists(path)) {
			LOGGER.error("File {} does not exist.", path);
			return new ArrayList<>();
		}

		try (BufferedReader reader = Files.newBufferedReader(path)) { // try-with-resources
			String line = null;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				try {
					Account account = AccountMapper.map(line);
					if (accounts.containsKey(account.getFullName())) {
						Transaction transaction = TransactionMapper.map(line);
						accounts.get(account.getFullName()).addTransaction(transaction);
					} else {
						account.addTransaction(TransactionMapper.map(line));
						accounts.put(account.getFullName(), account);
					}
				} catch (InvalidTransactionException e) {
					LOGGER.error("Error while mapping line: {}", e.getMessage());
				}
			}
		} catch (IOException e) {
			LOGGER.fatal("An error occurred while reading file: {}", path);
		}
		return new ArrayList<>(accounts.values());
	}
}
