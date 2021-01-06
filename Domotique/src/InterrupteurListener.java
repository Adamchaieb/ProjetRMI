
import java.awt.event.MouseEvent;
import java.util.EventListener;


public interface InterrupteurListener extends EventListener {
    
       public void etatChange(InterrupteurEvent e);

}
