<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MusicHub</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" >
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
        body {
            background-image: linear-gradient(to right , #7A88FF, #7AFFAF);
        }
    </style>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class="container"  style="margin-top: 100px">
    <div class="panel panel-default">
        <div class="panel-heading">
            <strong>用户管理<i class="zi zi_user" zico="用户标志"></i></strong>
        </div>
<%--        <div class="panel-body">--%>
<%--            <form class="form" >--%>
<%--                <input placeholder="请输入用户名字" value=""/>--%>
<%--                <button class="btn btn-success btn-small">Submit</button>--%>
<%--            </form>--%>
<%--        </div>--%>
        <!-- Table -->
        <table class="table table-bordered  table-hover table-responsive" id="t">
            <tbody>
            <tr class="success">
                <td>用户id</td>
                <td>用户账号</td>
                <td>用户姓名</td>
                <td>用户密码</td>
                <td>手机号</td>
            </tr>
            <c:forEach  items="${list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.account}</td>
                    <td>${user.name}</td>
                    <td>${user.password}</td>
                    <td>${user.phone}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="container col-md-12" style="margin-top: 50px"><button class=" btn btn-danger " id="add"><i class="glyphicon glyphicon-plus"></i>添加用户</button></div>
    </div>
</div>
</body>
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="../js/bootstable.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#t').SetEditable({
            columnsEd:"1,2,3,4",
            $addButton: $('#add'),
            onEdit: function(row) {
                var data={
                    "id":row.find("td").eq(0).text(),
                   "account":row.find("td").eq(1).text(),
                    "name":row.find("td").eq(2).text(),
                    "password":row.find("td").eq(3).text(),
                    "phone":row.find("td").eq(4).text()
                };
                //当确认编辑时如何是添加那么刷新页面
              if(row.find("td").eq(0).text()==="")
              {
                  $.ajax({
                      url:"/user/add",
                      method:"post",
                      data:data,
                      datatype:"json",
                      success:function (data) {
                          var temp=eval('('+data+')');
                          if(temp.result=="true")
                          {
                              alert("添加成功");
                              window.location.href="/admin/user";
                          }
                          else
                          {
                              alert("添加失败");
                          }
                      }
                  })
              }
              else
              {
                  $.ajax({
                      url:"/user/update",
                      method:"post",
                      data:data,
                      datatype:"json",
                      success:function (data) {
                          var temp=eval('('+data+')');
                          if(temp.result=="true")
                          {
                              alert("修改成功");
                          }
                          else
                          {
                              alert("修改失败");
                          }
                      }
                  })
              }

            },   //Called after edition
            onBeforeDelete: function(row) {
                var id=row.find("td").eq(0).text();
                $.ajax({
                    url:"/user/delete",
                    method:"post",
                    data: {"id":id},
                    datatype:"json",
                    success:function (data) {
                        var temp=eval('('+data+')');
                        if(temp.result=="true")
                        {
                            alert("删除成功");
                        }
                        else
                        {
                            alert("删除失败");
                        }
                    }
                })
            }, //Called before deletion
            onAdd: function() {

            }     //Called when added a new row
        });
    })
</script>
</html>