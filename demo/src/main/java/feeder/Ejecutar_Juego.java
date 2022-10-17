package feeder;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejecutar_Juego extends JPanel implements Runnable{

    private static final long serieVerisonUID = 1l;
    
    private static final int ANCHO = 1280;
    private static final int ALTO = 720;

    private static volatile boolean ejecucion = false;

    private static final String NAME_GAME = "Las flipantes aventuras de pedro el mecanico";

    private static int aps = 0;
    private static int fps = 0;


    private static JFrame ventana;
    private static Thread hilo;

    private static String text = "hola";

    private Ejecutar_Juego(){
        this.setPreferredSize(new Dimension(ANCHO,ALTO));
        ventana = new JFrame(NAME_GAME);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add (this,BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        Ejecutar_Juego ej = new Ejecutar_Juego();
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        mostrar();
    }

    private synchronized void iniciar(){
        this.ejecucion = true;
        hilo = new Thread(this, "Graficos");
        hilo.start();
    }
    private void mostrar(){
        //BufferStrategy estratejia = getBufferStrategy();
        //Graphics g = estratejia.getDrawGraphics();
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D) g ;
        g.setColor(Color.BLUE);
        g.setFont(new Font("Time New Roman", Font.PLAIN,500));
        g.drawString(text,100,100);
        g.dispose();
        this.fps ++;
    }
    private void actualizar(){
        this.aps++;
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
                ventana.setTitle(NAME_GAME + " || Aps" + aps +" || Fps "+fps );
                text = NAME_GAME + " || Aps" + aps +" || Fps "+fps ;
                this.aps = 0;
                this.fps = 0;
                referenciaContador = System.nanoTime(); 
            }
            this.actualizar();            
        }
    }
    //private  static final long  serie
}
