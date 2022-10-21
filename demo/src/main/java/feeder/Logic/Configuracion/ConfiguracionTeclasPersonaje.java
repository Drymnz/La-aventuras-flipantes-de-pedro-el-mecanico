package feeder.Logic.Configuracion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import feeder.Logic.Personajes.Jugador;

public class ConfiguracionTeclasPersonaje implements KeyListener  {

    private final static int NUMERO_TECLAS = 120;

    private final boolean [] tecladas = new boolean[NUMERO_TECLAS];

    private Jugador avatar;

    private int distancia = 10;

    private boolean tecla_a ;
    private boolean tecla_d ;
    private boolean tecla_w ;
    private boolean tecla_s ;

    public ConfiguracionTeclasPersonaje( Jugador avatar) {
        this.avatar = avatar;
    }
    public void actualizar(){
        tecla_a = tecladas[KeyEvent.VK_A];
        tecla_d = tecladas[KeyEvent.VK_D];
        tecla_w = tecladas[KeyEvent.VK_W];
        tecla_s = tecladas[KeyEvent.VK_S];
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() < this.NUMERO_TECLAS) {
            tecladas[arg0.getKeyCode()] = true;
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
    public boolean istecla_a() {
        return tecla_a;
    }
    public boolean istecla_d() {
        return tecla_d;
    }
    public boolean istecla_w() {
        return tecla_w;
    }
    public boolean istecla_s() {
        return tecla_s;
    }
    
}
