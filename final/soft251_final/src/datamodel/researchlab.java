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
public class researchlab extends building{
     @Override
    public room getRoom(){
        return room.researchlab;
    }
    
    public researchlab(int code, String Rstate, String Rmode )
    {
        super(code, Rstate, Rmode);
    }
}
