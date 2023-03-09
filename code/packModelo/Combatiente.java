package packModelo;

import java.util.Observable;

public abstract class Combatiente extends Observable {
    public ListaPokemons listaPokemons;
    public int TOTAL_POKEMONS;
    public String nombre;
    public boolean esTurno;

    public Combatiente(int TOTAL_POKEMONS, String nombre, boolean esTurno, ListaPokemons listaPokemons)
    {
        this.listaPokemons = listaPokemons;
        this.TOTAL_POKEMONS = TOTAL_POKEMONS;
        this.nombre = nombre;
        this.esTurno = esTurno;
    }

    @Override
    public String toString() {
        return "Combatiente{" +
                "nombre='" + nombre + '\'' +
                ", esTurno=" + esTurno +
                '}';
    }

    public abstract void atacar();

    public ListaPokemons getListaPokemons() {
        return this.listaPokemons;
    }

    public void setListaPokemons(ListaPokemons listaPokemons) {
        this.listaPokemons = listaPokemons;
    }

    public int getTOTAL_POKEMONS() {
        return TOTAL_POKEMONS;
    }

    public void setTOTAL_POKEMONS(int TOTAL_POKEMONS) {
        this.TOTAL_POKEMONS = TOTAL_POKEMONS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsTurno() {
        return esTurno;
    }

    public void setEsTurno(boolean esTurno) {
        this.esTurno = esTurno;
    }
}
