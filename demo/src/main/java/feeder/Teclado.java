package feeder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Teclado implements KeyListener{

    private final static int NUMERO_TECLAS = 120;
    private final boolean[] teclas = new boolean[NUMERO_TECLAS];

    public boolean arriba = false;
    public boolean abajo = false;
    public boolean derecha = false;
    public boolean izquierda = false;

    public void actualizar(){
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        derecha = teclas[KeyEvent.VK_D];
        izquierda = teclas[KeyEvent.VK_A];
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if (arg0.getKeyCode()<this.NUMERO_TECLAS) {
            teclas[arg0.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if (arg0.getKeyCode()<this.NUMERO_TECLAS) {
            teclas[arg0.getKeyCode()] = false; 
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
