package packModelo;

public class Turno {
    private Combatiente combatiente;
    private Pokemon atacante;
    private Pokemon objetivo;
    private boolean turnoTerminado;
    private boolean hanAtacadoTodos;
    private ModeloBatalla modeloBatalla;

    /**
     * CONSTRUCTOR DE TURNO
     * */
    public Turno(Combatiente combatiente, ModeloBatalla modeloBatalla)
    {
        this.combatiente = combatiente;
        turnoTerminado = false;
        hanAtacadoTodos = false;
        this.modeloBatalla = modeloBatalla;
    }

    /**
     * Si hay atacante se ataca.
     * Despues de atacar se comprueba si todos los pokemons del combatiente del turno han atacado.
     * Si no han atacado todos no se cambia de turno.
     * Si han atacado todos sus pokemons se cambia de turno.
     * */
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
                modeloBatalla.setVariable(true);
            }
        }
        atacante = null;
        objetivo = null;
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
    public void setObjetivo(Pokemon objetivo) {
        this.objetivo = objetivo;
        atacar();
    }
    public boolean isTurnoTerminado() {
        return turnoTerminado;
    }

    public void setTurnoTerminado(boolean turnoTerminado){
        this.turnoTerminado = turnoTerminado;
    }
}
