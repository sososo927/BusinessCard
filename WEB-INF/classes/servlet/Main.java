package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BCDAO;
import dao.Business_card_update_DAO;
import dao.SwapcreateDAO;
import model.CustomerBean;
import model.CustomerInsertBean;
import model.UserBean;

/**
 * Servlet implementation class Main
 */
//こんにちは
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
	
		BCDAO bcDAO=new BCDAO();
		CustomerBean cs = new CustomerBean();
		List<CustomerBean> bcList=bcDAO.findAll();
		request.setAttribute("bcList",bcList);
		
		String forwardPath=null;
		String action=request.getParameter("action");
		int pr=Integer.parseInt(request.getParameter("pr"));
		if(action!=null&&action.equals("accR")) {
			forwardPath="/WEB-INF/jsp/accountRegister.jsp";
		}else if(action!=null&&action.equals("logR")){
			forwardPath="/WEB-INF/jsp/loginResult.jsp";
		}else if(action!=null&&action.equals("logout")){
			forwardPath="/WEB-INF/jsp/logout.jsp";
		}else if(action!=null&&action.equals("main")){
			forwardPath="/WEB-INF/jsp/main.jsp";
			Business_card_update_DAO bupDao = new Business_card_update_DAO();
			cs = bupDao.select(pr);
			request.setAttribute("cs", cs);
		}
		session.setAttribute("loginUser", loginUser);
		RequestDispatcher dispatcher=request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		CustomerInsertBean presence = new CustomerInsertBean();
		//IDLogic idLogic=new IDLogic();
		//insertの値を定義している。
		System.out.println(request.getParameter("count1")+":count1");
		//int AID=Integer.parseInt(request.getParameter("count"));
		String id=request.getParameter("count1");
		String FN=request.getParameter("FN");
		String Industry=request.getParameter("Industry");
		String Cname=request.getParameter("Cname");
		String Pass=request.getParameter("Pass");
		String Phonenum=request.getParameter("Phonenum");
		String gender=request.getParameter("gender");
		String Prefecture=request.getParameter("Prefecture");
		String Address=request.getParameter("Address");
		String MailAdd=request.getParameter("MailAdd");
		
		System.out.println(id+":メインid");
		
		presence.setAID(id+1);
		presence.setFN(FN);
		presence.setIndustry(Industry);
		presence.setCname(Cname);
		presence.setPass(Pass);
		presence.setPhonenum(Phonenum);
		presence.setGender(gender);
		presence.setPrefecture(Prefecture);
		presence.setAddress(Address);
		presence.setMailAdd(MailAdd);
		//式です
		int AID = Integer.parseInt(id)+1;
		SwapcreateDAO scDAO = new SwapcreateDAO();
		ArrayList<CustomerBean> cs = scDAO.acselect();
		int maxAID = AID; /*ここに新しい人のAID*/
		for(CustomerBean cusBean:cs) {
    		AID=cusBean.getAID();
    		if (AID == maxAID) {
    			break;
    		}else {
    			scDAO.swinsert(AID, maxAID);
    		}
    	}
		//__________________________________________
		BCDAO bcDao=new BCDAO();
		bcDao.insert(presence);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("topPage.jsp");
		dispatcher.forward(request, response);
	}
}	

