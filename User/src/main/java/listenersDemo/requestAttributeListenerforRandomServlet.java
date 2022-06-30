package listenersDemo;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class requestAttributeListenerforRandomServlet implements ServletRequestListener, ServletRequestAttributeListener {

    
    public requestAttributeListenerforRandomServlet() {
        
    }
	
    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("Request Destroyed.."+sre.getSource());
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         System.out.println("request attribute removed..."+srae.getName()+"-"+srae.getValue()+" from "+srae.getSource());
    }
	
    public void requestInitialized(ServletRequestEvent sre)  { 
         System.out.println("Request Initialized..."+sre.getSource());
    }
	
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         System.out.println("request attribute added..."+srae.getName()+"-"+srae.getValue()+" from "+srae.getSource());
    }
	
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("request attribute replaced.."+srae.getName()+"-"+srae.getValue()+" from "+srae.getSource());
    }
	
}
