package com.fssa.sharetorise.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.sharetorise.dao.ShareToRiseDAO;
import com.fssa.sharetorise.logger.Logger;
import com.fssa.sharetorise.model.FundRaiser;

public class TestUserService {

	FundraiserService user = new FundraiserService();

	FundRaiser fundraiser = new FundRaiser();

	ShareToRiseDAO dao = new ShareToRiseDAO();

	Logger log = new Logger();

	// Test case for service layer

	@Test

	void testCreateFundraiser() {

//    	FundraisingValidator

		fundraiser.setTitle("Fund for Hemanath");
		fundraiser.setDescription("This fund is need for future football player who needs fund for his financial ");
		fundraiser.setFundEndingDate(LocalDate.of(2023, 8, 26));
		fundraiser.setFundingGoal(3000);

		assertDoesNotThrow(() -> user.createFundraiser(fundraiser));

	}

	@Test

	void testUpdateFundraiser() {

//    	FundraisingValidator

		fundraiser.setTitle("Fund for naresh");
		fundraiser.setDescription("This fund is need for future football player who needs fund for his financial ");
		fundraiser.setFundEndingDate(LocalDate.of(2023, 8, 26));
		fundraiser.setFundingGoal(4321);
		fundraiser.setFundraiserId(1);

		assertDoesNotThrow(() -> user.updateFundraiser(fundraiser));

	}

	@Test
	void testReadAllFundraisers() {

		List<FundRaiser> fundingRaiserList = user.readAllFundraiser();

		assertNotNull(fundingRaiserList);
		assertFalse(fundingRaiserList.isEmpty());

		for (FundRaiser fundRaiser : fundingRaiserList) {

			log.info(fundRaiser);
		}

	}

}
