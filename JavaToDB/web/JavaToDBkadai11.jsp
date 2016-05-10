<%-- 
    Document   : JavaToDBkadai11
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
               <form action="http://localhost:8080/JavaToDB/JavaToDBkadai11" method="post">
                   既存のIDを入力するとその他の入力で上書きされます<br>
                   また、入力が行われなかった部分は変更されません<br>
                   名前と電話番号が未入力の場合は「未入力」と<br>
                   年齢は「０」、誕生日は「1900-01-01」と表示されます<br>
                   IDが違う場合は処理が発生しません<br>
                   ID<br><input type="text" name="txtID"  required><br>
                   名前<br><input type="text" name="txtName" ><br>
                   電話番号<br><input type="text" name="txtTell" ><br>
                   年齢:数字<br><input type="text" name="txtAge" ><br>
                   誕生日は「2000-01-01」のように記入すること。<br>
                   それ以外だとエラーが出ます<br>
                   誕生日<br><input type="text" name="txtBirth" ><br><br>
                   <input type="submit" value="変更">
               </form>  
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
    </body>
</html>
