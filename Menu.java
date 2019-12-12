
package pacman;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Menu {
    
    public void paint(Graphics grafico, JPanel p){
        
        
        try {
            grafico.drawImage(ImageIO.read(new File("Icon/Pacman.png")), 0, 0, p);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
}



