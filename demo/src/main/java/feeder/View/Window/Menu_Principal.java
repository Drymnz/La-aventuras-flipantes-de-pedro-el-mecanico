package feeder.View.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menu_Principal extends JFrame implements ActionListener{

    private static final String NOMBRE_JUEGO = "Las flipantes aventuras de Pedro el mecanico";
    private static final int ANCHO_VENTANA = 1280;
    private static final int ALTO_VENTANA = 720;
    
    private JButton botonIniciar;
    private JPanel PanelIncial;

    private static Escenario_Uno primer_nivel = new Escenario_Uno(ANCHO_VENTANA,ALTO_VENTANA);
    
    public Menu_Principal(){
        this.setSize(ANCHO_VENTANA,ALTO_VENTANA);
        this.setTitle(NOMBRE_JUEGO);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.iniciarComponentes();
    }


    private void iniciarComponentes() {
        PanelIncial = new JPanel();
        PanelIncial.setBounds(0, 0, ANCHO_VENTANA, ALTO_VENTANA);
        PanelIncial.setVisible(true);
        PanelIncial.setLayout(null);
        this.getContentPane().add(PanelIncial);
        
        botonIniciar = new JButton("Empezar");
        botonIniciar.setBounds(400,200, 200,100);
        botonIniciar.setVisible(true);
        botonIniciar.addActionListener(this);
       
        PanelIncial. setFocusable(true);
        PanelIncial.add(botonIniciar);
        primer_nivel.setLayout(null);
        primer_nivel.setBounds(0, 0, ANCHO_VENTANA, ALTO_VENTANA);
        primer_nivel.setVisible(false);
        this.getContentPane().add(primer_nivel);
        botonIniciar.doClick();//click
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == botonIniciar) {
            primer_nivel.setVentana(this);
            primer_nivel.iniciar();
            PanelIncial.setVisible(false);
            primer_nivel.setVisible(true);
            this.addKeyListener(primer_nivel.getTeclado());
            this.repaint();
        }
    }
}
