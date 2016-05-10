<%-- 
    Document   : JavaToDBkadai8
    Created on : 2016/05/09, 13:49:46
    Author     : kotaroh
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaToDBkadai8</title>
    </head>
    <body>
        <h1>JavaToDBkadai8</h1>
               <form action="http://localhost:8080/JavaToDB/JavaToDBkadai8" method="post">
                   名前の一部を入力してください
                   入力しなかった場合、すべて表示されます<br>
                   <input type="text" name="txtName" ><br>
                   <input type="submit" value="検索">
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
