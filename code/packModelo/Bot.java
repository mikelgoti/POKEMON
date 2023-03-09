package packModelo;

import java.util.List;

public class Bot extends Combatiente{
    public Bot(int TOTAL_POKEMONS, String nombre, boolean esTurno, ListaPokemons listaPokemons)
    {
        super(TOTAL_POKEMONS, nombre, esTurno, listaPokemons);
    }

    @Override
    public void atacar() {

    }
}
