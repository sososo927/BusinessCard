package model;

public class ScheduleBean {
	private int id;
	private String userid;
	private String scheduledate;
	private String starttime;
	private String endtime;
	private String schedule;
	private String memo;
	public ScheduleBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public ScheduleBean(int id,String userid,String scheduledate,String starttime,String endtime,String schedule,String memo) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setId(id);
		this.setUserid(userid);
		this.setScheduledate(scheduledate);
		this.setStarttime(starttime);
		this.setEndtime(endtime);
		this.setSchedule(schedule);
		this.setMemo(memo);
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getScheduledate() {
		return scheduledate;
	}
	public void setScheduledate(String scheduledate) {
		this.scheduledate = scheduledate;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
