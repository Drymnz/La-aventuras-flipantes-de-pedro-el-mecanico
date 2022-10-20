package feeder;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Juego extends Canvas implements Runnable{

    private static final long serialVerisonUID = 1L;
    private static boolean enFuncionamiento = false;
    private static JFrame ventana;
    private static Thread thread;
    private static Pantalla pantalla;

    
    
    private static int x = 0;
    private static int y = 0;

    private static int fps = 0;
    private static int aps = 0;
    private static String info = "Error";

    private static final int ANCHO = 800;
    private static final int ALTO = 800;

    private static final String NOMBRE_JUEGO = "Las flipantes aventuras de Pedro el mecanico"; 
    private static Teclado teclado;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public static void main(String[] args) {
        Juego ejecutar = new Juego();
        ejecutar.iniciar();
    }
    
    public Juego (){
        teclado = new Teclado();
        pantalla = new Pantalla(ANCHO, ALTO);
        this.addKeyListener(teclado);

        this.setPreferredSize(new Dimension(this.ANCHO, this.ALTO));

        ventana = new JFrame(NOMBRE_JUEGO);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this,BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public synchronized void iniciar(){
        this.thread = new Thread(this,"Grafico");
        this.thread.start();
        enFuncionamiento = true;
    }
    public synchronized void detener(){
        enFuncionamiento= false;
        try {
            this.thread.join();//detener de forma amable
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    private void mostrar(){
        BufferStrategy estrategia = this.getBufferStrategy();
        if (estrategia ==null) {
            createBufferStrategy(3);
            return ;
        }
        pantalla.limpiar();
        pantalla.mostrar(x, y);

        System.arraycopy(pantalla.pixeles,0,pixels,0,pixels.length);

        Graphics dibujar = this.getGraphics();
        dibujar.drawImage(image,0,0,getWidth(),getHeight(),null);

        dibujar.dispose();
        estrategia.show();
        this.fps++;
    }
    private void actualizar(){
        this.teclado.actualizar();
        if (teclado.abajo) {
            y--;
        }
        if (teclado.arriba) {
            y++;
        }
        if (teclado.izquierda) {
            x--;
        }
        if (teclado.derecha) {
            x++;
        }
        colicionesObjetetos();
        this.aps ++;
    }
    public void colicionesObjetetos(){

    }
    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 120;
        final double NS_POR_ACTUALIZAR = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActual = System.nanoTime();
        long referenciaContador= System.nanoTime();

        double tiempoTrascurido = 0;
        double delta = 0;

        this.requestFocus();

        while (enFuncionamiento) {
            final long inicioBucle = System.nanoTime();

            tiempoTrascurido = inicioBucle - referenciaActual;
            referenciaActual = inicioBucle;

            delta+=tiempoTrascurido/NS_POR_ACTUALIZAR;
            while (delta >= 1) {
                actualizar();
                delta--;
            }
            mostrar();
            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                this.info = NOMBRE_JUEGO + "|| FPS : "+this.fps +" || APS : "+this.aps;
                ventana.setTitle(info);
                System.out.println(info);
                this.fps = 0;
                this.aps = 0 ;
                referenciaContador = System.nanoTime();
            }
        }
    }
}
