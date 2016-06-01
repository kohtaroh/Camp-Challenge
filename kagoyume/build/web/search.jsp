<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.SearchResultBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<SearchResultBeans> srb = (ArrayList<SearchResultBeans>) request.getAttribute("srb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>search</title>
    </head>
    <body><%--addされたときにここに戻ってくるが、その際に追加したという一文を表示させたい--%>
         <%if (request.getAttribute("add") != null){out.println(request.getAttribute("add"));}%><br><br>
         <div id="wrapper"> <p><table border=1>
                <tr>
                <th>商品名</th>
                <th>値段</th>
                <th>画像</th>
                <th></th>
                </tr>
                <tr>
                    <% for (int i = 0; i < srb.size(); i++) {%>
                    <td width="250"><a href="Item?id=<%= srb.get(i).getCode()%>"><%= srb.get(i).getName()%></td>
                    <td><%= srb.get(i).getPrice()%>円</td>
                    <td><img src="<%= srb.get(i).getImage()%>"></td>
                    <td width="90"><a href="Add?id=<%= srb.get(i).getCode()%>">カートに追加</td>
                </tr>
                <%}%>
                </table></p><!--/ #wrapper--></div> <br>
         <%=jh.top()%>
         <%--ログインの状態がセッションに入っており(LoginCheck.java)それにより表示を分岐させたい--%>
         <% if (session.getAttribute("userID") == null || session.getAttribute("userID").equals("0")) {
              out.print(jh.NotLoginMode());
           } else {out.print(jh.LoginMode());}%>
           <%=jh.cart()%>
    </body>
</html>
