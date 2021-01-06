import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;

import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  

public class Lampe extends Canvas implements LampeItf {
    
    private Image off;
    private Image on;
    private boolean etat ;
    
    
       public Lampe(){
        this.etat=false;
        this.repaint();
        this.setSize(154,183);
     off = new ImageIcon(this.getClass().getResource("off.png")).getImage();
     on = new ImageIcon(this.getClass().getResource("on.png")).getImage();
       
    }
    
    public void allumer() throws RemoteException{
        this.etat=true;
        repaint();
          
    }
    public void eteindre()throws RemoteException{
            this.etat=false;
            repaint();
        
    }
    
    public void paint(Graphics g){
        if(this.etat==true){
            g.drawImage(on, 0, 0, null);
        }else{
            g.drawImage(off,0,0,null);
        }
    }
    
    public String getOn(){
        return on.toString();
    }
    
    public void setOn(String imageFile){
        this.on = new ImageIcon(imageFile).getImage(); 
    }
}
