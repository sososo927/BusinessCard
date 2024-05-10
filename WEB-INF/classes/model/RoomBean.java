package model;

public class RoomBean {
	private int roomid;
  private int senderid;
  private String max_date;

  public RoomBean(int roomid,int senderid,String max_date) {
	  this.roomid = roomid;
    this.senderid = senderid;
    this.max_date = max_date;
  }

public int getSenderid() {
	return senderid;
}

public void setSenderid(int senderid) {
	this.senderid = senderid;
}

public String getMax_date() {
	return max_date;
}

public void setMax_date(String max_date) {
	this.max_date = max_date;
}

public int getRoomid() {
	return roomid;
}

public void setRoomid(int roomid) {
	this.roomid = roomid;
}

  
}
