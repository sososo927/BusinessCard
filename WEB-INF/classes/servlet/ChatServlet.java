package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChatDAO;
import model.ChatHistoryBean;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // チャットしたい相手のIDを取得する
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        int senderid = Integer.parseInt(request.getParameter("senderid"));
        int reciverid = Integer.parseInt(request.getParameter("reciverid"));
        // データベースから指定したroomidに合致するチャット履歴を取得
        
        System.out.println("ChatServelet到達");
        ChatDAO chatDAO = new ChatDAO();
        List<ChatHistoryBean> chatHistoryList = chatDAO.getChatHistoryByRoomId(roomId);
        // チャット履歴をセッションスコープに設定
        HttpSession chat_session = request.getSession();
        chat_session.setAttribute("chatHistoryList", chatHistoryList);
        
        chatDAO.Flag_Change_Five(senderid, reciverid, roomId);
        
        
        // チャットページにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("ChatPage.jsp");
        dispatcher.forward(request, response);
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

}
}