<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.Mutter,java.util.List,java.util.Random" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");

List<Mutter> mutterList=
	(List<Mutter>) application.getAttribute("mutterList");
String errorMsg=(String) request.getAttribute("errorMsg");

String[] foo = {"こんにちは","何か用ですか？","AI最強","寒い季節になってきました。どうぞ体に自愛ください",
		"カスタマーセンターまでご連絡してください","眠い","デバッグ","dsadhadhhud","dsffhefhwh","dwefewfehgihuwe"};
Random random = new Random();
int randomValue = random.nextInt(10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チャット機能★</title>
<link rel="stylesheet" href="css/chat.css">
</head>
<body>
<a class="mypage" href="/BusinessCard_School/Main?action=main">マイページへ</a>
<!-- <input class="back" type=button class="Form-Btn" value=">>戻る" onclick="history.back();"> -->
<h1>チャット機能</h1>
<form action="/BusinessCard_School/Chat" method="post">
<input class="in" type="text" name="text" placeholder="insert message">
<input class="send" type="submit" name="つぶやく">
</form>
<br>
<%if(errorMsg!=null){ %>
<p><%=errorMsg%></p>
<%}%>
<% for(Mutter mutter:mutterList) {%>
<dl class="faq_area">
  <div class="show">
    <dd>AIそうだねbot<br>
    <%if(randomValue==1){ %>
    <%=foo[0]%>
    <%}else if(randomValue==2){%>
    <%=foo[1]%>
    <%}else if(randomValue==3){%>
    <%=foo[2]%>
    <%}else if(randomValue==4){%>
    <%=foo[3]%>
    <%}else if(randomValue==5){%>
    <%=foo[4]%>
    <%}else if(randomValue==6){%>
    <%=foo[5]%>
    <%}else if(randomValue==7){%>
    <%=foo[6]%>
    <%}else if(randomValue==8){%>
    <%=foo[7]%>
    <%}else if(randomValue==9){%>
    <%=foo[8]%>
    <%}else if(randomValue==10){%>
    <%=foo[9]%>
    <%} %>
    </dd>
  </div>
  <div>
  	<img src="img/aikon.png"><dt><%=mutter.getUserName() %><br><%=mutter.getText() %></dt>
  </div>
</dl>
<%} %>
</body>
</html>