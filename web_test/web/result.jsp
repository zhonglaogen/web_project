<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 18-12-23
  Time: 下午1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery.js"></script>
    <script>

        $(document).ready(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/result",
                type: "POST",
                success: function (data) {
                    var html="";
                    var obj=eval('('+data+')');
                   // $.each(obj,function (index,values) {//解析出obj对应的Object数组
                        $.each(obj,function (index2,value) {//index2表示第几个对象，value表示每个对象的值--第一个对象为json数组对象
                            html += "<p>" + value.id + "---->" + value.age + "---->" + value.name + "</p>"
                        })
                    //})

                    $("#data").html(html);
                    // $("#data").text(html);//输出的是“”的纯字符串
                }
            })


        })


    </script>
</head>
<body>
<div id="data">

</div>
</body>
</html>
