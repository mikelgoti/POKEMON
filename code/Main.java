import packControlador.ControladorMenu;
import packModelo.ModeloMenu;
import packVista.VistaMenu;

public class Main {

    public static void main(String[] args) {
        ModeloMenu mm = ModeloMenu.getMiModeloMenu();

        VistaMenu vm = VistaMenu.getVistaMenu();

        ControladorMenu cm = ControladorMenu.getMiControladorMenu();

        mm.addObserver(vm);

    }
}