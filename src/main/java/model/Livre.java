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
public class Livre extends Document {
    
    private int nbPages;
    
    public Livre(String titre, String isbn, String edition, String editeur, String auteur, int nbPages) {
        super(titre, isbn, edition, editeur, auteur);
        this.nbPages=nbPages;
    }

    public int getNbPages() {
        return nbPages;
    }
    
    
    
}
