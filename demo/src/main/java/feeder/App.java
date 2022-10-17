package feeder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import feeder.Logic.Configuracion.ConfiguracionTeclasPersonaje;
import feeder.View.Window.Escenario_Uno;

public class App 
{
    public static void main( String[] args )  
    {
        //Menu_Principal menuPrincial = new Menu_Principal();
        JFrame ven = new JFrame();
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ven.pack();
        ven.setLocationRelativeTo(null);
        ven.setVisible(true);
        Escenario_Uno escenario = new Escenario_Uno();
        ConfiguracionTeclasPersonaje tecl = new ConfiguracionTeclasPersonaje(escenario.getJugador());
        escenario.addKeyListener(tecl);
        ven.addKeyListener(tecl);
        ven.add(escenario);
        ven.setSize(1280,720);
        ven.setLocationRelativeTo(null);
        ven.show(true);
        ven.repaint();
        ven.pack();
    }
    
}
