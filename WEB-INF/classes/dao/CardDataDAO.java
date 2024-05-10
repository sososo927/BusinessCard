package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CardDataBean;
public class CardDataDAO {

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

	public List<CardDataBean> findAll(){
		List<CardDataBean> carddataList=new ArrayList<CardDataBean>();
		
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT * FROM FRIENDLIST";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			
			ResultSet rs=pStmt.executeQuery();
			
			while(rs.next()) {
				String organization=rs.getString("organization");
				String name=rs.getString("name");
				String company=rs.getString("company");
				String prefecture=rs.getString("prefecture");
				
				CardDataBean cdBean=new CardDataBean(organization,name,company,prefecture);
				carddataList.add(cdBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return carddataList;
	}
	public static CardDataDAO getInstance() {
		return new CardDataDAO();
	}
	
	// 検索処理
	// 引数		：Beanクラス
	// 戻り値		：ArrayList<Beanクラス>
	public ArrayList<CardDataBean> SelectUserData(CardDataBean input_user) throws SQLException {
		// 初期値をセット
		Connection db_con = null;
		String organization = input_user.getOrganization();
		String name = input_user.getName();
		String company = input_user.getCompany();
		String prefecture=input_user.getPrefecture();
		System.out.println("検索リスト"+organization+name+company+prefecture);
		
		// 複数のユーザ情報を格納するため、Beanを格納する配列を作成
		ArrayList<CardDataBean> array_userinfo = new ArrayList<CardDataBean>();
	
		try (Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
		
			// 実行するSQL文をセット（空文字）
			String sql = "";
			
			// 実行するSQL文をセット
			// JSPでIDを指定しない場合は全件検索
			if(name == "" && organization=="" && company=="" && prefecture=="") {
				//sql = "select * from friendlist";
			}else {
				sql = "select * from friendlist where organization LIKE ? and name  LIKE ? and company LIKE ? and prefecture LIKE ?";
			}
		
			// DBで実行するSQL文を「prepareStatement」インスタンスに格納する
			PreparedStatement pStmt=conn.prepareStatement(sql);
			// ユーザIDを指定している場合は、条件指定する
			if(organization != "" || name!="" || company!="" || prefecture!="") {
				pStmt.setString(1, "%"+organization+"%");
				pStmt.setString(2, "%"+name+"%");
				pStmt.setString(3, "%"+company+"%");
				pStmt.setString(4, "%"+prefecture+"%");
			}
			
			// SQL文の実行結果を格納
			ResultSet rs = pStmt.executeQuery();
			
			// 検索結果格納のため、Beanクラスをインスタンス
			CardDataBean resultUserInfo = new CardDataBean();
					
			// SQL文の実行結果件数分ループ処理
			while(rs.next()) {
				// ユーザIDと名前をBeanクラスへセット
				resultUserInfo.setOrganization(rs.getString("Organization"));
				resultUserInfo.setName(rs.getString("NAME"));
				resultUserInfo.setCompany(rs.getString("Company"));
				resultUserInfo.setPrefecture(rs.getString("Prefecture"));
				
				// リストにBeanクラスごと格納
				array_userinfo.add(resultUserInfo);
				
				//Beanクラスを初期化
				resultUserInfo = new CardDataBean();
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

