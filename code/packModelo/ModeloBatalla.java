package packModelo;

import packControlador.ControladorPokemon;
import packVista.VistaJugador;

public class ModeloBatalla {
    private static ModeloBatalla modeloBatalla;
    private ListaCombatientes listaCombatientes;
    private int numJugadores;
    private int numBots;
    private int numPokemons;

    private ModeloBatalla(int numJugadores, int numBots, int numPokemons) {
        this.numJugadores = numJugadores;
        this.numBots = numBots;
        this.numPokemons = numPokemons;

        //GENERAR JUGADORES Y BOTS
        listaCombatientes = ListaCombatientes.getMiListaCombatientes(numJugadores, numBots, numPokemons);
        //System.out.println(listaCombatientes.verCombatientes());

        //Controlador para TODOS LOS POKEMONS
        ControladorPokemon controladorPokemon = ControladorPokemon.getMiControladorPokemon();

        //GENERAR SUS VENTANAS
        for(Combatiente c : listaCombatientes.getListaCombatientes()){
            if(c instanceof Jugador){
                Jugador j = (Jugador) c;
                VistaJugador vistaJugador = new VistaJugador(j, controladorPokemon);
            }
            else if(c instanceof  Bot){
                Bot b = (Bot) c;
                VistaJugador vistaBot = new VistaJugador(b, controladorPokemon);
            }
        }
    }

    public static ModeloBatalla getModeloBatalla(int numJugadores, int numBots, int numPokemons){
        if(modeloBatalla == null){
            modeloBatalla = new ModeloBatalla(numJugadores, numBots, numPokemons);
        }
        return modeloBatalla;
    }
    public void iniciarBatalla(){
        System.out.println("La batalla se a iniciado");
        //CICLO DEL JUEGO
        /*while(pokemonsVivos){

        }*/
    }

}
