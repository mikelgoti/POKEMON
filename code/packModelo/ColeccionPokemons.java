package packModelo;

import java.util.Random;

public class ColeccionPokemons {

    private final String listaNombres[] = {"Charizar", "bulbasur", "picachu", "pokemon1", "pokemon2", "pokemon3"};

    private final String listaTipos [] = {"Fuego", "Agua", "Hierba", "Electrico"};
    private static final Random r = new Random();

    public ColeccionPokemons()
    {

    }

    public String obtenerTipo(){
        return listaTipos[r.nextInt(listaTipos.length)];
    }
    public String obtenerNombre(){
        return listaNombres[r.nextInt(listaNombres.length)];
    }
}
