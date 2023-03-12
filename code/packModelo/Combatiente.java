package packModelo;

import packModelo.packPokemon.Pokemon;

import java.util.Observable;

/**
 * SUPERCLASE PARA REPRESENTAR A UN COMBATIENTE.
 * Los combatientes pueden ser jugadores o bots.
 * Los atributos son provisionales hay que definir unos mejores.
 */
public abstract class Combatiente extends Observable {
    private Pokemon listaPokemon [];
    private int TOTAL_POKEMONS;
    private String nombre;
    private boolean esTurno;

    /**
     * CONSTRUCTOR DE LA SUPERCLASE
     * */
    public Combatiente(int TOTAL_POKEMONS, String nombre, boolean esTurno, Pokemon listaPokemon [])
    {
        this.listaPokemon = listaPokemon;
        this.TOTAL_POKEMONS = TOTAL_POKEMONS;
        this.nombre = nombre;
        this.esTurno = esTurno;
    }
    public abstract void atacar();

    /**
     * Aqui se podria definir otro metodo abstracto que se llame actualizar vista del combatiente.
     * */
    public void actualizarVista(){
        setChanged();
        notifyObservers(esTurno);
    }

    public Pokemon [] getListaPokemons() {
        return this.listaPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEsTurno(boolean esTurno) {
        this.esTurno = esTurno;
    }
}
