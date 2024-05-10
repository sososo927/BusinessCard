<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.ScheduleBean,model.Mutter,java.util.ArrayList" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
%>
<%

ArrayList<ScheduleBean> customerRecordArray=
	(ArrayList<ScheduleBean>)request.getAttribute("user_list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>♪♬楽しい楽しいスケジュール★</title>
<link rel="stylesheet" href="css/schedule.css">
</head>
<body>
<!-- <input type=button class="Form-Btn" value="戻る" onclick="history.back();"> -->
<a class="mypage" href="Main?action=main&pr=<%= loginUser.getLoginid() %>">マイページへ</a>
<%System.out.println(loginUser.getLoginid()) %>
<h1>スケジュールホーム画面</h1>
      <div class="container-calendar">
          <h4 id="monthAndYear"></h4>
          <div class="button-container-calendar">
              <button id="previous" onclick="previous()">‹</button>
              <button id="next" onclick="next()">›</button>
          </div>
          
          <table class="table-calendar" id="calendar" data-lang="ja">
              <thead id="thead-month"></thead>
              <tbody id="calendar-body"></tbody>
          </table>
          
          <div class="footer-container-calendar">
              <label for="month">日付指定：</label>
              <select id="month" onchange="jump()">
                  <option value=0>1月</option>
                  <option value=1>2月</option>
                  <option value=2>3月</option>
                  <option value=3>4月</option>
                  <option value=4>5月</option>
                  <option value=5>6月</option>
                  <option value=6>7月</option>
                  <option value=7>8月</option>
                  <option value=8>9月</option>
                  <option value=9>10月</option>
                  <option value=10>11月</option>
                  <option value=11>12月</option>
              </select>
              <select id="year" onchange="jump()"></select>
          </div>
    </div>
    <script src="js/schedule.js" type="text/javascript"></script>
    
	<form action="/BusinessCard_School/Schedule" method="post">
		<p>
		日時<input type="date" name="scheduledate"></input>
		<br>
		開始時刻<input type="time" name="starttime" value="--:--">～
		終了時刻<input type="time" name="endtime" value="--:--">
		<br>
		予定<input class="in" type="text" name="schedule" placeholder="予定">
		<br>
		メモ書き<input class="in" type="text" name="memo" placeholder="備考">
		<br>
		<input class="send" type="submit" value="確定">
		</p>
	</form>

	<%
		
		if (customerRecordArray == null || customerRecordArray.size() == 0){
	%>
		<br>
		<div class="businessCard">
		<p>　検索結果<br>　　なし</p>
		</div>
		<br>
	<%	} else { %>
	<%		for(int i = 0; i < customerRecordArray.size(); i++){ %>
	<% String comp1 = String.valueOf(customerRecordArray.get(i).getUserid()); %>
	<% String comp2 = String.valueOf(loginUser.getLoginid()); %>
	<%if(comp1.equals(comp2)){ %>
			<div class="businessCard">
			<p>　<%= customerRecordArray.get(i).getScheduledate() %></p>
			<p>　<%= customerRecordArray.get(i).getStarttime() %></p>
			<p>　<%= customerRecordArray.get(i).getEndtime() %></p>
			<p>　<%= customerRecordArray.get(i).getSchedule() %></p>
			<p>　<%= customerRecordArray.get(i).getMemo() %></p>
			</div>
			<%} %>
			<% } %>
		<% } %>
</body>
</html>