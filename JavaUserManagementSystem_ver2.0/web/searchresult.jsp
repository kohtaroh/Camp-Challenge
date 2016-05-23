<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="jums.UserDataDAO"
        import="java.util.ArrayList" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList udd = (ArrayList)request.getAttribute("resultData");
    //UserDataDAOでsearch結果を入れたArrayListを呼び出す
%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
     <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <tr>
                <%for(int i=0;i<udd.size();i=i+5){ %>
                <td><a href="ResultDetail?id=<%= udd.get(i)%>"><%= udd.get(i+1)%></a></td>
                <td><%= udd.get(i+2)%></td>
                <td><%= jh.exTypeOb(udd.get(i+3))%></td><%//数字ではなく対応の種別で表示したい%>
                <td><%= udd.get(i+4)%></td>
            </tr>
            <% } %>
        </table><br>
    </body>
    <%=jh.home()%>
</html>
