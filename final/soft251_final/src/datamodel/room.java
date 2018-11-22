/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

/**
 *
 * @author bwilliams4
 */
public enum room {
    lecturehall,
    researchlab,
    secureroom,
    staffroom,
    studentlab;
    
    @Override 
    public String toString()
    {
        String strResult = "";
        switch (this)
        {
            case lecturehall:
                strResult = "lecturehall";
                break;
            case researchlab:
                strResult = "researchlab";
                break;
            case secureroom:
                strResult = "secureroom";
                break;
            case staffroom:
                strResult = "staffroom";
                break;
            case studentlab:
                strResult = "studentlab";
                break;
        }
        return strResult;
    }
}
