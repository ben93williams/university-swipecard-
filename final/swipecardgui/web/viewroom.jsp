<%-- 
    Document   : viewroom
    Created on : 22-Jan-2017, 17:12:05
    Author     : bwilliams4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datamodel.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/loadDataModelSegment.jspf" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="comp.css">
        <title>view room</title>
    </head>
    <body>
        <div>
            <table>
                <tr>
                    <td>room code</td>
                    <td>room state</td>
                    <td>room mode</td>
                    <td>building</td>
                    <td>actions</td>
                </tr>
                    <%
                        Integer index;
                        index = 0;
                        for(building currBuilding : mySwipecard.getbuilding())
                        {
                            out.println("<tr>");
                            
                            out.println("<td>");
                            out.println(currBuilding.getRoomCode());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(currBuilding.getRoomState());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(currBuilding.getRoomMode());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(currBuilding.getRoom());
                            out.println("</td>");
                            
                            out.println("<td>");
                        
                    %>
                    <form method="post" action="processBuildingActionServlet">
                        <input type="image" name="action" value="EDITROOM" src="/swipecardgui/images/edit.png" title="edit item">
                        <input type="image" name="action" value="DELETEROOM" src="/swipecardgui/images/delete.jpg" title="delete item">
                        <input hidden="true" name="index" value=
                               <%
                                   out.println("\"" + index.toString() + "\"");
                               %>
                               >                      
                    </form>    
                    <%
                        index++;
                        out.println("</td>");
                        out.println("</tr>");
                        }
                    %>           
            </table>
        </div>
            <div>
                <a href="index.html">main menu</a>
            </div>
    </body>
</html>
