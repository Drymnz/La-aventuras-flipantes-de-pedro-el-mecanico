package feeder.View.Window;

import feeder.Logic.Configuracion.ConfiguracionTeclasPersonaje;
import feeder.Logic.Personajes.Jugador;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Escenario_Uno extends Escenario {
    private Jugador jugador = new Jugador(100,"Pedro",0,0);
    private JLabel jlabel_jugador = new JLabel("hola mundo");
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
        jlabel_jugador.setBounds(jugador.getPosX(),jugador.getPosY(), 100,25);
        jlabel_jugador.setVisible(true);
        jlabel_jugador.setBackground(jugador.getColor_personaje());
        jlabel_jugador.setForeground(Color.CYAN);
        jugador.iniciar_animaccion();
        this.ver_area(jlabel_jugador,jugador.getColor_personaje());
        this.add(jlabel_jugador);
        this.add(info);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void mostrar() {
        // TODO Auto-generated method stub
        super.mostrar();
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
        jlabel_jugador.setLocation(jugador.getPosX(), jugador.getPosY());
        this.ver_area(jlabel_jugador,jugador.getColor_personaje());
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
