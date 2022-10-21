package feeder.View.Window;

import java.awt.Canvas;
import java.sql.Time;

import javax.swing.JPanel;

public class Escenario extends JPanel implements Runnable {


    private static String info = "";

    private static final String NAME_GAME = "Las flipantes aventuras de pedro el mecanico";

    private static volatile boolean ejecucion = false;

    private static Thread hilo;

    private static int aps = 0;
    private static int fps = 0;


    private final static short LIMTE_ACTUALIZACION = 60;

    public void mostrar(){
        this.fps++;
    }

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
    ////n³+3n²+11n+7
    @Override
    public void run() {
        long lastTime= System.nanoTime();
        double nsPerTick = 1000000000D /60D;
        
        long lastTimer = System.currentTimeMillis();
        double delta = 0;
        while (ejecucion) {//n
            long now  = System.nanoTime();
            delta += (now-lastTime) / nsPerTick;
            lastTime = now;
            boolean shoulRender = false; 
            while (delta>=1) {//n²
                delta-=1;//n²
                shoulRender = true;
                actualizar();//n³
            }
            if (shoulRender) {
                //render
            }
            if (System.currentTimeMillis()-lastTimer>=1000) {//n
                info = NAME_GAME + " || Aps" + aps +" || Fps "+fps ;//n
                System.out.println(this.info);//n
                this.aps = 0;//n
                this.fps = 0;//n
                lastTimer +=1000;
            }
        }
    }
    
}
