/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

/**
 *
 * @author ben
 */
public enum role {
    guest,
    staff,
    student,
    security,
    esponder,
    cleaner;
    
    @Override
    public String toString()
    {
        String strResult = "";
        switch (this)
        {
            case guest:
                strResult = "guest";
                break;
            case staff:
                strResult = "staff";
                break;
            case student:
                strResult = "student";
                break;
            case security:
                strResult = "security";
                break;
            case esponder:
                strResult = "emergency responder";
                break;
            case cleaner:
                strResult = "cleaner";
                break;                        
        }
        return strResult;
    }
}
