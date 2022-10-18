package feeder.Logic.Personajes;

import javax.swing.ImageIcon;

public class Personaje {
    private int Vida;
    private String Nombre;
    private int PosX;
    private int PosY;
    private ImageIcon textura;

    public Personaje(int vida, String nombre, int posX, int posY) {
        Vida = vida;
        Nombre = nombre;
        PosX = posX;
        PosY = posY;
    }

    /*Movimiento */

    public void moverTop(int distancia){
        this.setPosY(this.getPosY()-distancia);
    }
    public void moverBot(int distancia){
        this.setPosY(this.getPosY()+distancia);
    }
    public void moverDerecha(int distancia){
        this.setPosX(this.getPosX()+distancia);
    }
    public void moverIzquierda(int distancia){
        this.setPosX(this.getPosX()-distancia);
    }

    /*fin Movimiento */

    
    public int getVida() {
        return Vida;
    }
    public void setVida(int vida) {
        Vida = vida;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public int getPosX() {
        return PosX;
    }
    public void setPosX(int posX) {
        PosX = posX;
    }
    public int getPosY() {
        return PosY;
    }
    public void setPosY(int posY) {
        PosY = posY;
    }

    public ImageIcon getTextura() {
        return textura;
    }

    public void setTextura(ImageIcon textura) {
        this.textura = textura;
    }
    
}
