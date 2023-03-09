package packModelo;

public abstract class Combatiente {
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

    public abstract void atacar();

    public ListaPokemons getListaCombatientes() {
        return this.listaPokemons;
    }

    public void setListaCombatientes(ListaPokemons listaPokemons) {
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
