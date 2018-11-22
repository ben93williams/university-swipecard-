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
public class guest extends person{
    @Override
    public role getrole(){
        return role.guest;
    }
    
    public guest(int id, String fname, String sname)
    {
        super(id, fname, sname);
    }
}
