package packModelo;

import java.util.Observable;

public class Pokemon extends Observable {

    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private int vida;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
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

    }

    public void recibirAtaque(Pokemon pokemon){
        
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
}
