package model;

public class SendMessageBean {
	  private int SendMessage_roomid;
	  private int SendMessage_receiverId;
	  private int SendMessage_senderId;
	  private String SendMessage_sentence;
	public int getSendMessage_roomid() {
		return SendMessage_roomid;
	}
	public void setSendMessage_roomid(int sendMessage_roomid) {
		SendMessage_roomid = sendMessage_roomid;
	}
	public int getSendMessage_receiverId() {
		return SendMessage_receiverId;
	}
	public void setSendMessage_receiverId(int sendMessage_receiverId) {
		SendMessage_receiverId = sendMessage_receiverId;
	}
	public int getSendMessage_senderId() {
		return SendMessage_senderId;
	}
	public void setSendMessage_senderId(int sendMessage_senderId) {
		SendMessage_senderId = sendMessage_senderId;
	}
	public String getSendMessage_sentence() {
		return SendMessage_sentence;
	}
	public void setSendMessage_sentence(String sendMessage_sentence) {
		SendMessage_sentence = sendMessage_sentence;
	}
}
