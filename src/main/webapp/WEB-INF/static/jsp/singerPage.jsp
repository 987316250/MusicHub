
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <strong>歌手<i class="zi zi_love"></i></strong>
        </div>
        <!-- Table -->
        <table class="table table-bordered  table-hover table-responsive" id="t">
            <tbody>
            <tr class="success">
                <td>歌手id</td>
                <td>歌手名字</td>
                <td>歌手头像</td>
            </tr>
            <c:forEach items="${list}" var="each">
                 <tr>
                     <td>${each.id}</td>
                     <td>${each.name}</td>
                     <td><img src="${each.location}" style="height: 50px;width: 50px" class="center-block"/></td>
<%--                     <td><img src="${each.location}" style="height: 100px;width: 100px;" class="center-block"/></td>--%>
                 </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="btn btn-success" id="add">添加</div>
</div>
</body>
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="../js/bootstable.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#t').SetEditable({
            columnsEd:"1",
            $addButton: $('#add'),
            onEdit: function(row) {
                var data={
                    "id":row.find("td").eq(0).text(),
                    "name":row.find("td").eq(1).text(),
                };
                //当确认编辑时如何是添加那么刷新页面
                if(row.find("td").eq(0).text()==="")
                {
                    $.ajax({
                        url:"/singer/add",
                        method:"post",
                        data:data,
                        datatype:"json",
                        success:function (data) {
                            var temp=eval('('+data+')');
                            if(temp.result=="true")
                            {
                                alert("添加成功");
                                window.location.href="/admin/singer";
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
                        url:"/singer/update",
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
                    url:"/singer/delete",
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
