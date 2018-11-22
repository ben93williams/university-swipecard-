<%-- 
    Document   : edituser
    Created on : 21-Jan-2017, 16:08:03
    Author     : bwilliams4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datamodel.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="comp.css">
        <title>edit user</title>
    </head>
    <body>
        <%
            person personToEdit = (person) session.getAttribute("editperson");
            if (null != personToEdit)
            {
                String strId = "value=\"" + personToEdit.getPersonid() + "\"";
                String strFname = "value=\"" + personToEdit.getForename() + "\"";
                String strSname = "value=\"" + personToEdit.getSurname() + "\"";
        %>
        
            <form method="post" action="ProcessPersonEditServlet">
                <p>user type: <select name="myRole">
                        <%
                            for (role currRole : role.values())
                            {
                                String Role = currRole.toString();
                                String html = "<option value=\"" + Role + "\">" + Role + "</option>";
                                if(currRole.equals(personToEdit.getrole()))
                                {
                                    html = "<option selected value=\"" + Role + "\">" + Role + "</option>";
                                }
                                out.println(html);
                            }
                        %>
                </select></p>
                <p>user id: <input type="text" name="Personid" <% out.println(strId);%>></p>
                <p>forename: <input type="text" name="Forename" <% out.println(strFname);%>></p>
                <p>surname: <input type="text" name="Surname" <% out.println(strSname);%>></p>
                <p><button type="submit" name="action" value="PERFORMEDIT">save changes</button> <button type="submit" name="action" value="CANCELEDIT">cancel</button></p>
            </form>
        
                <%
                    }else{
                    response.sendRedirect("ProcessPersonEditServlet");
                    }
                %>
    </body>
</html>
