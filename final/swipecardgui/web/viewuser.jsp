<%-- 
    Document   : viewuser
    Created on : 20-Jan-2017, 20:40:43
    Author     : ben
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datamodel.*"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/loadDataModelSegment.jspf" %>
    <head>
                <link rel="stylesheet" type="text/css" href="comp.css">
        <link rel="shortcut icon" href="favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view user</title>
    </head>
    <body>
        <div>
            <table>
                <tr>
                    <td>id</td>
                    <td>forename</td>
                    <td>surname</td>
                    <td>role</td>
                    <td>actions</td>
                </tr>
                    <% 
                        Integer index;
                        index = 0;
                        for(person currperson : mySwipecard.getperson())
                        {
                            out.println("<tr>");
                            
                            out.println("<td>");
                            out.println(currperson.getPersonid());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(currperson.getForename());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(currperson.getSurname());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(currperson.getrole());
                            out.println("</td>");
                            
                            out.println("<td>");
                    %>
                    <form method="post" action="processpersonactionservlet">
                        <input type="image" name="action" value="EDIT" src="/swipecardgui/images/edit.png" title="edit item">
                        <input type="image" name="action" value="DELETE" src="/swipecardgui/images/delete.jpg" title="delete item">
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
            <a href="index.html" id="lm">main menu</a>
        </div>
    </body>
</html>
