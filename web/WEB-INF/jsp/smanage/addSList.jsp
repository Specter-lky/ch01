<%@ page import="com.pojo.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.swing.*" %><%--
  Created by IntelliJ IDEA.
  User: Specter
  Date: 2019/12/5
  Time: 23:08
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
    <title>添加商品</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/add.css">
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
                    <a class="navbar-brand" href="#">XXX公司</a>
                </div>

                <div class="collapse navbar-collapse" id="hrms-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账号管理 <span class="caret"></span></a>
                            <ul class="dropdown-menu nav nav-pills nav-stacked">
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
            <ul class="nav nav-pills nav-stacked emp_sidebar">
                <li role="presentation" class="active">
                    <a href="#" data-toggle="collapse" data-target="#collapse_kh">
                        <span class="glyphicon glyphicon-user" aria-hidden="true">客户管理</span>
                    </a>
                    <ul class="nav nav-pills nav-stacked" id="collapse_kh">
                        <li role="presentation"><a href="#">客户信息</a></li>
                        <li role="presentation"><a href="/client/add">客户新增</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav nav-pills nav-stacked dept_sidebar">
                <li role="presentation" class="active">
                    <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                        <span class="glyphicon glyphicon-cloud" aria-hidden="true">合同管理</span>
                    </a>
                    <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                        <li role="presentation"><a href="/contract/lookContract">合同信息</a></li>
                        <li role="presentation"><a href="/contract/add">合同新增</a></li>
                        <li role="presentation"><a href="/orders/lookOrders">查看订单</a></li>
                        <li role="presentation"><a href="/dlist/lookDList">查看发货单</a></li>
                        <li role="presentation"><a href="/slist/add">添加进货单</a></li>
                        <li role="presentation"><a href="/slist/slooksList">查看进货单</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav nav-pills nav-stacked dept_sidebar">
                <li role="presentation" class="active">
                    <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                        <span class="glyphicon glyphicon-cloud" aria-hidden="true">销售总额查看</span>
                    </a>
                    <ul class="nav nav-pills nav-stacked" id="collapse_sales">
                        <li role="presentation"><a href="/sales/lookGSales">商品销售总额</a></li>
                        <li role="presentation"><a href="/sales/lookCSales">客户销售总额</a></li>
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
                        <li><a href="#">货物管理</a></li>
                        <li class="active">进货</li>
                    </ol>
                </div>
            </div><!-- /.panel panel-success -->
            <form action="/slist/addSList" method="post" style="text-align: center;">
                <table border="2" cellspacing="0" cellpadding="0" bgcolor="#95BDFF" width="60%" align="center">
                    <%
                        List<Goods> allGoods=(List) session.getAttribute("allGoods");
                        if (allGoods==null||allGoods.size()==0){
                            String msg = "请先添加商品！";
                            int type = JOptionPane.YES_NO_CANCEL_OPTION;
                            String title = "信息提示";
                            JOptionPane.showMessageDialog(null, msg, title, type);
                            response.sendRedirect("http://localhost:8080/goods/add");
                        }
                    %>
                    <tr>
                        <td height="30">商品：</td>
                        <td>
                            <select name="gname" style="border: none;">
                                <option value="" >请选择商品</option>
                                <%
                                    for(Goods g:allGoods){
                                %><option value="<%=g.getG_name()%>"><%=g.getG_name()%></option><%
                                }
                            %>
                            </select>
                        </td>
                    </tr>
                    <tr class="msg">
                        <td height="30">进货数量：</td>
                        <td><input type="text" required="required" onkeyup="this.value=this.value.replace(/\D/g, '')" name="slnum"></td>
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