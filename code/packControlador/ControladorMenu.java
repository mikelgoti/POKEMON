package packControlador;
import packModelo.ModeloMenu;
import packVista.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu {
    /**
     * CLASE PARA GESTIONAR=> VistaMenu Y ModeloMenu
     * */
    private static ControladorMenu miControladorMenu;
    private VistaMenu vistaMenu;
    private ModeloMenu modeloMenu;

    /**
     * CONSTRUCTOR DEL ControladorMenu
     * */
    public ControladorMenu(VistaMenu vistaMenu, ModeloMenu modeloMenu) {
        this.vistaMenu = vistaMenu;
        this.modeloMenu = modeloMenu;

           vistaMenu.getBotonInicio().addActionListener(e -> {
               modeloMenu.setNumJugadores(vistaMenu.getTextNumJugadores().getText());
               modeloMenu.setNumBots(vistaMenu.getTextNumBots().getText());
               modeloMenu.setNumPokemons(vistaMenu.getTextNumPokemons().getText());
               modeloMenu.comprobarInputs();
           });
    }

    public static ControladorMenu getMiControladorMenu(VistaMenu vm, ModeloMenu mm){
        if(miControladorMenu == null){
            miControladorMenu = new ControladorMenu(vm, mm);
        }
        return miControladorMenu;
    }


}
