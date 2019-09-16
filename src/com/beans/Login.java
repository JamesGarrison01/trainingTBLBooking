package com.beans;

public class Login {
	int userId;
	String loginId;
	String password;
	String userName;
	String userType;
	
	public Login() {
		
	}
	
	public Login(int userId, String loginId, String password, String userName, String userType) {
		super();
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.userName = userName;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Login [userId=" + userId + ", loginId=" + loginId + ", password=" + password + ", userName=" + userName
				+ ", userType=" + userType + "]";
	}
	
	
}
