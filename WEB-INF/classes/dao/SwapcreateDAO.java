package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CustomerBean;

public class SwapcreateDAO {

	/*private final String JDBC_URL="jdbc:mysql://localhost/busiesecard_db";
	private final String DB_USER="R2A406";
	private final String DB_PASS="mysql";*/
	
	//private final String JDBC_URL="jdbc:mysql://fukushima-pc/reserveSystemDB";
	//private final String DB_USER="teamG";
	//private final String DB_PASS="guavaMySQL";
	
	private final String JDBC_URL="jdbc:mariadb://localhost/busiesecard_db";
	//private final String DB_USER="R2A406";
	private final String DB_USER="root";
	private final String DB_PASS="mysql";
	public int flag2=999;
	public ArrayList<CustomerBean> acselect() {
		ArrayList<CustomerBean> acList = new ArrayList<CustomerBean>();
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)) {	
			String sql="SELECT AID FROM account";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			
			ResultSet rs=pStmt.executeQuery();
				
			while(rs.next()) {
				int Aid=rs.getInt("AID");
				CustomerBean csBean=new CustomerBean(Aid);
				acList.add(csBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return acList;
	}
	
	public void swinsert(int aid,int aid2) {
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)) {
			String sql="INSERT INTO swap(Reciver_id,Sender_id) VALUES (?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setInt(1,aid);
			pStmt.setInt(2,aid2);
			pStmt.executeUpdate();
			
			sql="INSERT INTO swap(Reciver_id,Sender_id) VALUES (?,?)";
			pStmt=conn.prepareStatement(sql);
			pStmt.setInt(1,aid2);
			pStmt.setInt(2,aid);
			pStmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Swapcreateのエラー");
		}
		
	}
}

