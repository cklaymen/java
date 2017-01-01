<%-- 
    Document   : index
    Created on : 2016-12-28, 21:19:05
    Author     : Ryszard
    Version    : 1.0
--%>
<%
   boolean secretKey = false;
   Cookie[] cookies = null;
   // Get an array of Cookies associated with this domain
   cookies = request.getCookies();
   if( cookies != null ){
            String lastVisit = "never";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("secretKey")) {
                    if (cookie.getValue().equals("bumszakalaka")) {
                        secretKey = true;
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                    break;
                }
            }
  }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Christmas Tree</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="secret.css" type="text/css">
    </head>
    <body>
        <%
            if(secretKey) {
                out.println("<div id=\"secret_div\" class=\"secret\">");
            }
        %>
        <h1>Christmas Tree</h1>
        <div>
            <form action="view" method="GET">
                <input type="number" name="width" />
                <input type="number" name="height" />
                <input type="submit" value="print" />
            </form>
            <a href="history">history</a> <a href="secret">secret key</a>
        </div>
        <%
            if(secretKey) {
                out.println("</div>");
                out.println("<div id=\"secret_button\"><button onClick=\"deleteEffect()\">repair it now! :O</button></div>");
                out.println("<script>function deleteEffect() {document.getElementById(\"secret_div\").className = \"\"; document.getElementById(\"secret_button\").className = \"invisib\"}</script>");
            }
        %>
    </body>
</html>

