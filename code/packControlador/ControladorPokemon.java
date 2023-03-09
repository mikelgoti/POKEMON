package packControlador;

import packModelo.Pokemon;

import javax.naming.ldap.Control;
import javax.swing.*;

public class ControladorPokemon {

    private static ControladorPokemon miControladorPokemon;

    private ControladorPokemon(){}

    public static ControladorPokemon getMiControladorPokemon(){
        if(miControladorPokemon == null){
            miControladorPokemon = new ControladorPokemon();
        }
        return miControladorPokemon;
    }

    public void atacar(Pokemon pokemon){
        System.out.println("El pokemon "+pokemon.getNombre()+" ha sido seleccionado para atacar.");

    }
}
