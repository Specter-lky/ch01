<%@ page import="com.pojo.Salesman" %><%--
  Created by IntelliJ IDEA.
  User: Specter
  Date: 2019/12/5
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>编辑员工信息</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/addSalesman.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>
    </script>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <div class="hrms_brand_nav">
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#hrms-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">XXX公司LOGO</a>
                </div>

                <div class="collapse navbar-collapse" id="hrms-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">公司介绍 <span class="sr-only">(current)</span>  </a>
                        </li>
                        <li><a href="#">人力资源部</a></li>
                        <li><a href="#">请假申请</a></li>
                        <li><a href="#">报销申请</a></li>
                        <li><a href="#">出勤记录</a></li>
                    </ul>

                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="站内搜索">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账号管理 <span class="caret"></span></a>
                            <ul class="dropdown-menu nav nav-pills nav-stacked">
                                <li class="active"><a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改信息</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 头像更换</a></li>
                                <li class="hrms_logout"><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> 账号退出</a></li>
                            </ul>
                        </li>
                    </ul><!-- /.nav navbar-nav navbar-right -->
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div><!-- /.hrms_brand_nav -->

    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
            <ul class="nav nav-pills nav-stacked emp_sidebar">
                <li role="presentation" class="active">
                    <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                        <span class="glyphicon glyphicon-user" aria-hidden="true">员工管理</span>
                    </a>
                    <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                        <li role="presentation"><a href="/sales/employee">员工信息</a></li>
                        <li role="presentation"><a href="/sales/add">员工新增</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav nav-pills nav-stacked dept_sidebar">
                <li role="presentation" class="active">
                    <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                        <span class="glyphicon glyphicon-cloud" aria-hidden="true">部门管理</span>
                    </a>
                    <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                        <li role="presentation"><a href="#">部门信息</a></li>
                        <li role="presentation"><a href="#">部门新增</a></li>
                        <li role="presentation"><a href="#">部门清零</a></li>
                    </ul>
                </li>
            </ul>

        </div><!-- /.panel-group，#hrms_sidebar_left -->

        <!-- 中间员工表格信息展示内容 -->
        <div class="emp_info col-sm-10">

            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="/sales/employee">员工管理</a></li>
                        <li class="active">员工信息修改</li>
                    </ol>
                </div>
            </div><!-- /.panel panel-success -->
            <form action="/sales/updateSalesman" method="post" style="text-align: center;">
                <table border="2" cellspacing="0" cellpadding="0" bgcolor="#95BDFF" width="60%" align="center">
                    <%
                        Salesman salesman=(Salesman) session.getAttribute("salesman");
                    %>
                    <tr>
                        <td height="30">员工编号</td>
                        <td><input type="text" name="no" value="<%=salesman.getS_no()%>" readonly = "readonly" style="border:none;"></td>
                    </tr>
                    <tr>
                        <td height="30">员工姓名：</td>
                        <td><input type="text" required="required" name="name" value="<%=salesman.getS_name()%>"></td>
                    </tr>
                    <tr class="msg">
                        <td height="30">员工电话：</td>
                        <td><input type="text" required="required" value="<%=salesman.getS_phone()%>" onkeyup="this.value=this.value.replace(/\D/g, '')" name="phone"></td>
                    </tr>
                    <tr class="msg">
                        <td height="30">员工地址：</td>
                        <td><input type="text" required="required" name="adress" value="<%=salesman.getS_adress()%>"></td>
                    </tr>
                    <tr class="msg">
                        <td height="30">登录密码：</td>
                        <td><input type="text" required="required" name="password" value="<%=salesman.getS_password()%>"></td>
                    </tr>
                    <tr class="msg">
                        <td align="center" colspan="2"><input type="submit" class="button" value="提交"></td>
                    </tr>
                </table>
            </form>
        </div><!-- /.hrms_body -->


        <!-- 尾部 -->
        <div class="hrms_footer" style="text-align: center;">
            <address>
                <strong>Copyright&copy;XXX公司.Inc</strong><br>
                徐汇区民润大厦五层<br>
                <abbr title="Phone">P:</abbr> (123) 456-7890
            </address>
        </div><!-- /.hrms_footer -->
    </div>
</div><!-- /.container -->
</body>
</html>
