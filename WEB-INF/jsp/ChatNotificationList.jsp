<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Notification_Bean" %>
<%@ page import="dao.Notification_DAO" %>
<%@ page import="model.UserBean" %>
<%
    Notification_DAO noDAO = new Notification_DAO();
%>
<%@ page import="model.CustomerBean" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
ArrayList<Notification_Bean> noList = noDAO.Chatselect(Integer.parseInt(loginUser.getLoginid()));
%>l
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>チャット通知画面</title>
</head>

<body class="bg-gray-100">

    <div class="container mx-auto p-8">
        <h1 class="text-3xl font-bold mb-8">チャット通知一覧</h1>

        <table class="w-full bg-white border border-gray-300">
            <!-- Table Header -->
            <thead>
                <tr>
                    <th class="py-2 px-4 border-b">ユーザー番号</th>
                    <th class="py-2 px-4 border-b">氏名</th>
                    <th class="py-2 px-4 border-b">会社名</th>
                    <th class="py-2 px-4 border-b">アクション</th>
                </tr>
            </thead>

            <!-- Table Body -->
            <tbody>
                <%
                    for (Notification_Bean no : noList) {
                %>
                <tr>
                    <td class="py-2 px-4 border-b text-center"><%= no.getUser_id()%></td>
                    <td class="py-2 px-4 border-b text-center"><%= no.getName()%>様</td>
                    <td class="py-2 px-4 border-b text-center"><%= no.getCompany_name()%></td>
                    <td class="py-2 px-4 border-b text-center">
                        <!-- Use onclick event to trigger JavaScript function on button click -->
                        <button class="bg-blue-500 text-white py-2 px-4 rounded"
                            onclick="location.href='ChatServlet?senderid=<%= loginUser.getLoginid() %>&reciverid=<%= no.getUser_id() %>&roomId=<%= no.getRoom_id() %>'">
                            チャットへ
                        </button>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <div class="mt-8">
            <button class="bg-gray-500 text-white py-2 px-4 rounded"
                onclick="location.href='Main?action=main&pr=<%= loginUser.getLoginid() %>'">戻る</button>
            <button class="bg-green-500 text-white py-2 px-4 rounded"
                onclick="location.href='Notification_Servlet?action=appno&fl=null'">申請通知画面へ</button>
            <button class="bg-green-500 text-white py-2 px-4 rounded"
                onclick="location.href='Notification_Servlet?action=answer&fl=null'">返信通知画面へ</button>
            
        </div>
    </div>

    <!-- JavaScript function to show an alert with the provided message -->
    <script>
        function showAlert(name) {
            alert("Hello, " + name + "!"); // Modify this alert message as needed
        }
    </script>

</body>

</html>