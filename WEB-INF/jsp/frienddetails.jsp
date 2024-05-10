<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Notification_Bean" %>
<%
	Notification_Bean no = (Notification_Bean)request.getAttribute("no");
%>
<%@ page import="model.CustomerBean,model.UserBean" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>待ち名刺確認画面</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
    <div class="container mx-auto p-8 max-w-lg mt-10">
        <h1 class="text-4xl font-bold mb-4"><%= no.getName() %>様の名刺</h1>
        <div class="bg-white rounded p-4 mb-4">
            <p class="text-gray-600 text-4xl font-bold text-center py-4 mb-6"> <%= no.getCompany_name() %></p>
            <p class="text-gray-600 text-3xl font-bold text-center py-4 mb-6"> <%= no.getName() %></p>
            <p class="text-gray-600 text-sm mx-20">電話番号: <%= no.getPhonenum() %></p>
            <p class="text-gray-600 text-sm mx-20">住所: <%= no.getAdd() %></p>
            <p class="text-gray-600 text-sm mx-20">メールアドレス: <%= no.getMailadd() %></p>
        </div>
        <div class="flex space-x-4">
            <button class="bg-gray-500 text-white py-2 px-4 rounded" onclick="location.href='Notification_Servlet?action=friendlist'">戻る</button>
        </div>
    </div>
</body>
</html>