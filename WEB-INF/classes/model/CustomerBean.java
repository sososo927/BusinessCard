package model;

public class CustomerBean {

	/*yoyakuInfo用*/
	
	public int AID;
	private String FN;
	private String Industry;
	private String Cname;
	private String Pass;
	private String Phonenum;
	private String gender;
	private String Prefecture;
	private String Address;
	private String MailAdd;
	public CustomerBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public CustomerBean(int AID) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setAID(AID);
	}
	
	public CustomerBean(int AID,String FN,String Cname,String Phonenum,String Address,String MailAdd) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setAID(AID);
		this.setFN(FN);
		this.setCname(Cname);
		this.setPhonenum(Phonenum);
		this.setAddress(Address);
		this.setMailAdd(MailAdd);
	}
	
	public CustomerBean(int AID,String FN,String Industry,String Cname,String Pass,String Phonenum,String Gender,String Prefecture,String Address,String MailAdd) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setAID(AID);
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
	public int getAID() {return AID;}
	public void setAID(int AID) {this.AID=AID;}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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

}
