/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Kindel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author rachad
 */
public class KindelUtile {
    
    private Connection con;
    
    public KindelUtile() throws SQLException{
            
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque ","root","2020-2021");
    }
    
    
    public Kindel getKindelByMac(String mac){
        return null;
    }
    
    public Kindel getKindelByCode(String code){
         return null;
    }
    
    public LinkedList<Kindel> getAllKindels(){
         return null;
    }
    
    public boolean ajouterKindel(Kindel k){
         return true;
    }
   
    public boolean supprimerKindel(Kindel k){
         return true;
    }
    
}
