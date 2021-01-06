

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LampeItf extends Remote{

    public void allumer() throws RemoteException;
    public void eteindre() throws RemoteException;
    
}
   