import java.util.EventObject;

public class InterrupteurEvent extends EventObject {
    private boolean newStatus;

    public boolean getEtat(){
        return newStatus;    
    }
    
    public void setEtat(boolean a){
        this.newStatus = a;
    }
       public InterrupteurEvent(boolean source) {
        super(source);
        this.setEtat(source);
    }
}
