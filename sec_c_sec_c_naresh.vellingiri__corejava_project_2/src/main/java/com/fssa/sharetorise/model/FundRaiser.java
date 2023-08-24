package com.fssa.sharetorise.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/*
 * 
 * multiple recievers
 * 
 * */
public class FundRaiser {

	private int fundraiserId;// ===============

	private String title;// ===============

	private String description;// ===============

	private double fundingGoal;// ===============

	private LocalDate fundEndingDate;// ===============

	private String imageUrl;

	private List<Certificate> certificate;// create set 1-img1;2-img2

	public FundRaiser() {

	}

	public FundRaiser(int fundraiserId, String title, String description, double fundingGoal, LocalDate fundEndingDate,
			String imageUrl, List<Certificate> certificate) {
		this.fundraiserId = fundraiserId;
		this.title = title;
		this.description = description;
		this.fundingGoal = fundingGoal;
		this.fundEndingDate = fundEndingDate;
		this.imageUrl = imageUrl;
		this.certificate = certificate;

	}

	public int getFundraiserId() {
		return fundraiserId;
	}

	public void setFundraiserId(int fundraiserId) {
		this.fundraiserId = fundraiserId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getFundingGoal() {
		return fundingGoal;
	}

	public void setFundingGoal(double fundingGoal) {
		this.fundingGoal = fundingGoal;
	}

	public LocalDate getFundEndingDate() {
		return fundEndingDate;
	}

	public void setFundEndingDate(LocalDate fundEndingDate) {
		this.fundEndingDate = fundEndingDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Certificate> getCertificate() {
		return certificate;
	}

	public void setCertificate(List<Certificate> certificate) {
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		return "FundRaiser [fundraiserId=" + fundraiserId + ", title=" + title + ", description=" + description
				+ ", fundingGoal=" + fundingGoal + ", fundEndingDate=" + fundEndingDate + ", imageUrl=" + imageUrl
				+ ", certificate=" + certificate + "]";
	}

}
