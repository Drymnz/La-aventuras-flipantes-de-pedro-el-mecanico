package feeder.View.Window;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menu_Principal extends JFrame implements KeyListener{
    
    JButton botonIniciar;
    JPanel PanelIncial;
    JLabel prueba;
    
    
    public Menu_Principal(){
    
        setSize(1280,720);
        setTitle("Zombies");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        iniciarComponentes();
    }


    private void iniciarComponentes() {
        
        
        
        PanelIncial = new JPanel();
        PanelIncial.setBounds(0, 0, 1280, 720);
        PanelIncial.setVisible(true);
        PanelIncial.setLayout(null);
        this.getContentPane().add(PanelIncial);
        
        prueba = new JLabel("hola mundo");
        prueba.setBounds(100, 100, 50, 50);
        prueba.setBackground(Color.BLUE);
        prueba.setForeground(Color.BLUE);
        
        
        botonIniciar = new JButton("Empezar");
        botonIniciar.setBounds(400,200, 200,100);
       // PanelIncial.add(botonIniciar);
        PanelIncial.addKeyListener(this);
        
        
        
       
       PanelIncial. setFocusable(true);
       PanelIncial. add(prueba);
        
        
    }

    public synchronized void mostar(){

    }

    public synchronized void actualizar(){
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getKeyChar() == 'a') {
            prueba.setLocation(prueba.getX()-5, prueba.getY());

        }else if (e.getKeyChar() == 'd') {
            prueba.setLocation(prueba.getX()+5, prueba.getY());        
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
