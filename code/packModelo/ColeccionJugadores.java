package packModelo;

import java.util.Random;

public class ColeccionJugadores {
    private static final Random r = new Random();
    private final String listaNombres[] = {"Andrea", "Mikel", "Jon", "Ane", "Aitor", "Uxue"};

    public ColeccionJugadores()
    {

    }
    public String obtenerNombre(){
        return listaNombres[r.nextInt(listaNombres.length)];
    }
}
