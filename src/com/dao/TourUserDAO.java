package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.Login;
import com.beans.Registration;
import com.util.DBUtil;

public class TourUserDAO implements UserData{
	
	public TourUserDAO(){
		
	}
	
	@Override
	public int checkUserLogin(String userName, String password) {
		int userValid = 0;

		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "Select login_id, password FROM LOGIN_MST WHERE login_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, userName);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String newUser = rs.getString("login_id");
				String newPass = rs.getString("password");
				
				if(newUser.equals(userName)) {
					if(newPass.equals(password)) {
						userValid++;
					}
				}
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
			
			
		return userValid;
	}

	@Override
	public int checkPrivlages(Login user) {
		int privlage = -1;
		if(user.getUserType() == "Admin")
			privlage = 1;
		else if(user.getUserType() == "Member")
			privlage = 2;
		
		return privlage;
	}

	@Override
	public int subscribeTourPackage(Registration newReg) {
		int userCount = 0;

		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "INSERT INTO registration_details (tour_booking_id, "
					+ "member_name, no_of_passengers, amount_paid, "
					+ "journey_start_date) "
					+ "VALUES (?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, newReg.getTourID());
			ps.setString(2, newReg.getMemberName());
			ps.setInt(3, newReg.getNoPassengers());
			ps.setInt(4, newReg.getAmtPaid());
			ps.setDate(5, newReg.getJourneyStartDate());

			if(ps.executeUpdate() != 0) {
				userCount++;
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
		return userCount;
	}

	@Override
	public int cancelTour(int bookingId) {
		int canceled = 0;

		Connection con = null;
		try {
			
			con  = DBUtil.getConnect();
			
			String query = "DELETE FROM registration_details WHERE tour_booking_id = ?";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, bookingId);

			if(ps.executeUpdate() != 0) {
				canceled++;
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
		return canceled;
	}

}
