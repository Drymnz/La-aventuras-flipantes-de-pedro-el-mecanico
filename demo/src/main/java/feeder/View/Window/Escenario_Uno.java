package feeder.View.Window;

import feeder.Logic.Personajes.Jugador;
import java.awt.Graphics2D;

public class Escenario_Uno extends Escenario {
    private Jugador jugador = new Jugador(100,"Pedro",0,0);
    @Override
    protected void mostrar() {
        super.mostrar();
        if (getGraphics() != null) {
            Graphics2D g2d = (Graphics2D) getGraphics();
            g2d.fill3DRect(jugador.getPosX(),jugador.getPosY(), 100, 100, getFocusTraversalKeysEnabled());
            if (jugador.getTextura()!= null) {
                g2d.drawImage(jugador.getTextura().getImage(), jugador.getPosX(),jugador.getPosY(),100,100,this);
            }
        }
    }
    public Jugador getJugador() {
        return jugador;
    }
}
