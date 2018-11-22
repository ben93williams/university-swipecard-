/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datamodel.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ben
 */
public class adduserservlet extends HttpServlet {

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
        
        swipecard mySwipecard;
        HttpSession session = request.getSession();
        mySwipecard = (swipecard) session.getAttribute("swipecard");
        if(null == mySwipecard)
        {
            mySwipecard = new swipecard();
            mySwipecard.createTestData();
            session.setAttribute("swipecard", mySwipecard);
        }
        
        String strRole = request.getParameter("myrole");
        String strId = request.getParameter("personid");
        String strFname = request.getParameter("forename");
        String strSname = request.getParameter("surname");
        role myrole = role.student;
        for(role currRole : role.values())
        {
            if(strRole.equals(currRole.toString()))
            {
                myrole = currRole;
                break;
            }
        }
        
        Integer id = Integer.parseInt(strId);    
        person aPerson;
        switch(myrole){
            case student:
                aPerson = new student(id, strFname, strSname);
                mySwipecard.addNewPerson(aPerson);
                break;
            case cleaner:
                aPerson = new cleaner(id, strFname, strSname);
                mySwipecard.addNewPerson(aPerson);
                break;
            case staff:
                aPerson = new staff(id, strFname, strSname);
                mySwipecard.addNewPerson(aPerson);
                break;
            case security:
                aPerson = new security(id, strFname, strSname);
                mySwipecard.addNewPerson(aPerson);
                break;
            case guest:
                aPerson = new guest(id, strFname, strSname);
                mySwipecard.addNewPerson(aPerson);
                break;
            case esponder:
                aPerson = new esponder(id, strFname, strSname);
                mySwipecard.addNewPerson(aPerson);
                break;
        }        
        response.sendRedirect("/swipecardgui/viewuser.jsp");     
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
