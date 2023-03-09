package packVista;

import packControlador.ControladorPokemon;
import packModelo.Pokemon;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPokemon {
    private Pokemon pokemon;

    private ControladorPokemon controladorPokemon;

    private JLabel labelNombre;
    private JLabel labelTipo;
    private JLabel labelAtaque;
    private JLabel labelDefensa;
    private JLabel labelVida;

    private JButton botonAtacar;

    private Pokemon pokemonAtacante;

    private Pokemon pokemonObjetivo;

    public VistaPokemon(Pokemon pokemon, ControladorPokemon controladorPokemon)
    {
        this.pokemon = pokemon;
        this.controladorPokemon = controladorPokemon;
    }

    public JPanel crearPanelPokemon(){
        JPanel panelPokemon = new JPanel(new GridLayout(6,1));

        panelPokemon.add(getLabelNombre());
        panelPokemon.add(getLabelTipo());
        panelPokemon.add(getLabelAtaque());
        panelPokemon.add(getLabelDefensa());
        panelPokemon.add(getLabelVida());
        panelPokemon.add(getBotonAtacar());

        getBotonAtacar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pokemonAtacante = getBotonAtacar()
            }
        });

        return panelPokemon;
    }

    /**
     * COMPONENTES DE LA INTERFZ GRAFICA DEL POKEMON
     * */
    public JLabel getLabelNombre(){
        if(labelNombre == null){
            labelNombre = new JLabel(pokemon.getNombre());
            //MODIFICACION DE LA INTERFAZ GRAFICA DEL POKEMON
        }
        return labelNombre;
    }

    public JLabel getLabelTipo(){
        if(labelTipo == null){
            labelTipo = new JLabel(pokemon.getTipo());
            //MODIFICACION DE LA INTERFAZ GRAFICA DEL POKEMON
        }
        return labelTipo;
    }

    public JLabel getLabelAtaque(){
        if(labelAtaque == null){
            labelAtaque = new JLabel(String.valueOf(pokemon.getAtaque()));
            //MODIFICACION DE LA INTERFAZ GRAFICA DEL POKEMON
        }
        return labelAtaque;
    }

    public JLabel getLabelDefensa(){
        if(labelDefensa == null){
            labelDefensa = new JLabel(String.valueOf(pokemon.getDefensa()));
            //MODIFICACION DE LA INTERFAZ GRAFICA DEL POKEMON
        }
        return labelDefensa;
    }

    public JLabel getLabelVida(){
        if(labelVida == null){
            labelVida = new JLabel(String.valueOf(pokemon.getVida()));
            //MODIFICACION DE LA INTERFAZ GRAFICA DEL POKEMON
        }
        return labelVida;
    }

    public JButton getBotonAtacar(){
        if(botonAtacar == null){
            botonAtacar = new JButton("Atacar");
        }
        return botonAtacar;
    }
    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
