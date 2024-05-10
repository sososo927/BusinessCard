

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Business_card_update_DAO;
import model.CustomerBean;
import model.UserBean;



@WebServlet("/ID_Upadate_Servlet")
public class ID_Upadate_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
		int Up_AID = Integer.parseInt(request.getParameter("Up_AID"));
		CustomerBean cs = new CustomerBean();
		Business_card_update_DAO Business_card_update_DAO = new Business_card_update_DAO();
		cs = Business_card_update_DAO.select(Up_AID);
		request.setAttribute("cs", cs);
		session.setAttribute("loginUser", loginUser);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ID_Upadate.jsp");
		dispatcher.forward(request,response);
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			request.setCharacterEncoding("UTF-8");
			HttpSession session=request.getSession();
			UserBean loginUser=(UserBean) session.getAttribute("loginUser");
			CustomerBean cs = new CustomerBean();
			System.out.println("でバック用");
			int Up_AID = Integer.parseInt(request.getParameter("Up_AID"));  
			String Up_FN=request.getParameter("Up_FN");
			String Up_Cname=request.getParameter("Up_Cname");
			String Up_Phonenum=request.getParameter("Up_Phonenum");
			String Up_Address=request.getParameter("Up_Address");
			String Up_MailAdd=request.getParameter("Up_MailAdd");
			System.out.println(Up_AID);
			System.out.println(Up_FN);
			System.out.println(Up_Cname);
			System.out.println(Up_Phonenum);
			System.out.println(Up_Address);
			System.out.println(Up_MailAdd);
			
			cs.setAID(Up_AID);
			cs.setFN(Up_FN);
			cs.setCname(Up_Cname);
			cs.setPhonenum(Up_Phonenum);
			cs.setAddress(Up_Address);
			cs.setMailAdd(Up_MailAdd);
//			DAOの準備
			Business_card_update_DAO Business_card_update_DAO = new Business_card_update_DAO();
			Business_card_update_DAO.Business_card_update(Up_AID,Up_FN,Up_Cname,Up_Phonenum,Up_Address,Up_MailAdd);
			session.setAttribute("loginUser", loginUser);
			//フォワード
			//request.setAttribute("action","main");
			//request.setAttribute("pr",cs.getAID());
			RequestDispatcher dispatcher = request.getRequestDispatcher("workUpdate.jsp");
			dispatcher.forward(request, response);
			
			
	}
}	

