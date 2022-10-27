package feeder.Logic.Personajes;

import javax.swing.ImageIcon;
import java.awt.Color;


public class Jugador extends Personaje implements Runnable{

    protected boolean ejecuccion = false;

    private Thread hilo;

    private Color color_personaje;

    private static ImageIcon viendo_derecha;
    private static ImageIcon viendo_izquierda;
    private static ImageIcon paso_derecha;
    private static ImageIcon paso_izquierda;


    public Jugador(int vida, String nombre, int posX, int posY) {
        super(vida, nombre, posX, posY);
        try {
        viendo_derecha = new ImageIcon(getClass().getResource("/Personaje/Viendo a la derecha.png"));
        viendo_izquierda = new ImageIcon(getClass().getResource("/Personaje/Viendo a la izquierda.png"));
        paso_derecha = new ImageIcon(getClass().getResource("/Personaje/Paso a la derecha.png"));
        paso_izquierda = new ImageIcon(getClass().getResource("/Personaje/Paso a la izquierda.png"));
        } catch (Exception e) {
        }
  
        
    }

    public synchronized void iniciar_animaccion(){
        this.ejecuccion = true;
        hilo = new Thread(this, "Jugador_Animaccion");
        hilo.start();
    }
    public synchronized void detener_animaccion(){
        this.ejecuccion = false;
        try {
            hilo.join();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (this.ejecuccion) {
            try {
                this.color_personaje = Color.BLUE;
                //this.setTextura(paso_izquierda);
                Thread.sleep(500);
                //this.setTextura(paso_derecha);
                this.color_personaje = Color.GREEN;
                Thread.sleep(500);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
    
    @Override
    public void moverBot(int distancia) {
        // TODO Auto-generated method stub
        super.moverBot(distancia);
    }
    @Override
    public void moverDerecha(int distancia) {
        // TODO Auto-generated method stub
        super.moverDerecha(distancia);
        this.setTextura(paso_derecha);
    }
    @Override
    public void moverIzquierda(int distancia) {
        // TODO Auto-generated method stub
        super.moverIzquierda(distancia);
        this.setTextura(paso_izquierda);
    }
    @Override
    public void moverTop(int distancia) {
        // TODO Auto-generated method stub
        super.moverTop(distancia);
    }

    public Color getColor_personaje() {
        return color_personaje;
    }


}
