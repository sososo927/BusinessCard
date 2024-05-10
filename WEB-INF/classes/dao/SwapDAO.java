package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SwapBean;
public class SwapDAO {

	/*private final String JDBC_URL="jdbc:mysql://localhost/busiesecard_db";
	private final String DB_USER="R2A406";
	//private final String DB_USER="root";
	private final String DB_PASS="mysql";*/
	
	//private final String JDBC_URL="jdbc:mysql://fukushima-pc/reserveSystemDB";
	//private final String DB_USER="teamG";
	//private final String DB_PASS="guavaMySQL";
	
	private final String JDBC_URL="jdbc:mariadb://localhost/busiesecard_db";
	//private final String DB_USER="R2A406";
	private final String DB_USER="root";
	private final String DB_PASS="mysql";
	public int flag2=999;
	public List<SwapBean> findAll(){
		List<SwapBean> swapList=new ArrayList<SwapBean>();
		
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT * FROM swap";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			
			ResultSet rs=pStmt.executeQuery();
			
			while(rs.next()) {
				int received_id=rs.getInt("Received_id");
				int sender_id=rs.getInt("Sender_id");
				int flag=rs.getInt("Flag");
				int room_id=rs.getInt("Room_id");
				
				
				SwapBean swBean=new SwapBean(received_id,sender_id,flag,room_id);
				swapList.add(swBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return swapList;
	}
	public boolean insert(SwapBean presence2) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="INSERT INTO swap(Reciver_id,Sender_id,Flag,Room_id) VALUES (?,?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setInt(1,presence2.getReceiver_id());
			pStmt.setInt(2,presence2.getSender_id());
			pStmt.setInt(3,presence2.getFlag());
			pStmt.setInt(4,presence2.getRoom_id());
			
			int result=pStmt.executeUpdate();
			
			if(result!=1) {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("追加時に問題が発生しました。");
			e.printStackTrace();
			return false;
		}
		System.out.println("正常追加完了");
		return true;
	}

	public boolean searchflag(SwapBean presence2) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT Flag FROM swap WHERE Reciver_id=? AND Sender_id=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setInt(1,presence2.getReceiver_id());
			pStmt.setInt(2,presence2.getSender_id());
			
			ResultSet rs=pStmt.executeQuery();
			
			while(rs.next()) {
				int flag=rs.getInt("Flag");
				flag2=flag;
			}
		}catch(SQLException e) {
			System.out.println("追加時に問題が発生しました。");
			e.printStackTrace();
			return false;
		}
		System.out.println("正常検索完了");
		return true;
	}
	public static SwapDAO getInstance() {
		return new SwapDAO();
	}
}

