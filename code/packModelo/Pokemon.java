package packModelo;

import java.util.Observable;

/**
 * CLASE QUE REPRESENTA UN OBJETO POKEMON
 * */
public class Pokemon extends Observable {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private int vida;
    private boolean haAtacado;

    /**
     * CONSTRUCTOR DE LA CLASE POKEMON
     * */
    public Pokemon(String nombre, String tipo, int ataque, int defensa, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
        this.haAtacado = false;
    }

    /**
     * METODO ATACAR
     * El pokemon de esta instancia ataca al pokemon que se recibe como parametro.
     * Al atacar se resta la vida del pokemon que a sido atacado.
     * El pokemon atacante se asigna como que ya a atacado.
     * y se actualiza la vista del pokemon atacado.
     * */
    public void atacar(Pokemon pokemon){
        //System.out.println(this.nombre+" con "+this.getAtaque()+" ataque esta atacando a "+pokemon.nombre+" con "+pokemon.getVida()+" de vida");
        pokemon.setVida(pokemon.getVida()-this.ataque);
        //System.out.println("Despues del ataque "+pokemon.nombre+" tiene "+pokemon.getVida()+ " vida");
        this.setHaAtacado(true);

        pokemon.actualizarVista();
    }
    public void actualizarVista(){
        setChanged();
        notifyObservers(getVida());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean getHaAtacado() {
        return haAtacado;
    }

    public void setHaAtacado(boolean haAtacado) {
        this.haAtacado = haAtacado;
    }
}
