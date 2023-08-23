package com.fssa.sharetorise.validator;

/**
 * 
 * A class which holds the validator methods for the fundraiser object
 * 
 * @author NareshVellingiri
 */

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.sharetorise.errors.FundraiserErrors;
import com.fssa.sharetorise.exceptions.InvalidInputException;
import com.fssa.sharetorise.model.FundRaiser;

public class FundraisingValidator {

	public boolean validateFundingRaiser(FundRaiser fund) throws InvalidInputException {

		if (fund == null) {

			throw new InvalidInputException(FundraiserErrors.INVALID_ID);
		}

		validateTitle(fund.getTitle());
		validateDescription(fund.getDescription());
		validateFundingGoal(fund.getFundingGoal());
		validateFundEndingDate(fund.getFundEndingDate());

		return true;
	}

	/**
	 * Validates the title of a fundraiser.
	 * 
	 * @param title The title to validate.
	 * @return true if the title is valid.
	 * @throws InvalidInputException if the title is null, empty, or less than 30
	 *                                 characters long, or if it contains non-letter
	 *                                 characters.
	 */
	public boolean validateTitle(String title) throws InvalidInputException {
		// Check if the title is not null, not empty, and at least 30 characters long
		if (title == null || title.equals("") || title.length() < 10 || title.length() > 20) {
			throw new InvalidInputException(FundraiserErrors.INVALID_TITLE_NAME);
		}

		// Use a regular expression to check if the title contains only letters (no
		// numbers or special characters)
		String nameregex = "^[A-Za-z ]+$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(title);
		Boolean isMatch = matcher.matches();

		// If the title does not match the regular expression, it is considered invalid
		if (!isMatch) {
			throw new InvalidInputException(FundraiserErrors.INVALID_TITLE_NAME);
		}

		return true;
	}

	/**
	 * Validates the description of a fundraiser.
	 * 
	 * @param description The description to validate.
	 * @return true if the description is valid.
	 * @throws InvalidInputException if the description is null, empty, or less
	 *                                 than 300 characters long, or if it contains
	 *                                 non-letter characters.
	 */
	public boolean validateDescription(String description) throws InvalidInputException {
		// Check if the description is not null, not empty, and at least 300 characters
		// long
		if (description == null || description.trim().equals("") || description.length() < 30) {
			throw new InvalidInputException(FundraiserErrors.INVALID_DESCRIPTION);
		}

		// Use a regular expression to check if the description contains only letters
		// (no numbers or special characters)
		String nameregex = "^[A-Za-z ]+$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(description);
		Boolean isMatch = matcher.matches();

		// If the description matches the regular expression, it is considered invalid
		if (!isMatch) {
			throw new InvalidInputException(FundraiserErrors.INVALID_DESCRIPTION);
		}

		return true;
	}



	/**
	 * Validates the funding goal for a fundraiser.
	 * 
	 * @param fundingGoal The funding goal to validate.
	 * @return true if the funding goal is valid.
	 * @throws InvalidInputException if the funding goal is less than or equal to
	 *                                 2000.
	 */
	public boolean validateFundingGoal(double fundingGoal) throws InvalidInputException {
		// Check if the funding goal is greater than 2000
		if (fundingGoal <= 2000) {
			throw new InvalidInputException(FundraiserErrors.Funding_Goal);
		}
		return true;
	}

	/**
	 * Validates the ending date for a fundraiser.
	 * 
	 * @param fundEndingDate The ending date to validate.
	 * @return true if the ending date is valid.
	 * @throws InvalidInputException if the ending date is null or if it is before
	 *                                 the current date.
	 */
	public boolean validateFundEndingDate(LocalDate fundEndingDate) throws InvalidInputException {
		// Check if the ending date is not null and is not before the current date
		if (fundEndingDate == null) {
			throw new InvalidInputException(FundraiserErrors.Fund_Ending_Date);
		}

		LocalDate today = LocalDate.now();
		if (fundEndingDate.isBefore(today)) {
			throw new InvalidInputException(FundraiserErrors.Fund_Ending_Date);
		}

		return true;
	}
}
