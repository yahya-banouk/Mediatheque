/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rachad
 */
public class User {
    private String nom;
    private String prenom;
    private String cin;
    
    public User(String nom, String prenom, String cin){
        this.nom= new String(nom);
        this.prenom= new String(prenom);
        this.cin = new String(cin);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }
    
    }
   
