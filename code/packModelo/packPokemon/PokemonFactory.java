package packModelo.packPokemon;

import packUtils.InstanciaRandom;

import java.util.HashMap;
import java.util.Map;

public class PokemonFactory implements IPokemonFactory{
    private static final Map<String, PokemonTipo> listaPokemons = new HashMap<>();

    static{
        listaPokemons.put("Pikachu", PokemonTipo.ELECTRICO);
        listaPokemons.put("Bulbasur", PokemonTipo.PLANTA);
        listaPokemons.put("Charmeleon", PokemonTipo.FUEGO);
        listaPokemons.put("Squirtle", PokemonTipo.AGUA);
    }

    @Override
    public Pokemon crearPokemon(String nombre) {
        if(!listaPokemons.containsKey(nombre)){
            throw new IllegalArgumentException("No existe ese nombre");
        }
        return new Pokemon(nombre, listaPokemons.get(nombre));
    }

    @Override
    public Pokemon[] getListaPokemons(int numPokemons) {
        Pokemon lista [] = new Pokemon[numPokemons];
        for(int ite = 0 ; ite < numPokemons ; ite++){
            lista[ite] = crearPokemon((String) listaPokemons.keySet().toArray()[InstanciaRandom.getInstanciaRandom().getR().nextInt(listaPokemons.size())]);
        }
        return lista;
    }
}
