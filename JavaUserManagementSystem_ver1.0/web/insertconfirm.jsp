<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>

<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        
    <% if(!request.getParameter("name").equals("")&&!request.getParameter("year").equals("")&&
          !request.getParameter("month").equals("")&&!request.getParameter("day").equals("")&&
          request.getParameter("type")!=null&&!request.getParameter("tell").equals("")&&
          !request.getParameter("comment").equals("")){ 
    //課題3「hs.getAttribute」では情報を文字そのままで受け取れないため修正。
    //また、If文に「name」のみだったため、全ての要素を追加。全てに情報がある時に登録が可能になる
    //「type」だが、ラジオボタンが未入力の場合は「null」が与えられるため条件が他と違う
    %>
        <h1>登録確認</h1>
        名前:<%= request.getParameter("name")%><br>
        生年月日:<%= request.getParameter("year")+"年"+request.getParameter("month")+"月"+request.getParameter("day")+"日"%><br>
        種別:<%= request.getParameter("type")%><br>
        電話番号:<%= request.getParameter("tell")%><br>
        自己紹介:<%= request.getParameter("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        以下の情報を追加してください
     <% if(request.getParameter("name").equals(""))
     {%>  <br>名前              <%}
        if(request.getParameter("year").equals("")||request.getParameter("month").equals("")||request.getParameter("day").equals(""))
     {%>  <br>生年月日              <%}
        if(request.getParameter("type")==null)
     {%>  <br>種別            <%}
        if(request.getParameter("tell").equals(""))
     {%>  <br>電話番号              <%}
        if(request.getParameter("comment").equals(""))
     {%>  <br>自己紹介              <%}
//課題3 それぞれが未入力の場合に対応したメッセージを表示する
   //こちらの「type」もだが、ラジオボタンが未入力の場合は「null」が与えられるため条件が他と違う
}%> 

        <form action="insert" method="POST">
            <input type="hidden" name="name" value= "<%= request.getParameter("name") %>" >
            <input type="hidden" name="year" value= "<%= request.getParameter("year") %>" >
            <input type="hidden" name="month" value= "<%= request.getParameter("month") %>" >
            <input type="hidden" name="day" value= "<%= request.getParameter("day") %>" >
            <input type="hidden" name="type" value= "<%= request.getParameter("type") %>" >
            <input type="hidden" name="tell" value= "<%= request.getParameter("tell") %>" >
            <input type="hidden" name="comment" value= "<%= request.getParameter("comment") %>" >
<%//課題4「hidden」によって「insert」から送られてきたデータをそのまま送り返す
//空データの場合は「""」が挿入されるが、「insert」側で処理するようにしている
%>            
            <input type="submit" name="no" value = "登録画面に戻る" >
        </form>
        
        <br><br><%=JumsHelper.getInstance().home()%>
        <br>注意！保存されません！！
        <%
//課題1修正箇所
//JumsHelper()のhome()の戻り値を使用するURLに変更したため
//それを呼び出すだけでいい
        %>
        
    </body>
</html>
