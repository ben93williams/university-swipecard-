/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;
import java.util.*;
/**
 *
 * @author ben
 */
public class swipecard {
    private ArrayList<person> arlperson = new ArrayList();
    
    private ArrayList<building> arlbuilding = new ArrayList();
    
   
    public void createTestData(){
    
        arlperson = new ArrayList();
        person people;
        
        people = new student(1,"ben", "williams");
        this.addNewPerson(people);
        
        people = new cleaner(2, "sam", "reynolds");
        this.addNewPerson(people);
        
        people = new security(3, "tom", "brady");
        this.addNewPerson(people);
    
    }
    
    public ArrayList<person> getperson(){
        ArrayList<person> arlResult = new ArrayList<>();
        for (person currperson : this.arlperson)
        {
            arlResult.add(currperson);
        }
        return arlResult;
    }
    
    public Boolean addNewPerson(person objnewperson){
        Boolean blnresult = false;
        if(null != objnewperson)
        {
            if (!this.arlperson.contains(objnewperson))
            {
                blnresult = this.arlperson.add(objnewperson);   
            }
        }
        return blnresult;
    }
    
    public Boolean deletePerson(person objoldperson){
        Boolean blnResult = false;
        if (null != objoldperson)
        {
            if (this.arlperson.size() > 0)
            {
                blnResult = this.arlperson.remove(objoldperson);
            }
        }
        return blnResult;
    }
    
    public Boolean removePersonAt (int index)
    {
        Boolean blnResult = false;
        if(index < arlperson.size() && index >= 0)
        {
            arlperson.remove(arlperson.get(index));
            blnResult = true;
        }
        return blnResult;
    }
    
    
    
    
    
 
   
    public void createTestDataRoom(){
    
        arlbuilding = new ArrayList();
        building campus;
        
        campus = new staffroom(406,"busy", "normal");
        this.addNewBuilding(campus);
        
        campus = new lecturehall(207, "available", "normal");
        this.addNewBuilding(campus);
        
        campus = new studentlab(108, "reserved", "emergency");
        this.addNewBuilding(campus);
    
    }
    
    public ArrayList<building> getbuilding(){
        ArrayList<building> arlResult = new ArrayList<>();
        for (building currbuilding : this.arlbuilding)
        {
            arlResult.add(currbuilding);
        }
        return arlResult;
    }
    
    public Boolean addNewBuilding(building objnewbuilding){
        Boolean blnresult = false;
        if(null != objnewbuilding)
        {
            if (!this.arlbuilding.contains(objnewbuilding))
            {
                blnresult = this.arlbuilding.add(objnewbuilding);   
            }
        }
        return blnresult;
    }
    
    public Boolean deleteBuilding(building objoldbuilding){
        Boolean blnResult = false;
        if (null != objoldbuilding)
        {
            if (this.arlbuilding.size() > 0)
            {
                blnResult = this.arlbuilding.remove(objoldbuilding);
            }
        }
        return blnResult;
    }
    
    public Boolean removeBuildingAt (int index)
    {
        Boolean blnResult = false;
        if(index < arlbuilding.size() && index >= 0)
        {
            arlbuilding.remove(arlbuilding.get(index));
            blnResult = true;
        }
        return blnResult;
    }
    
}
