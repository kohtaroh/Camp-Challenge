<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.kadai7Bean" %>

<%//<jsp:useBean id="k7" class="jums.kadai7Bean" />
   session = request.getSession();
   kadai7Bean k = (kadai7Bean)session.getAttribute("kadai7");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <%//= k.getName() %>
        <%// <jsp:getProperty name="k7" property="name" />%>
    <%  /*if(!request.getParameter("name").equals("")&&!request.getParameter("year").equals("")&&
          !request.getParameter("month").equals("")&&!request.getParameter("day").equals("")&&
          request.getParameter("type")!=null&&!request.getParameter("tell").equals("")&&
          !request.getParameter("comment").equals("")){ */
    //課題3「hs.getAttribute」では情報を文字そのままで受け取れないため修正。
    //また、If文に「name」のみだったため、全ての要素を追加。全てに情報がある時に登録が可能になる
    //「type」だが、ラジオボタンが未入力の場合は「null」が与えられるため条件が他と違う    
         if(!"".equals(session.getAttribute("name"))&&!"".equals(session.getAttribute("year"))
            &&!"".equals(session.getAttribute("month"))&&!"".equals(session.getAttribute("day"))
            &&session.getAttribute("type")!=null&&!"".equals(session.getAttribute("tell"))
            &&!"".equals(session.getAttribute("comment"))){
    %>
        <h1>登録確認</h1>
        名前:<%= (String)session.getAttribute("name")%><br>
        生年月日:<%= (String)session.getAttribute("year")+"年"+(String)session.getAttribute("month")+"月"+(String)session.getAttribute("day")+"日"%><br>
        種別:<%= (String)session.getAttribute("type")%><br>
        電話番号:<%= (String)session.getAttribute("tell")%><br>
        自己紹介:<%= (String)session.getAttribute("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
         <input type="hidden" name="result"  value="<%= session.getAttribute("result")%>">
         <%//課題2insertを参考に作成%>
         <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        以下の情報を追加してください
        <% if("".equals(session.getAttribute("name")))
     {%>  <br>名前              <%}
        if("".equals(session.getAttribute("year"))||"".equals(session.getAttribute("month"))||"".equals(session.getAttribute("day")))
     {%>  <br>生年月日              <%}
        if(session.getAttribute("type")==null)
     {%>  <br>種別            <%}
        if("".equals(session.getAttribute("tell")))
     {%>  <br>電話番号              <%}
        if("".equals(session.getAttribute("comment")))
     {%>  <br>自己紹介              <%}
//課題3 それぞれが未入力の場合に対応したメッセージを表示する
   //こちらの「type」もだが、ラジオボタンが未入力の場合は「null」が与えられるため条件が他と違う
}%> 

        <form action="insert" method="POST">
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
