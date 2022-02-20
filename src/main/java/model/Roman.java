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
public class Roman extends Document {
    
    private int nbTomes;
    
    public Roman(String titre, String isbn, String edition, String editeur, String auteur, int nbTomes) {
        super(titre, isbn, edition, editeur, auteur);
        this.nbTomes=nbTomes;
        
    }
    
}
