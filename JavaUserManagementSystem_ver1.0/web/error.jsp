
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = " jums.JumsHelper " %>
<%//課題1 JumpHelperをimport %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        エラーが発生しました。以下の項目を確認してください。<br>
        <%=request.getAttribute("error")%>

        <br><br><%=JumsHelper.getInstance().home()%>
        <%
//課題1修正箇所
//JumsHelper()のhome()の戻り値を使用するURLに変更したため
//それを呼び出すだけでいい
        %>

    </body>

</html>
