<%--
  Created by IntelliJ IDEA.
  User: Specter
  Date: 2019/11/25
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  <body>
    <%
if (session.getAttribute("error")!=null)
{
  String error=(String) session.getAttribute("error");
    %>
  <script>alert("<%=error%>");</script>
<%
  }
  session.setAttribute("error",null);
%>
  <div class="column">
  <h2>公司销售管理系统</h2>
  <form action="/hi/login" method="post" onsubmit="return submit_from()">
    <div style="margin-top:25px;position:relative;">
      <input name="username" id="login_name" type="text" class="txt" required="required" placeholder="请输入用户名">
    </div>
    <div style="margin-top:25px;position: relative;">
      <input name="password" id="login_password" class="txt" type="password" required="required" placeholder="请输入密码">
    </div>
    <div style="margin-top:25px;position: relative;text-align: left;padding: 0px 25px;">
      <select name="identity">
        <option value="">请选择登录身份</option>
        <option value="销售管理员">销售管理员</option>
        <option value="仓库管理员">仓库管理员</option>
        <option value="销售人员">销售人员</option>
      </select>
    </div>
    <div id="login"  style="margin-top: 25px">
      <input class="button" type="submit" value="立即登录" />
    </div>
  </form>
  </div>
  </body>
</html>
