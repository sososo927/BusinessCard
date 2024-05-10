package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Notification_DAO;
import model.Notification_Bean;
import model.UserBean;

@WebServlet("/Notification_Servlet")
public class Notification_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
		String forwardPath = "topPage.jsp";
		if(loginUser==null) {
			response.sendRedirect("/BusinessCard_School/");
		}else {
			System.out.println("loginid取得");
			Notification_DAO noDAO = new Notification_DAO();
			Notification_Bean no = new Notification_Bean();
			
			
			int user_id = 0;
			int login_id = Integer.parseInt(loginUser.getLoginid());
			int flag = 0;
			/*action系*/
			String action = request.getParameter("action");
			String fl = null;
			

			if (action.equals("appno")) {
				/*申請通知*/
				fl = request.getParameter("fl");
				System.out.println(fl);
				if (fl.equals("null")) {
					forwardPath = "WEB-INF/jsp/AppNotificationList.jsp";
				}else if (fl.equals("yes")) {
					flag = 3;
					user_id = Integer.parseInt(request.getParameter("user_id"));
					System.out.println(user_id);
					noDAO.flag_con(flag,user_id,login_id);
					forwardPath = "WEB-INF/jsp/AppNotificationList.jsp";
				}else if (fl.equals("no")) {
					flag = 0;
					user_id = Integer.parseInt(request.getParameter("user_id"));
					noDAO.flag_con(flag,user_id,login_id);
					forwardPath = "WEB-INF/jsp/AppNotificationList.jsp";
				}
			
			} else if (action.equals("chatno")) {
				/*チャット通知*/
				forwardPath = "WEB-INF/jsp/ChatNotificationList.jsp";
			} else if (action.equals("card")) {
				/*名刺交換*/
				forwardPath = "WEB-INF/jsp/Cardjudge.jsp";
				user_id = Integer.parseInt(request.getParameter("user_id"));
				no = noDAO.Cardjudge(user_id);
				request.setAttribute("no", no);
			} else if (action.equals("home")) {
				/*マイページ*/
				forwardPath = "WEB-INF/jsp/main.jsp";
			} else if (action.equals("request")) {
				/*リクエスト*/
				forwardPath = "WEB-INF/jsp/request.jsp";
			} else if (action.equals("answer")) {
				fl = request.getParameter("fl");
				System.out.println(fl);
				if (fl.equals("null")) {
					forwardPath = "WEB-INF/jsp/AnsNotificationList.jsp";
				}else if (fl.equals("yes")) {
					flag = 5;
					user_id = Integer.parseInt(request.getParameter("user_id"));
					noDAO.flag_con(flag,user_id,login_id);
					forwardPath = "WEB-INF/jsp/AnsNotificationList.jsp";
				}
			} else if (action.equals("cardans")) {
				/*フレンド登録*/
				forwardPath = "WEB-INF/jsp/Cardjudgefriend.jsp";
				user_id = Integer.parseInt(request.getParameter("user_id"));
				no = noDAO.friend(user_id);
				request.setAttribute("no", no);
			}else if (action.equals("return")) {
				/*返信待ち*/
				forwardPath = "WEB-INF/jsp/Cardreturn.jsp";
			}else if (action.equals("returnwait")) {
				/*返信待ち名刺確認*/
				forwardPath = "WEB-INF/jsp/Returnwait.jsp";
				user_id = Integer.parseInt(request.getParameter("user_id"));
				no = noDAO.Returnwait(user_id);
				request.setAttribute("no", no);
			}else if (action.equals("friendlist")) {
				/*フレンド一覧*/
				forwardPath = "WEB-INF/jsp/FriendList.jsp";
			}else if (action.equals("forfriend")) {
				/*フレンド名刺表示*/
				forwardPath = "WEB-INF/jsp/frienddetails.jsp";
				user_id = Integer.parseInt(request.getParameter("user_id"));
				no = noDAO.frienddetails(user_id);
				request.setAttribute("no", no);
			}
		} 
		RequestDispatcher dispatcher=request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
	
}
