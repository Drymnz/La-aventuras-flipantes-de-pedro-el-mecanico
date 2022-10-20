package feeder.View.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menu_Principal extends JFrame implements ActionListener{

    private static final String NOMBRE_JUEGO = "Las flipantes aventuras de Pedro el mecanico";
    
    private JButton botonIniciar;
    private JPanel PanelIncial;

    private static Escenario_Uno primer_nivel = new Escenario_Uno();
    
    public Menu_Principal(){
        this.setSize(1280,720);
        this.setTitle(NOMBRE_JUEGO);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.iniciarComponentes();
    }


    private void iniciarComponentes() {
        PanelIncial = new JPanel();
        PanelIncial.setBounds(0, 0, 1280, 720);
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
        primer_nivel.setBounds(0, 0, 1280, 720);
        primer_nivel.setVisible(false);
        this.getContentPane().add(primer_nivel);
        botonIniciar.doClick();//click
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == botonIniciar) {
            primer_nivel.iniciar();
            PanelIncial.setVisible(false);
            primer_nivel.setVisible(true);
            this.repaint();
        }
    }


/*     @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getKeyChar() == 'a') {
            prueba.setLocation(prueba.getX()-5, prueba.getY());

        }else if (e.getKeyChar() == 'd') {
            prueba.setLocation(prueba.getX()+5, prueba.getY());        
        }
    } */
    
}
