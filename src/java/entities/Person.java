/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author raimb
 */
public class Person {
    
    private int id;
    private String lastName;
    private String midName;
    private String name;
    private String address;
    private String docNumber;
    private String org;
    private long phone;
    
    
    public Person(){

    }
    
    public Person(String name){
        this.name = name;
    }
            
            
    
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
       this.id = id;
    }
    
    
    public void setLastName(String lname){
        this.lastName = lname;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    
    public void setMidName(String mname){
        this.midName = mname;
    }
    
    public String getMidName(){
        return this.midName;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAdress(){
        return this.address;
    }
    
    
    public void setDocNumber(String doc){
        this.docNumber = doc;
    }
    
    public String getDocNumber(){
        return this.docNumber;
    }
    
    
    public void setOrg(String org){
        this.org = org;
    }
    
    public String getOrg(){
        return this.org;
    }
    
    
    public void setPhone(long number){
        this.phone = number;
    }
    
    public long getPhone(){
        return this.phone;
    }
    
    public String toString(){
        return "["+ this.lastName +" | "+ this.midName +" | "+ this.name +" | "+ this.address +" | "+ this.docNumber +" | "+ this.org +" | "+ this.phone +"]\n";
    }
}
