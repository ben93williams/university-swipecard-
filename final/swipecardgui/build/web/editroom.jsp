<%-- 
    Document   : editroom
    Created on : 23-Jan-2017, 04:43:31
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datamodel.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit room</title>
                <link rel="stylesheet" type="text/css" href="comp.css">
    </head>
    <body>
        <%
            building buildingToEdit = (building) session.getAttribute("editbuilding");
            if (null != buildingToEdit)
            {
                String strCode = "value=\"" + buildingToEdit.getRoomCode()+ "\"";
                String strState = "value=\"" + buildingToEdit.getRoomState()+ "\"";
                String strMode = "value=\"" + buildingToEdit.getRoomMode()+ "\"";
        %>
        
            <form method="post" action="ProcessBuildingEditServlet">
                <p>user type: <select name="myRoom">
                        <%
                            for (room currRoom : room.values())
                            {
                                String Room = currRoom.toString();
                                String html = "<option value=\"" + Room + "\">" + Room + "</option>";
                                if(currRoom.equals(buildingToEdit.getRoom()))
                                {
                                    html = "<option selected value=\"" + Room + "\">" + Room + "</option>";
                                }
                                out.println(html);
                            }
                        %>
                </select></p>
                <p>room code: <input type="text" name="code" <% out.println(strCode);%>></p>
                <p>room state: <input type="text" name="roomstate" <% out.println(strState);%>></p>
                <p>room mode: <input type="text" name="roommode" <% out.println(strMode);%>></p>
                <p><button type="submit" name="action" value="PERFORMEDIT">save changes</button> <button type="submit" name="action" value="CANCELEDIT">cancel</button></p>
            </form>
        
                <%
                    }else{
                    response.sendRedirect("ProcessBuildingEditServlet");
                    }
                %>
    </body>
</html>
