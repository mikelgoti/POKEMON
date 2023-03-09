package packModelo;

import java.util.ArrayList;
import java.util.Random;

public class ListaCombatientes {
    private static ListaCombatientes miListaCombatientes;
    private ArrayList<Combatiente> listaCombatientes;
    private ColeccionJugadores coleccionJugadores;

    private ListaCombatientes(int numJugadores, int numBots, int numPokemons)
    {
        listaCombatientes = new ArrayList<>();
        coleccionJugadores = new ColeccionJugadores();

        for(int ite = 0 ; ite < numJugadores ; ite++){
            ListaPokemons listaP = new ListaPokemons();
            Jugador jugador = new Jugador(numPokemons, coleccionJugadores.obtenerNombre(),false, );
        }
    }

    public static ListaCombatientes getMiListaCombatientes(int numJugadores, int numBots, int numPokemons){
        if(miListaCombatientes == null){
            miListaCombatientes = new ListaCombatientes(numJugadores, numBots, numPokemons);
        }
        return miListaCombatientes;
    }

    public void agregarCombatiente(){

    }
    public void eliminarCombatiente(){

    }

}
