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
public class Etudiant extends Abonne {
    
    private String cne;
    
    public Etudiant(String nom, String prenom, String cin, String cne) {
        super(nom, prenom, cin);
        this.cne= new String(cne);
    }
    
}
