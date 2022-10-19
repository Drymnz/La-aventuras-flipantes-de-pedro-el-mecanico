package feeder;

public class Pantalla {
    private final int ancho;
    private final int alto;

    public final int []pixeles;
    public Pantalla(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho*alto];
    }
    public void limpiar(){
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i]=0;
        }
    }
    public void mostrar(){
        for (int y = 0; y < this.alto; y++) {
            //int posicionY= y+compens https://www.youtube.com/watch?v=BaT0DM2f2dU&list=PLN9W6BC54TJJr3erMptodGOQFX7gWfKTM&index=10 6:40 Episode 789 –16min
            for (int x = 0; x < this.ancho; x++) {
                
            }
        }
    }
}