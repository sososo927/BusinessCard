package model;

import servlet.IDLogic2;

public class ScheduleInsertBean {
	private String id;
	private String userid;
	private String scheduledate;
	private String starttime;
	private String endtime;
	private String schedule;
	private String memo;
	public int count2=1024000000;
	public ScheduleInsertBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public ScheduleInsertBean(String Id,String userid,String scheduledate,String starttime,String endtime,String schedule,String memo) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setId(Integer.toString(count2+1));
		this.setUserid(userid);
		this.setScheduledate(scheduledate);
		this.setStarttime(starttime);
		this.setEndtime(endtime);
		this.setSchedule(schedule);
		this.setMemo(memo);
	}
	public int getCount2() {
		System.out.println("ScheduleInsertBeanでの出来事"+IDLogic2.getIDplus2());
		count2=IDLogic2.getIDplus2()+1;
		//count=2023000010;
		return count2;
		}
	public void setCount2(int count2) {
		this.count2=count2+1;
		}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
}
