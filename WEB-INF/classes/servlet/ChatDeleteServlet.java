package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChatDAO;

@WebServlet("/ChatDeleteServlet")
public class ChatDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String roomId = request.getParameter("roomId");
        String ChatDelete_messagedate = request.getParameter("ChatDelete_messagedate"); 

        // チャットメッセージをデータベースに保存
        ChatDAO chatDAO = new ChatDAO();
        chatDAO.Chat_Delete(ChatDelete_messagedate);
        
//        RequestDispatcher dispatcher = request.getRequestDispatcher("ChatPage.jsp");
//        dispatcher.forward(request, response);      

        	response.sendRedirect("ChatServlet?roomId=" + roomId);
        }
    }
