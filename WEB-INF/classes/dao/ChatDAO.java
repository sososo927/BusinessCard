package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ChatHistoryBean;
import model.RoomBean;
public class ChatDAO {

	private final String JDBC_URL="jdbc:mariadb://localhost/busiesecard_db";
	//private final String DB_USER="R2A406";
	private final String DB_USER="root";
	private final String DB_PASS="mysql";


 public List<RoomBean> findAll() {
     List<RoomBean> roomList = new ArrayList<RoomBean>();
//現在ログイン中のユーザがチャット可能なリストの表示
     try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
          PreparedStatement RoompStmt = conn.prepareStatement("SELECT SENDERID,ROOMID,MAX(MESSAGEDATE) AS MAX_DATE FROM chat WHERE RECEIVERID = 999  GROUP BY SENDERID,RECEIVERID;");) {
         try (ResultSet Roomrs = RoompStmt.executeQuery()) {
             while (Roomrs.next()) {
            	 int roomid = Roomrs.getInt("ROOMID");
                 int senderid = Roomrs.getInt("SENDERID");
                 String max_date = Roomrs.getString("MAX_DATE");
                 RoomBean RoomBean = new RoomBean(roomid,senderid, max_date);
                 roomList.add(RoomBean);
             }
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }

     return roomList;
 }
 
// 個人ルームの履歴を取得するメソッド
public List<ChatHistoryBean> getChatHistoryByRoomId(int roomid) {
    List<ChatHistoryBean> chatHistoryList = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
         PreparedStatement ChatpStmt = conn.prepareStatement("SELECT * FROM chat WHERE ROOMID = ? ORDER BY MESSAGEDATE DESC;");){
    		ChatpStmt.setInt(1, roomid);
        	try (ResultSet Chatrs = ChatpStmt.executeQuery()) {
        		while (Chatrs.next()) {
        			int chat_roomid = Chatrs.getInt("ROOMID");
        			int chat_receiverId = Chatrs.getInt("RECEIVERID");
        			int chat_senderId = Chatrs.getInt("SENDERID");
        			String  chat_messagedate= Chatrs.getString("MESSAGEDATE");
        			String chat_sentence = Chatrs.getString("SENTENCE");

        		ChatHistoryBean chatHistoryBean = new ChatHistoryBean(chat_roomid,chat_receiverId, chat_senderId,chat_messagedate,chat_sentence);
                // ChatHistoryBean に必要な情報をセット
                chatHistoryList.add(chatHistoryBean);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return chatHistoryList;
}

//チャットをインサートする
public boolean getSendMessageBean(int SendMessage_roomid,int SendMessage_receiverId, int SendMessage_senderId, String SendMessage_sentence,String loginID){
Connection conn = null;
int affectedRows = 0;
try {
    conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	PreparedStatement SendMessagepStmt = conn.prepareStatement("INSERT INTO chat (ROOMID, MESSAGEDATE,RECEIVERID, SENDERID,SENTENCE) VALUES (?,SYSDATE(), ?, ?, ?)");
	
	// if(loginID.equals(SendMessage_senderId)) {
 	SendMessagepStmt.setInt(1, SendMessage_roomid);
 	SendMessagepStmt.setInt(2, SendMessage_receiverId);
 	SendMessagepStmt.setInt(3, SendMessage_senderId);
 	SendMessagepStmt.setString(4, SendMessage_sentence);
	 //}
     // SQLを実行し、影響を受けた行数が返る
     affectedRows = 	SendMessagepStmt.executeUpdate();

     // 影響を受けた行数が1以上であれば挿入成功
     conn.commit();
 } catch (SQLException e) {
     e.printStackTrace();
     // エラーが発生した場合は挿入失敗
     
     return false;
 }finally {
     try {
         if (conn != null) {
             conn.setAutoCommit(true); // 元に戻
             conn.close();
         }
     } catch (SQLException e) {
         e.printStackTrace();
     	}
     }
return affectedRows > 0;
}

//チャットを削除する
 public String Chat_Delete(String ChatDelete_messagedate) {
	 try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			 PreparedStatement Chat_DeleteStmt = conn.prepareStatement("DELETE FROM chat WHERE MESSAGEDATE =?")) {
		 Chat_DeleteStmt.setString(1, ChatDelete_messagedate);
		 Chat_DeleteStmt.executeUpdate();
		     conn.commit();
	 } catch (SQLException e) {
	     e.printStackTrace();	     
	 }
	return ChatDelete_messagedate;
 } 
 
 //Flagを6に更新
 public void Flag_Change_Six(int se,int re,int roomId) {
	    Connection conn = null;
	    try {
	        conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	        conn.setAutoCommit(false);

	        try (PreparedStatement Flag_Change_Six = conn.prepareStatement("UPDATE swap SET FLAG = 6 WHERE SENDER_ID = ? AND RECIVER_ID = ? AND ROOM_ID = ?")) {
	            Flag_Change_Six.setInt(1, re);
	            Flag_Change_Six.setInt(2, se);
	            Flag_Change_Six.setInt(3, roomId);
	            System.out.println("送信者6:"+se);
	            System.out.println("受信者6:"+re);
	            
	            Flag_Change_Six.executeUpdate();
	            conn.commit();
	        } catch (SQLException e) {
	            conn.rollback(); // ロールバックを追加
	            e.printStackTrace();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (conn != null) {
	                conn.setAutoCommit(true); // 元に戻す
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
 //Flag5に更新

public void Flag_Change_Five(int se,int re,int roomId) {
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
         PreparedStatement Flag_Change_Five = conn.prepareStatement("UPDATE swap SET FLAG = 5 WHERE SENDER_ID = ? AND RECIVER_ID = ? AND ROOM_ID = ?")) {
    	Flag_Change_Five.setInt(1, se);
        Flag_Change_Five.setInt(2, re);
    	Flag_Change_Five.setInt(3, roomId);
    	
    	System.out.println("送信者5:"+se);
        System.out.println("受信者5:"+re);
    	
    	Flag_Change_Five.executeUpdate();
    	
	     conn.commit();
    } catch (SQLException e) {
    	e.printStackTrace(); // あるいは、適切な処理を行う
    }
}
}

