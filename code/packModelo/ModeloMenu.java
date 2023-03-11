package packModelo;
import java.util.Observable;

public class ModeloMenu extends Observable{

    /**
     * VARIABLES DE CLASE
     * */
    private int numJugadores;
    private boolean jugadoresBien = true;
    private int numBots;
    private boolean botsBien = true;
    private int numPokemons;
    private boolean pokemonsBien = true;
    public ModeloMenu() {}

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
    public void comprobarInputs(){
        if(jugadoresBien && botsBien && pokemonsBien){
            ModeloBatalla modeloBatalla = ModeloBatalla.getModeloBatalla(numJugadores, numBots, numPokemons);
            setChanged();
            notifyObservers();
            modeloBatalla.iniciarBatalla();
        }
        else{
            setChanged();
            notifyObservers(new boolean[]{jugadoresBien, botsBien, pokemonsBien});
        }
    }

    /**
     * SETTERS
     * */
    public void setNumJugadores(String numJugadores) {
        this.numJugadores = obtenerEntero(numJugadores);
        this.jugadoresBien = this.numJugadores > -1 && this.numJugadores <= 6 ? true : false;
    }
    public void setNumBots(String numBots) {
        this.numBots = obtenerEntero(numBots);
        this.botsBien = this.numBots > -1 && this.numBots <= 6 ? true : false;
    }
    public void setNumPokemons(String numPokemons) {
        this.numPokemons = obtenerEntero(numPokemons);
        this.pokemonsBien = this.numPokemons > -1 && this.numPokemons <= 6 ? true : false;
    }

}
