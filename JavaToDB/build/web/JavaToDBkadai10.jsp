<%-- 
    Document   : JavaToDBkadai10
    Created on : 2016/05/09, 14:11:22
    Author     : kotaroh
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaToDBkadai9</title>
    </head>
    <body>
        <h1>JavaToDBkadai9</h1>
               <form action="http://localhost:8080/JavaToDB/JavaToDBkadai10" method="post">
                   入力されたIDを削除します<br>
                   同じIDがあった場合すべて削除します<br>
                   ID<br><input type="text" name="txtID"  required><br>
                   <input type="submit" value="削除">
               </form>  
    </body>
    <%
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","Ohguchi","0086");
            
            db_st = db_con.prepareStatement("select *from  profiles");
           
            db_data = db_st.executeQuery();
            out.println("現在の入力済みデータ"+"<br>");
            while(db_data.next()){
               out.println("IDは"+db_data.getString("profileID")+"<br>");
               out.println("名前は"+db_data.getString("name")+"<br>");
               out.println("電話番号は"+db_data.getString("tell")+"<br>");
               out.println("年齢は"+db_data.getString("age")+"<br>");
               out.println("誕生日は"+db_data.getString("birthday")+"<br>");
               out.println("<br>");
            }
            %>
</html>
