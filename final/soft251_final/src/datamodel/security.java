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
public class security extends person{
       @Override
    public role getrole(){
        return role.security;
    }
    
    public security(int id, String fname, String sname)
    {
        super(id, fname, sname);
    }
}
