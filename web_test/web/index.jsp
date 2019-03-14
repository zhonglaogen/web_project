<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 18-11-9
  Time: 下午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="jquery.js"></script>
    <script>
        $(document).ready(function () {




            $("#submit").on('click', function () {
                // var form = $("#form").serialize();
                var age = $("input[name='age']").val();
                var name = $("input[name='name']").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/demo",
                    data: {age: age, name: name},
                    type: "POST",
                    success: function (data) {
                         console.log(data);
                        alert("ssssssss");
                        window.open("/result.jsp");
                    }
                });



            });












            $("input[name='age']").blur(function () {
                var value = $(this).val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/valid",
                    data: {age: value},
                    type: "POST",
                    success: function (data) {
                        $("#age_error").text(data);
                    }
                });
            });

        });
    </script>
</head>
<body>
<%--<form id="form">--%>
age:<input name="age" type="text"/><label id="age_error" style="color: red"></label>
name:<input name="name" type="text"/><label id="name_error" style="color: red"></label>
<input type="color"/>
<input type="date"/>
<input type="file" style="width: 1000px"/>
<img src="" alt="">
<input type="submit" value="submit" id="submit"/>
<%--<a href="/result.jsp">result</a>--%>
<%--</form>--%>
</body>
</html>
