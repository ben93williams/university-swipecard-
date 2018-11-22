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
 * @author ben
 */
public class ProcessBuildingEditServlet extends HttpServlet {

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
        
        building buildingToEdit = (building) session.getAttribute("editbuilding");
        if(buildingToEdit != null)
        {
            String strRoom = request.getParameter("myRoom");
            String strCode = request.getParameter("code");
            String strState = request.getParameter("roomstate");
            String strMode = request.getParameter("roommode");
            
            room myRoom = room.studentlab;
            for (room currRoom : room.values())
            {
                if (strRoom.equals(currRoom.toString()))
                {
                    myRoom = currRoom;
                    break;
                }
            }
            int Rcode = Integer.parseInt(strCode);
              
            if(myRoom.equals(buildingToEdit.getRoom()))
            {
                buildingToEdit.setRoomCode(Rcode);
                buildingToEdit.setRoomState(strState);
                buildingToEdit.setRoomMode(strMode);
            }else{
                building newbuilding;
                switch(myRoom)
                {
                    case staffroom:
                        newbuilding = new staffroom(Rcode, strState, strMode);
                        break;
                    case secureroom:
                        newbuilding = new secureroom(Rcode, strState, strMode);
                        break;
                    case studentlab:
                        newbuilding = new studentlab(Rcode, strState, strMode);
                        break;
                    case lecturehall:
                        newbuilding = new lecturehall(Rcode, strState, strMode);
                        break;
                    default:
                        newbuilding = new researchlab(Rcode, strState, strMode);
                        break;
                }
                mySwipecard.deleteBuilding(buildingToEdit);
                mySwipecard.addNewBuilding(newbuilding);
            }
            session.removeAttribute("editbuilding");
            response.sendRedirect("/swipecardgui/viewroom.jsp");
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
