package feeder.View.Window;

import feeder.Logic.Personajes.Jugador;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class Escenario_Uno extends Escenario {
    private Jugador jugador = new Jugador(100,"Pedro",0,0);
 
    public Escenario_Uno(){
        this.setBackground(Color.BLACK);
        JLabel ver = new JLabel("hola mundo");
        ver.setBounds(400,200, 200,100);
        ver.setVisible(true);
        ver.setBackground(Color.BLACK);
        ver.setForeground(Color.CYAN);
        this.add(ver);
    }
    public Jugador getJugador() {
        return jugador;
    }
}
