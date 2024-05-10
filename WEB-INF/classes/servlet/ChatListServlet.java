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
import model.RoomBean;

@WebServlet("/ChatListServlet")
public class ChatListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ChatDAO ChatDAO = new ChatDAO();
        List<RoomBean> roomList = ChatDAO.findAll();
        
        HttpSession session = request.getSession();
        session.setAttribute("roomList", roomList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ChatList.jsp");
        dispatcher.forward(request, response);
    }
}
