package packModelo;

public class Turno {

    private Combatiente combatiente;
    private Pokemon atacante;
    private Pokemon objetivo;
    private boolean turnoTerminado;
    private int totalPokemons;

    private boolean hanAtacadoTodos;

    public Turno(Combatiente combatiente)
    {
        this.combatiente = combatiente;
        turnoTerminado = false;
        hanAtacadoTodos = false;

        this.totalPokemons = this.combatiente.getListaPokemons().obtenerListaPokemons().length;

    }

    public void atacar(){
        if(atacante != null){
            atacante.atacar(objetivo);
            for(Pokemon p : combatiente.getListaPokemons().obtenerListaPokemons()){
                if(p.getHaAtacado()){
                    hanAtacadoTodos = true;
                }
                else{
                    hanAtacadoTodos = false;
                }
            }
            if(hanAtacadoTodos){
                //Al finalizar el turno reiniciamos los ataques de los pokemons.
                for(Pokemon p : combatiente.getListaPokemons().obtenerListaPokemons()){
                    p.setHaAtacado(false);
                }
                this.turnoTerminado = true;
            }
        }
        atacante = null;
        objetivo = null;
    }


    public Combatiente getCombatiente() {
        return combatiente;
    }

    public void setCombatiente(Combatiente combatiente) {
        this.combatiente = combatiente;
    }

    public Pokemon getAtacante() {
        return atacante;
    }
    public boolean setAtacante(Pokemon pokemon) {
        if(!pokemon.getHaAtacado()){
            atacante = pokemon;
            return true;
        }
        else{
            System.out.println("Ya a atacado");
            return false;
        }
    }

    public Pokemon getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Pokemon objetivo) {
        this.objetivo = objetivo;
        atacar();
    }

    public boolean isTurnoTerminado() {
        return turnoTerminado;
    }

    public void setTurnoTerminado(boolean turnoTerminado) {
        this.turnoTerminado = turnoTerminado;
    }
}
