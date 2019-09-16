package com.beans;

public class Tour {
	int tourId;
	String tourName;
	String startLoc;
	String placeInc;
	int tourCost;
	int discount;
	int tourDays;
	
	public Tour() {
		
	}
	
	public Tour(int tourId, String tourName, String startLoc, String placeInc, int tourCost, int discount,
			int tourDays) {
		super();
		this.tourId = tourId;
		this.tourName = tourName;
		this.startLoc = startLoc;
		this.placeInc = placeInc;
		this.tourCost = tourCost;
		this.discount = discount;
		this.tourDays = tourDays;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getStartLoc() {
		return startLoc;
	}

	public void setStartLoc(String startLoc) {
		this.startLoc = startLoc;
	}

	public String getPlaceInc() {
		return placeInc;
	}

	public void setPlaceInc(String placeInc) {
		this.placeInc = placeInc;
	}

	public int getTourCost() {
		return tourCost;
	}

	public void setTourCost(int tourCost) {
		this.tourCost = tourCost;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getTourDays() {
		return tourDays;
	}

	public void setTourDays(int tourDays) {
		this.tourDays = tourDays;
	}

	@Override
	public String toString() {
		return "Tour [tourId=" + tourId + ", tourName=" + tourName + ", startLoc=" + startLoc + ", placeInc=" + placeInc
				+ ", tourCost=" + tourCost + ", discount=" + discount + ", tourDays=" + tourDays + "]";
	}
	
	
}
