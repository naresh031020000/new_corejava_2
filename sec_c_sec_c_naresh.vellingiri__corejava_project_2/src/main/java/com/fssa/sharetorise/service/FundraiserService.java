package com.fssa.sharetorise.service;

import java.util.List;

import com.fssa.sharetorise.dao.ShareToRiseDAO;
import com.fssa.sharetorise.exceptions.*;
import com.fssa.sharetorise.model.FundRaiser;
import com.fssa.sharetorise.validator.FundraisingValidator;

public class FundraiserService {

	FundraisingValidator validator = new FundraisingValidator();
	ShareToRiseDAO dao = new ShareToRiseDAO();

	public boolean createFundraiser(FundRaiser fundraiser) throws  DAOException {

		if (validator.validateFundingRaiser(fundraiser))
			return dao.createFundraiser(fundraiser);
		return false;

	}

	
	public boolean updateFundraiser (FundRaiser fundraiser, int id) throws  DAOException {
		
		if(validator.validateFundingRaiser(fundraiser))
			return dao.updateFundraiser(fundraiser, id);

		return false;
	}
	
	
	
}
