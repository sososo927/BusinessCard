<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.Mutter,java.util.List" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <title>中間結果の保持</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>

<body class="bg-gray-100 min-h-screen flex items-center justify-center">

    <div class="bg-white p-8 rounded shadow-md max-w-md w-full">
        <h3 class="font-serif text-2xl font-bold mb-4"><%= loginUser.getName() %>さんの名刺情報を変更しました。</h3>
        <h3 class="mb-4 font-serif text-2xl font-bold">引き続きお楽しみください！</h3>
        <div>
            <a href="Main?action=main&pr=<%= loginUser.getLoginid() %>"
                class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded transition duration-300 ease-in-out">
                マイページに進むbbb
            </a>
        </div>
    </div>

</body>

</html>