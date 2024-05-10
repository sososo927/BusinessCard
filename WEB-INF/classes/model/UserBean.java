package model;

import java.io.Serializable;

public class UserBean implements Serializable{
	private String loginid;
	private String name;
	private String pass;
	
	public UserBean() {}
	
	public UserBean(String loginid,String name,String pass) {
		this.loginid=loginid;
		this.name=name;
		this.pass=pass;
	}
	public String getLoginid() {return loginid;}
	public String getName() {return name;}
	public String getPass() {return pass;}
}
