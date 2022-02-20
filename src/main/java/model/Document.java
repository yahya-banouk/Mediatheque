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
public class Document {
    
    private String titre;
    private String isbn;
    private String edition;
    private String editeur;
    private String auteur;

    public Document(String titre, String isbn, String edition, String editeur, String auteur) {
        this.titre = new String(titre);
        this.isbn = new String(isbn);
        this.edition = new String(edition);
        this.editeur = new String(editeur);
        this.auteur = new String(auteur);
    }

    public String getTitre() {
        return titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEdition() {
        return edition;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getAuteur() {
        return auteur;
    }
    
    
    
    
    
}
