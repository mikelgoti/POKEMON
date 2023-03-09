package packControlador;
import packModelo.ModeloMenu;
import packVista.VistaMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu {

    /**
     * INSTANCIAS DEL MODELO MVC => VISTA Y MODELO
     * */
    private static ControladorMenu miControladorMenu;
    private static VistaMenu vistaMenu;
    private static ModeloMenu modeloMenu;

    /**
     * Elementos de la interfaz grafica
     * */
    private JLabel labelJugadores;
    private JTextField textNumJugadores;
    private JLabel labelBots;
    private JTextField  textNumBots;
    private JLabel labelPokemons;
    private JTextField  textNumPokemons;
    private JButton botonInicio;

    /**
     * CONSTRUCTOR DEL CONTROLADOR PARA EL MENU
     * */
    public ControladorMenu() {
        this.vistaMenu = VistaMenu.getVistaMenu();
        this.modeloMenu = ModeloMenu.getMiModeloMenu();

        this.labelJugadores = vistaMenu.getLabelJugadores();
        this.textNumJugadores = vistaMenu.getTextNumJugadores();
        this.labelBots = vistaMenu.getLabelBots();
        this.textNumBots = vistaMenu.getTextNumBots();
        this.labelPokemons = vistaMenu.getLabelPokemons();
        this.textNumPokemons = vistaMenu.getTextNumPokemons();
        this.botonInicio = vistaMenu.getBotonInicio();

           botonInicio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*System.out.printf("Jugadores: %s\n" +
                            "Bots: %s\n" +
                            "Pokemons: %s",j,b,p);*/
                    ModeloMenu menu = ModeloMenu.getMiModeloMenu();
                    menu.setNumJugadores(textNumJugadores.getText());
                    menu.setNumBots(textNumBots.getText());
                    menu.setNumPokemons(textNumPokemons.getText());
                    menu.comprobarInputs();
                }
            });
    }

    public static ControladorMenu getMiControladorMenu(){
        if(miControladorMenu == null){
            miControladorMenu = new ControladorMenu();
        }
        return miControladorMenu;
    }


}
