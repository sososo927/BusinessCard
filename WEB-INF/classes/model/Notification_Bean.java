package model;

public class Notification_Bean {
	private int user_id;
	private String name;
	private String company_name;
	private String phonenum;
	private String add;
	private String mailadd;
	private int flag;
	private int room_id;
	
	public Notification_Bean() {}
	
	public Notification_Bean(int user_id,String name,String company_name) {
		this.user_id = user_id;
		this.name = name;
		this.company_name = company_name;
	}
	
	public Notification_Bean(int user_id,String name,String company_name,int room_id) {
		this.user_id = user_id;
		this.name = name;
		this.company_name = company_name;
		this.room_id = room_id;
	}
	
	public Notification_Bean(int user_id,String name,String company_name,String phonenum,String add,String mailadd) {
		this.user_id = user_id;
		this.name = name;
		this.company_name = company_name;
		this.phonenum = phonenum;
		this.add = add;
		this.mailadd = mailadd;
	}
	
	public Notification_Bean(int user_id,String name,String company_name,String phonenum,String add,String mailadd,int flag,int room_id) {
		this.user_id = user_id;
		this.name = name;
		this.company_name = company_name;
		this.phonenum = phonenum;
		this.add = add;
		this.mailadd = mailadd;
		this.flag = flag;
		this.room_id = room_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getMailadd() {
		return mailadd;
	}

	public void setMailadd(String mailadd) {
		this.mailadd = mailadd;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	
	
}
