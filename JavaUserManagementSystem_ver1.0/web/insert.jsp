<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<% request.setCharacterEncoding("UTF-8");//課題4データが戻ってきたとき用のエンコード処理
   HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <%
           String name = "";
           String On = "";
           String year = "";
           String month = "";
           String day = "";
           String type1 = "";
           String type2 = "";
           String type3 = "";
           String tell = "";
           String comment = "";
           String submit = "";
           //課題4それぞれに初期値となる変数をを設定
           //この後変数が変化したりしなかったりする
            
        if("登録画面に戻る".equals(request.getParameter("no")))
        {//課題4画面に戻ってきたときに「hidden」で送り返されてきたパラメータを挿入
         //データが空の場合は""が入るため問題なく起動する
           name = request.getParameter("name");
           year = request.getParameter("year");
           month = request.getParameter("month");
           day = request.getParameter("day");
           tell = request.getParameter("tell");
           comment = request.getParameter("comment");

           if(request.getParameter("type").length()>0)
           {//課題4ラジオボタンが押されていた場合にどれか一つを初期値としてくれる
                if("1".equals(request.getParameter("type")))
                 {
                    type1 = "checked";
                 }
                if("2".equals(request.getParameter("type")))
                  {
                    type2 = "checked";
                  }
                if("3".equals(request.getParameter("type")))
                  {
                     type3 = "checked";
                  }
           }
        }
    %>    

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%= name %>">
        <br><br>
        生年月日:　
        <select name="year" >
            <option value="" >----</option>
            <%//課題4「year」「month」「day」の三種類にそれぞれ初期値を設定する処理
              //空の場合に「""」が挿入されると何もしないため、希望の箇所にだけ
              //初期値となる「selected」を、その他の場所に「""」を追加する
            for(int i=1950; i<=2010; i++){
                if(year.equals(String.valueOf(i)))
                    {
                        On ="selected";
                    }
                else
                    {
                        On = "";
                    }%>
                    <option value="<%=i%>" <%=On%>> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month" >
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ 
                if(month.equals(String.valueOf(i)))
                    {
                        On ="selected";
                    }
                else
                    {
                        On = "";
                    }%>
            <option value="<%=i%>" <%=On%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ 
                if(day.equals(String.valueOf(i)))
                    {
                        On ="selected";
                    }
                else
                    {
                        On = "";
                    }%>
            <option value="<%=i%>"<%=On%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <%= type1 %>>エンジニア<br>
        <input type="radio" name="type" value="2" <%= type2 %>>営業<br>
        <input type="radio" name="type" value="3" <%= type3 %>>その他<br>
        <%//課題3設定されていたエンジニアのcheckedを削除%>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= tell %>" >
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ><%= comment %></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>


    </body>
</html>
