package feeder.View.Window;

import java.awt.Canvas;

public class Escenario extends Canvas implements Runnable {

    private static String info = "";

    private static final String NAME_GAME = "Las flipantes aventuras de pedro el mecanico";

    private static volatile boolean ejecucion = false;

    private static Thread hilo;

    private static int aps = 0;
    private static int fps = 0;

    protected void mostrar(){
        this.getBufferStrategy().getDrawGraphics().dispose();
        this.fps++;
    }

    protected void actualizar(){
        this.aps++;
    }

    private synchronized void iniciar(){
        this.ejecucion = true;
        hilo = new Thread(this, "Graficos");
        hilo.start();
    }
    private synchronized void detener(){
        this.ejecucion = false;
        //hilo.stop(); a bruta
        try {
            hilo.join();//termina de ejecutar y te paras
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final short APS_OBJETIVO = 120;
        final double NS_POR_ACTUALIZAR = NS_POR_SEGUNDO / APS_OBJETIVO;

        
        double tiempoTrascurido;
        long referenciactualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double delta = 0; 

        while (ejecucion) {

            final long inicioBucle = System.nanoTime();

            tiempoTrascurido = inicioBucle - referenciactualizacion;
            referenciactualizacion = inicioBucle;

            delta += tiempoTrascurido / NS_POR_ACTUALIZAR;

            while (delta>=1) {
                actualizar();
                delta--;
            }

            this.mostrar();
            if (System.nanoTime()-referenciaContador > NS_POR_SEGUNDO) {
                info = NAME_GAME + " || Aps" + aps +" || Fps "+fps ;
                this.aps = 0;
                this.fps = 0;
                referenciaContador = System.nanoTime(); 
            }
            this.actualizar();            
        }
    }
    
}
