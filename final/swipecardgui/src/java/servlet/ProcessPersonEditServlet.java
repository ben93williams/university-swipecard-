/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datamodel.*;
import helperfunction.helperfunction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bwilliams4
 */
public class ProcessPersonEditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        swipecard mySwipecard = helperfunction.retrieveswipecard(request);
        
        person personToEdit = (person) session.getAttribute("editperson");
        if(personToEdit != null)
        {
            String strRole = request.getParameter("myRole");
            String strId = request.getParameter("Personid");
            String strFname = request.getParameter("Forename");
            String strSname = request.getParameter("Surname");
            
            role myRole = role.student;
            for (role currRole : role.values())
            {
                if (strRole.equals(currRole.toString()))
                {
                    myRole = currRole;
                    break;
                }
            }
            int Id = Integer.parseInt(strId);
            
            
            if(myRole.equals(personToEdit.getrole()))
            {
                personToEdit.setPersonid(Id);
                personToEdit.setForename(strFname);
                personToEdit.setSurname(strSname);

            }else{
                person newperson;
                switch(myRole)
                {
                    case staff:
                        newperson = new staff(Id, strFname, strSname);
                        break;
                    case cleaner:
                        newperson = new cleaner(Id, strFname, strSname);
                        break;
                    case security:
                        newperson = new security(Id, strFname, strSname);
                        break;
                    case esponder:
                        newperson = new esponder(Id, strFname, strSname);
                        break;
                    case guest:
                        newperson = new guest(Id, strFname, strSname);
                        break;
                    default:
                        newperson = new student(Id, strFname, strSname);
                        break;
                }
                mySwipecard.deletePerson(personToEdit);
                mySwipecard.addNewPerson(newperson);
            }
            session.removeAttribute("editperson");
            response.sendRedirect("/swipecardgui/viewuser.jsp");
        }else{}
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
