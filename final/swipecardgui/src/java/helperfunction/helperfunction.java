/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperfunction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import datamodel.*;

/**
 *
 * @author bwilliams4
 */
public class helperfunction {
    
    public static swipecard retrieveswipecard(HttpServletRequest request){
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
        return mySwipecard;
    }
}
