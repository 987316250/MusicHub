<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" >
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.z01.com/v4/dist/css/zico.min.css" >
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="//code.z01.com/v4/dist/js/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/fileinput.css" />
    <style>
        body {
            background-image: linear-gradient(to right , #7A88FF, #7AFFAF);
        }
    </style>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<div class=" col-md-4 col-md-offset-2" style="margin-top: 200px">
    <!-- type必须指定为文件 name是为了后台能拿到值 multiple支持多文件上传 id是为了script对input进行初始化-->
    <label>音乐上传</label>
    <input type="file" class="file" id="myinput" multiple  name="file" style="width: 500px" />
</div>
<div class=" col-md-4" style="margin-top: 200px">
    <!-- type必须指定为文件 name是为了后台能拿到值 multiple支持多文件上传 id是为了script对input进行初始化-->
    <label>图片上传</label>
    <input type="file" class="file" id="myinput1" multiple  name="file" style="width: 500px" />
</div>
<script type="text/javascript" src="../js/fileinput.js"></script>
<script type="text/javascript" src="../js/zh.js"></script>
<script>
    //初始化fileinput控件（第一次初始化）
    $('#myinput').fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/file/upload", //上传的地址
        allowedFileExtensions : ['jpg', 'png','gif',"mp3"],//接收的文件后缀,
        maxFileCount: 100,
        enctype: 'multipart/form-data',
        showUpload: true, //是否显示上传按钮
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: 100,
        showPreview: true,
    });
</script>
<script>
    //初始化fileinput控件（第一次初始化）
    $('#myinput1').fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/img/upload", //上传的地址
        allowedFileExtensions : ['jpg', 'png','gif',"mp3"],//接收的文件后缀,
        maxFileCount: 100,
        enctype: 'multipart/form-data',
        showUpload: true, //是否显示上传按钮
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: 100,
        showPreview: true,
    });
</script>
</body>
</html>

