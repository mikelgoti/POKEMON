package packVista;
import packControlador.ControladorPokemon;
import packModelo.Combatiente;
import packModelo.ModeloBatalla;
import packModelo.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VistaCombatiente implements Observer {

    private Combatiente combatiente;
    private JLabel labelJugador;
    private JFrame frame;
    public VistaCombatiente(Combatiente combatiente, ControladorPokemon controladorPokemon)
    {
        this.combatiente = combatiente;

        frame = new JFrame();
        frame.setTitle("COMBATIENTE");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelCombatiente = new JPanel();
        panelCombatiente.setLayout(new BorderLayout());
        panelCombatiente.add(getLabelJugador());

        JPanel panelPokemons = new JPanel(new FlowLayout());

        for (Pokemon p : VistaCombatiente.this.combatiente.getListaPokemons().obtenerListaPokemons()) {
            VistaPokemon vistaPokemon = new VistaPokemon(p, controladorPokemon);
            p.addObserver(vistaPokemon);

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

    @SuppressWarnings("deprecated")
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ModeloBatalla){
            if(arg instanceof Combatiente){
                Combatiente c = (Combatiente) arg;
                if(c.equals(this.combatiente)){
                    if(c.esTurno){
                        this.frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.RED));
                    }
                    else{
                        this.frame.getRootPane().setBorder(BorderFactory.createEmptyBorder());
                    }
                }
            }
        }
    }
}
