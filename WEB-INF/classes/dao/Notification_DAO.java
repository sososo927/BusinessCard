package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Notification_Bean;
import model.Roomidinsert_Bean;
import servlet.RoomLogic;

public class Notification_DAO {
	private final String JDBC_URL="jdbc:mariadb://localhost/busiesecard_db";
	//private final String DB_USER="R2A406";
	private final String DB_USER="root";
	private final String DB_PASS="mysql";
	/*全体*/
	public ArrayList<Roomidinsert_Bean> findAll() {
		ArrayList<Roomidinsert_Bean> noList = new ArrayList<Roomidinsert_Bean>();
	//データベースを接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)) {
			//SELECT文を準備
			String sql = "SELECT * FROM nop";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			//結果票に格納されたレコードの内容を
			//Notificationインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int user_id = rs.getInt("SENDER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				String phonenum = rs.getString("Phonenum");
				String add = rs.getString("Address");
				String mailadd = rs.getString("Mailadd");
				int flag = rs.getInt("FLAG");
				int room_id = rs.getInt("ROOM_ID");
				Roomidinsert_Bean no = new Roomidinsert_Bean(user_id,name,company_name,phonenum,add,mailadd,flag,room_id);
				noList.add(no);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("findAll()のエラー");
			return null;
		}
			System.out.println("findAll()の正常動作");
			return noList;
	}
		
	public ArrayList<Notification_Bean> Appselect(int l_id) {
		
		ArrayList<Notification_Bean> noList = new ArrayList<Notification_Bean>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname FROM nop WHERE FLAG = 2 AND SENDER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, l_id);
			// SQL文の実行結果を格納
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				
				Notification_Bean no = new Notification_Bean(user_id,name,company_name);
				noList.add(no);
			}

		} catch (SQLException e) {
			System.out.println("Appnoのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("Appnoの正常動作");
		return noList;
	}
	
	public ArrayList<Notification_Bean> Returnselect(int l_id) {
		
		ArrayList<Notification_Bean> noList = new ArrayList<Notification_Bean>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname FROM nop WHERE FLAG = 3 AND SENDER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, l_id);
			// SQL文の実行結果を格納
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				
				Notification_Bean no = new Notification_Bean(user_id,name,company_name);
				noList.add(no);
			}

		} catch (SQLException e) {
			System.out.println("Returnnoのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("Returnnoの正常動作");
		return noList;
	}
	
	public ArrayList<Notification_Bean> Ansselect(int l_id) {
		
		ArrayList<Notification_Bean> noList = new ArrayList<Notification_Bean>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname FROM nop WHERE FLAG = 4 AND SENDER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, l_id);
			// SQL文の実行結果を格納
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				
				Notification_Bean no = new Notification_Bean(user_id,name,company_name);
				noList.add(no);
			}

		} catch (SQLException e) {
			System.out.println("Ansnoのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("Ansnoの正常動作");
		return noList;
	}
	
	public ArrayList<Notification_Bean> Chatselect(int l_id) {
		
		ArrayList<Notification_Bean> noList = new ArrayList<Notification_Bean>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname,ROOM_ID FROM nop WHERE FLAG = 6 AND SENDER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, l_id);
			// SQL文の実行結果を格納
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				int room_id = rs.getInt("ROOM_ID");
				Notification_Bean no = new Notification_Bean(user_id,name,company_name,room_id);
				noList.add(no);
			}

		} catch (SQLException e) {
			System.out.println("Chatnoのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("Chatnoの正常動作");
		return noList;
	}
	
	public ArrayList<Notification_Bean> friendlist(int l_id) {
		
		ArrayList<Notification_Bean> noList = new ArrayList<Notification_Bean>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname,ROOM_ID FROM nop WHERE (FLAG = 5 OR FLAG = 6) AND SENDER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, l_id);
			// SQL文の実行結果を格納
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				int room_id = rs.getInt("ROOM_ID");
				Notification_Bean no = new Notification_Bean(user_id,name,company_name,room_id);
				noList.add(no);
			}

		} catch (SQLException e) {
			System.out.println("friendlistのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("friendlistの正常動作");
		return noList;
	}
	
	public ArrayList<Notification_Bean> request(int l_id) {
		
		ArrayList<Notification_Bean> noList = new ArrayList<Notification_Bean>();
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname,ROOM_ID FROM nop WHERE FLAG = 1 AND SENDER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, l_id);
			// SQL文の実行結果を格納
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				int room_id = rs.getInt("ROOM_ID");
				Notification_Bean no = new Notification_Bean(user_id,name,company_name,room_id);
				noList.add(no);
			}

		} catch (SQLException e) {
			System.out.println("requestのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("requestの正常動作");
		return noList;
	}
	
	public Notification_Bean Cardjudge(int s_id) {
		Notification_Bean no = new Notification_Bean();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname,Phonenum,Address,Mailadd FROM nop WHERE RECIVER_ID = ? and FLAG = 2";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, s_id);

			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				String phonenum = rs.getString("Phonenum");
				String add = rs.getString("Address");
				String mailadd = rs.getString("Mailadd");
				no = new Notification_Bean(user_id,name,company_name,phonenum,add,mailadd);
			}

		} catch (SQLException e) {
			System.out.println("Cardjudgeのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("Cardjudgeの正常動作");
		return no;
	}
	
	public Notification_Bean Returnwait(int s_id) {
		Notification_Bean no = new Notification_Bean();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname,Phonenum,Address,Mailadd FROM nop WHERE RECIVER_ID = ? and FLAG = 3";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, s_id);

			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				String phonenum = rs.getString("Phonenum");
				String add = rs.getString("Address");
				String mailadd = rs.getString("Mailadd");
				no = new Notification_Bean(user_id,name,company_name,phonenum,add,mailadd);
			}

		} catch (SQLException e) {
			System.out.println("Returnwaitのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("Returnwaitの正常動作");
		return no;
	}
	
	public Notification_Bean friend(int s_id) {
		Notification_Bean no = new Notification_Bean();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname,Phonenum,Address,Mailadd FROM nop WHERE RECIVER_ID = ? and FLAG = 4";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, s_id);

			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				String phonenum = rs.getString("Phonenum");
				String add = rs.getString("Address");
				String mailadd = rs.getString("Mailadd");
				no = new Notification_Bean(user_id,name,company_name,phonenum,add,mailadd);
			}

		} catch (SQLException e) {
			System.out.println("friendのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("friendの正常動作");
		return no;
	}
	
	public Notification_Bean frienddetails(int s_id) {
		Notification_Bean no = new Notification_Bean();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			String sql = "SELECT RECIVER_ID,FN,Cname,Phonenum,Address,Mailadd FROM nop WHERE RECIVER_ID = ? and FLAG = 5";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, s_id);

			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				int user_id = rs.getInt("RECIVER_ID");
				String name = rs.getString("FN");
				String company_name = rs.getString("Cname");
				String phonenum = rs.getString("Phonenum");
				String add = rs.getString("Address");
				String mailadd = rs.getString("Mailadd");
				no = new Notification_Bean(user_id,name,company_name,phonenum,add,mailadd);
			}

		} catch (SQLException e) {
			System.out.println("frienddetailsのエラー");
			e.printStackTrace();
			return null;
		}
		System.out.println("frienddetailsの正常動作");
		return no;
	}
	
	public void flag_con(int fl,int user_id,int login_id) {

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//文を準備
			PreparedStatement pStmt;
			String sql;
			if(fl == 1) {
				/*名刺検索からの*/
				sql = "UPDATE nop SET FLAG = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, fl);
				pStmt.setInt(2, login_id);
				pStmt.setInt(3, user_id);
				pStmt.executeUpdate();
				
				sql = "UPDATE nop SET FLAG = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, 2);
				pStmt.setInt(2, user_id);
				pStmt.setInt(3, login_id);
				pStmt.executeUpdate();
			}else if(fl == 3) {
				/*申請通知からの*/
				sql = "UPDATE nop SET FLAG = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, fl);
				pStmt.setInt(2, login_id);
				pStmt.setInt(3, user_id);
				pStmt.executeUpdate();
				
				sql = "UPDATE nop SET FLAG = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, 4);
				pStmt.setInt(2, user_id);
				pStmt.setInt(3, login_id);
				pStmt.executeUpdate();
			}else if(fl==5) {
				/*返信通知からの*/
				//roomid作成
				sql = "UPDATE nop SET ROOM_ID = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, RoomLogic.getRoomplus()+1);
				pStmt.setInt(2, login_id);
				pStmt.setInt(3, user_id);
				pStmt.executeUpdate();
				sql = "UPDATE nop SET ROOM_ID = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, RoomLogic.getRoomplus());
				pStmt.setInt(2, user_id);
				pStmt.setInt(3, login_id);
				pStmt.executeUpdate();
				//flagを5にupdate
				sql = "UPDATE nop SET FLAG = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, fl);
				pStmt.setInt(2, login_id);
				pStmt.setInt(3, user_id);
				pStmt.executeUpdate();
				
				sql = "UPDATE nop SET FLAG = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, fl);
				pStmt.setInt(2, user_id);
				pStmt.setInt(3, login_id);
				pStmt.executeUpdate();
			}else if(fl == 0) {
				sql = "UPDATE nop SET FLAG = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, fl);
				pStmt.setInt(2, login_id);
				pStmt.setInt(3, user_id);
				pStmt.executeUpdate();
				
				sql = "UPDATE nop SET FLAG = ? WHERE SENDER_ID = ? AND RECIVER_ID = ?";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, fl);
				pStmt.setInt(2, user_id);
				pStmt.setInt(3, login_id);
				pStmt.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println("fl_coのエラー");
			e.printStackTrace();
		}
		System.out.println("fl_coの正常動作");
	}
	
}