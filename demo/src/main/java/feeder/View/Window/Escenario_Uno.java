package feeder.View.Window;

import feeder.Logic.Configuracion.ConfiguracionTeclasPersonaje;
import feeder.Logic.Personajes.Jugador;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Escenario_Uno extends Escenario {
    private Jugador jugador = new Jugador(100,"Pedro",0,0);
    private JLabel ver = new JLabel("hola mundo");
    private JLabel info = new JLabel("info");
    private ConfiguracionTeclasPersonaje teclado = new ConfiguracionTeclasPersonaje(jugador);
    private JFrame ventana;


    public Escenario_Uno(int ANCHO_VENTANA, int ALTO_VENTANA) {
        super(ANCHO_VENTANA, ALTO_VENTANA);
        this.setBackground(Color.BLACK);
        info.setBounds(10,10, ANCHO_VENTANA,100);
        info.setVisible(true);
        info.setBackground(Color.BLACK);
        info.setForeground(Color.CYAN);

        ver.setBounds(jugador.getPosX(),jugador.getPosY(), 200,100);
        ver.setVisible(true);
        ver.setBackground(Color.BLACK);
        ver.setForeground(Color.CYAN);
        this.add(ver);
        this.add(info);;
        //TODO Auto-generated constructor stub
    }
    @Override
    public void mostrar() {
        // TODO Auto-generated method stub
        super.mostrar();
        if (ventana!=null) {
            ventana.repaint();
        }
    }

    @Override
    protected void actualizar() {
        // TODO Auto-generated method stub
        super.actualizar();
        teclado.actualizar();
        final short velocidad = 10 ;
        if (teclado.istecla_s()) {
            jugador.setPosY(jugador.getPosY()+velocidad);
        }
        if (teclado.istecla_a()) {
            jugador.setPosX(jugador.getPosX()-velocidad);
        }if (teclado.istecla_d()) {
            jugador.setPosX(jugador.getPosX()+velocidad);
        }if (teclado.istecla_w()) {
            jugador.setPosY(jugador.getPosY()-velocidad);
        }
        info.setText("jugador x: "+jugador.getPosX()+" || y:" +jugador.getPosY()+"  "+this.INFORMACION_ESCENARIO);
        ver.setLocation(jugador.getPosX(), jugador.getPosY());
    }
    public Jugador getJugador() {
        return jugador;
    }

    public ConfiguracionTeclasPersonaje getTeclado() {
        return teclado;
    }
    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }
    
}
