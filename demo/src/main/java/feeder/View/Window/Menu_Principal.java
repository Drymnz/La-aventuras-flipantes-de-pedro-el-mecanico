package feeder.View.Window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu_Principal extends JFrame implements ActionListener{
    
    JButton botonIniciar;
    JPanel PanelIncial;
    
    
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
        this.getContentPane().add(PanelIncial);
        
        
        botonIniciar = new JButton("Empezar");
        botonIniciar.setBounds(400,200, 200,100);
        PanelIncial.add(botonIniciar);
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
