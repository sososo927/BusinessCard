<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ChatHistoryBean" %>
<%@ page import="model.UserBean,model.CustomerBean,model.Mutter,java.util.List" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
CustomerBean cs = (CustomerBean)request.getAttribute("cs");
%>
<!DOCTYPE html>
 
<html>
<head>
    <meta charset="UTF-8">
    <title>個人Room</title>
    <style>
        /* Tailwind CSS CDNを追加していない場合、以下のように手動でスタイルを追加してください */
        /* メッセージ送信フォームのスタイル */
        .message-form {
            max-width: 400px;
            margin-top: 20px;
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            padding: 10px;
            background-color: #fff;
            box-shadow: 0px -5px 5px -5px #333;
        }
 
        .message-form label {
            display: block;
            margin-bottom: 10px;
        }
 
        .message-form input {
            width: calc(100% - 20px);
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }
 
        .message-form button {
            padding: 10px;
            background-color: #4caf50; /* ボタンの背景色 */
            color: white; /* ボタンの文字色 */
            border: none;
            cursor: pointer;
            display: block;
            width: calc(100% - 20px);
            box-sizing: border-box;
        }
 
        .message-form button:hover {
            background-color: #45a049; /* ボタンのホバー時の背景色 */
        }
 
        /* チャットメッセージのスタイル */
        .chat-message {
            margin-bottom: 10px;
            padding: 10px;
            word-wrap: break-word;
            box-sizing: border-box;
        }
 
        .left-message {
            background-color: #4caf50; /* 左側メッセージの背景色（緑色） */
            text-align: left;
            color: white; /* テキストの色 */
        }
 
        .right-message {
            background-color: #e0e0e0; /* 右側メッセージの背景色 */
            text-align: right;
        }
    </style>
</head>
<body>
    <!-- ここに誰とのチャットルームかを表示する-->
    <ul>
        <!-- チャットの送信者IDをif文で判定（左右に振り分ける）
            ＊後ほど、判定条件を現在ログイン中のユーザにおきかえる -->
        <% List<ChatHistoryBean> chatHistoryList = (List<ChatHistoryBean>)session.getAttribute("chatHistoryList"); %>
        <% for (ChatHistoryBean chathistory : chatHistoryList) { %>
            <!-- パラメータが存在するか確認 -->
            
            <% if (chathistory.getChat_senderId()==Integer.parseInt(loginUser.getLoginid())) { %>
                <div class="chat-message left-message">
                    <p>
                        送信者: <%= chathistory.getChat_senderId() %><br>
                        メッセージ: <a href="Message_Delete.jsp?action=<%= chathistory.getChat_sentence() %>&chat_messagedate=<%= chathistory.getChat_messagedate() %>&roomId=<%= chathistory.getChat_roomid() %>&receiverId=<%= chathistory.getChat_receiverId() %>&senderId=<%= chathistory.getChat_senderId() %>" class="no-underline"><%= chathistory.getChat_sentence() %></a><br>
                        送信時間: <%= chathistory.getChat_messagedate() %>
                    </p>
                </div>
            <% } else { %>
                <div class="chat-message right-message">
                    <p>
                        受信者: <%= chathistory.getChat_senderId()%><br>
                        メッセージ: <%= chathistory.getChat_sentence() %><br>
                        送信時間: <%= chathistory.getChat_messagedate() %>
                    </p>
                </div>
            <% } %>
        <% } %>
    </ul>
 
    <!-- チャットを送信するためのForm -->
    <% ChatHistoryBean chathistory = chatHistoryList.get(0); %>
    <%int reserveAID=chathistory.getChat_receiverId(); %>
    <%int reserveBID=chathistory.getChat_senderId(); %>
    <%int reserve=0; %>
    <%if(reserveAID==Integer.parseInt(loginUser.getLoginid())){ %>
    <%reserve=reserveBID; %>
    <%}else{ %>
    <%reserve=reserveAID; %>
    <%} %>
  <% if (chatHistoryList != null && !chatHistoryList.isEmpty()) { %>
    <% ChatHistoryBean chathistory2 = chatHistoryList.get(0); %>
    <form class="message-form" method="post" action="SendMessageServlet" onsubmit="return validateForm()">
        <input type="hidden" name="SendMessage_roomid" value="<%= chathistory.getChat_roomid() %>">
        <input type="hidden" name="SendMessage_receiverId" value="<%= reserve %>">
        <input type="hidden" name="SendMessage_senderId" value="<%=loginUser.getLoginid() %>">
        <label>メッセージ: <input class="border p-2" type="text" name="SendMessage_sentence" id="messageInput" placeholder="メッセージを入力してください"></label>
        <button class="bg-green-500 text-white" type="submit">送信</button>
    </form>
<% } %>
 

        <div class="right-message">
            <button class="bg-green-500 text-white py-2 px-4 rounded"
                onclick="location.href='Notification_Servlet?action=friendlist'">戻る</button>
            
        </div>        
   <script>
    function validateForm() {
        var messageInput = document.getElementById("messageInput").value;
 
        if (messageInput.trim() === "") {
            alert("メッセージを入力してください。");
            return false;
        }
 
        return true;
    }
 
    document.body.scrollTop = document.body.scrollHeight;
</script>
</body>
</html>