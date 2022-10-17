package feeder.Logic.Configuracion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import feeder.Logic.Personajes.Personaje;

public class ConfiguracionTeclasPersonaje implements KeyListener  {

    private final static int numerotelca = 120;

    private Personaje avatar;

    private int distancia = 10;

    private char avanzar = KeyEvent.VK_A;
    private char retroceder  =KeyEvent.VK_D;
    private char arriba =KeyEvent.VK_W;
    private char abajo = KeyEvent.VK_S;

    public ConfiguracionTeclasPersonaje( Personaje avatar) {
        this.avatar = avatar;
    }


    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() == avanzar) {
            avatar.setPosX(avatar.getPosX()-distancia);
        }
        if (arg0.getKeyCode() == retroceder) {
            avatar.setPosX(avatar.getPosX()+distancia);
        }
        if (arg0.getKeyCode() == abajo) {
            avatar.setPosY(avatar.getPosY()+distancia);
        }
        if (arg0.getKeyCode() == arriba) {
            avatar.setPosY(avatar.getPosY()-distancia);
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}
