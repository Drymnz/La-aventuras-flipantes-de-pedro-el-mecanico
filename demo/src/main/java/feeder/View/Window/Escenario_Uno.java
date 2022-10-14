package feeder.View.Window;

import java.awt.Graphics;

import javax.swing.JPanel;

import feeder.Logic.Personajes.Personaje;

public class Escenario_Uno extends JPanel {
    Personaje jugador_uno = new Personaje(100, "Pedro");
    @Override
    public void paintAll(Graphics g) {
        // TODO Auto-generated method stub
        super.paintAll(g);
        //g.drawImage(jugador_uno.getImagen(), jugador_uno.getPosY(), jugador_uno.getPosX(), Color.BLUE, null);
    }
    //ListerActionKyes
    //jugador_uno.setPosY(jugador_uno.getPosY()+1);
}
