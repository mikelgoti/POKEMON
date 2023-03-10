package packModelo;

import packControlador.ControladorPokemon;
import packVista.VistaCombatiente;

import java.util.Observable;

@SuppressWarnings("deprecated")
public class ModeloBatalla extends Observable {
    private static ModeloBatalla modeloBatalla;
    private ListaCombatientes listaCombatientes;
    private int numJugadores;
    private int numBots;
    private int numPokemons;

    private Turno turno;

    private ModeloBatalla(int numJugadores, int numBots, int numPokemons) {
        this.numJugadores = numJugadores;
        this.numBots = numBots;
        this.numPokemons = numPokemons;

        //GENERAR JUGADORES Y BOTS
        listaCombatientes = ListaCombatientes.getMiListaCombatientes(numJugadores, numBots, numPokemons);

        //Controlador para TODOS LOS POKEMONS
        //ControladorPokemon controladorPokemon = ControladorPokemon.getMiControladorPokemon();
        /*if(c instanceof Jugador){
                Jugador j = (Jugador) c;
                VistaJugador vistaJugador = new VistaJugador(j, controladorPokemon);
            }
            else if(c instanceof  Bot){
                Bot b = (Bot) c;
                VistaJugador vistaBot = new VistaJugador(b, controladorPokemon);
            }*/
    }

    public static ModeloBatalla getModeloBatalla(int numJugadores, int numBots, int numPokemons){
        if(modeloBatalla == null){
            modeloBatalla = new ModeloBatalla(numJugadores, numBots, numPokemons);
        }
        return modeloBatalla;
    }
    public void iniciarBatalla(){
        ControladorPokemon controladorPokemon = ControladorPokemon.getMiControladorPokemon(modeloBatalla);
        for(Combatiente c : listaCombatientes.getListaCombatientes()){
            VistaCombatiente vistaCombatiente = new VistaCombatiente(c, controladorPokemon);
            modeloBatalla.addObserver(vistaCombatiente);
        }
        System.out.println("Iniciando batalla");
        Thread batallaThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int cont = 0;
                // Aquí va la lógica de la batalla
                while(true){
                    Combatiente combatiente = listaCombatientes.asignarTurno();
                    combatiente.esTurno = true;
                    turno = new Turno(combatiente);
                    actualizarObservadores(combatiente);
                    while(!turno.isTurnoTerminado()){
                        //El jugador ataca
                    }
                    combatiente.esTurno = false;
                    actualizarObservadores(combatiente);
                }
            }
        });
        batallaThread.start();
    }

    public void setTurnoAtacanteObjetivo(){

    }

    public void actualizarObservadores(Combatiente combatiente){
        setChanged();
        notifyObservers(combatiente);
    }

    public Turno getTurno(){
        return this.turno;
    }
}
