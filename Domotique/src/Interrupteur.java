import java.awt.Canvas;
import java.awt.Graphics;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;


public class Interrupteur extends Canvas {

    private final ArrayList<InterrupteurListener> ls;
    private boolean status;
  
   public Interrupteur(){
       this.ls = new ArrayList(); 
       this.status = false;
       super.setSize(40,0);
   }
       
   
    public boolean getEtat(){
       return this.status;
   }
    
   public void setEtat(boolean a){
       this.status = a;
   }
   
   public void change(){
       this.setEtat(!getEtat());
   }
   
   public void addInterrupteurListener(InterrupteurListener switch1){
       this.ls.add(switch1); 
       
   }
   
   public void removeInterrupteurListener(InterrupteurListener switch1){
       this.ls.remove(switch1);
   }
   
   public void fireInterrupteurEvent(InterrupteurEvent e){
        for (InterrupteurListener l : ls) {
            l.etatChange(e);
        }
   }
      
    @Override
   public void paint(Graphics g){
       g.drawRect(0,0,40,20);
       if(getEtat()){
           g.fillRect(20,0,40,20);
       }else{
           g.fillRect(0,0,20,20);
       }
   }
   
  public void lampeProxyRemote(String lampewindowselected,int serviceport) throws RemoteException     
    {
       try
        {
            Registry register = LocateRegistry.getRegistry("localhost",serviceport);
            LampeItf lampeInterface = (LampeItf) register.lookup(lampewindowselected);
            if(!this.getEtat())
            {
               lampeInterface.eteindre();  
            }else
            {
               lampeInterface.allumer();
            }
        }catch(NotBoundException e)
        {
            System.out.println("Not Bound Exception "+e);
        }
        
    }
}
