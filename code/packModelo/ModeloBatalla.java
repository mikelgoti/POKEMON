package packModelo;
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

        listaCombatientes = ListaCombatientes.getMiListaCombatientes(numJugadores, numBots, numPokemons);
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
