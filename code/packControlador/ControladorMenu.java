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
     * CONSTRUCTOR DEL CONTROLADOR PARA EL MENU
     * */
    public ControladorMenu() {
        this.vistaMenu = VistaMenu.getVistaMenu();
        this.modeloMenu = ModeloMenu.getMiModeloMenu();

           vistaMenu.getBotonInicio().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*System.out.printf("Jugadores: %s\n" +
                            "Bots: %s\n" +
                            "Pokemons: %s",j,b,p);*/
                    ModeloMenu menu = ModeloMenu.getMiModeloMenu();
                    menu.setNumJugadores(vistaMenu.getTextNumJugadores().getText());
                    menu.setNumBots(vistaMenu.getTextNumBots().getText());
                    menu.setNumPokemons(vistaMenu.getTextNumPokemons().getText());
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
