package model;

public class SwapBean {
	private int receiver_id;
	private int sender_id;
	private int flag;
	private int room_id;
	public SwapBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public SwapBean(int receiver_id,int sender_id,int flag,int room_id) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setReceiver_id(receiver_id);
		this.setSender_id(sender_id);
		this.setFlag(flag);
		this.setRoom_id(room_id);
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	public int getSender_id() {
		return sender_id;
	}
	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
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
