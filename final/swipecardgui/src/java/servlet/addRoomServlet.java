/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datamodel.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ben
 */
public class addRoomServlet extends HttpServlet {

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
            mySwipecard.createTestDataRoom();
            session.setAttribute("swipecard", mySwipecard);
        }
        
        String strRoom = request.getParameter("myRoom");
        String strCode = request.getParameter("code");
        String strState = request.getParameter("roomstate");
        String strMode = request.getParameter("roommode");
        room myroom = room.lecturehall;
        for(room currRoom : room.values())
        {
            if(strRoom.equals(currRoom.toString()))
            {
                myroom = currRoom;
                break;
            }
        }
        
        Integer Rcode = Integer.parseInt(strCode);
        building aBuilding;
        switch(myroom){
            case lecturehall:
                aBuilding = new lecturehall(Rcode, strState, strMode);
                mySwipecard.addNewBuilding(aBuilding);
                break;
            case studentlab:
                aBuilding = new studentlab(Rcode, strState, strMode);
                mySwipecard.addNewBuilding(aBuilding);
                break;
            case staffroom:
                aBuilding = new staffroom(Rcode, strState, strMode);
                mySwipecard.addNewBuilding(aBuilding);
                break;
            case secureroom:
                aBuilding = new secureroom(Rcode, strState, strMode);
                mySwipecard.addNewBuilding(aBuilding);
                break;
            case researchlab:
                aBuilding = new researchlab(Rcode, strState, strMode);
                mySwipecard.addNewBuilding(aBuilding);
                break;
        }
        response.sendRedirect("/swipecardgui/viewroom.jsp");
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
