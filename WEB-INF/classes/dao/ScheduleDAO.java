package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ScheduleBean;
import model.ScheduleInsertBean;
public class ScheduleDAO {

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

	public ArrayList<ScheduleBean> findAll(){
		ArrayList<ScheduleBean> customerList=new ArrayList<ScheduleBean>();
		
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT * FROM schedule";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			
			ResultSet rs=pStmt.executeQuery();
			
			while(rs.next()) {
				int ID=rs.getInt("ID");
				String userID=rs.getString("userID");
				String scheduledate=rs.getString("scheduledate");
				String starttime=rs.getString("starttime");
				String endtime=rs.getString("endtime");
				String schedule=rs.getString("schedule");
				String memo=rs.getString("memo");
				
				ScheduleBean scheduleBean=new ScheduleBean(ID,userID,scheduledate,starttime,endtime,schedule,memo);
				customerList.add(scheduleBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return customerList;
	}
	public boolean insert(ScheduleInsertBean presence2) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="INSERT INTO schedule(ID,userID,scheduledate,starttime,endtime,schedule,memo) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setLong(1,presence2.getCount2());
			pStmt.setString(2,presence2.getUserid());
			pStmt.setString(3,presence2.getScheduledate());
			pStmt.setString(4,presence2.getStarttime());
			pStmt.setString(5,presence2.getEndtime());
			pStmt.setString(6,presence2.getSchedule());
			pStmt.setString(7,presence2.getMemo());
			
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
	public static ScheduleDAO getInstance() {
		return new ScheduleDAO();
	}
	public ArrayList<ScheduleBean> SelectUserData(ScheduleBean input_user) throws SQLException {
		// 初期値をセット
		Connection db_con = null;
		String userID=input_user.getUserid();
		
		// 複数のユーザ情報を格納するため、Beanを格納する配列を作成
		ArrayList<ScheduleBean> array_userinfo = new ArrayList<ScheduleBean>();
	
		try (Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
		
			// 実行するSQL文をセット（空文字）
			String sql = "";
			
			// 実行するSQL文をセット
			// JSPでIDを指定しない場合は全件検索
			if(userID == "") {
				//sql = "select * from friendlist";
			}else {
				sql = "SELECT scheduledate,starttime,endtime,SCHEDULE,memo FROM SCHEDULE WHERE userid=?;";
			}
		
			// DBで実行するSQL文を「prepareStatement」インスタンスに格納する
			PreparedStatement pStmt=conn.prepareStatement(sql);
			// ユーザIDを指定している場合は、条件指定する
			if(userID != "") {
				
				pStmt.setString(1, "%"+userID+"%");
			}
			
			// SQL文の実行結果を格納
			ResultSet rs = pStmt.executeQuery();
			
			// 検索結果格納のため、Beanクラスをインスタンス
			ScheduleBean resultUserInfo = new ScheduleBean();
					
			// SQL文の実行結果件数分ループ処理
			while(rs.next()) {
				// ユーザIDと名前をBeanクラスへセット
				resultUserInfo.setScheduledate(rs.getString("scheduledate"));
				resultUserInfo.setStarttime(rs.getString("starttime"));
				resultUserInfo.setEndtime(rs.getString("endtime"));
				resultUserInfo.setSchedule(rs.getString("schedule"));
				resultUserInfo.setMemo(rs.getString("memo"));

				// リストにBeanクラスごと格納
				array_userinfo.add(resultUserInfo);
				
				//Beanクラスを初期化
				resultUserInfo = new ScheduleBean();
				}
			
		} catch(SQLException sql_e) {
			// エラーハンドリング
			System.out.println("sql実行失敗");
			sql_e.printStackTrace();
			
		} finally {
			// DB接続を解除
			if (db_con != null) {
					db_con.close();
			}
		}
		// リストを返す
		return array_userinfo;
	}
}

