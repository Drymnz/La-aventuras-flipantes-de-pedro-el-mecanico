package feeder.View.Window;

import feeder.Logic.Configuracion.ConfiguracionTeclasPersonaje;
import feeder.Logic.Personajes.Jugador;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Escenario_Uno extends Escenario {
    private Jugador jugador = new Jugador(100,"Pedro",0,0);
    private ConfiguracionTeclasPersonaje teclado = new ConfiguracionTeclasPersonaje(jugador);
    private JFrame ventana;
 
    public Escenario_Uno(){
        this.setBackground(Color.BLACK);
        JLabel ver = new JLabel("hola mundo");
        ver.setBounds(jugador.getPosX(),jugador.getPosY(), 200,100);
        ver.setVisible(true);
        ver.setBackground(Color.BLACK);
        ver.setForeground(Color.CYAN);
        this.add(ver);
    }
    @Override
    public void mostrar() {
        // TODO Auto-generated method stub
        super.mostrar();
        if (this.ventana != null) {
            this.ventana.repaint();    
        }
    }

    @Override
    protected void actualizar() {
        // TODO Auto-generated method stub
        super.actualizar();
        teclado.actualizar();
        if (teclado.isAbajo()) {
            jugador.setPosY(jugador.getPosY()-1);
        }
        if (teclado.isRetroceder()) {
            jugador.setPosX(jugador.getPosX()-1);
        }if (teclado.isAvanzar()) {
            jugador.setPosX(jugador.getPosX()+1);
        }if (teclado.isArriba()) {
            jugador.setPosY(jugador.getPosY()+1);
        }
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
