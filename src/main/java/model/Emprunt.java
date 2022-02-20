/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author rachad
 */
public class Emprunt {
    
    private String code_abonne;
    private String code_kindle;
    private Date date_amprunt;
    

    public Emprunt(String code_abonne, String code_kindle) {
        this.code_abonne = code_abonne;
        this.code_kindle = code_kindle;
    }

    public String getCode_abonne() {
        return code_abonne;
    }

    public String getCode_kindle() {
        return code_kindle;
    }

    public Date getDate_amprunt() {
        return date_amprunt;
    }
    
    
    
}
