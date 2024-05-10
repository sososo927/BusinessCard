<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.UserBean" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>calendar page</title>
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css"
		integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1" crossorigin="anonymous" />

	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700&display=swap" rel="stylesheet" />
	<title>CalenderApp</title><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/calendarstyle.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div id="current-day-info" class="color">
		<h1 id="app-name-landscape" class="off-color center default-cursor">
			スケジュール画面
		</h1>

		<div>
			<h2 id="current-year" class="center default-cursor">2019</h2>
		</div>

		<div>
			<h1 id="cur-day" class="current-day-heading center default-cursor">
				Monday
			</h1>
			<h1 id="cur-month" class="current-month-heading center default-cursor">
				June
			</h1>
			<h1 id="cur-date" class="current-date-heading center default-cursor">
				7
			</h1>
		</div>

		<div class="time">
			<span> 22 </span>: <span> 55 </span>:
			<span> 23 </span>
		</div>

		<button id="theme-landscape" class="font btn">テーマを変える</button>
		<br>
		<button id="theme-landscape" class="font btn"
                onclick="location.href='Main?action=main&pr=<%= loginUser.getLoginid() %>'">マイページ</button>
	</div>

	<div id="calender">
		<h1 id="app-name-portrait" class="center ">Calender</h1>
		<!-- h1 'off-color' class was removed -->
		<table>
			<thead class="color">
				<tr>
					<th colspan="7" class="border-color">
						<h4 id="cal-year" contenteditable="true">2018</h4>
						<div>
							<i class="fas fa-caret-left icon"> </i>
							<h3 id="cal-month">july</h3>
							<i class="fas fa-caret-right icon"> </i>
						</div>
					</th>
				</tr>

				<tr>
					<th class="weekday border-color">Sun</th>
					<th class="weekday border-color">Mon</th>
					<th class="weekday border-color">Tue</th>
					<th class="weekday border-color">Wed</th>
					<th class="weekday border-color">Thu</th>
					<th class="weekday border-color">Fri</th>
					<th class="weekday border-color">Sat</th>
				</tr>
			</thead>

			<tbody id="table-body">
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
				<tr>
					<td>1</td>
					<td>1</td>
					<td class="tooltip-container">
						<span class="day">1</span>
						<img src="./images/note1.png" alt="note" />
						<span class="tooltip"> this is pretty tooltip</span>
					</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
			</tbody>
		</table>
		<button id="theme-portrait" class="font btn">Change Theme</button>
	</div>

	<div class="modal">
		<div id="fav-color" hidden>
			<div class="popup">
				<h4>何色にしますか？</h4>

				<div id="color-options">
					<div class="color-option">
						<div class="color-preview" id="blue" style="background-color: #1B19CD;">
							<!-- <i class="fas fa-check checkmark"></i> -->
						</div>
						<h5>Blue</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="red" style="background-color: #D01212;"></div>
						<h5>Red</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="purple" style="background-color: #721D89;"></div>
						<h5>Purple</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="green" style="background-color: #158348;"></div>
						<h5>Green</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="orange" style="background-color: #EE742D;"></div>
						<h5>Orange</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="deep-orange" style="background-color: #F13C26;"></div>
						<h5>Deep Orange</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="baby-blue" style="background-color: #31B2FC;"></div>
						<h5>Baby Blue</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="cerise" style="background-color: #EA3D69;"></div>
						<h5>Cerise</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="lime" style="background-color: #36C945;"></div>
						<h5>Lime</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="teal" style="background-color: #2FCCB9;"></div>
						<h5>Teal</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="pink" style="background-color: #F50D7A;"></div>
						<h5>Pink</h5>
					</div>

					<div class="color-option">
						<div class="color-preview" id="black" style="background-color: #212524;"></div>
						<h5>Black</h5>
					</div>
				</div>

				<button id="update-theme-button" class="font btn color">
					色を変更
				</button>
			</div>
		</div>

		<div id="make-note" hidden>
			<div class="popup">
				<h4> <span class="verb"></span> note on <span id="noteDate">2019 12 5</span></h4>
				<input class="note-title" type="text" name="title" placeholder="タイトルを入力 ..." />
				<textarea class="note-content" id="edit-post-it" name="post-it"
					placeholder="予定を入力 ..."></textarea>
				<span style="color:red;" id="warning"></span>
				<div>
					<button class="btn font post-it-button" id="add-post-it">
						更新
					</button>
					<button class="btn font post-it-button" id="delete-button">
						削除
					</button>
				</div>
			</div>
		</div>
	</div>
<!-- partial -->
  <script  src="js/calendarscript.js"></script>

</body>
</html>