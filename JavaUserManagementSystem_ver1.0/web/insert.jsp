<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<% request.setCharacterEncoding("UTF-8");//課題4データが戻ってきたとき用のエンコード処理
   session = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <%  
        String name="";//課題4 セッションから
         if ( session.getAttribute("name") != null)
             {
                name = (String)session.getAttribute("name") ;
             }
        String On = "";//生年月日入力時に初期値を設定するが、「選択しない」という初期値をここで宣言しておく
        String year = "";
         if ( session.getAttribute("year") != null)
            {   
                year = (String)session.getAttribute("year") ;
            } 
        String month = "";
         if ( session.getAttribute("month") != null)
            {   
                month = (String)session.getAttribute("month") ;
            } 
        String day = "";
         if ( session.getAttribute("day") != null)
            {   
                day = (String)session.getAttribute("day") ;
            } 
           String type1 = "";
           String type2 = "";
           String type3 = "";
           String a=(String)session.getAttribute("type");
           if("1".equals(a))
                {
                    type1 = "checked";
                }
            if("2".equals(a))
                {
                    type2 = "checked";
                }
            if("3".equals(a))
                {
                    type3 = "checked";
                }
        String tell = "";
         if ( session.getAttribute("tell") != null)
            {   
               tell = (String)session.getAttribute("tell") ;
            } 
        String comment = "";
         if ( session.getAttribute("comment") != null)
            {   
                comment = (String)session.getAttribute("comment");
            }
            //課題4それぞれに初期値となる変数をを設定
           //この後変数が変化したりしなかったりする
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
        
        <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>


    </body>
</html>
