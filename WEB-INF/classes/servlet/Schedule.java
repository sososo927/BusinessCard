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

import dao.ScheduleDAO;
import model.ScheduleBean;
import model.UserBean;

@WebServlet("/Schedule")
public class Schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
		ScheduleDAO scheduleDao=new ScheduleDAO();
		ScheduleBean schedulebean = new ScheduleBean();
		
		
		schedulebean.setUserid(loginUser.getLoginid());
		ArrayList<ScheduleBean> user_list;
		user_list = scheduleDao.findAll();
		request.setAttribute("user_list", user_list);

		if(loginUser==null) {
			response.sendRedirect("/BusinessCard_School/");
		}else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/calendarindex.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
		/*ScheduleInsertBean scheduleinsertbean = new ScheduleInsertBean();
		//IDLogic idLogic=new IDLogic();
		//insertの値を定義している。
		//int AID=Integer.parseInt(request.getParameter("count"));
		
		String id=request.getParameter("count2");
		String userid=loginUser.getLoginid();
		String Scheduledate=request.getParameter("scheduledate");
		String Starttime=request.getParameter("starttime");
		String Endtime=request.getParameter("endtime");
		String Schedule=request.getParameter("schedule");
		String Memo=request.getParameter("memo");
		
		System.out.println(id+":スケジュールid");
		
		scheduleinsertbean.setId(id+1);
		scheduleinsertbean.setUserid(userid);
		scheduleinsertbean.setScheduledate(Scheduledate);
		scheduleinsertbean.setStarttime(Starttime);
		scheduleinsertbean.setEndtime(Endtime);
		scheduleinsertbean.setSchedule(Schedule);
		scheduleinsertbean.setMemo(Memo);
		
		ScheduleDAO scheduleDao=new ScheduleDAO();
		scheduleDao.insert(scheduleinsertbean);
		
		
		ScheduleBean schedulebean = new ScheduleBean();
		schedulebean.setUserid(loginUser.getLoginid());
		ArrayList<ScheduleBean> user_list;
		user_list = scheduleDao.findAll();
		request.setAttribute("user_list", user_list);*/
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/calendarindex.jsp");
		dispatcher.forward(request, response);
	}

}
/*
 * 		try {
			schedulebean.setUserid(loginUser.getLoginid());
			ArrayList<ScheduleBean> user_list;
			user_list = ScheduleDAO.getInstance().SelectUserData(schedulebean);
			scheduleDao.findAll();
			request.setAttribute("user_list", user_list);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
 */
/*
ScheduleBean schedulebean = new ScheduleBean();
schedulebean.setUserid(loginUser.getLoginid());
ArrayList<ScheduleBean> user_list;
user_list = scheduleDao.findAll();
request.setAttribute("user_list", user_list);*/
