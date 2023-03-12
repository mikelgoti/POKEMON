package packVista;

import packControlador.ControladorPokemon;
import packModelo.packPokemon.Pokemon;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VistaPokemon implements Observer {
    private Pokemon pokemon;
    private ControladorPokemon controladorPokemon;
    private JLabel labelNombre;
    private JLabel labelTipo;
    private JLabel labelAtaque;
    private JLabel labelDefensa;
    private JLabel labelVida;
    private JButton botonAtacar;

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

        controladorPokemon.setVistaPokemon(this);

        return panelPokemon;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Pokemon){
            if(arg instanceof Integer){
                int vidaDespuesDelAtaque = (int) arg;
                getLabelVida().setText(String.valueOf(vidaDespuesDelAtaque));
            }
        }
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
            labelTipo = new JLabel(String.valueOf(pokemon.getTipo()));
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
