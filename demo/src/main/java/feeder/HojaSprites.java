package feeder;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HojaSprites {
    public final int[]pixeles;
    private final int ANCHO ;
    private final int ALTO ;
    private final String RUTA;
    /*COLECION DE HOJAS */
    public static HojaSprites suelo = new HojaSprites(320,320, "/sprintes/personaje.png");
    /*FIANL COLECION DE HOJAS */
    public HojaSprites(final int aNCHO,final int aLTO,final String rUTA) {
        this.ANCHO = aNCHO;
        this.ALTO = aLTO;
        this.RUTA = rUTA;

        this.pixeles = new int [ANCHO*ALTO];

        BufferedImage imagen ;

        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(rUTA));
            imagen.getRGB(0,0,this.ALTO, this.ANCHO, pixeles, 0, this.ANCHO);
            System.out.println("CARGO LA IMAGEN ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public int getANCHO() {
        return ANCHO;
    }
    
}
