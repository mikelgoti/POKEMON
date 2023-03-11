import packControlador.ControladorMenu;
import packModelo.ModeloMenu;
import packVista.VistaMenu;

public class Main {
    public static void main(String[] args) {
        ModeloMenu mm = new ModeloMenu();

        VistaMenu vm = new VistaMenu();

        ControladorMenu.getMiControladorMenu(vm, mm);

        mm.addObserver(vm);

    }
}