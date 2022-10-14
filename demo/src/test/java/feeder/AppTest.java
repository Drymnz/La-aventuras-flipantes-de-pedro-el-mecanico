package feeder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import feeder.Logic.Personajes.Personaje;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void pruevademovimiento()
    {
        Personaje personaje = new Personaje(15,"Benja");
        Personaje personaje1 = new Personaje(15,"Benja");
        /**
         * pelp personaje.pelea(personaje1,5);
        */
        assertTrue( personaje.getVida()==15 );
    }
     /**
     * Rigorous Test :-)
     */
    @Test
    public void pruevadememoriapersonaje()
    {
        Personaje personaje = new Personaje(15,"Benja");
        assertTrue( personaje.getNombre().equals("Benja") );
    }
}
