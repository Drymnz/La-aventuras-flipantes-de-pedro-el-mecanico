package feeder.Logic.Personajes.Sprintes;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class HojaSprites {
    public final  int[] pixeles;
    public final int ancho;
    public final int alto;
    public HojaSprites(final  String ruta,final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
        pixeles =  new int[ancho * alto];
        try {
            BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0,0,ancho,alto,pixeles,0 ,ancho);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getAncho() {
        return ancho;
    }

}
