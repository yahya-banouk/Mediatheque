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
public class Professeur extends Abonne {
    
    private String cnss;
    
    public Professeur(String nom, String prenom, String cin, String cnss) {
        super(nom, prenom, cin);
        this.cnss=new String(cnss);
    }
    
}
