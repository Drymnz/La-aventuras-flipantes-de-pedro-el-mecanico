package feeder.Logic.Fisica;

import feeder.Logic.Personajes.Personaje;

public class Graveda {

    private static volatile boolean ejecucion = false;
    private Thread hilo;
    private final static short METOR = 127;
    private final static short GRAVEDA = 10;
    private final short MOVER;
    private final short ACTUALIZACION;

    public Graveda(final short ACTUALIZACION) {
        this.ACTUALIZACION = ACTUALIZACION;
        this.MOVER = (short) ((GRAVEDA*METOR) / ACTUALIZACION);
    }
     
    public void reaccion(boolean abajo_arriba,Personaje afectar){
        if (abajo_arriba) {
            afectar.setPosY(afectar.getPosY()-this.MOVER);
        }else{
            afectar.setPosY(afectar.getPosY()+this.MOVER);
        }
    }
}
