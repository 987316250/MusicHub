 $(document).ready(function () {
        $("#search").click(function () {
         var musicName=$("#in").val();

         if(musicName.length===0||musicName.trim().length===0)
         {
                alert("输入错误无法搜索");
         }
         else
         {
            $("#tb").html("");
              $.ajax({
                            url:"/search/musicName",
                            data:{"musicName":musicName},
                            method:"post",
                            datatype:"json",
                            success:function (data) {
                                var temp=eval('('+data+')');
                                for(var i=0;i<temp.length;++i)
                                {

                                var $td1=$("<td>");
                                $td1.html(temp[i].name.split("-")[0]);
                                 var $td2=$("<td>");
                                   $td2.html(temp[i].singer.name);
                                  var $td3=$("<td>");
                                    $td3.html(temp[i].location);
                                    $td3.attr("style","display:none");
                                   var $td4=$("<td>");
                                     $td4.html(temp[i].category.name);
                                   var $tr=$("<tr>");
                             $tr.append($td1);
                             $tr.append($td2);
                             $tr.append($td3);
                             $tr.append($td4);
                                  $("#tb").append($tr);
                                }
                               if(temp.length===0)
                               {
                                        alert("音乐库里没有该音乐");
                               }
                            }
                        })
         }

    })
        })