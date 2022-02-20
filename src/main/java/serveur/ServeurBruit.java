/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

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
public class ServeurBruit extends Thread {
   
    
  public void run(){
     try { 
            ServerSocket sersoc = new ServerSocket(5000);
            while (true)
            {
               Socket soc = sersoc.accept();
               SocketThread st= new SocketThread(soc);
               Thread t= new Thread(st);
               t.start();
            } 

         } 
     catch (IOException ex) {
               Logger.getLogger(ServeurBruit.class.getName()).log(Level.SEVERE, null, ex);
           }
  }
      
   // Classe interne 
   class  SocketThread implements Runnable {
       
    private Socket soc;
 
    
    public SocketThread(Socket soc){
         this.soc = soc;
    }
   
    public void run() { 
        OutputStream streamOut=null;
        InputStream streamIn=null;
        
        try {
            streamIn  = soc.getInputStream ();
            BufferedReader entree = new BufferedReader (new InputStreamReader (streamIn));
            
            Thread.sleep(10000);
            String data=entree.readLine();
            //Traitement à realiser
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServeurBruit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServeurBruit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                streamOut.close();
                streamIn.close();
            } catch (IOException ex) {
                Logger.getLogger(ServeurBruit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            
       

    }
    }

} 
