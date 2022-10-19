package feeder;

public class Pantalla {
    private final int ancho;
    private final int alto;

    public final int []pixeles;

    private final static int LADO_SPRINTE = 32;
    private final static int MASCARA_SPRINTE = LADO_SPRINTE-1;
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
    public void mostrar(final int compensacionX, final int compesacionY){
        for (int y = 0; y < this.alto; y++) {
            int posicionY= y+ compesacionY;
            if (posicionY<0||posicionY>=alto) {
                continue;
            }
            for (int x = 0; x < this.ancho; x++) {
                int posicionX = x + compensacionX;
                if (posicionX<0||posicionX>=alto) {
                    continue;
                }
                /*CODIGO PARA DIBUJAR */
                pixeles[posicionX+posicionY*ancho]= Sprinte.suel.pixeles[(x&MASCARA_SPRINTE)+(y&MASCARA_SPRINTE)*LADO_SPRINTE];
            }
        }
    }
}