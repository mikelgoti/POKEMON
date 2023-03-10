package packModelo.packPokemon;

import packUtils.InstanciaRandom;

import java.util.Observable;
import java.util.Random;

/**
 * CLASE QUE REPRESENTA UN OBJETO POKEMON
 * */
public class Pokemon extends Observable {

    /**
     * VARIABLES PARA ACOTAR LA CREACION DE ATRIBUTOS
     * */
    private static final int MINIMO_PUNTOS_VIDA = 50;
    private static final int MAXIMO_PUNTOS_VIDA = 100;
    private static final int MINIMO_ATAQUE = 10;
    private static final int MAXIMO_ATAQUE = 50;
    private static final int MINIMO_DEFENSA = 5;
    private static final int MAXIMO_DEFENSA = 30;

    private String nombre;
    private PokemonTipo tipo;
    private int ataque;
    private int defensa;
    private int vida;
    private boolean haAtacado;

    /**
     * CONSTRUCTOR DE LA CLASE POKEMON
     * */
    public Pokemon(String nombre, PokemonTipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = generarAtributo(MINIMO_PUNTOS_VIDA, MAXIMO_PUNTOS_VIDA);
        this.ataque = generarAtributo(MINIMO_ATAQUE, MAXIMO_ATAQUE);
        this.defensa = generarAtributo(MINIMO_DEFENSA, MAXIMO_DEFENSA);

        this.haAtacado = false;
    }

    private int generarAtributo(int minimo, int maximo){
        return InstanciaRandom.getInstanciaRandom().getR().nextInt((maximo - minimo) + 1) + minimo;
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

    public PokemonTipo getTipo() {
        return tipo;
    }

    public void setTipo(PokemonTipo tipo) {
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
