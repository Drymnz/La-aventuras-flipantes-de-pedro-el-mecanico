package feeder.Logic.Personajes;

import javax.swing.ImageIcon;

public class Jugador extends Personaje{

    private static ImageIcon viendo_derecha;
    private static ImageIcon viendo_izquierda;
    private static ImageIcon paso_derecha;
    private static ImageIcon paso_izquierda;


    public Jugador(int vida, String nombre, int posX, int posY) {
        super(vida, nombre, posX, posY);
        viendo_derecha = new ImageIcon(getClass().getResource("/Personaje/Viendo a la derecha.png"));
        viendo_izquierda = new ImageIcon(getClass().getResource("/Personaje/Viendo a la izquierda.png"));
        paso_derecha = new ImageIcon(getClass().getResource("/Personaje/Paso a la derecha.png"));
        paso_izquierda = new ImageIcon(getClass().getResource("/Personaje/Paso a la izquierda.png"));
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
}
