package packControlador;

import packModelo.ModeloBatalla;
import packModelo.packPokemon.Pokemon;
import packVista.VistaPokemon;

public class ControladorPokemon {

    private static ControladorPokemon miControladorPokemon;

    private ModeloBatalla modeloBatalla;

    private VistaPokemon vistaPokemon;

    private Pokemon pokemonAtacante;

    private Pokemon pokemonObjetivo;

    private ControladorPokemon(ModeloBatalla modeloBatalla){
        this.modeloBatalla = modeloBatalla;
    }

    public static ControladorPokemon getMiControladorPokemon(ModeloBatalla modeloBatalla){
        if(miControladorPokemon == null){
            miControladorPokemon = new ControladorPokemon(modeloBatalla);
        }
        return miControladorPokemon;
    }

    public void setVistaPokemon(VistaPokemon vistaPokemon){
        this.vistaPokemon = vistaPokemon;
        vistaPokemon.getBotonAtacar().addActionListener(e -> {
            setAtacante(vistaPokemon.getPokemon());
        });
    }

    public void setAtacante(Pokemon pokemon){
        if(pokemonAtacante == null){
            if(modeloBatalla.getTurno().setAtacante(pokemon)){
                pokemonAtacante = pokemon;
            }
        }
        else if(pokemonAtacante != null && pokemonObjetivo == null){
            modeloBatalla.getTurno().setObjetivo(pokemon);
            pokemonAtacante = null;
        }
    }
}
