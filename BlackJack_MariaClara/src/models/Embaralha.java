package models;

import java.util.ArrayList;
import java.util.Collections;

public class Embaralha {
    private static final Embaralha embaralhador = new Embaralha();

    private Embaralha() {
        //Para não haver novas instancias
    }

    public static Embaralha getEmbaralhador() {
        return embaralhador;
    }

    public void embaralhar(ArrayList<Carta> baralho) {
        Collections.shuffle(baralho);
    }
}

 // Padrão Singleton, método de embaralha só será chamado uma unica vez, portanto terá uma única instancia

