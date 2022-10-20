package feeder.View.Window;

import java.awt.Canvas;

import javax.swing.JPanel;

public class Escenario extends JPanel implements Runnable {


    private static String info = "";

    private static final String NAME_GAME = "Las flipantes aventuras de pedro el mecanico";

    private static volatile boolean ejecucion = false;

    private static Thread hilo;

    private static int aps = 0;
    private static int fps = 0;

    public void mostrar(){
        this.fps++;
    }

    //n
    protected void actualizar(){
        this.aps++;
    }

    public synchronized void iniciar(){
        this.ejecucion = true;
        hilo = new Thread(this, "Graficos");
        hilo.start();
    }
    public synchronized void detener(){
        this.ejecucion = false;
        //hilo.stop(); a bruta
        try {
            hilo.join();//termina de ejecutar y te paras
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* 60 */

    ////n³+3n²+11n+7
    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;//1
        final int APS_OBJETIVO = 120;//1  
        final double NS_POR_ACTUALIZAR = NS_POR_SEGUNDO / APS_OBJETIVO;//1

        
        double tiempoTrascurido;//1
        long referenciactualizacion = System.nanoTime();//1
        long referenciaContador = System.nanoTime();//1
        double delta = 0; //1

        while (ejecucion) {//n

            final long inicioBucle = System.nanoTime();//n

            tiempoTrascurido = inicioBucle - referenciactualizacion;//n
            referenciactualizacion = inicioBucle;//n

            delta += tiempoTrascurido / NS_POR_ACTUALIZAR;//n

            while (delta>=1) {//n²
                actualizar();//n³
                delta--;//n²
            }

            if (System.nanoTime()-referenciaContador > NS_POR_SEGUNDO) {//n
                info = NAME_GAME + " || Aps" + aps +" || Fps "+fps ;//n
                System.out.println(this.info);//n
                this.aps = 0;//n
                this.fps = 0;//n
                referenciaContador = System.nanoTime(); //n
            }
            this.actualizar();   //n²         
        }
    }
    
}
