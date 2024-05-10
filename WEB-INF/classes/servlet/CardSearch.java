package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BCDAO;
import dao.Notification_DAO;
import dao.SwapDAO;
import model.CustomerBean;
import model.SwapBean;
import model.UserBean;

@WebServlet("/CardSearch")
public class CardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/cardsearch.jsp");
			dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Jspのフォーム画面から検索対象ユーザIDを取得
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
		
		String input_Prefecture=request.getParameter("Prefecture");
		String input_Industry=request.getParameter("Industry");
		String input_name = request.getParameter("name");
		String input_companyname=request.getParameter("companyname");
		
		String action=request.getParameter("action");
		if(action!=null) {
			SwapBean swap=new SwapBean();
			Notification_DAO notDAO = new Notification_DAO();
			swap.setSender_id(Integer.parseInt(loginUser.getLoginid()));
			swap.setReceiver_id(Integer.parseInt(action));
			//DB行存在しない場合作成　存在する場合Flag0で1にする それ以外：
			SwapDAO swapDao=new SwapDAO();
			swapDao.searchflag(swap);
			System.out.println(swapDao.flag2);
			if(swapDao.flag2!=1 && swapDao.flag2!=2 && swapDao.flag2!=3 && swapDao.flag2!=4 && swapDao.flag2!=5 && (Integer.parseInt(loginUser.getLoginid())!=Integer.parseInt(action))) {
				swap.setFlag(1);
				//swapDao.insert(swap);
				notDAO.flag_con(1, Integer.parseInt(action), Integer.parseInt(loginUser.getLoginid()));
				
			}
			
			
			request.getRequestDispatcher("/WEB-INF/jsp/cardsearch.jsp").forward(request, response);
		}else {
		try{
			// Beanクラスのインスタンス
			CustomerBean input_user = new CustomerBean();
			
			// Beanクラスに入力したユーザIDをセットする
			System.out.println(input_user.getAID());
			System.out.println("業種："+input_Industry+"]氏名:"+input_name+"]会社名:"+input_companyname+"[都道府県:"+input_Prefecture);
			input_user.setIndustry(input_Industry);
			input_user.setFN(input_name);
			input_user.setCname(input_companyname);
			//input_user.setName(input_othername);
			//input_user.setPhonenum(input_othername);
			//input_user.setGender(input_othername);
			input_user.setPrefecture(input_Prefecture);
			//input_user.setAddress(input_othername);
			//input_user.setMailAdd(input_othername);
			
			// リスト＜Beanクラス＞に検索結果を格納する
			ArrayList<CustomerBean> user_list = BCDAO.getInstance().SelectUserData(input_user);
			
			// 検索結果をJSP画面に返す
			System.out.print("私、javaのプリント関数。こっちは検索結果。");
			request.setAttribute("user_list", user_list);
            request.getRequestDispatcher("/WEB-INF/jsp/cardsearch.jsp").forward(request, response);
			
		}catch(Exception e){
			//何らかの理由で失敗したらエラーページにエラー文を渡して表示。
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			}
		}
	}
}
