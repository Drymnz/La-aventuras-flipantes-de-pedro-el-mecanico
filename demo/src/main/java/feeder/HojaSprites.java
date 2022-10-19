package feeder;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HojaSprites {
    public final int[]pixeles;
    private final int ANCHO ;
    private final int ALTO ;
    private final String RUTA;
    public HojaSprites(final int aNCHO,final int aLTO,final String rUTA) {
        this.ANCHO = aNCHO;
        this.ALTO = aLTO;
        this.RUTA = rUTA;

        this.pixeles = new int [ANCHO*ALTO];

        BufferedImage imagen ;

        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(rUTA));
            imagen.getRGB(0,0,this.ALTO, this.ANCHO, pixeles, 0, this.ANCHO);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    public int getANCHO() {
        return ANCHO;
    }
    
}
