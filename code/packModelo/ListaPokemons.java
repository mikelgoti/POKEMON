package packModelo;

import java.util.ArrayList;

public class ListaPokemons {
    private ArrayList<Pokemon> listaPokemons;
    private int numPokemons;
    public ListaPokemons()
    {
        listaPokemons = new ArrayList<>();

    }

    public void agregarPokemon(){

    }

    public void eliminarPokemon(){

    }

    public ArrayList<Pokemon> getListaPokemons() {
        return listaPokemons;
    }

    public void setListaPokemons(ArrayList<Pokemon> listaPokemons) {
        this.listaPokemons = listaPokemons;
    }

    public int getNumPokemons() {
        return numPokemons;
    }

    public void setNumPokemons(int numPokemons) {
        this.numPokemons = numPokemons;
    }

}
