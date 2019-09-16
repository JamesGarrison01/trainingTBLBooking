package com.dao;

import com.beans.Login;
import com.beans.Registration;

public interface UserData {
	public int checkPrivlages(Login user);
	public int subscribeTourPackage(Registration newReg);
	public int cancelTour(int bookingId);
	public int checkUserLogin(String userName, String password);
}
