package model;

public class ChatHistoryBean {
  private int chat_roomid;
  private int chat_receiverId;
  private int chat_senderId;
  private String chat_messagedate;
  private String chat_sentence;
  
  public ChatHistoryBean() {}

  public ChatHistoryBean(int chat_roomid,int chat_receiverId, int chat_senderId, String chat_messagedate, String chat_sentence) {
	  this.chat_roomid = chat_roomid;
	  this.chat_receiverId = chat_receiverId;
	    this.chat_senderId = chat_senderId;
	    this.chat_messagedate = chat_messagedate;
	    this.chat_sentence = chat_sentence;
  }

public int getChat_receiverId() {
	return chat_receiverId;
}

public void setChat_receiverId(int chat_receiverId) {
	this.chat_receiverId = chat_receiverId;
}

public int getChat_senderId() {
	return chat_senderId;
}

public void setChat_senderId(int chat_senderId) {
	this.chat_senderId = chat_senderId;
}



public String getChat_sentence() {
	return chat_sentence;
}

public void setChat_sentence(String chat_sentence) {
	this.chat_sentence = chat_sentence;
}

public String getChat_messagedate() {
	return chat_messagedate;
}

public void setChat_messagedate(String chat_messagedate) {
	this.chat_messagedate = chat_messagedate;
}

public int getChat_roomid() {
	return chat_roomid;
}

public void setChat_roomid(int chat_roomid) {
	this.chat_roomid = chat_roomid;
}
}
  

