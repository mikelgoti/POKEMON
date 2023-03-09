package packModelo;

import java.util.ArrayList;
import java.util.Random;

public class ListaCombatientes {
    private static ListaCombatientes miListaCombatientes = null;
    private Combatiente listaCombatientes [];
    private ColeccionJugadores coleccionJugadores;
    private static int TOTAL_COMBATIENTES = 0;

    private ListaCombatientes(int numJugadores, int numBots, int numPokemons)
    {
        int cont = 0;
        TOTAL_COMBATIENTES = numJugadores + numBots;
        listaCombatientes = new Combatiente[TOTAL_COMBATIENTES];
        coleccionJugadores = new ColeccionJugadores();

        //JUGADORES
        for(int ite = 0 ; ite < numJugadores ; ite++){
            ListaPokemons listaP = new ListaPokemons(numPokemons);
            Jugador jugador = new Jugador(numPokemons, coleccionJugadores.obtenerNombre(),false, listaP);
            listaCombatientes[cont++] = jugador;
        }

        //BOTS
        for(int ite = 0 ; ite < numBots ; ite++){
            ListaPokemons listaP = new ListaPokemons(numPokemons);
            Bot bot = new Bot(numPokemons, "bot"+(ite+1),false, listaP);
            listaCombatientes[cont++] = bot;
        }
    }
    public static ListaCombatientes getMiListaCombatientes(int numJugadores, int numBots, int numPokemons){
        if(miListaCombatientes == null){
            miListaCombatientes = new ListaCombatientes(numJugadores, numBots, numPokemons);
        }
        return miListaCombatientes;
    }

    public Combatiente[] getListaCombatientes(){
        return this.listaCombatientes;
    }

    public String verCombatientes() {
        StringBuilder sb = new StringBuilder();
        sb.append("LISTA COMBATIENTES\n")
                .append("------------------\n\n");

        for(Combatiente c : listaCombatientes) {
            if(c instanceof Jugador){
                Jugador j = (Jugador) c;
                sb.append(j.toString()).append("\n");
                for (Pokemon p : j.listaPokemons.obtenerListaPokemons()) {
                    sb.append(p.toString()).append("\n");
                }
                sb.append("\n");
            } else if(c instanceof Bot) {
                Bot b = (Bot) c;
                sb.append(b.toString()).append("\n");
                for (Pokemon p : b.listaPokemons.obtenerListaPokemons()) {
                    sb.append(p.toString()).append("\n");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void agregarCombatiente(){

    }
    public void eliminarCombatiente(){

    }
    public Combatiente obtenerCombatiente(){
        Random r = new Random();
        return listaCombatientes[r.nextInt(TOTAL_COMBATIENTES)];
    }
}
