<%-- 
    Document   : JavaToDBkadai12
    Created on : 2016/05/09, 14:11:22
    Author     : kotaroh
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaToDBkadai12</title>
    </head>
    <body>
        <h1>JavaToDBkadai12</h1>
               <form action="http://localhost:8080/JavaToDB/JavaToDBkadai12" method="post">
                   検索フォームです<br>
                   苗字と名前両方を入力する場合は間に半角スペースを入力してください<br>
                   数字は半角でお願いします<br>
                   年齢はどちらの検索でも完全一致でのみ受け付けます<br>
                   誕生日は「2000-01-01」のように記入すること。<br>
                   年、月、日をそれぞれ一つで入力しても検索が可能ですが、<br>
                   --で挟むと月のみの部分検索ができます<br>
                   日のみの部分検索はできません<br>
                   入力後、完全一致または部分一致ボタンを押してください。<br>
                   名前<br><input type="text" name="txtName" ><br>
                   年齢:<br><input type="text" name="txtAge" ><br>
                   誕生日<br><input type="text" name="txtBirth" ><br><br>
                   <input type="submit" value="完全一致" name="AND"><br>
                   <input type="submit" value="部分一致" name="OR">
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
