package packModelo;

/**
 * CLASE HIJA DE COMBATIENTE
 * */
public class Jugador extends Combatiente{
    public Jugador(int TOTAL_POKEMONS, String nombre, boolean esTurno, ListaPokemons listaPokemons)
    {
        super(TOTAL_POKEMONS, nombre, esTurno, listaPokemons);
    }

    @Override
    public void atacar() {

    }
}
