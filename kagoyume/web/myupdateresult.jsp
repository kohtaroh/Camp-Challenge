<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        変更が完了しました<br>
    </body>
    <%--ここに遷移できる時点でログイン状態なので、他ページと違いif文がない--%>
    <%=jh.Logout()%>
    <%=jh.top()%>
    <%=jh.cart()%>
</html>
