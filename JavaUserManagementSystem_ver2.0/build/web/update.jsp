<%@page import="jums.JumsHelper" 
        import="jums.UserDataDTO" 
        import="javax.servlet.http.HttpSession" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    UserDataDTO udd = (UserDataDTO) session.getAttribute("update");
//各種初期値の書式はinsertを参考に作成。また、空白で更新させないようにした
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
        <form action="UpdateResult" method="POST">
            名前:
            <input type="text" name="name" value="<%=udd.getName()%>" required>
            <br><br>

            生年月日:　
            <select name="year" required>
                <option value="">----</option>
                <% for (int i = 1950; i <= 2010; i++) {%><!-- 表示用の変換をここでしないためにJumsHelperに作成した-->
                <option value="<%=i%>" <% if (i == jh.exBirth(udd.getBirthday())[0]){out.print("selected = \"selected\"");}%>><%=i%></option>
                <% } %>
            </select>年
            <select name="month" required>
                <option value="">--</option>
                <% for (int i = 1; i <= 12; i++) {%><!-- 表示用の変換をここでしないためにJumsHelperに作成した-->
                <option value="<%=i%>" <% if (i == jh.exBirth(udd.getBirthday())[1]){out.print("selected = \"selected\"");}%>><%=i%></option>
                <% } %>
            </select>月
            <select name="day" required>
                <option value="">--</option>
                <% for (int i = 1; i <= 31; i++) {%><!-- 表示用の変換をここでしないためにJumsHelperに作成した-->
                <option value="<%=i%>"<% if (i == jh.exBirth(udd.getBirthday())[2]){out.print("selected = \"selected\"");}%>><%=i%></option>
                <% } %>
            </select>日
            <br><br>

            種別:
            <br>
            <% for (int i = 1; i <= 3; i++) {%>
            <input type="radio" name="type" value="<%=i%>"<%if (udd.getType() == i){out.print("checked = \"checked\"");}%> required><%=jh.exTypenum(i)%><br>
            <% }%>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%=udd.getTell()%>" required>
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" required><%=udd.getComment()%></textarea><br><br>
            <input type="hidden" name="userID" value="<%=udd.getUserID()%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <form action="ResultDetail" method="POST">
            <input type="hidden" name="id"  value="<%= udd.getUserID()%>">
            <input type="submit" name="NO" value="詳細画面に戻る" style="width:100px">
        </form><br>
        <br>
        <%=jh.home()%>
    </body>
</html>
