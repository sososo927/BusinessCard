<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ChatHistoryBean" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>チャット削除</title>
</head>
<body>
    <ul>
                             
    <!-- チャットを削除するためのForm -->
				<h1>削除するかの最終確認です。</h1>
				
				<%= request.getParameter("action") %>
				<form method="post" action="ChatDeleteServlet">
					<input type="hidden" name="roomId" value="<%= request.getParameter("roomId") %>">
					<input type="hidden" name="roomId" value="<%= request.getParameter("roomId") %>">
					<input type="hidden" name="roomId" value="<%= request.getParameter("roomId") %>">
           	    	<input type="hidden" name="ChatDelete_messagedate" value="<%= request.getParameter("chat_messagedate") %>">
                	<button type="submit">削除</button>
          		  </form>
          		 
            <form method="post" action="ChatList.jsp">
            
        <button type="submit">戻る</button>
    </form>        
</body>
</html>
