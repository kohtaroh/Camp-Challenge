<%@page import="jums.JumsHelper"
        import="javax.servlet.http.HttpSession"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>top</title>
    </head>
    <body>
        <div class="main"><form action="Search" method="GET"><br>
            <h1>このサイトは検索を行え、好きなだけ購入した気分に浸ることができます<br>
            なので、在庫などは気にしなくてもいいのです</h1><br>
            購入確認画面でカートの中身を変更・削除が可能ですが、その場合一つ前のページであるカートに戻ります<br>
            これは、カートでしっかりと確認してから購入確認画面に行ってほしいからです
            <h3>ここは検索フォームです</h3><br><br>
            <%if (request.getAttribute("error") != null){out.println(request.getAttribute("error"));}%><br><br>
            名前:
            <input type="text" name="name" ><br>
            <input type="submit" name="and" value="検索"><br><br>
        </form>
        <%--ログインの状態がセッションに入っており(LoginCheck.java)それにより表示を分岐させたい--%>
     <% if (session.getAttribute("userID") == null || session.getAttribute("userID").equals("0")) {
              out.print(jh.NotLoginMode());
        } else {out.print(jh.LoginMode());}%>
        <%=jh.cart()%></div>
    </body>
</html>
