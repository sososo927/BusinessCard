package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CustomerBean;
 
public class Business_card_update_DAO {
 
	private final String JDBC_URL="jdbc:mariadb://localhost/busiesecard_db";
	private final String DB_USER = "root";
	private final String DB_PASS = "mysql";
	
	public CustomerBean select(int s_id) {
		CustomerBean cs = new CustomerBean();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT AID,FN,Cname,Phonenum,Address,Mailadd FROM account WHERE AID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, s_id);

			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				int user_id = rs.getInt("AID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				String phonenum = rs.getString("Phonenum");
				String add = rs.getString("Address");
				String mailadd = rs.getString("Mailadd");
				cs = new CustomerBean(user_id,name,company_name,phonenum,add,mailadd);
			}

		} catch (SQLException e) {
			System.out.println("businessupdateselectのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("businessupdateselectの正常動作");
		return cs;
	}
	public CustomerBean Business_card_update(int Up_AID,String Up_FN,String Up_Cname,String Up_Phonenum,String Up_Address,String Up_MailAdd) {
		CustomerBean cs = new CustomerBean();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "UPDATE  account SET FN = ?,Cname= ?,Phonenum= ?,Address= ?,Mailadd= ?  WHERE AID = ? ";
			PreparedStatement Acount_Update = conn.prepareStatement(sql);
			
			Acount_Update.setString(1, Up_FN);
			Acount_Update.setString(2, Up_Cname);
			Acount_Update.setString(3, Up_Phonenum);
			Acount_Update.setString(4, Up_Address);
			Acount_Update.setString(5, Up_MailAdd);
			Acount_Update.setInt(6, Up_AID);

			ResultSet rs = Acount_Update.executeQuery();
			
			if (rs.next()) {
				int user_id = rs.getInt("AID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				String phonenum = rs.getString("Phonenum");
				String add = rs.getString("Address");
				String mailadd = rs.getString("Mailadd");
				cs = new CustomerBean(user_id,name,company_name,phonenum,add,mailadd);
			}

		} catch (SQLException e) {
			System.out.println("businessupdateselectのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("businessupdateselectの正常動作");
		return cs;

		
}
}