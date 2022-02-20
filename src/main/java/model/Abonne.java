/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author rachad
 */
public abstract class Abonne extends User {
    private String code_abonne;
    private Date date_abonnement;
    private LinkedList<Document> favoris;
    private LinkedList<Document> tbr;
    
    
    String genererCode(){
        // generer un code avec random
      return null;
    }
    public Abonne(String nom, String prenom, String cin) {
        super(nom, prenom, cin);
        code_abonne=genererCode();
        favoris= new LinkedList<Document>();
        tbr= new LinkedList<Document>();
    }

    public String getCode() {
        return code_abonne;
    }

    public String getCode_abonne() {
        return code_abonne;
    }

    public Date getDate_abonnement() {
        return date_abonnement;
    }

    public LinkedList<Document> getFavoris() {
        return favoris;
    }

    public LinkedList<Document> getTbr() {
        return tbr;
    }
    
    public String toString(){
        return "Abonne: "+code_abonne+" Nom:"+this.getNom()+".......";
    }
    
    
   
    
  
    
}
