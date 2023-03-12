package packModelo.packPokemon;

public interface IPokemonFactory {
    Pokemon crearPokemon(String nombre);
    Pokemon [] getListaPokemons(int numPokemons);
}
