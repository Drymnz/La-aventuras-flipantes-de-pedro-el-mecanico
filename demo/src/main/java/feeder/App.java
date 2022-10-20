package feeder;

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
        ven.setSize(1280,720);
        Escenario_Uno escenario = new Escenario_Uno();
        ConfiguracionTeclasPersonaje tecl = new ConfiguracionTeclasPersonaje(escenario.getJugador());
        escenario.iniciar();
        ven.addKeyListener(tecl);
        ven.add(escenario);
        ven.setLocationRelativeTo(null);
        ven.show(true);
    }
    
}
