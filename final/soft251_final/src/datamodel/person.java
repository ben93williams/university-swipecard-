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
public abstract class person  {
    
    private int personid;
    private String forename;
    private String surname;

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public person(){}
    
    public person(int id){
        this.personid = id;
    }
    
    public person(int id, String fname){
        this.personid = id;
        this.forename = fname;
        
    }
    
    public person(int id, String fname, String sname){
        this.personid = id;
        this.forename = fname;
        this.surname = sname;
    }
    
    public abstract role getrole();

}
