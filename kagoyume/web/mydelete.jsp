<%@page import="jums.UserDataDTO"
        import="java.util.ArrayList"
        import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("udd");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <form action="MyDeleteResult" method="POST">
            <h2>削除確認画面</h2><br>
            名前：<br>
            <%=udd.getName()%>
            <br><br>
            パスワード：<br>
            <%=udd.getPassWord()%>
            <br><br>
            メールアドレス：<br>
            <%=udd.getMail()%>
            <br><br>
            住所：
            <br>
            <%=udd.getAddress()%>
            <br><br>
            <input type="submit" name="btnSubmit" value="はい"><br><br>
        </form>
            <%--削除確認の画面なので、ログアウトとマイページに戻れるようにしたい--%>
        <%=jh.LoginMode()%>
        <%=jh.top()%>
        <%=jh.cart()%>
    </body>
</html>
