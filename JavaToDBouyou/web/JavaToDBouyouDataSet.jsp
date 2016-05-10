<%-- 
    Document   : JavaToDBouyouDataSet
    Created on : 2016/05/10, 13:08:13
    Author     : kotaroh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaToDBouyouDateSet</title>
    </head>
    <body>
        <h1>商品情報登録機能</h1>
               <form action="http://localhost:8080/JavaToDBouyou/JavaToDBouyouDataGet" method="post">
                       商品情報入力フォームです<br>
                       全ての項目が入力必須となっています<br>
                   ID<input type="text" name="txtID" required><br><br>
                   名前<input type="text" name="txtName" required><br>
                   種類<select name="txtGenre" size="1" required><br><br>
                            <option></option>
                            <option value="肉類">肉類</option>
                            <option value="魚介類">魚介類</option>
                            <option value="青果">青果</option>
                            <option value="飲料">飲料</option>
                            <option value="菓子類">菓子類</option>
                            <option value="酒">酒</option>
                            <option value="雑貨">雑貨</option>
                       </select><br><br>
                   値段<input type="text" name="txtPrice" required><br>
                   原価<input type="text" name="txtCost" required><br>
                   <input type="submit" value="登録">
               </form>  
               <form action="http://localhost:8080/JavaToDBouyou/JavaToDBouyouResults" method="post">
                  <br><br>
                  このボタンを押すと入力フォームが保存されません！！<br>
                  注意！！<br>
                  <input type="submit" value="一覧を見る">
               </form>          
               <form action="http://localhost:8080/JavaToDBouyou/JavaToDBouyouLogin.jsp" method="post">
                  <br><br>
                  <input type="submit" value="ログアウト">
               </form>          
    </body>
</html>
