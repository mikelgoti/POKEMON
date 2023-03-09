package packModelo;
import java.util.Observable;

public class ModeloMenu extends Observable{

    /**
     * VARIABLES DE CLASE
     * */
    private static ModeloMenu miModeloMenu = null;
    private int numJugadores;
    private boolean jugadoresBien = true;
    private int numBots;
    private boolean botsBien = true;
    private int numPokemons;
    private boolean pokemonsBien = true;
    private boolean datosCorrectos = true;

    /**
     * CONSTRUCTOR PRIVADO => PATRON SINGLETON
     * */
    private ModeloMenu() {}

    /**
     * METODOS PRIVADOS
     * */
    private int obtenerEntero(String s){
        try{
            int value = Integer.parseInt(s);
            if(value > 0){
                return value;
            }
            else{
                return 0;
            }
        }catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * METODOS PUBLICOS
     * */

    /**
     * Metodo para crear una unica instancia si no se a creado y obtenerla.
     * */
    public static ModeloMenu getMiModeloMenu()
    {
        if(miModeloMenu == null){
            miModeloMenu = new ModeloMenu();
        }
        return miModeloMenu;
    }
    public void comprobarInputs(){
        if(jugadoresBien && botsBien && pokemonsBien){
            ModeloBatalla batalla = ModeloBatalla.getModeloBatalla(numJugadores, numBots, numPokemons);
            setChanged();
            notifyObservers();
            //batalla.iniciarBatalla();
        }
        else{
            setChanged();
            notifyObservers(new boolean[]{jugadoresBien, botsBien, pokemonsBien});
        }
    }

    /**
     * GETTERS & SETTERS
     * */
    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(String numJugadores) {
        this.numJugadores = obtenerEntero(numJugadores);
        this.jugadoresBien = this.numJugadores > 0 && this.numJugadores <= 6 ? true : false;
    }

    public int getNumBots() {
        return numBots;
    }

    public void setNumBots(String numBots) {
        this.numBots = obtenerEntero(numBots);
        this.botsBien = this.numBots > 0 && this.numBots <= 6 ? true : false;
    }

    public int getNumPokemons() {
        return numPokemons;
    }

    public void setNumPokemons(String numPokemons) {
        this.numPokemons = obtenerEntero(numPokemons);
        this.pokemonsBien = this.numPokemons > 0 && this.numPokemons <= 6 ? true : false;
    }
}
