package feeder.Logic.Configuracion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import feeder.Logic.Personajes.Jugador;

public class ConfiguracionTeclasPersonaje implements KeyListener  {

    private final static int NUMERO_TECLAS = 120;

    private final boolean [] tecladas = new boolean[NUMERO_TECLAS];

    private Jugador avatar;

    private int distancia = 10;

    private boolean avanzar ;
    private boolean retroceder ;
    private boolean arriba ;
    private boolean abajo ;

    public ConfiguracionTeclasPersonaje( Jugador avatar) {
        this.avatar = avatar;
    }
    public void actualizar(){
        avanzar = tecladas[KeyEvent.VK_A];
        retroceder = tecladas[KeyEvent.VK_D];
        arriba = tecladas[KeyEvent.VK_W];
        abajo = tecladas[KeyEvent.VK_S];
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() < this.NUMERO_TECLAS) {
            tecladas[arg0.getKeyCode()] = true;
            System.out.println(arg0.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        if (arg0.getKeyCode() < this.NUMERO_TECLAS) {
            tecladas[arg0.getKeyCode()] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
    public static int getNumeroTeclas() {
        return NUMERO_TECLAS;
    }
    public boolean[] getTecladas() {
        return tecladas;
    }
    public Jugador getAvatar() {
        return avatar;
    }
    public int getDistancia() {
        return distancia;
    }
    public boolean isAvanzar() {
        return avanzar;
    }
    public boolean isRetroceder() {
        return retroceder;
    }
    public boolean isArriba() {
        return arriba;
    }
    public boolean isAbajo() {
        return abajo;
    }
    
}
