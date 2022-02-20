/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Document;
import model.Livre;
import model.Roman;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author rachad
 */
public class DocumentUtile <T extends Document> {
    
    private Connection con;

    
    public  DocumentUtile () throws SQLException{
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque ","root","2020-2021");
     
    }
    
    
    LinkedList<T> getDocumentByTitre(String titre) throws SQLException{
            
            LinkedList<T> documents= new LinkedList<T>();
        
            Type sooper = getClass().getGenericSuperclass();
            Type t = ((ParameterizedType)sooper).getActualTypeArguments()[0];
            String table="";

            if(t.getTypeName().equals("Livre"))
                table="livre";
            else
                table="roman";


           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("select * from"+ table+" where titre like '"+titre+"' ");
          

        while (rs.next()) {
            T d= null;
            if (table=="livre"){
                d= (T) new Livre(null,null,null,null,null,0);
                // d=(T) new Livre(rs.getString("isbn"),...);
            }
            else{
                d=(T) new Roman(null,null,null,null,null,0);
                //d=new Roman(rs.getString("isbn"),...);
            }
            documents.add(d);
        }  
        return documents;
    }
    
    LinkedList<T> getDocumentByEditeur(){
        return null;
    }
    
    LinkedList<T> getDocumentByEdition(){
        return null;
    }
    
    LinkedList<T> getDocumentByAuteur(){
        return null;
    }
    
    T getDocumentByIsbn(String isbn) throws SQLException{
        Type sooper = getClass().getGenericSuperclass();
        Type t = ((ParameterizedType)sooper).getActualTypeArguments()[0];
        String table="";
        
        if(t.getTypeName().equals("Livre"))
            table="livre";
        else
            table="roman";
        
       
       Statement stmt = con.createStatement();
       ResultSet rs = stmt.executeQuery("select * from"+ table+" where isbn like '"+isbn+"' ");
       T d= null;

    if (rs.next()) {
        if (table=="livre"){
            d=(T) new Livre(null,null,null,null,null,0);
            // d=(T) new Livre(rs.getString("isbn"),...);
        }
        else{
            d=(T) new Roman(null,null,null,null,null,0);
            //d=new Roman(rs.getString("isbn"),...);
        }
    }  
    return d;
        
    }
    
    LinkedList<T> getAllDocuments() throws SQLException{
        
        LinkedList<T> documents= new LinkedList<T>();
        
            Type sooper = getClass().getGenericSuperclass();
            Type t = ((ParameterizedType)sooper).getActualTypeArguments()[0];
            String table="";

            if(t.getTypeName().equals("Livre"))
                table="livre";
            else
                table="roman";


           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("select * from"+ table);
          

        while (rs.next()) {
            T d= null;
            if (table=="livre"){
                d= (T) new Livre(null,null,null,null,null,0);
                // d=(T) new Livre(rs.getString("isbn"),...);
            }
            else{
                d=(T) new Roman(null,null,null,null,null,0);
                //d=new Roman(rs.getString("isbn"),...);
            }
            documents.add(d);
        }  
        return documents;
    }
    
    LinkedList<T> getDocumentByEditeur(String editeur){
        return null;
    }
    
    LinkedList<T> getDocumentByEdition(String edition){
        return null;
    }
    
    LinkedList<T> getDocumentByAuteur(String auteur){
        return null;
    }
    
    boolean ajouterDocument(T d) throws SQLException{
        
    Statement stmt = con.createStatement();
    String query="";
    
    if (d instanceof Livre){
      query=" ";
    }
    else  if (d instanceof Roman){
      query=" ";
    }
    
    int nbUpdated = stmt.executeUpdate(query);
    return nbUpdated>0;
    
        
    }
   
    boolean supprimerDocument(T d){
        return true;
    }
    
}
