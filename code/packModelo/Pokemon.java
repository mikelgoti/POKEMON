package packModelo;

import java.util.Observable;

public class Pokemon extends Observable {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private int vida;
    private boolean haAtacado;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
        this.haAtacado = false;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", vida=" + vida +
                '}';
    }

    public void atacar(Pokemon pokemon){
        System.out.println("");
        System.out.println(this.nombre+" con "+this.getAtaque()+" ataque esta atacando a "+pokemon.nombre+" con "+pokemon.getVida()+" de vida");
        pokemon.setVida(pokemon.getVida()-this.ataque);
        System.out.println("Despues del ataque "+pokemon.nombre+" tiene "+pokemon.getVida()+ " vida");
        this.setHaAtacado(true);

        pokemon.actualizarVista();
    }

    public void recibirAtaque(Pokemon pokemon){
        
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
