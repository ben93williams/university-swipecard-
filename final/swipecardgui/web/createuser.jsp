<%-- 
    Document   : createuser
    Created on : 20-Jan-2017, 20:41:23
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datamodel.*" %>
<!DOCTYPE html>
<html>
    <head>
                <link rel="stylesheet" type="text/css" href="comp.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create user</title>
    </head>
    <body>
        <form method="post" action="adduserservlet">
            pick role: <select name="myrole">
                <%
                    for(role currRole : role.values())
                    {
                        String Role = currRole.toString();
                        String html = "<option value=\"" + Role + "\">" + Role + "</option>";
                        out.println(html);
                    }
                %>
            </select>
            <br>
            input id: <input type="text" name="personid"><br>
            input forename: <input type="text" name="forename"><br>
            input surname: <input type="text" name="surname"><br>
            <input type="submit">
        </form>
        <div>
            <a href="index.html" id="lm">main menu</a>
        </div>
    </body>
</html>
