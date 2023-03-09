package packModelo;

import java.util.ArrayList;
import java.util.Random;

public class ListaPokemons {
    private Pokemon listaPokemons[];
    private ColeccionPokemons coleccionPokemons;
    public ListaPokemons(int numPokemons) {
        coleccionPokemons = new ColeccionPokemons();
        Random r = new Random();
        listaPokemons = new Pokemon[numPokemons];
        for (int ite = 0; ite < numPokemons; ite++) {
            listaPokemons[ite] = new Pokemon(coleccionPokemons.obtenerNombre(), coleccionPokemons.obtenerTipo(), r.nextInt(10), r.nextInt(20), r.nextInt(71) + 30);
        }
    }

    public Pokemon [] obtenerListaPokemons(){
        return this.listaPokemons;
    }
    public void agregarPokemon() {

    }
    public void eliminarPokemon() {

    }
}
