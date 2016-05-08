<%-- 
    Document   : DBouyou
    Created on : 2016/05/08, 15:52:57
    Author     : kotaroh
--%>

<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
      String name="";
      String sex="";
      String fun="";

      File ReadName = new File("C:\\Users\\kotaroh\\Downloads\\DBouyouName.txt");
      if (ReadName.exists()){
           FileReader Nreader = new FileReader(ReadName);
            BufferedReader brN=new BufferedReader(Nreader);
              name = brN.readLine();
                brN.close();
      }
      
      
      File ReadSex = new File("C:\\Users\\kotaroh\\Downloads\\DBouyouSex.txt");
      if (ReadSex.exists()){
          FileReader Sreader = new FileReader(ReadSex);
           BufferedReader brS=new BufferedReader(Sreader);
            sex = brS.readLine();
              brS.close();
        }
      
      String Male = "";
      String Female = "";
      
      if(sex.equals("男")){
              Male = "checked";}
      if(sex.equals("女")){
              Female = "checked";}

      File ReadFun = new File("C:\\Users\\kotaroh\\Downloads\\DBouyouFun.txt");
      if (ReadFun.exists()){
           FileReader Freader = new FileReader(ReadFun);
            BufferedReader brF=new BufferedReader(Freader);
              fun = brF.readLine();
                brF.close();
      }
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Javaでのデータ操作.応用課題</title>
    </head>
    <body>
        <h1>Javaでのデータ操作.応用課題</h1>
              <form id="入力" action="http://localhost:8080/DB-sousa/DBouyou" method="post">
                  名前:<input type="text" name="txtName" value="<%= name %>"><br><br>
      性別:
      男:<input type="radio" name="rdoSex" value="男" <%= Male %>>
      女:<input type="radio" name="rdoSex" value="女" <%= Female %>><br><br>
      趣味:<br><textarea name="txtFun" rows="4" cols="30" ><%= fun %></textarea><br>
      <input type="submit" value="送信">
    </form>
    </body>
</html>
