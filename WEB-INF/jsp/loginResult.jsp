<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.Mutter,java.util.List" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>ログイン成功</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
  <link rel="stylesheet" href="css/loginResult.css">
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
        <div class="hit">
           <h3 class="font-serif text-2xl font-bold"><%= loginUser.getName() %>さんでログインしました。</h3>
            <h3 class="mb-4 font-serif text-2xl font-bold">引き続きお楽しみください！</h3>
            <div>
                <a href="Main?action=main&pr=<%= loginUser.getLoginid() %>" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded transition duration-300 ease-in-out">
                  マイページに進む
                </a>
              </div>
        <div class="stack-container">
            <div class="card-container">
                <div class="perspec" style="--spreaddist: 125px; --scaledist: .75; --vertdist: -25px;">
                    <div class="card">
                        <div class="writing">
                            <div class="topbar">
                                <div class="red"></div>
                                <div class="yellow"></div>
                                <div class="green"></div>
                            </div>
                            <div class="code">
                                <ul>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-container">
                <div class="perspec" style="--spreaddist: 100px; --scaledist: .8; --vertdist: -20px;">
                    <div class="card">
                        <div class="writing">
                            <div class="topbar">
                                <div class="red"></div>
                                <div class="yellow"></div>
                                <div class="green"></div>
                            </div>
                            <div class="code">
                                <ul>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-container">
                <div class="perspec" style="--spreaddist:75px; --scaledist: .85; --vertdist: -15px;">
                    <div class="card">
                        <div class="writing">
                            <div class="topbar">
                                <div class="red"></div>
                                <div class="yellow"></div>
                                <div class="green"></div>
                            </div>
                            <div class="code">
                                <ul>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-container">
                <div class="perspec" style="--spreaddist: 50px; --scaledist: .9; --vertdist: -10px;">
                    <div class="card">
                        <div class="writing">
                            <div class="topbar">
                                <div class="red"></div>
                                <div class="yellow"></div>
                                <div class="green"></div>
                            </div>
                            <div class="code">
                                <ul>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-container">
                <div class="perspec" style="--spreaddist: 25px; --scaledist: .95; --vertdist: -5px;">
                    <div class="card">
                        <div class="writing">
                            <div class="topbar">
                                <div class="red"></div>
                                <div class="yellow"></div>
                                <div class="green"></div>
                            </div>
                            <div class="code">
                                <ul>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-container">
                <div class="perspec" style="--spreaddist: 0px; --scaledist: 1; --vertdist: 0px;">
                    <div class="card">
                        <div class="writing">
                            <div class="topbar">
                                <div class="red"></div>
                                <div class="yellow"></div>
                                <div class="green"></div>
                            </div>
                            <div class="code">
                                <ul>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
<!-- partial -->
  <script  src="js/loginResult.js"></script>

</body>
</html>
