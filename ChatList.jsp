<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.RoomBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>チャットリスト</title>
</head>
<body>
<a class="mypage" href="/BusinessCard_School/Main?action=main">マイページへ</a>
    <h1>会話可能なルーム一覧</h1>
    <ul>
        <% 
            List<RoomBean> roomList = (List<RoomBean>)session.getAttribute("roomList");
            for (RoomBean room : roomList) {
        %>
    送信者: <%= room.getSenderid() %>
    <form method="get" action="ChatServlet">
		<input type="hidden" name="roomId" value="<%= room.getRoomid() %>">
        <button type="submit">ルームに入る</button>
    </form>

        <%
            }
        %>
    </ul>
</body>
</html>
