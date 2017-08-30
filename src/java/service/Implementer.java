package service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Riko
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/*Custom libraries*/
import entities.Person;


public class Implementer {

/*------------------------------------------------------------------------*/
    
    public ArrayList<String> getPersonsImpl(){
        
        ArrayList<String> x = new ArrayList();
        
        try{
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("parkDataSource");
            Connection con = ds.getConnection();
            
            Statement myStmnt = con.createStatement();
            ResultSet myRs = myStmnt.executeQuery("select * from Persons");
            while(myRs.next()){
                String a = myRs.getString("last_name") + " " + myRs.getString("first_name");
                x.add(a);
            }
            
            con.close();
            myStmnt.close();
            myRs.close();
        }catch(Exception ex){
            x.add(ex.toString());
            return x;
        }
        return x;
    } 
    
/*---------------------------------------------------------------------------------*/
        public String addPersonImpl(String l_name, String m_name, String name, String address, String doc, String org, long phone){
        
            String sql = "INSERT INTO `Persons` (`id`, `last_name`, `middle_name`, "
                    + "`first_name`, `address`, `document_number`, `organisation`, `phone_number`) VALUES"
                    + " (NULL, '"+ l_name +"', '"+ m_name +"', '"+ name +"', '"+ address +"', '"+doc+"', '"+org+"', '"+phone+"');";
        
        try{
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("parkDataSource");
            Connection con = ds.getConnection();
            Statement myStmnt = con.createStatement();
            myStmnt.executeUpdate(sql);
            con.close();
            myStmnt.close();
        }catch(Exception ex){
            return ex.getMessage();
        }
        return "Success!";
    }
/*-----------------------------------------------------------------------------*/
    public List<String> getLotsImpl(){
        
        List<String> table = new ArrayList();
        /*ArrayList<String> x = new ArrayList();
        ArrayList<String> y = new ArrayList();
        x.add("Asdasd");
        x.add("asdasdasdasdad");
        y.add("aPasd");
        y.add("ptasd");
        table.add(x);
        table.add(y);*/
        
        
        try{
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("parkDataSource");
            Connection con = ds.getConnection();
            
            Statement myStmnt = con.createStatement();
            ResultSet myRs = myStmnt.executeQuery("select * from parking_lots");
            ResultSetMetaData meta = myRs.getMetaData();
            int colNum = meta.getColumnCount();
            String cNames = "";
            for(int i=0; i < colNum; i++){
                cNames = cNames + meta.getColumnName(i+1) + " ";
            }
            table.add(cNames);
            while(myRs.next()){
                String a = myRs.getString("id") + " " + myRs.getString("l_number") + " " + myRs.getString("type_id");
                table.add(a);
            }
            con.close();
            myStmnt.close();
            myRs.close();
            
            
        }catch(Exception ex){
            ArrayList<String> exx = new ArrayList();
            exx.add(ex.toString());
            return exx;
        }
        return table;
    }
    
/*------------------------------------------------------------------------------*/
    public String addLotImpl(int lnum, int type){
        
            String sql = "INSERT INTO `parking_lots` (`id`, `l_number`, `type_id`) VALUES (NULL, '" + lnum + "', '"+type+"')";
        
        try{
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("parkDataSource");
            Connection con = ds.getConnection();
            Statement myStmnt = con.createStatement();
            myStmnt.executeUpdate(sql);
            con.close();
            myStmnt.close();
        }catch(Exception ex){
            return ex.getMessage();
        }
        return "Success!";
    }
    
    public ArrayList<Person> getPersonTest(){
        
        ArrayList<Person> persons = new ArrayList();
        
        try{
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("parkDataSource");
            Connection con = ds.getConnection();
            
            Statement myStmnt = con.createStatement();
            ResultSet myRs = myStmnt.executeQuery("select * from Persons");
            while(myRs.next()){
                Person pers = new Person();
                
                
                pers.setLastName(myRs.getString("last_name"));
                pers.setMidName(myRs.getString("middle_name"));
                pers.setName(myRs.getString("first_name"));
                pers.setAddress(myRs.getString("address"));
                pers.setDocNumber(myRs.getString("document_number"));
                pers.setOrg(myRs.getString("organisation"));
                pers.setPhone(Long.parseLong(myRs.getString("phone_number")));
                
                persons.add(pers);
            }
            
            con.close();
            myStmnt.close();
            myRs.close();
        }catch(Exception ex){
            persons.add(new Person("Error!"));
            return persons;
        }
        
        return persons;
    }
    
    
    public List<String> getAddr(){
    
         ArrayList<String> addr = new ArrayList();
        
        try{
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("parkDataSource");
            Connection con = ds.getConnection();
            
            Statement myStmnt = con.createStatement();
            ResultSet myRs = myStmnt.executeQuery("select * from Persons");
            while(myRs.next()){
                Person pers = new Person();
                
                pers.setLastName(myRs.getString("last_name"));
                pers.setMidName(myRs.getString("middle_name"));
                pers.setName(myRs.getString("first_name"));
                pers.setAddress(myRs.getString("address"));
                pers.setDocNumber(myRs.getString("document_number"));
                pers.setOrg(myRs.getString("organisation"));
                pers.setPhone(Long.parseLong(myRs.getString("phone_number")));
                
                addr.add(pers.toString());

            }
            
            con.close();
            myStmnt.close();
            myRs.close();
        }catch(Exception ex){
            addr.add("Error");
            return addr;
        }
        
        return addr;
    
    } 
    
}
