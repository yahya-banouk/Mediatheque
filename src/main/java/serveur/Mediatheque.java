package serveur;


import dao.AdherentUtile;
import dao.DocumentUtile;
import dao.EmpruntUtile;
import dao.KindelUtile;
import model.Abonne;
import model.Emprunt;
import model.Kindel;

import java.io.IOException;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rachad
 */
public class Mediatheque {
    
    // a remplacer par les utiles 
     DocumentUtile documentDAO;
     AdherentUtile adherentDAO;
     KindelUtile kindelDAO;
     EmpruntUtile empruntDAO;
    
    
    public Mediatheque() throws SQLException{
        
          documentDAO= new DocumentUtile() ;
          adherentDAO= new AdherentUtile();
          kindelDAO= new KindelUtile();
          empruntDAO= new EmpruntUtile();
    }
    
    
    //CRUD Kindles
    
    private void ajouterKindle(Kindel k){
        kindelDAO.ajouterKindel(k);
    }
    
  
    
     private void supprimerKindle(Kindel k){
            kindelDAO.supprimerKindel(k);
    }
    
     boolean Emprunter(Kindel k, Abonne A){
        
        if (!k.isEmprunte()){
            Emprunt e= new Emprunt(A.getCode_abonne(),k.getCode_kindle());
            k.setEmprunte(true);
            boolean emprunte=empruntDAO.ajouterEmprunt();// la methode ajouterEmprunt() doit verifier si l'adherent n'a pas deja un autre emprunt en cours
            return emprunte;
        }
      
        return false;
        
    }
    
    boolean rendre(Kindel k, Abonne a){
        if (k.isEmprunte() && empruntExiste(k,a)){
            k.setEmprunte(false);
            return true;
        }
        else
            return false;
    }

    private boolean empruntExiste(Kindel k, Abonne a) {
    // return true s'il y a un emprunt recent realise par l'abonne a avec le kindle k 
    return false;
    }
    
    
    public static void main(String args[]) throws IOException{
        
        //Authentification  ==> BD
        //Demarage en background du serveur de communication avec les Kindels ==> Sockets+Threds 
        ServeurKindels sk= new ServeurKindels();
        sk.start();
        
        ServeurBruit sb= new ServeurBruit();
        sb.start();
        
        ServeurPlaces sp= new ServeurPlaces();
        sp.start();
       
        //Affichage du menu CRUD ==> BD
        //***1- Gestion des Kindels
        //***2- Gestion des Documents
        //***3- Gestion des Adherents
        //***4- Gestion des Emprunts
        //***5- suspondre les kindels temporairement  ==>sk.sleep(xx)
        //***6- Reprendre le serveur des kindels  ==> sk.interrupt() // a ne pas afficher si les serveur  est deja demarre
        //***5- Se Deconnecter
        
        
        
        
        
    }
    
    
}
