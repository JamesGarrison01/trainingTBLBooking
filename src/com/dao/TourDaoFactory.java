package com.dao;

public class TourDaoFactory {
	private static TourDaoFactory tourFactory = null;
	
	private TourDaoFactory() {
	}
	
	public static TourDaoFactory getTourFactoryInstance() {
		if(tourFactory == null) {
			tourFactory = new TourDaoFactory();
		}
		
		return tourFactory;
	}
	
	public TourData getTourStorage(String storageMedium) {
		TourData tourData = null;
		
		if("basic".equals(storageMedium)) {
			tourData = new TourDataBasic();
		}
		
		return tourData;
	}
}
