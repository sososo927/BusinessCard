<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.CustomerBean,model.Mutter,java.util.List" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
CustomerBean cs = (CustomerBean)request.getAttribute("cs");
%>

  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <script src="https://cdn.tailwindcss.com"></script>
      <script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
  </head>
  <div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
    <div class="sm:mx-auto sm:w-full sm:max-w-sm">
      <img class="mx-auto h-10 w-auto" src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=600" alt="Your Company">
      <h2 class="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">名刺変更</h2>
    </div>
    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
      <form class="space-y-6" action="ID_Upadate_Servlet" method="post">
      	<h1 name="Up_AID">ID：<%= cs.getAID() %></h1>
      	<div>
          <div class="mt-2">
            <input id="AID" name="Up_AID" value=<%=cs.getAID() %> type="hidden" autocomplete="AID" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <label for="Phonenum" class="block text-sm font-medium leading-6 text-gray-900">電話番号</label>
          <div class="mt-2">
            <input id="Phonenum" name="Up_Phonenum" value=<%=cs.getPhonenum() %> type="Phonenum" autocomplete="Phonenum" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <label for="Address" class="block text-sm font-medium leading-6 text-gray-900">住所</label>
          <div class="mt-2">
            <input id="Address" name="Up_Address" value=<%=cs.getAddress() %> type="text" autocomplete="Address" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <div class="mt-2">
            <input id="MailAdd" name="Up_MailAdd" value=<%=cs.getMailAdd() %> type="hidden" autocomplete="MailAdd" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <label for="FN" class="block text-sm font-medium leading-6 text-gray-900">氏名</label>
          <div class="mt-2">
            <input id="FN" name="Up_FN" value=<%=cs.getFN() %> type="FN" autocomplete="FN" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <label for="Cname" class="block text-sm font-medium leading-6 text-gray-900">企業名</label>
          <div class="mt-2">
            <input id="Cname" name="Up_Cname" value=<%=cs.getCname() %> type="Cname" autocomplete="Cname" required class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400  sm:text-sm sm:leading-6">
          </div>
        </div>
        <div>
          <button type="submit" class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">変更</button>
        </div>
      </form>
      </p>
    </div>
  </div>
  