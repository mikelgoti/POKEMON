package packModelo;

import packControlador.ControladorPokemon;
import packVista.VistaCombatiente;

import java.util.Observable;
public class ModeloBatalla extends Observable {
    private static ModeloBatalla modeloBatalla;
    private ListaCombatientes listaCombatientes;
    private boolean variable;
    private Turno turno;
    private ModeloBatalla(int numJugadores, int numBots, int numPokemons) {
        //GENERAR JUGADORES Y BOTS
        listaCombatientes = ListaCombatientes.getMiListaCombatientes(numJugadores, numBots, numPokemons);
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
            c.addObserver(vistaCombatiente);
        }
        System.out.println("Iniciando batalla");
        Thread batallaThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Aquí va la lógica de la batalla
                while(true){
                    Combatiente combatiente = listaCombatientes.asignarTurno();
                    System.out.println("Es el turno de: "+combatiente.getNombre());
                    combatiente.setEsTurno(true);
                    turno = new Turno(combatiente, modeloBatalla);
                    combatiente.actualizarVista();
                    while(!variable){
                        try{Thread.sleep(500);}catch (Exception e){};
                    }
                    variable = false;
                    combatiente.setEsTurno(false);
                    System.out.println("El turno de "+combatiente.getNombre()+" acaba.");
                    combatiente.actualizarVista();
                }
            }
        });
        batallaThread.start();
    }
    public void setVariable(boolean variable) {
        this.variable = variable;
    }

    public Turno getTurno(){
        return this.turno;
    }
}

