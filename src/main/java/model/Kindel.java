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
public class Kindel {
    private String code_kindle;
    private String mac;
    private boolean emprunte;

    public Kindel(String code_kindle, String mac) {
        this.code_kindle = code_kindle;
        this.mac = mac;
        emprunte=false;
    }

    public String getCode_kindle() {
        return code_kindle;
    }

    public String getMac() {
        return mac;
    }

    public boolean isEmprunte() {
        return emprunte;
    }

    public void setEmprunte(boolean emprunte) {
        this.emprunte = emprunte;
    }
    
    
    
    
    
}
