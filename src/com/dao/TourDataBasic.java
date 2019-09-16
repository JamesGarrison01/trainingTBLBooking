package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Tour;
import com.util.DBUtil;

public class TourDataBasic implements TourData {

	@Override
	public int addTour(Tour tour) {
		int tourCount = 0;
		
			Connection con = null;
			try {
				
				con  = DBUtil.getConnect();
				
				String query = "INSERT INTO tour_plan_mst ( tour_name, "
						+ "starting_location, places_included, "
						+ "tour_cost, discount_per, tour_days) "
						+ "VALUES (?,?,?,?,?,?)";

				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setString(1, tour.getTourName());
				ps.setString(2, tour.getStartLoc());
				ps.setString(3, tour.getPlaceInc());
				ps.setInt(4, tour.getTourCost());
				ps.setInt(5, tour.getDiscount());
				ps.setInt(6, tour.getTourDays());

				
				if(ps.executeUpdate() != 0) {
					tourCount++;
				}
				ps.close();
				
				
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					DBUtil.closeConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return tourCount;
	}

	@Override
	public Tour getToursByName(String tourName){
		Tour tour = new Tour();
		
		Connection con = null;
		try {
			con = DBUtil.getConnect();
			String query = "SELECT * FROM tour_plan_mst WHERE tour_name = ?";
		
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, tourName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				tour.setTourId(rs.getInt("tour_id"));
				tour.setTourName(rs.getString("tour_name"));
				tour.setStartLoc(rs.getString("starting_location"));
				tour.setPlaceInc(rs.getString("places_included"));
				tour.setTourCost(rs.getInt("tour_cost"));
				tour.setDiscount(rs.getInt("Discount_per"));
				tour.setTourDays(rs.getInt("tour_days"));
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tour;
		
	}
	
	@Override
	public List<Tour> getToursByCost(int tourCost) {
	List<Tour> tourList = new ArrayList<Tour>();
		
		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "select * from tour_plan_mst where tour_cost <= ?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, tourCost);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Tour tour = new Tour();
				tour.setTourId(rs.getInt("tour_id"));
				tour.setTourName(rs.getString("tour_name"));
				tour.setStartLoc(rs.getString("starting_location"));
				tour.setPlaceInc(rs.getString("places_included"));
				tour.setTourCost(rs.getInt("tour_cost"));
				tour.setDiscount(rs.getInt("Discount_per"));
				tour.setTourDays(rs.getInt("tour_days"));
				tourList.add(tour);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tourList;
	}

	@Override
	public List<String> getTours() {
		List<String> tourList = new ArrayList<String>();
		
		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "select * from tour_plan_mst";
			
			PreparedStatement ps = con.prepareStatement(query);

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tourList.add(rs.getString("tour_name"));
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tourList;
	}
	
	@Override
	public List<Tour> getToursByPOI(String tourPOI) {
	List<Tour> tourList = new ArrayList<Tour>();
		
		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "select * from tour_plan_mst where places_included LIKE ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			tourPOI = "%" + tourPOI + "%";
			ps.setString(1, tourPOI);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Tour tour = new Tour();
				tour.setTourId(rs.getInt("tour_id"));
				tour.setTourName(rs.getString("tour_name"));
				tour.setStartLoc(rs.getString("starting_location"));
				tour.setPlaceInc(rs.getString("places_included"));
				tour.setTourCost(rs.getInt("tour_cost"));
				tour.setDiscount(rs.getInt("Discount_per"));
				tour.setTourDays(rs.getInt("tour_days"));
				tourList.add(tour);
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tourList;
	}

	@Override
	public List<Tour> getToursByBoth(int tourCost, String tourPOI) {
	List<Tour> tourList = new ArrayList<Tour>();
		
		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "select * from tour_plan_mst where places_included LIKE ?"
					+ "AND tour_cost < ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			tourPOI = "%" + tourPOI + "%";
			ps.setString(1, tourPOI);
			ps.setInt(2, tourCost);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Tour tour = new Tour();
				tour.setTourId(rs.getInt("tour_id"));
				tour.setTourName(rs.getString("tour_name"));
				tour.setStartLoc(rs.getString("starting_location"));
				tour.setPlaceInc(rs.getString("places_included"));
				tour.setTourCost(rs.getInt("tour_cost"));
				tour.setDiscount(rs.getInt("Discount_per"));
				tour.setTourDays(rs.getInt("tour_days"));
				tourList.add(tour);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tourList;
	}

	@Override
	public int cancelTourByID(int tourId) {
		int validation = 0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnect();
			String query = "DELETE FROM registration_details WHERE tour_id = ?";
		
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, tourId);
			
			if(ps.executeUpdate() == 1) {
				validation++;
			}
			ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return validation;
	}

}
