package feeder.Logic.Personajes;

public class Personaje {
    private int Vida;
    private String Nombre;
    public Personaje(int Vida, String Nombre){
        this.Vida = Vida;
        this.Nombre = Nombre;
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
    
}
