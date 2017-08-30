package service;

import entities.Person;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Riko
 */
@WebService
public class Parking {
    
    Implementer impl = new Implementer();
    
    @WebMethod
    public List<String> getPersons(){
        return impl.getPersonsImpl();
    }
    
    public List<Person> getPersonsTest(){
        return impl.getPersonTest();
    }

    public String addPerson(String l_name, String m_name, String name, String address, String doc, String org, long phone){
        return impl.addPersonImpl(l_name, m_name, name, address, doc, org, phone);
    }
    
    public List<String> getLots(){
        return impl.getLotsImpl();
    }
    
    public String addLot(int lnum, int type){
        return impl.addLotImpl(lnum, type);
    }
    
    public List<String> AddrTest(){
        return impl.getAddr();
    }

}
