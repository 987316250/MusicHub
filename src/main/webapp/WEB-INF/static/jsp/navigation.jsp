<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>MusicHub</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" >
  <link rel="stylesheet" href="../css/nav.css">
  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="//code.z01.com/v4/dist/css/zico.min.css" >
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script src="//code.z01.com/v4/dist/js/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    table tbody tr td{
      vertical-align: middle;
      text-align: center;
    }
  </style>
</head>
<body>

<div class="container-fluid navbar-inverse navbar-fixed-top">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header  col-md-4">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#" >MusicHub后台管理系统</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse col-md-4" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li ><a href="/admin/dashboard">首页 </a></li>
      <li ><a href="/admin/user">用户管理 </a></li>
      <li><a href="/admin/uploadAndDown">上传管理</a></li>
      <li><a href="/admin/songPage">库存音乐</a></li>
      <li><a href="/admin/singer">歌手</a></li>
    </ul>
    <form class="navbar-form navbar-left">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default ">Submit</button>
    </form>
  </div>
</div>
</body>
</html>
