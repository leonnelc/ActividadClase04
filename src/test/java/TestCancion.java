import TendenciasMusicales.Cancion;
import org.junit.Assert;
import org.junit.Test;

public class TestCancion {

    @Test
    public void casosDePrueba() {
        String normal = "\uD83C\uDFB5Coldplay - A Rush of Blood to the head – The Scientist";
        String auge = "\uD83D\uDE80Coldplay - The Scientist (A Rush of Blood to the head - 2002)";
        String tendencia = "\uD83D\uDD25The Scientist - Coldplay (A Rush of Blood to the head - 2002)";
        Cancion cancion = new Cancion("Coldplay", "The Scientist", "A Rush of Blood to the head", 2002);
        // 1. “The Scientist” recién se lanza (tiene popularidad normal).
        Assert.assertEquals(normal, cancion.getEstadoPopularidad());

        // 2. “The Scientist” está en auge por superar el mínimo de reproducciones esperadas.
        cancion.setReproducciones(15000);
        Assert.assertEquals(auge, cancion.getEstadoPopularidad());

        // 3. “The Scientist” baja del auge por tener muchos dislikes.
        cancion.setDislikes(10000);
        Assert.assertEquals(normal, cancion.getEstadoPopularidad());

        // 4. “The Scientist” es tendencia por récord de reproducciones y cantidad de personas que le gusta el tema.
        cancion.setReproducciones(250000);
        cancion.setLikes(70000);
        Assert.assertEquals(tendencia, cancion.getEstadoPopularidad());

        // 5. “The Scientist” era tendencia pero vuelve a ser normal por no ser escuchada en las últimas horas.
        cancion.setReproducidaEnLasUltimas24Horas(false);
        Assert.assertEquals(normal, cancion.getEstadoPopularidad());
    }
}
