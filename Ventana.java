
package pacman;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Ventana {
    
    public Ventana(){
        
        JFrame miventana = new JFrame("Mi primer laberinto");
        Juego game = new Juego();
        miventana.add(game); 
        miventana.setSize(465,485);
        miventana.setLocationRelativeTo(null);
        miventana.setVisible(true);
        miventana.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            miventana.repaint();
        }
        
    }
}
