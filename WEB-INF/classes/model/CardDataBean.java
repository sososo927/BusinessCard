package model;

public class CardDataBean {

	private String organization;
	private String name;
	private String company;
	private String prefecture;
	public CardDataBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public CardDataBean(String organization,String name,String company,String prefecture) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setOrganization(organization);
		this.setName(name);
		this.setCompany(company);
		this.setPrefecture(prefecture);
	}
	public String getOrganization() {return organization;}
	public void setOrganization(String organization) {this.organization=organization;}
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public String getCompany() {return company;}
	public void setCompany(String company) {this.company=company;}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
}
