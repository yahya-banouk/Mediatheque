/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import dao.AdherentUtile;
import dao.DocumentUtile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rachad
 * 
 * Ce Thread sera lancer au demarage du systeme pour assurer les
 * communicartions avec les kindles sans interompre les taches de gestion 
 * qui seront relisees par l'admin
 */
public class ServeurKindels extends Thread {
   
    
  public void run(){
     try { 
            ServerSocket sersoc = new ServerSocket(10000);
            while (true)
            {
               Socket soc = sersoc.accept();
               SocketThread st= new SocketThread(soc);
               Thread t= new Thread(st);
               t.start();
            } 

         } 
     catch (IOException ex) {
               Logger.getLogger(ServeurKindels.class.getName()).log(Level.SEVERE, null, ex);
           }
  }
      
   // Classe interne 
   class  SocketThread implements Runnable {
       
    private Socket soc;
    DocumentUtile docDAO;
    AdherentUtile adDAO;
    
    public SocketThread(Socket soc){
         this.soc = soc;
    }
   
    public void run() { 
        OutputStream streamOut=null;
        InputStream streamIn=null;
        
        try {
            streamOut = soc.getOutputStream();
            OutputStreamWriter sortie = new OutputStreamWriter (streamOut) ;
            streamIn  = soc.getInputStream ();
            BufferedReader entree = new BufferedReader (new InputStreamReader (streamIn));
            
            //enchainement a definir selon le protocole en se seravt de 
                //String message = entree.readLine();
                //sortie.write(message) ;
            /**
            * recevoir information d'authentification
            * envoyer decision authentification 
            * attendre une requete de recherche de la part de l'adherent
            * anvoyer le resultat de la requete
            * repeter les deux taches precedents jusqu'a la deconnexion de l'adherent 
            * une fois que l'adherent est deconnecté alors return 
        **/
        } catch (IOException ex) {
            Logger.getLogger(ServeurKindels.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                streamOut.close();
                streamIn.close();
            } catch (IOException ex) {
                Logger.getLogger(ServeurKindels.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            
       

    }
    }

} 
