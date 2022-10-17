package feeder.Logic.Personajes;

public class Personaje {
    private int Vida;
    private String Nombre;
    private int PosX;
    private int PosY;

    public Personaje(int vida, String nombre, int posX, int posY) {
        Vida = vida;
        Nombre = nombre;
        PosX = posX;
        PosY = posY;
    }
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
    
}
