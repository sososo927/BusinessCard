package model;

import servlet.IDLogic;

public class CustomerInsertBean {

	/*yoyakuInfo用*/
	public String AID;
	private String FN;
	private String Industry;
	private String Cname;
	private String Pass;
	private String Phonenum;
	private String gender;
	private String Prefecture;
	private String Address;
	private String MailAdd;
	public int count1=2024000000;
	public CustomerInsertBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public CustomerInsertBean(String AID,String FN,String Industry,String Cname,String Pass,String Phonenum,String Gender,String Prefecture,String Address,String MailAdd,int count) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setAID(Integer.toString(count1+1));
		this.setFN(FN);
		this.setIndustry(Industry);
		this.setCname(Cname);
		this.setPass(Pass);
		this.setPhonenum(Phonenum);
		this.setGender(gender);
		this.setPrefecture(Prefecture);
		this.setAddress(Address);
		this.setMailAdd(MailAdd);
		
	}
	public int getCount1() {
		System.out.println("CustemerinsertBeanでの出来事"+IDLogic.getIDplus());
		count1=IDLogic.getIDplus()+1;
		//count=2023000010;
		return count1;
		}
	public void setCount1(int count1) {
		this.count1=count1+1;
		}
	public String getAID() {return AID;}
	public void setAID(String AID) {this.AID=AID;}
	public String getFN() {
		return FN;
	}
	public void setFN(String fN) {
		FN = fN;
	}
	public String getIndustry() {
		return Industry;
	}
	public void setIndustry(String industry) {
		Industry = industry;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getPhonenum() {
		return Phonenum;
	}
	public void setPhonenum(String phonenum) {
		Phonenum = phonenum;
	}
	public String getPrefecture() {
		return Prefecture;
	}
	public void setPrefecture(String prefecture) {
		Prefecture = prefecture;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMailAdd() {
		return MailAdd;
	}
	public void setMailAdd(String mailAdd) {
		MailAdd = mailAdd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
