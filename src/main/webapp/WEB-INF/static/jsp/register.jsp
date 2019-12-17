<%--
  Created by IntelliJ IDEA.
  User: fanfan
  Date: 2019/11/27
  Time: 3:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            background-image: url("//images/login.jpg");
            background-size: 100%;
            background-repeat: no-repeat;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
               $("#sb").click(function () {
                   var name=$("#name").val();
                   var password=$("#password").val();
                   var temp={
                       "name":name,
                       "password":password
                   }
                    $.ajax({
                        url:"validate",
                        method:"post",
                        datatype:"json",
                        data:temp,
                        success:function (data) {
                                var js=eval('('+data+')');
                                alert(js.res);
                        }
                    })
               })
        })
    </script>
</head>
<body>
<div >
    <div class="btn-group" style="margin-left:575px;margin-top: 100px">
            <button class=" btn btn-info ">我的主页</button>
            <button class="btn btn-danger">我的订单</button>
            <button class="btn btn-success">个人简介</button>
            <button class="btn btn-dark">注册界面</button>
        </div>
    <div >
        <div style="margin-left: 600px;margin-top: 130px" >
            <div class="form-group">
                <label for="name">用户名</label>
                <input  type="text" placeholder="请输入用户名" id="name">
            </div>
            <div class="form-group">
                <label for="password">密码</label>&nbsp&nbsp&nbsp&nbsp
                <input  type="password" placeholder="请输入密码" id="password">
            </div>
            <div >
              <input type="button" class="btn btn-info" style="margin-left: 100px" id="sb" value="确认注册">
            </div>
        </div>
    </div>
</div>
</body>
</html>