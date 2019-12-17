<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!--  <script src="../dist/js/bootstrap.min.js"></script>-->
  <!--  <script src="../dist/css/bootstrap.min.css"></script>-->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" >
  <meta charset="UTF-8">
  <title>后台管理系统</title>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="//code.z01.com/v4/dist/css/zico.min.css" >
  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script src="//code.z01.com/v4/dist/js/popper.min.js"></script>
  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>\
  <script src="http://ico.z01.com/zico.min.js"></script>
  <style>
    body {
      background-image: linear-gradient(to right , #7A88FF, #7AFFAF);
    }
  </style>
  <script>
    $(document).ready(function(){
        $("#div1").fadeIn(2000);
        $("#sb").click(function () {
            $.ajax({
                url:"/admin/login",
                method:"post",
                datatype:"json",
                data:$("form").serialize(),
                success:function (data) {
                    var temp=eval('('+data+')');
                    if(temp.result=="true")
                    {
                        window.location.href="/admin/main";
                    }
                    else
                    {
                        window.location.href="/admin/fault";
                    }
                }

            })
        })
    });
  </script>
</head>
<body>

<div id="div1" style="display: none">
   <div class="container col-md-4 col-md-offset-4"  style="margin-top: 200px">
         <form role="form">
           <div class="form-group">
              <p>MusicHub后台管理登陆界面</p>
           </div>
            <div class="form-group">
              <label for="name">姓名<i class="zi zi_useralt" zico="用户黑"></i></label>
              <input type="text" value="" name="name" placeholder="请输入管理员姓名" class="form-control">
            </div>
           <div class="form-group">
             <label for="password">密码</label>
             <i class="glyphicon glyphicon-lock"></i>
             <input type="text" value="" class="form-control" name="password" placeholder="请输入管理员密码" >
           </div>
             <div class="form-group">
                 <button type="button" class="btn btn-danger" id="sb">确认登陆</button>
             </div>
         </form>
   </div>
</div>
</body>
</html>
