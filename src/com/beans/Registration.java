package com.beans;

import java.sql.Date;

public class Registration {
	int tourID;
	String memberName;
	int noPassengers;
	int amtPaid;
	Date journeyStartDate;
	int tourBookingId;
	boolean isActive;
	String remarks;
	
	public Registration(){
		
	}

	public Registration(int tourID, String memberName, int noPassengers, int amtPaid, Date journeyStartDate,
			int tourBookingId, boolean isActive, String remarks) {
		super();
		this.tourID = tourID;
		this.memberName = memberName;
		this.noPassengers = noPassengers;
		this.amtPaid = amtPaid;
		this.journeyStartDate = journeyStartDate;
		this.tourBookingId = tourBookingId;
		this.isActive = isActive;
		this.remarks = remarks;
	}



	public int getTourID() {
		return tourID;
	}

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getNoPassengers() {
		return noPassengers;
	}

	public void setNoPassengers(int noPassengers) {
		this.noPassengers = noPassengers;
	}

	public int getAmtPaid() {
		return amtPaid;
	}

	public void setAmtPaid(int amtPaid) {
		this.amtPaid = amtPaid;
	}

	public Date getJourneyStartDate() {
		return journeyStartDate;
	}

	public void setJourneyStartDate(Date sqlStartDate) {
		this.journeyStartDate = sqlStartDate;
	}

	public int getTourBookingId() {
		return tourBookingId;
	}

	public void setTourBookingId(int tourBookingId) {
		this.tourBookingId = tourBookingId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Registration [tourID=" + tourID + ", membername=" + memberName + ", noPassengers=" + noPassengers
				+ ", amtPaid=" + amtPaid + ", journeyStartDate=" + journeyStartDate + "]";
	}
	
	
}
