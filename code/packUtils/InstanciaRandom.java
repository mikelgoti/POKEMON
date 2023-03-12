package packUtils;

import java.util.Random;

public class InstanciaRandom {
    private static InstanciaRandom miInstanciaRandom;
    private static final Random r = new Random();

    private InstanciaRandom(){}

    public static InstanciaRandom getInstanciaRandom(){
        if(miInstanciaRandom == null){
            miInstanciaRandom = new InstanciaRandom();
        }
        return miInstanciaRandom;
    }

    public Random getR(){
        return r;
    }
}
