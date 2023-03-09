package packModelo;

import packControlador.ControladorPokemon;
import packVista.VistaJugador;

import java.util.Scanner;

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

        //Controlador para TODOS LOS POKEMONS
        ControladorPokemon controladorPokemon = ControladorPokemon.getMiControladorPokemon();
        /*if(c instanceof Jugador){
                Jugador j = (Jugador) c;
                VistaJugador vistaJugador = new VistaJugador(j, controladorPokemon);
            }
            else if(c instanceof  Bot){
                Bot b = (Bot) c;
                VistaJugador vistaBot = new VistaJugador(b, controladorPokemon);
            }*/

        //GENERAR SUS VENTANAS
        for(Combatiente c : listaCombatientes.getListaCombatientes()){
            VistaJugador vistaJugador = new VistaJugador(c, controladorPokemon);
        }
    }

    public static ModeloBatalla getModeloBatalla(int numJugadores, int numBots, int numPokemons){
        if(modeloBatalla == null){
            modeloBatalla = new ModeloBatalla(numJugadores, numBots, numPokemons);
        }
        return modeloBatalla;
    }
    public void iniciarBatalla(){
        System.out.println("Iniciando batalla");
        Thread batallaThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int cont = 0;
                // Aquí va la lógica de la batalla
                while(true){
                    Combatiente combatiente = listaCombatientes.asignarTurno();
                    System.out.println(combatiente);
                    new Scanner(System.in).next();
                }
            }
        });
        batallaThread.start();
    }
}
