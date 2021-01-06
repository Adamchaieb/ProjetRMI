import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ProxyLampe extends UnicastRemoteObject implements LampeItf {
    
    private Lampe l = new Lampe();
    
    public ProxyLampe() throws RemoteException{
        super();
    }
    
       public ProxyLampe(Lampe l1) throws RemoteException{
        super();
        this.l = l1;
    }
    
    public void allumer() throws RemoteException{
        l.allumer();
    }
    
    public void eteindre() throws RemoteException{
        l.eteindre();
    }
}

