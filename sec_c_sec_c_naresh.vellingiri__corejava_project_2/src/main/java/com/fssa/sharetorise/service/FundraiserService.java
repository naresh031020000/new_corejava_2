package com.fssa.sharetorise.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.sharetorise.dao.DonateFundDao;
import com.fssa.sharetorise.dao.ShareToRiseDAO;
import com.fssa.sharetorise.exceptions.*;
import com.fssa.sharetorise.model.FundRaiser;
import com.fssa.sharetorise.validator.FundraisingValidator;

public class FundraiserService {

	FundraisingValidator validator = new FundraisingValidator();
	ShareToRiseDAO dao = new ShareToRiseDAO();
	DonateFundDao donateFundDao = new DonateFundDao();

	public boolean createFundraiser(FundRaiser fundraiser) throws DAOException {

		if (validator.validateFundingRaiser(fundraiser)) {

			if (fundraiser.getCertificate().isEmpty() && fundraiser.getVideo().isEmpty()) {

				// call basic DAO Method
				return dao.createFundraiserWithNone(fundraiser);

			}

			else if (fundraiser.getVideo().isEmpty()) {

				// call the basic and cert method
				return dao.createFundraiserWithCertificates(fundraiser);
			}

			else if (fundraiser.getCertificate().isEmpty()) {
				return dao.createFundraiserWithVideosOnly(fundraiser);

			} else {

				// call the all the method to add all the details
				return dao.createFundraiser(fundraiser);
			}

		}
		return false;

	}

	public boolean updateFundraiser(FundRaiser fundraiser, int id) throws DAOException {

		if (validator.validateFundingRaiser(fundraiser)) {

			if (fundraiser.getCertificate().isEmpty() && fundraiser.getVideo().isEmpty()) {

				// call basic DAO Method
				return dao.updateFundraiser(fundraiser, id);

			}

			else if (fundraiser.getVideo().isEmpty()) {

				// call the basic and cert method
				return dao.updateFundraiserWithVideo(fundraiser, id);
			}

			else if (fundraiser.getCertificate().isEmpty()) {
				return dao.updateFundraiserWithCer(fundraiser, id);

			} else {

				// call the all the method to add all the details
				return dao.updateFundraiserWithAll(fundraiser, id);
			}

		}
		return false;
	}

	public List<FundRaiser> readAllFundraiser() throws DAOException {

		return dao.getAllFundraiser();
	}

	public boolean deleteFundRaiser(int id) throws DAOException {

		return dao.deleteFundraiser(id);
	}

	public boolean deleteCertificates(int id) throws DAOException {

		return dao.deleteCertificates(id);
	}

	public boolean deleteVideoLinks(int id) throws DAOException {

		return dao.deleteVideoLinks(id);
	}

	public FundRaiser getFundraiserById(int id) throws DAOException {
		try {

			return dao.getFundRaiserById(id);

		} catch (SQLException e) {

			throw new DAOException(e.getMessage());

		}
	}

	public boolean donateFundint(double amount, int userId, int fundRaiserId) throws DAOException {

		if (true) {
			return donateFundDao.donateFund(amount, userId, fundRaiserId);
		}
		return false;

	}

	public int countDonationsByFundraiserId(int fundraiserId) {

		return donateFundDao.countDonationsByFundraiserId(fundraiserId);
	}

	public List<FundRaiser> readAllFundraiserByUserId(int id) throws DAOException {

		return dao.getAllFundraiserByUserId(id);
	}

	public static void main(String[] args) {
		FundraiserService fundraiserService = new FundraiserService();

		System.out.println(fundraiserService.readAllFundraiserByUserId(1));
	}

}
