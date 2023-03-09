package packVista;
import packControlador.ControladorPokemon;
import packModelo.Combatiente;
import packModelo.Jugador;
import packModelo.Pokemon;

import javax.swing.*;
import java.awt.*;

public class VistaJugador {

    private Combatiente combatiente;
    private JLabel labelJugador;
    public VistaJugador(Combatiente combatiente, ControladorPokemon controladorPokemon)
    {
        this.combatiente = combatiente;

        JFrame frame = new JFrame();
        frame.setTitle("COMBATIENTE");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelCombatiente = new JPanel();
        panelCombatiente.setLayout(new BorderLayout());
        panelCombatiente.add(getLabelJugador());

        JPanel panelPokemons = new JPanel(new FlowLayout());

        for (Pokemon p : VistaJugador.this.combatiente.getListaPokemons().obtenerListaPokemons()) {
            VistaPokemon vistaPokemon = new VistaPokemon(p, controladorPokemon);
            JPanel panelPokemon = vistaPokemon.crearPanelPokemon();
            panelPokemons.add(panelPokemon);
        }

        frame.setLayout(new BorderLayout());
        frame.add(panelCombatiente,BorderLayout.WEST);
        frame.add(panelPokemons,BorderLayout.CENTER);

        frame.setVisible(true);
    }
    public JLabel getLabelJugador(){
        if(labelJugador == null){
            labelJugador = new JLabel(combatiente.getNombre());
            //MODIFICACION DE LA INTERFAZ GRAFICA DEL JUGADOR
        }
        return labelJugador;
    }

}
