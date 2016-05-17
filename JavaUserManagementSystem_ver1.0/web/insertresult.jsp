<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.kadai7Bean" %>
<%  session = request.getSession();
    kadai7Bean k = (kadai7Bean)session.getAttribute("kadai7Bean");
        
            String type ="";        
            if("1".equals(k.getType()))
            {
                type = "エンジニア";
            }
            if("2".equals(k.getType()))
            {
                type = "営業";
            }
            if("3".equals(k.getType()))
            {
                type = "その他";
            }//登録確認画面で数字ではなく種別の文字で出したい
            //下記の登録結果を従来のセッションのもの(getAttribute())からjavabeansのものに変更
%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前: <%= k.getName() %><br>
        生年月日: <%= k.getYear()+"年"+k.getMonth()+"月"+k.getDay()+"日"%><br>
        種別: <%= type%><br>
        電話番号: <%= k.getTell()%><br>
        自己紹介: <%= k.getComment()%><br>
        以上の内容で登録しました。<br>
        
        <br><br><%=JumsHelper.getInstance().home()%>
        <% 
//課題1修正箇所
//JumsHelper()のhome()の戻り値を使用するURLに変更したため
//それを呼び出すだけでいい
        %>

    </body>
</html>
