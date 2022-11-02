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
    private JLabel suelo = new JLabel("suelo");
    private ConfiguracionTeclasPersonaje teclado = new ConfiguracionTeclasPersonaje(jugador);
    private JFrame ventana;

    public Escenario_Uno(int ANCHO_VENTANA, int ALTO_VENTANA) {
        super(ANCHO_VENTANA, ALTO_VENTANA);
        this.setBackground(Color.BLACK);
        this.agregarJLabel(this.info, 10, 10, Color.BLACK, Color.CYAN, ANCHO_VENTANA, 100);
        this.agregarJLabel(this.jlabel_jugador, this.jugador.getPosX(), this.jugador.getPosY(), this.jugador.getColor_personaje(), Color.CYAN, 100, 25);
        this.agregarJLabel(this.suelo, 0,600, Color.BLACK, Color.CYAN, ANCHO_VENTANA, 200);
        jugador.iniciar_animaccion();
        this.ver_area(this.jlabel_jugador,jugador.getColor_personaje());
        this.ver_area(this.suelo, Color.CYAN);
        //TODO Auto-generated constructor stub
    }
    private void agregarJLabel(JLabel agregar,int posx , int posy,Color fondo, Color borde,int ancho, int alto){
        agregar.setBounds(posx,posy, ancho,alto);
        agregar.setVisible(true);
        agregar.setBackground(fondo);
        agregar.setForeground(borde);
        this.add(agregar);
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
            jugador.setPosY(0);
            //jugador.setPosY(jugador.getPosY()-velocidad);
        }
        info.setText("jugador x: "+jugador.getPosX()+" || y:" +jugador.getPosY()+"  "+this.INFORMACION_ESCENARIO);
        jlabel_jugador.setLocation(jugador.getPosX(), jugador.getPosY());
        this.ver_area(jlabel_jugador,jugador.getColor_personaje());
        this.graveda.reaccion(false, jugador);
        /*impacto con el suelo */

        this.impacto(this.jlabel_jugador,this.suelo);
    }

    private void impacto(JLabel objeto_uno,JLabel objeto_dos){
        if (this.limitesY(objeto_uno,objeto_dos)) {
            objeto_uno.setLocation(objeto_uno.getX(), objeto_uno.getY()-objeto_uno.getHeight());
            jugador.setPosX(objeto_uno.getX());
            jugador.setPosY(objeto_uno.getY());
            System.out.println("x:"+objeto_uno.getX()+"y"+objeto_uno.getY());
        }
    }
    private boolean limitesY(JLabel objeto_uno,JLabel objeto_dos){
        System.out.println(objeto_uno.getY()+"igual mayou"+objeto_dos.getY());
        if (objeto_uno.getY()>=objeto_dos.getY()) {
            return true;
        }
        return false;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public ConfiguracionTeclasPersonaje getTeclado() {
        return teclado;
    }
    public void setVentana(JFrame ventana){
        this.ventana = ventana;
    }
}
