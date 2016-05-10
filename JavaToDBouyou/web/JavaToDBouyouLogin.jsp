<%-- 
    Document   : JavaToDBouyouLogin
    Created on : 2016/05/10, 13:07:30
    Author     : kotaroh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaToDBouyouLogin</title>
    </head>
    <body>
        <h1>ログインページ</h1>
               <form action="http://localhost:8080/JavaToDBouyou/JavaToDBouyouLoginHandan" method="post">
                  Ohguchi<br>0086<br>
                   名前<br><input type="text" name="txtName" required><br>
                   パスワード<br><input type="text" name="txtPassWord" required><br>
                  <input type="submit" value="ログイン">
               </form>           
    </body>
</html>
