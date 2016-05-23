<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報検索画面</title>
    </head>
    <body>
         <form action="SearchResult" method="get">
             <table border=1>
                 <th>部分一致で空白を入力した場合は全件表示されます</th>
             </table><br>
             
             <table border=1>
                 <th>名前:</th>
                <td><input type="text" name="name"></td>
             </table><br>
                
             <table border=1><th>生年:</th>
                <td> <select name="year">
                    <option value="">----</option>
                    <% for(int i=1950; i<=2010; i++){ %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %></select>年生まれ
                </td>
             </table><br>

        <table border=1>
            <th align="center" rowspan="5">種別:</th>
            <% for(int i = 1; i<=3; i++){ %>                 <!-- 表示を数字ではなく文字に変更したい-->
            <tr><td><input type="radio" name="type" value="<%=i%>"><%=jh.exTypenum(i)%></td></tr>
            <% } %>
            <tr><td><input type="radio" name="type" value="0" checked>なし</td></tr>
        </table>
        <br>
        <br>
        <input type="submit" name="and" value="完全一致検索"><br>
        <input type="submit" name="or" value="部分一致検索"><br>
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
