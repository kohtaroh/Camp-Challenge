<%-- 
    Document   : OhguchiServletJSPrenkeikadaiResult
    Created on : 2016/04/12, 11:02:36
    Author     : kotaroh
--%>

<%@page import="org.mypackage.sample.OhguchiServletJSPrenkeikadaiResultData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            OhguchiServletJSPrenkeikadaiResultData data = (OhguchiServletJSPrenkeikadaiResultData)request.getAttribute("DATA");
            %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (data !=null){
                out.print("<h1>あなたの"+data.getD()+"の運勢は、"+data.getLuck()+"です！</h1>");
            }
          %>
        <h1>Hello World!</h1>
    </body>
</html>
