package feeder.Logic.Personajes.Sprintes;

public class Sprinte {
    private final  int lado;

    private int x;
    private int y;

    

    private int [] pixeles;
    private final HojaSprites hoja;

    public Sprinte(final int lado , final int columna, final int fila,final HojaSprites hoja){
        this.lado = lado;

        pixeles = new int [this.lado * this.lado];
        this.x = columna*this.lado;
        this.y = fila * this.lado;
        this.hoja = hoja;
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x+y *lado] = hoja.pixeles[(x+this.x ) + (y + this.y)  * hoja.getAncho()];
            }
        }
    }
}
