<%--
  Created by IntelliJ IDEA.
  User: dkw
  Date: 2017/6/28
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <style>
        th {
            width: 150px;
        }

    </style>
</head>
<body>
<h1>customer config</h1>
<div>

    id:<input name="id" id="id">
    name:<input name="name" id="name">
    </br>
    code:<input name="name" id="code">
    phone:<input name="name" id="phone">
    <button onclick="aa()">search</button>
    <button id="update">update</button>
    <button>create</button>
</div>
<div style="width: 500px;height: 300px">
    <table border="1">
        <tr>
            <th>name</th>
            <th>code</th>
            <th>phone</th>
            <th>operation</th>

        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.code}</td>
                <td>${customer.phone}</td>
                <td>
                    <button onclick="edit('${customer.id}','${customer.name}','${customer.code}','${customer.phone}')">
                        编辑
                    </button>
                    <a href="${BASE}/delete?id=${customer.id}">删除</a>

                </td>

            </tr>

        </c:forEach>
        <tbody id="tb"></tbody>

    </table>
</div>
</body>
<script type="text/javascript" src="/public/js/common/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/public/js/common/httpRequest.js"></script>
<script type="text/javascript">
    $(function () {
        $("#update").click(function () {
            var id = $("#id").val();
            var name = $("#name").val();
            var code = $("#code").val();
            var phone = $("#phone").val();
            post("/edit", {id: id,name:name,code:code,phone:phone})
        });
    });
    function aa() {
        alert($("#tb").html());
    }
    function edit(id, name, code, phone) {
        $("#id").val(id);
        $("#name").val(name);
        $("#code").val(code);
        $("#phone").val(phone);
    }

</script>
</html>
