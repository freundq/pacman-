
package pacman;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Juego extends JPanel{
    
    Menu menu = new Menu();
    Laberinto laberinto = new Laberinto();
    Pacman pacman = new Pacman();
    Fantasmas fantasma1 = new Fantasmas(390,30); //(posicion x, posicion en y)
    Fantasmas fantasma2 = new Fantasmas(390,390);
    boolean iniciarJuego = false;
    AudioClip intermissionSound, startSound;
    
    public Juego(){
        
        intermissionSound = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/intermissionSound.wav"));
        startSound = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/startSound.wav"));
        intermissionSound.play();
        
        //Movimiento con el mouse
        addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent me) {
                //System.out.println(me.getX()+"," + me.getY());
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
                if((me.getX()>180 & me.getX()<300)&(me.getY()>320 & me.getY()<360)){
                    iniciarJuego = true;
                    startSound.play();
                 
                }
                
                if((me.getX()>190 & me.getX()<360)&(me.getY()>380 & me.getY()<410)){
                    iniciarJuego = false;
                    System.exit(0);
                }
                  
            }

            @Override
            public void mouseReleased(MouseEvent me) {    
            }

            @Override
            public void mouseEntered(MouseEvent me) {    
            }

            @Override
            public void mouseExited(MouseEvent me) {    
            } 
        });
        
        //Movimiento de teclado
         addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {       
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_ENTER){
                    iniciarJuego = true;
                    startSound.play();
                }
                pacman.teclapresionar(e);   
            }

            @Override
            public void keyReleased(KeyEvent e) {
               
            }
        });
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics grafico){
        
       if(iniciarJuego == false){
            menu.paint(grafico, this);
            
        }else{
            laberinto.paint(grafico);
            pacman.paint(grafico);
            fantasma1.paint(grafico);
            fantasma2.paint(grafico);
            intermissionSound.stop();
        }
        
    }
    
}
