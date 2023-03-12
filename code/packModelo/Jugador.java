package packModelo;

import packModelo.packPokemon.Pokemon;

/**
 * CLASE HIJA DE COMBATIENTE
 * */
public class Jugador extends Combatiente{
    public Jugador(int TOTAL_POKEMONS, String nombre, boolean esTurno, Pokemon listaPokemon[])
    {
        super(TOTAL_POKEMONS, nombre, esTurno, listaPokemon);
    }

    @Override
    public void atacar() {

    }
}
