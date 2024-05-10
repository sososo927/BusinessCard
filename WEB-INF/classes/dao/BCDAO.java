package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CustomerBean;
import model.CustomerInsertBean;
public class BCDAO {
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

	public List<CustomerBean> findAll(){
		List<CustomerBean> customerList=new ArrayList<CustomerBean>();
		
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT * FROM ACCOUNT";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			
			ResultSet rs=pStmt.executeQuery();
			
			while(rs.next()) {
				int AID=rs.getInt("AID");
				String FN=rs.getString("FN");
				String Industry=rs.getString("Industry");
				String Cname=rs.getString("Cname");
				String Pass=rs.getString("Pass");
				String Phonenum=rs.getString("Phonenum");
				String gender=rs.getString("gender");
				String Prefecture=rs.getString("Prefecture");
				String Address=rs.getString("Address");
				String MailAdd=rs.getString("MailAdd");
				
				
				CustomerBean customerBean=new CustomerBean(AID,FN,Industry,Cname,Pass,Phonenum,gender,Prefecture,Address,MailAdd);
				customerList.add(customerBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return customerList;
	}
	public boolean insert(CustomerInsertBean presence2) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="INSERT INTO ACCOUNT(AID,FN,Industry,Cname,Pass,Phonenum,gender,Prefecture,Address,MailAdd) VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setLong(1,presence2.getCount1());
			pStmt.setString(2,presence2.getFN());
			pStmt.setString(3,presence2.getIndustry());
			pStmt.setString(4,presence2.getCname());
			pStmt.setString(5,presence2.getPass());
			pStmt.setString(6,presence2.getPhonenum());
			pStmt.setString(7,presence2.getGender());
			pStmt.setString(8,presence2.getPrefecture());
			pStmt.setString(9,presence2.getAddress());
			pStmt.setString(10,presence2.getMailAdd());
			
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
	public static BCDAO getInstance() {
		return new BCDAO();
	}
	public ArrayList<CustomerBean> SelectUserData(CustomerBean input_user) throws SQLException {
		// 初期値をセット
		Connection db_con = null;
		int AID=input_user.getAID();
		String Industry = input_user.getIndustry();
		String FN = input_user.getFN();
		String Cname = input_user.getCname();
		String Prefecture=input_user.getPrefecture();
		
		// 複数のユーザ情報を格納するため、Beanを格納する配列を作成
		ArrayList<CustomerBean> array_userinfo = new ArrayList<CustomerBean>();
	
		try (Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
		
			// 実行するSQL文をセット（空文字）
			String sql = "";
			
			// 実行するSQL文をセット
			// JSPでIDを指定しない場合は全件検索
			//sql = "select * from account where Industry= ? and FN LIKE ? and Cname LIKE ? and Prefecture=?";
			// DBで実行するSQL文を「prepareStatement」インスタンスに格納する
			PreparedStatement pStmt;
			ResultSet rs=null;
			// ユーザIDを指定している場合は、条件指定する
			if(Industry != "" && FN!="" && Cname!="" && Prefecture!="") {
				sql = "select * from account where Industry= ? and FN LIKE ? and Cname LIKE ? and Prefecture=?";
				pStmt=conn.prepareStatement(sql);
				// DBで実行するSQL文を「prepareStatement」インスタンスに格納する
				/*すべて入ってる*/
				pStmt.setString(1, Industry);
				pStmt.setString(2, "%"+FN+"%");
				pStmt.setString(3, "%"+Cname+"%");
				pStmt.setString(4, Prefecture);
				rs=pStmt.executeQuery();
				System.out.println("こんにちは、全部の世界!!");
			}else if(Industry != "" && FN=="" && Cname=="" && Prefecture=="") {
				/*業種だけ入ってる☆*/
				sql = "select * from account where Industry= ?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, Industry);
				rs=pStmt.executeQuery();
			}else if(Industry != "" && FN!="" && Cname=="" && Prefecture=="") {
				/*業種と氏名だけ入ってる☆*/
				sql = "select * from account where Industry= ? and FN=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, Industry);
				pStmt.setString(2, "%"+FN+"%");
				rs=pStmt.executeQuery();
			}else if(Industry != "" && FN!="" && Cname!="" && Prefecture=="") {
				/*業種と氏名と会社名だけ入ってる☆*/
				sql = "select * from account where Industry= ? and FN=? and Cname=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, Industry);
				pStmt.setString(2, "%"+FN+"%");
				pStmt.setString(3, "%"+Cname+"%");
				rs=pStmt.executeQuery();
			}else if(Industry != "" && FN!="" && Cname=="" && Prefecture!="") {
				/*業種、氏名、県☆*/
				sql = "select * from account where Industry= ? and FN=? and Prefecture=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, Industry);
				pStmt.setString(2, "%"+FN+"%");
				pStmt.setString(3, Prefecture);
				rs=pStmt.executeQuery();
			}else if(Industry != "" && FN=="" && Cname!="" && Prefecture!="") {
				/*業種、会社名、県☆*/
				sql = "select * from account where Industry= ? and Cname=? and Prefecture=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, Industry);
				pStmt.setString(2, "%"+Cname+"%");
				pStmt.setString(3, Prefecture);
				rs=pStmt.executeQuery();
			}else if(Industry == "" && FN!="" && Cname=="" && Prefecture=="") {
				//氏名☆
				sql = "select * from account where FN=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, "%"+FN+"%");
				rs=pStmt.executeQuery();
			}else if(Industry == "" && FN=="" && Cname!="" && Prefecture=="") {
				//会社名☆
				sql = "select * from account where Cname=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, "%"+Cname+"%");
				rs=pStmt.executeQuery();
			}else if(Industry == "" && FN=="" && Cname=="" && Prefecture!="") {
				//県☆
				sql = "select * from account where Prefecture=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, Prefecture);
				rs=pStmt.executeQuery();
			}else if(Industry == "" && FN!="" && Cname!="" && Prefecture=="") {
				//氏名会社名☆
				sql = "select * from account where FN=? and Cname=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, "%"+FN+"%");
				pStmt.setString(2, "%"+Cname+"%");
				rs=pStmt.executeQuery();
			}else if(Industry == "" && FN!="" && Cname=="" && Prefecture!="") {
				//氏名県☆
				sql = "select * from account where FN=? and Prefecture=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, "%"+FN+"%");
				pStmt.setString(2, Prefecture);
				rs=pStmt.executeQuery();
			}else if(Industry == "" && FN=="" && Cname!="" && Prefecture!="") {
				//会社名県☆
				sql = "select * from account where Cname=? and Prefecture=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, "%"+Cname+"%");
				pStmt.setString(2, Prefecture);
				rs=pStmt.executeQuery();
			}else if(Industry != "" && FN!="" && Cname=="" && Prefecture!="") {
				//業種県hosi
				sql = "select * from account where Industry=? and Prefecture=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, Industry);
				pStmt.setString(2, Prefecture);
				rs=pStmt.executeQuery();
			}else if(Industry != "" && FN=="" && Cname!="" && Prefecture=="") {
				//業種会社名☆
				sql = "select * from account where Industry=? and Cname=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, Industry);
				pStmt.setString(2, "%"+Cname+"%");
				rs=pStmt.executeQuery();
			}else if(Industry == "" && FN!="" && Cname!="" && Prefecture!="") {
				/*氏名、会社名、県☆*/
				sql = "select * from account where FN= ? and Cname=? and Prefecture=?";
				pStmt=conn.prepareStatement(sql);
				pStmt.setString(1, "%"+FN+"%");
				pStmt.setString(2, "%"+Cname+"%");
				pStmt.setString(3, Prefecture);
				rs=pStmt.executeQuery();
			}else if(Industry == "" && FN=="" && Cname=="" && Prefecture=="") {
				pStmt=conn.prepareStatement(sql);
				sql = "select * from account";
				rs=pStmt.executeQuery();
			}
			// SQL文の実行結果を格納
			
			
			// 検索結果格納のため、Beanクラスをインスタンス
			CustomerBean resultUserInfo = new CustomerBean();
					
			// SQL文の実行結果件数分ループ処理
			while(rs.next()) {
				// ユーザIDと名前をBeanクラスへセット
				resultUserInfo.setAID(rs.getInt("AID"));
				resultUserInfo.setIndustry(rs.getString("Industry"));
				resultUserInfo.setFN(rs.getString("FN"));
				resultUserInfo.setCname(rs.getString("Cname"));
				resultUserInfo.setPhonenum(rs.getString("Phonenum"));
				resultUserInfo.setGender(rs.getString("gender"));
				resultUserInfo.setPrefecture(rs.getString("Prefecture"));
				resultUserInfo.setAddress(rs.getString("Address"));
				resultUserInfo.setMailAdd(rs.getString("MailAdd"));
				// リストにBeanクラスごと格納
				array_userinfo.add(resultUserInfo);
				
				//Beanクラスを初期化
				resultUserInfo = new CustomerBean();
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

