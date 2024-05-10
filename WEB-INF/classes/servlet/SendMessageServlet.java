package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChatDAO;
import model.UserBean;

@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//デバック
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
    	int SendMessage_roomid = Integer.parseInt(request.getParameter("SendMessage_roomid"));
        int SendMessage_receiverId = Integer.parseInt(request.getParameter("SendMessage_receiverId"));
        int SendMessage_senderId = Integer.parseInt(request.getParameter("SendMessage_senderId"));
        String SendMessage_sentence = request.getParameter("SendMessage_sentence"); 
        
        // チャットメッセージをデータベースに
        ChatDAO chatDAO = new ChatDAO();
        chatDAO.Flag_Change_Six(SendMessage_senderId,SendMessage_receiverId,SendMessage_roomid);
        boolean SendMessage = chatDAO.getSendMessageBean(SendMessage_roomid, SendMessage_receiverId,SendMessage_senderId, SendMessage_sentence,loginUser.getLoginid());
        System.out.println("SendMessage_roomid"+SendMessage_roomid);
        if (SendMessage) {
            // チャットページにリダイレクト
        	System.out.println("リダイレクト");
        	response.sendRedirect("ChatServlet?senderid=" + SendMessage_senderId + "&reciverid=" + SendMessage_receiverId + "&roomId=" + SendMessage_roomid);
        } else {
            // エラーが発生した場合の処理（例えばエラーページにリダイレクトするなど）
            response.sendRedirect("SendMessage_Error.jsp");
        }
    }
}
