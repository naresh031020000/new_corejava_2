package com.fssa.sharetorise.model;

public class Donation {

	
	private int donation_amount;
	private int fundraiser_id;
	private int isAnonymous;
	private String PhoneNumber;
	public int getDonation_amount() {
		return donation_amount;
	}
	public void setDonation_amount(int donation_amount) {
		this.donation_amount = donation_amount;
	}
	public int getFundraiser_id() {
		return fundraiser_id;
	}
	public void setFundraiser_id(int fundraiser_id) {
		this.fundraiser_id = fundraiser_id;
	}
	public int getIsAnonymous() {
		return isAnonymous;
	}
	public void setIsAnonymous(int isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Donation [donation_amount=" + donation_amount + ", fundraiser_id=" + fundraiser_id + ", isAnonymous="
				+ isAnonymous + ", PhoneNumber=" + PhoneNumber + "]";
	}
	
	
}
