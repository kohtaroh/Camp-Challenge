<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.kadai7Bean" %>
<%//
   response.setContentType("text/html;charset=UTF-8");
   request.setCharacterEncoding("UTF-8");//課題4データが戻ってきたとき用のエンコード処理
   kadai7Bean k = (kadai7Bean)session.getAttribute("kadai7Bean");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% 
        /*    k.getName()System.out.print(k.getName());
        if(!request.getParameter("name").equals("")&&!request.getParameter("year").equals("")&&
          !request.getParameter("month").equals("")&&!request.getParameter("day").equals("")&&
          request.getParameter("type")!=null&&!request.getParameter("tell").equals("")&&
          !request.getParameter("comment").equals("")){ */
    //課題3「hs.getAttribute」では情報を文字そのままで受け取れないため修正。
    //また、If文に「name」のみだったため、全ての要素を追加。全てに情報がある時に登録が可能になる
    //「type」だが、ラジオボタンが未入力の場合は「null」が与えられるため条件が他と違う    
      /*   if(
                 !"".equals(session.getAttribute("year"))
            &&!"".equals(session.getAttribute("month"))&&!"".equals(session.getAttribute("day"))
            &&session.getAttribute("type")!=null&&!"".equals(session.getAttribute("tell"))
            &&!"".equals(session.getAttribute("comment"))){*/
            if("true".equals(session.getAttribute("check"))){
            //InsertConfirmで作成したsessionを使用
    %>
      <h1>登録確認</h1>
           名前:<%=k.getName()%><br>
        生年月日:<%=k.getYear()%>+"年"+
                <%=k.getMonth()%>+"月"+
                <%=k.getDay()%>+"日"<br>
        種別:<%=k.getType()%><br>
        電話番号:<%=k.getTell()%><br>
        自己紹介:<%=k.getComment()%><br>
        上記の内容で登録します。よろしいですか？ 
        <form action="insertresult" method="POST">
         <input type="hidden" name="result"  value="<%= session.getAttribute("result")%>">
         <%//課題2insertを参考に作成%>
         <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        以下の情報を追加してください
   <%    if("".equals(k.getName()))
          {%>  <br>名前              <%}
         if("".equals(k.getYear())||"".equals(k.getMonth())||"".equals(k.getDay()))
          {%>  <br>生年月日             <%}
         if(null==k.getType())
          {%>  <br>種別              <%}
         if("".equals(k.getTell()))
          {%>  <br>電話番号              <%}
         if("".equals(k.getComment()))
          {%>  <br>自己紹介              <%}     
     //課題7get.「」()を使用したif文に変更
     
     
     
     
     
     
 //下記の{}の中に%><%//でそれぞれのif分に応じて足りない日本語が入る    
 //    if("".equals(session.getAttribute("name"))||null==session.getAttribute("name"))
 //    {}
 //         if("".equals(session.getAttribute("year"))||null==session.getAttribute("year")
 //           ||"".equals(session.getAttribute("month"))||null==session.getAttribute("month")
 //           ||"".equals(session.getAttribute("day"))||null==session.getAttribute("day"))
 //    {}
 //         if(null==session.getAttribute("type")) 
 //    {}
 //         if("".equals(session.getAttribute("tell"))||null==session.getAttribute("tell"))
 //    {}
 //         if("".equals(session.getAttribute("comment"))||null==session.getAttribute("comment"))
 //    {}
 //課題3 それぞれが未入力の場合に対応したメッセージを表示する
   //こちらの「type」もだが、ラジオボタンが未入力の場合は「null」が与えられるため条件が他と違う
}%>

        <form action="insert.jsp" method="POST">
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
