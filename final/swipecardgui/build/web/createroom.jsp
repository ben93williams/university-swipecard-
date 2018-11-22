<%-- 
    Document   : createroom
    Created on : 23-Jan-2017, 02:36:23
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datamodel.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <link rel="stylesheet" type="text/css" href="comp.css">
        <title>create room</title>
    </head>
    <body>
        <form method="post" action="addRoomServlet">
            pick room: <select name="myRoom">
                <%
                    for(room currRoom : room.values())
                    {
                        String Room = currRoom.toString();
                        String html = "<option value=\"" + Room + "\">" + Room + "</option>";
                        out.println(html);
                    }
                %>
            </select>
            <br>
            input code: <input type="text" name="code"><br>
            input room state: <input type="text" name="roomstate"><br>
            input room mode: <input type="text" name="roommode"><br>
            <input type="submit">
        </form>
        <div>
            <a href="index.html" id="lm">main menu</a>
        </div>
    </body>
</html>
