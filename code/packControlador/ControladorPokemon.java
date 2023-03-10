package packControlador;

import packModelo.ModeloBatalla;
import packModelo.Pokemon;
import packVista.VistaPokemon;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.module.ModuleDescriptor;

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

    /*public void atacar(){
         pokemonAtacante.atacar(pokemonObjetivo);
         pokemonAtacante = null;
         pokemonObjetivo = null;
    }*/

    public void setAtacante(Pokemon pokemon){
        if(pokemonAtacante == null){
            if(modeloBatalla.getTurno().setAtacante(pokemon)){
                pokemonAtacante = pokemon;
            }
        }
        else if(pokemonAtacante != null && pokemonObjetivo == null){
            modeloBatalla.getTurno().setObjetivo(pokemon);
            pokemonAtacante = null;
            //atacar();
        }
    }
}
