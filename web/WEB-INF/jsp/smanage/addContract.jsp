<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Salesman" %>
<%@ page import="com.pojo.Goods" %>
<%@ page import="com.pojo.Client" %>
<%@ page import="javax.annotation.Resource" %><%--
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
    <title>添加合同</title>
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
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        table.table input{ /*可输入区域样式*/
            width:100%;
            height: 100%;
            border:none; /* 输入框不要边框 */
            font-family:Arial;
        }
    </style>
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
                        <li role="presentation"><a href="/client/lookClient">客户信息</a></li>
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
                        <li role="presentation"><a href="#">合同新增</a></li>
                        <li role="presentation"><a href="/orders/lookOrders">查看订单</a></li>
                        <li role="presentation"><a href="/dlist/lookDList">查看发货单</a></li>
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
                        <li><a href="#">合同管理</a></li>
                        <li class="active">合同新增</li>
                    </ol>
                </div>
            </div><!-- /.panel panel-success -->
            <%
                List<Salesman> allSalesman=(List) session.getAttribute("allSalesman");
                List<Goods> allGoods=(List)session.getAttribute("allGoods");
                List<Client> allClient=(List)session.getAttribute("allClient");
            %>
            <form style="text-align: left;">
                <div class="msg">
                    合 同 号：<input type="text" style="margin-left: 20px;" required="required" name="ctno" onkeyup="this.value=this.value.replace(/\D/g, '')">
                </div>
                <div class="msg">
                    负责员工：
                    <select name="sname" style="margin-left: 10px;width: 174px;height: 26px;">
                        <option value="" >请选择销售员</option>
                        <%
                            for(Salesman s:allSalesman){
                        %><option value="<%=s.getS_name()%>"><%=s.getS_name()%></option><%
                            }
                        %>
                    </select>
                </div>
                <div class="msg">
                    客户姓名：
                    <select name="cname" style="margin-left: 10px;width: 174px;height: 26px;" required="required">
                        <option value="" >请选择客户</option>
                        <%
                            for(Client c:allClient){
                        %><option value="<%=c.getC_name()%>"><%=c.getC_name()%></option><%
                        }
                    %>
                    </select>
                </div>
                <div class="msg">
                    签订日期：<input type="date" style="margin-left: 12px;" name="date">
                </div>
                填写订单：
                <table class="table" border="1" align="center">
                    <thead>
                    <tr>
                        <th>单号</th>
                        <th>商品名称</th>
                        <th>订购数量</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr id="clo">
                        <td class="td">1</td>
                        <td>
                            <select name="gname" style="border: none;">
                                <option value="">请选择商品</option>
                                <%
                                    for(Goods g:allGoods){
                                %><option value="<%=g.getG_name()%>"><%=g.getG_name()%></option><%
                                }
                            %>
                            </select>
                        </td>
                        <td> <input placeholder="填写订购数量" name="onum" onkeyup="this.value=this.value.replace(/\D/g, '')"/></td>
                    </tr>
                    </tbody>
                </table>
                <div style="text-align: right;">
                    <button onclick="fun()" type="button">增加一行</button>
                    <button onclick="del()" type="button">删除一行</button>
                </div>
                <div class="msg" style="text-align: center;">
                    <input type="button" class="button" value="提交">
                </div>
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
<script type="text/javascript">
    //前面的序号1,2,3......
    var i = 1;
    $(".td").each(function(){
        $(this).html(i++);
    })
    //添加一行
    function fun(){
        var $td = $("#clo").clone();       //增加一行,克隆第一个对象
        $(".table").append($td);
        var i = 1;
        $(".td").each(function(){       //增加一行后重新更新序号1,2,3......
            $(this).html(i++);
        })
        $("table tr:last").find(":input").val('');   //将尾行元素克隆来的保存的值清空
    }
    //删除一行
    function del(){
        $("table tr:not(:first):not(:first):last").remove();//移除最后一行,并且保留前两行
    }

    $(".button").click(function ( ) {
        var $ctno = $("input[name='ctno']").val();
        var $sname = $("select[name='sname']").val();
        var $cname = $("select[name='cname']").val();
        var $date = $("input[name='date']").val();
        if ($ctno==""){
            alert("请填写合同号");
            return false;
        }
        if($sname==""){
            alert("请选择销售员");
            return false;
        }
        if($cname==""){
            alert("请选择客户");
            return false;
        }
        if($date==""){
            alert("请选择日期");
            return false;
        }
        var $gname = $("select[name='gname']");
        var $onum = $("input[name='onum']");
        var $orders = new Array($gname.length);
        for (var i = 0; i < $gname.length; i++) {
            if ($gname.eq(i).val()==""){
                alert("请选择商品");
                return false;
            }
            if ($onum.eq(i).val()=="") {
                alert("请填写订购数量");
                return false;
            }
            $orders[i] = {"gname": $gname.eq(i).val(),"onum": parseInt($onum.eq(i).val())}
        }
        var json = {"ctno": $ctno, "sname": $sname, "cname": $cname, "date": $date, "status": 0, "orders": $orders};
        var url = "http://localhost:8080/contract/addContract";
        $.ajax({
            async: false,
            url: url,
            type: "POST",
            data: JSON.stringify(json),
            contentType: 'application/json;charset=utf-8',
            dataType: 'text',
            success: function (result) {
                if (result=="success") {
                    alert("添加成功");
                    $(window).attr("location","http://localhost:8080/contract/lookContract");
                } else {
                    alert("该合同号已存在，请重新填写");
                }
            },
            error: function (result) {
                console.log(result);
                alert("出错：" + result);
            }
        });
    })
</script>
</body>
</html>
