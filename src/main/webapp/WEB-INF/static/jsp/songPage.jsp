<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <strong>音乐管理<i class="zi zi_music"></i></strong>
        </div>
<%--        <div class="panel-body">--%>
<%--&lt;%&ndash;            <form class="form" >&ndash;%&gt;--%>
<%--&lt;%&ndash;                <input placeholder="请输入音乐名" value=""/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <button class="btn btn-success btn-small">Submit</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </form>&ndash;%&gt;--%>
<%--        </div>--%>
        <!-- Table -->
        <table class="table table-bordered  table-hover table-responsive" id="t">
            <tbody>
            <tr class="success">
                <td>音乐id</td>
                <td>音乐名</td>
                <td>歌手名</td>
                <td>音乐路径</td>
                <td>上传时间</td>
                <td>音乐分类</td>
            </tr>
            <c:forEach  items="${list}" var="each">
                <tr>
                    <td>${each.id}</td>
                    <td>${each.name}</td>
                    <td>${each.singer.name}</td>
                    <td>${each.location}</td>
                    <td>${each.uploadtime}</td>
                    <td>${each.category.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="../js/bootstable.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#t').SetEditable({
            columnsEd:"1,2,3,4,5",
            // onEdit: function(row) {
            //     var data={
            //         "id":row.find("td").eq(0).text(),
            //         "account":row.find("td").eq(1).text(),
            //         "name":row.find("td").eq(2).text(),
            //         "password":row.find("td").eq(3).text(),
            //         "phone":row.find("td").eq(4).text()
            //     };
            //     //当确认编辑时如何是添加那么刷新页面
            //     if(row.find("td").eq(0).text()==="")
            //     {
            //         $.ajax({
            //             url:"/user/add",
            //             method:"post",
            //             data:data,
            //             datatype:"json",
            //             success:function (data) {
            //                 var temp=eval('('+data+')');
            //                 if(temp.result=="true")
            //                 {
            //                     alert("添加成功");
            //                     window.location.href="/admin/user";
            //                 }
            //                 else
            //                 {
            //                     alert("添加失败");
            //                 }
            //             }
            //         })
            //     }
            //     else
            //     {
            //         $.ajax({
            //             url:"/user/update",
            //             method:"post",
            //             data:data,
            //             datatype:"json",
            //             success:function (data) {
            //                 var temp=eval('('+data+')');
            //                 if(temp.result=="true")
            //                 {
            //                     alert("修改成功");
            //                 }
            //                 else
            //                 {
            //                     alert("修改失败");
            //                 }
            //             }
            //         })
            //     }
            //
            // },   //Called after edition
            onBeforeDelete: function(row) {
                var id=row.find("td").eq(0).text();
                if(id==="音乐id")
                    alert("不可以删除");
                {
                    $.ajax({
                        url:"/song/delete",
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
                }

            }, //Called before deletion
            onAdd: function() {

            }     //Called when added a new row
        });
    })
</script>
</html>
