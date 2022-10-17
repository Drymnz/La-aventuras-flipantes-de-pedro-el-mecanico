package feeder.View.Window;

import feeder.Logic.Personajes.Personaje;

public class Escenario_Uno extends Escenario {
    Personaje jugador = new Personaje(100,"Pedro",0,0);
    @Override
    protected void mostrar() {
        this.getBufferStrategy().getDrawGraphics().fillRect(0,0, 100, 100);
        super.mostrar();
    }
    public Personaje getJugador() {
        return jugador;
    }
}
