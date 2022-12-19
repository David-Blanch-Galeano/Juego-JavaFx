package juego;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class observableAux {
    
    protected static ObservableList<infoJugador> aux;
    
    public static void inicializar() {
        aux = FXCollections.observableArrayList();
    }

    public static void add(infoJugador stats) {
        aux.add(stats);
    }
    
    protected static ObservableList getAux(){
        return aux;
    }
    
}
