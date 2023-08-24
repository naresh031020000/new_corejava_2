package com.fssa.sharetorise.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import com.fssa.sharetorise.dao.ShareToRiseDAO;
import com.fssa.sharetorise.logger.Logger;
import com.fssa.sharetorise.model.Certificate;
import com.fssa.sharetorise.model.FundRaiser;

public class TestUserService {

	FundraiserService user = new FundraiserService();

	FundRaiser fundraiser = new FundRaiser();

	ShareToRiseDAO dao = new ShareToRiseDAO();

	Logger log = new Logger();

	// Test case for service layer

	@Test

	void testCreateFundraiser() {


		FundRaiser fund = new FundRaiser();

//    	FundraisingValidator

		fund.setTitle("Fund for Balaji");
		fund.setDescription("This fund is need for future football player who needs fund for his financial ");
		fund.setFundEndingDate(LocalDate.of(2023, 8, 26));
		fund.setImageUrl("https://www.kasandbox.org/programming-images/avatars/spunky-sam.png");
		fund.setFundingGoal(3000);

		List<Certificate> certificates = new ArrayList<>();
		certificates.add(
				new Certificate("h369sjfn", "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png"));
		certificates
				.add(new Certificate("h647jfn", "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png"));

		fund.setCertificate(certificates);

		assertDoesNotThrow(() -> user.createFundraiser(fund));

	}

	@Test

	void testUpdateFundraiser() { 

 
//    	FundraisingValidator
		FundRaiser fund = new FundRaiser();

		fund.setTitle("Fund for naresh");
		fund.setDescription("This fund is need for future football player who needs fund for his financial ");
		fund.setFundEndingDate(LocalDate.of(2023, 8, 26));
		fund.setFundingGoal(8998);
		fund.setImageUrl("https://www.kasandbox.org/programming-images/avatars/spunky-sam.png");

		List<Certificate> certificates = new ArrayList<>();
		certificates.add(
				new Certificate("h369sjfn", "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png"));
		certificates
				.add(new Certificate("h647jfn", "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png"));

		fund.setCertificate(certificates);
		assertDoesNotThrow(() -> user.updateFundraiser(fund, 1));

	}

	

}
