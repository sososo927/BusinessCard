package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String JDBC_URL="jdbc:mariadb://localhost/busiesecard_db";
	private final String DB_USER="root";
	private final String DB_PASS="mysql";
	
	/*private final String JDBC_URL="jdbc:mysql://localhost/busiesecard_db";
	private final String DB_USER="R2A406";
	//private final String DB_USER="root";
	private final String DB_PASS="mysql";*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String loginid = null;
	    String userName = request.getParameter("email");
	    String password = request.getParameter("password");
	    String path = "";
	    System.out.println(userName+password);
	    try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {
	    	String sql = "SELECT AID,Mailadd FROM account WHERE Mailadd=? AND Pass=?";
	    	PreparedStatement pstmt=conn.prepareStatement(sql);{
	            pstmt.setString(1, userName);
	            pstmt.setString(2, password);
	            // SQLの実行
	            ResultSet res = pstmt.executeQuery();

	            // ユーザーIDとパスワードが一致するユーザーが存在し
	            if (res.next()) {
	                // user_idをリクエストスコープに設定する
	            	loginid=res.getString("AID");
	            	//System.out.print(res.getString("AID"));
	                request.setAttribute("email", res.getString("Mailadd"));
	                request.setAttribute("loginid", res.getString("AID"));
	                // ログイン成功画面に遷移する
	                path = "/WEB-INF/jsp/loginResult.jsp";
	            } else {
	                // ログイン失敗の文言を追加する
	                request.setAttribute("loginFailure", "ログインに失敗しました");
	                System.out.println("ログイン失敗");
	                // ログインに失敗したときはもう一度ログイン画面を表示する
	                path = "loginerror.html";
	            }
	    	}
	    	
	    	UserBean userbean=new UserBean(loginid,userName,password);
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", userbean);
	    	//System.out.println(userName+"が現在のユーザです");
	    	
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }

	    RequestDispatcher rd = request.getRequestDispatcher(path);
	    rd.forward(request, response);
	}
}
