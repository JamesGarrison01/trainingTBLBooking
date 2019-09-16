package com.dao;

import com.beans.Tour;
import java.util.List;

public interface TourData {
	public int addTour(Tour tour);
	public List<Tour> getToursByCost(int tourCost);
	public List<Tour> getToursByPOI(String tourPOI);
	public List<Tour> getToursByBoth(int tourCost, String tourPOI);
	public Tour getToursByName(String tourName);
	public int cancelTourByID(int tourId);
	public List<String> getTours();
}
