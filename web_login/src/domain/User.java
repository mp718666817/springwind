package domain;

import java.util.Date;

public class User {
	private String  name;
	private String pwd;
	private String email;
	private Date birthdayDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public User(String name, String pwd, String email, Date birthdayDate) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.birthdayDate = birthdayDate;
	}

	
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public User() {
		super();
	}
	
	
}
