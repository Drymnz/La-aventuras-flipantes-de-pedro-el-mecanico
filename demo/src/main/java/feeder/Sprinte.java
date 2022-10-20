package feeder;

public class Sprinte {
    private final int lado;

    private int x;
    private int y;

    public int[] pixeles;
    /*colecion sprinte */
    public static Sprinte suel = new Sprinte(32, 0, 0, HojaSprites.suelo);
    /*final colecion sprinte */

    public Sprinte(final int lado, final int columna, final int fila,final HojaSprites hoja){
        this.lado = lado;

        pixeles = new int[this.lado*this.lado];
        this.x = columna*lado;
        this.y = fila*lado;

        for (int y = 0 ; y <lado;y++){
            for (int x = 0 ; x <lado;x++){
                pixeles[x+y*lado] = hoja.pixeles[(x+this.x)+(y+this.y)*hoja.getANCHO()];
            }
        }
    }
}
