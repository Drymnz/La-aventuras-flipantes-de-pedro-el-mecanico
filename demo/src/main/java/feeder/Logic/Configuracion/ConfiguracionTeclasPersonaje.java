package feeder.Logic.Configuracion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import feeder.Logic.Personajes.Personaje;

public class ConfiguracionTeclasPersonaje implements KeyListener  {

    private final static int numerotelca = 120;

    private Personaje avatar;

    private int distancia = 10;

    private char avanzar = 'a';
    private char retroceder  ='d';
    private char arriba ='w';
    private char abajo ='s';

    public ConfiguracionTeclasPersonaje(Personaje avatar) {
        this("a","d","w","s",avatar);
    }
    
    public ConfiguracionTeclasPersonaje(String avanzar, String retroceder, String arriba, String abajo, Personaje avatar) {
        this.avanzar = avanzar.charAt(0);
        this.retroceder = retroceder.charAt(0);
        this.arriba = arriba.charAt(0);
        this.abajo = abajo.charAt(0);
        this.avatar = avatar;
    }


    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyChar() == avanzar) {
            avatar.setPosX(avatar.getPosX()-distancia);
        }
        if (arg0.getKeyChar() == retroceder) {
            avatar.setPosX(avatar.getPosX()+distancia);
        }
        if (arg0.getKeyChar() == abajo) {
            avatar.setPosY(avatar.getPosY()-distancia);
        }
        if (arg0.getKeyChar() == arriba) {
            avatar.setPosY(avatar.getPosY()+distancia);
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }
}
