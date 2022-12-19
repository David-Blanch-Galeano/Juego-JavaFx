package juego;

import Personaje.Personaje;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SeleccionCampeon implements Initializable {
    
    public static String nombre1 = "", nombre2 = "";
    
    @FXML
    private ImageView ace;

    @FXML
    private ImageView aokiji;

    @FXML
    private Label ataqueDerecha;

    @FXML
    private Label ataqueIzquierda;

    @FXML
    private ImageView brook;

    @FXML
    private Label criticoDerecha;

    @FXML
    private Label criticoIzquierda;

    @FXML
    private Label defensaDerecha;

    @FXML
    private Label defensaIzquierda;

    @FXML
    private ImageView doffy;

    @FXML
    private ImageView enel;

    @FXML
    private Label evasionDerecha;

    @FXML
    private Label evasionIzquierda;

    @FXML
    private ImageView luffy;

    @FXML
    private ImageView marco;

    @FXML
    private ImageView mihawk;

    @FXML
    private Label nombreDerecha;

    @FXML
    private Label nombreIzquierda;

    @FXML
    private Button pelea;

    @FXML
    private ImageView personaje1;

    @FXML
    private ImageView personaje2;

    @FXML
    private ImageView sanji;

    @FXML
    private Button selcecion1;

    @FXML
    private Label vidaDerecha;

    @FXML
    private Label vidaIzquierda;

    @FXML
    private ImageView zoro;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    protected Personaje eleccion1, eleccion2;

    //MediaPlayer mediaPlayer;
    
    boolean seleccion = false, seleccionadoIzquierdo = false, seleccionadoDerecha = false;

    protected static ArrayList<Personaje> listaPersonajes = new ArrayList<Personaje>();

    void anadirPersonajes() {
        // nombre, vida, daño, evasion, probCritico, defensa
        listaPersonajes.add(new Personaje("Aokiji", 700, 20, 5, 45, 100));
        listaPersonajes.add(new Personaje("Brook", 650, 30, 10, 40, 10));
        listaPersonajes.add(new Personaje("Ace", 675, 30, 20, 30, 25));
        listaPersonajes.add(new Personaje("Doffy", 665, 40, 5, 30, 25));
        listaPersonajes.add(new Personaje("Enel", 620, 45, 25, 35, 25));
        listaPersonajes.add(new Personaje("Luffy", 700, 25, 15, 20, 10));
        listaPersonajes.add(new Personaje("Sanji", 675, 25, 25, 30, 50));
        listaPersonajes.add(new Personaje("Zoro", 750, 25, 25, 30, 50));
    }

    @FXML
    void seleccionar(ActionEvent event) {
        if (event.getSource().equals(selcecion1) && seleccion == false) {
            seleccion = true;
            seleccionadoIzquierdo = false;
            selcecion1.setText("Selecciona el PJ 2 >>");
        } else if (event.getSource().equals(selcecion1) && seleccion == true) {
            seleccion = false;
            seleccionadoDerecha = false;
            selcecion1.setText("<< Selecciona el PJ 1");
        }
    }

    @FXML
    void hovered(MouseEvent event) {
        if (seleccion == false) {
            if (seleccionadoIzquierdo == false) {
                cambiarImagen(event, eleccion1, personaje1, nombreDerecha, ataqueDerecha, vidaDerecha, evasionDerecha, criticoDerecha, defensaDerecha);
            }
        } else if (seleccion == true) {
            if (seleccionadoDerecha == false) {
                cambiarImagen(event, eleccion2, personaje2, nombreIzquierda, ataqueIzquierda, vidaIzquierda, evasionIzquierda, criticoIzquierda, defensaIzquierda);
            }
        }
    }

    @FXML
    void hoverent(MouseEvent event) {
        if (seleccion == false) {
            if (seleccionadoIzquierdo == false) {
                quitarDatos(personaje1, nombreDerecha, ataqueDerecha, vidaDerecha, evasionDerecha, criticoDerecha, defensaDerecha);
            }
        } else if (seleccion == true) {
            if (seleccionadoDerecha == false) {
                quitarDatos(personaje2, nombreIzquierda, ataqueIzquierda, vidaIzquierda, evasionIzquierda, criticoIzquierda, defensaIzquierda);
            }
        }
    }
    
    void quitarDatos(ImageView personaje, Label nombre, Label ataque, Label vida, Label evasion, Label critico, Label defensa){
        personaje.setImage(null);
        nombre.setText("");
        ataque.setText("");
        vida.setText("");
        evasion.setText("");
        critico.setText("");
        defensa.setText("");
    }

    @FXML
    void cambiar(MouseEvent event) {
        if (seleccion == false) {
            cambiarImagen(event, eleccion1, personaje1, nombreDerecha, ataqueDerecha, vidaDerecha, evasionDerecha, criticoDerecha, defensaDerecha);
            cambiarCara(event);
            nombre1 = getPersonaje(nombreDerecha.getText());
            seleccionadoIzquierdo = true;
        } else if (seleccion == true) {
            cambiarImagen(event, eleccion2, personaje2, nombreIzquierda, ataqueIzquierda, vidaIzquierda, evasionIzquierda, criticoIzquierda, defensaIzquierda);
            cambiarCara(event);
            nombre2 = getPersonaje(nombreIzquierda.getText());
            seleccionadoDerecha = true;
        }
    }

    protected void datosPersonaje(String nombre, Personaje eleccion, Label ataque, Label vida, Label evasion, Label critico, Label defensa) {
        for (Personaje i : listaPersonajes) {
            if (i.getNombre().equals(nombre)) {
                ataque.setText("Ataque: " + i.getDanio());
                vida.setText("Vida: " + i.getVida());
                evasion.setText("Evasion: " + i.getEvasion() + "%");
                critico.setText("Critico: " + i.getProbCritico() + "%");
                defensa.setText("Defensa: " + i.getDefensa());
            }
        }
    }
    
    protected void disable(MouseEvent event, ImageView seleccion){
        if (!seleccion.equals(aokiji)) {
            aokiji.setImage(new Image("juego/One Piece/Cara/Aokiji.png"));
        }
        if (!seleccion.equals(brook)) {
            brook.setImage(new Image("juego/One Piece/Cara/Brook.png"));
        }
        if (!seleccion.equals(ace)) {
            ace.setImage(new Image("juego/One Piece/Cara/Ace.png"));
        }
        if (!seleccion.equals(doffy)) {
            doffy.setImage(new Image("juego/One Piece/Cara/Doffy.png"));
        }
        if (!seleccion.equals(enel)) {
            enel.setImage(new Image("juego/One Piece/Cara/Enel.png"));
        }
        if (!seleccion.equals(luffy)) {
            luffy.setImage(new Image("juego/One Piece/Cara/Luffy.png"));
        }
        if (!seleccion.equals(sanji)) {
           sanji.setImage(new Image("juego/One Piece/Cara/Sanji.png"));
        }
        if (!seleccion.equals(zoro)) {
           zoro.setImage(new Image("juego/One Piece/Cara/Zoro.png"));
        }
    }
    
    protected void cambiarCara(MouseEvent event){
        if (event.getSource().equals(aokiji)) {
            aokiji.setImage(new Image("juego/One Piece/Cara/AokijiDisable.png"));
            disable(event, aokiji);
        } else if (event.getSource().equals(brook)) {
            brook.setImage(new Image("juego/One Piece/Cara/BrookDisable.png"));
            disable(event, brook);
        } else if (event.getSource().equals(ace)) {
            ace.setImage(new Image("juego/One Piece/Cara/AceDisable.png"));
            disable(event, ace);
        } else if (event.getSource().equals(doffy)) {
            doffy.setImage(new Image("juego/One Piece/Cara/DoffyDisable.png"));
            disable(event, doffy);
        } else if (event.getSource().equals(enel)) {
            enel.setImage(new Image("juego/One Piece/Cara/EnelDisable.png"));
            disable(event, enel);
        } else if (event.getSource().equals(luffy)) {
            luffy.setImage(new Image("juego/One Piece/Cara/LuffyDisable.png"));
            disable(event, luffy);
        } else if (event.getSource().equals(sanji)) {
           sanji.setImage(new Image("juego/One Piece/Cara/SanjiDisable.png"));
           disable(event, sanji);
        } else if (event.getSource().equals(zoro)) {
           zoro.setImage(new Image("juego/One Piece/Cara/ZoroDisable.png"));
           disable(event, zoro);
        }
    }

    protected void cambiarImagen(MouseEvent event, Personaje eleccion, ImageView personaje, Label nombre, Label ataque, Label vida, Label evasion, Label critico, Label defensa) {
        String nombreParametro = null;
        if (event.getSource().equals(aokiji)) {
            personaje.setImage(new Image("juego/One Piece/Seleccion/Aokiji.png"));
            nombre.setText("Kuzan (Aokiji)");
            nombreParametro = "Aokiji";
        } else if (event.getSource().equals(brook)) {
            personaje.setImage(new Image("juego/One Piece/Seleccion/Brook.png"));
            nombre.setText("Soul King (Brook)");
            nombreParametro = "Brook";
        } else if (event.getSource().equals(ace)) {
            personaje.setImage(new Image("juego/One Piece/Seleccion/Ace.png"));
            nombre.setText("Portgas D. Ace");
            nombreParametro = "Ace";
        } else if (event.getSource().equals(doffy)) {
            personaje.setImage(new Image("juego/One Piece/Seleccion/Doffy.png"));
            nombre.setText("Donquixote Doflamingo");
            nombreParametro = "Doffy";
        } else if (event.getSource().equals(enel)) {
            personaje.setImage(new Image("juego/One Piece/Seleccion/Enel.png"));
            nombre.setText("Enel");
            nombreParametro = "Enel";
        } else if (event.getSource().equals(luffy)) {
            personaje.setImage(new Image("juego/One Piece/Seleccion/Luffy.png"));
            nombre.setText("Monkey D. Luffy");
            nombreParametro = "Luffy";
        } else if (event.getSource().equals(sanji)) {
            personaje.setImage(new Image("juego/One Piece/Seleccion/Sanji.png"));
            nombre.setText("Vinsmoke Sanji");
            nombreParametro = "Sanji";
        } else if (event.getSource().equals(zoro)) {
            personaje.setImage(new Image("juego/One Piece/Seleccion/Zoro.png"));
            nombre.setText("Roronoa Zoro");
            nombreParametro = "Zoro";
        }
        datosPersonaje(nombreParametro, eleccion, ataque, vida, evasion, critico, defensa);
    }
    
    protected String getPersonaje(String nombre) {
        String nombreParametro = null;
        if (nombre.equals("Kuzan (Aokiji)")) {
            nombreParametro = "Aokiji";
        } else if (nombre.equals("Soul King (Brook)")) {
            nombreParametro = "Brook";
        } else if (nombre.equals("Portgas D. Ace")) {
            nombreParametro = "Ace";
        } else if (nombre.equals("Donquixote Doflamingo")) {
            nombreParametro = "Doffy";
        } else if (nombre.equals("Enel")) {
            nombreParametro = "Enel";
        } else if (nombre.equals("Monkey D. Luffy")) {
            nombreParametro = "Luffy";
        } else if (nombre.equals("Marco el Fenix")) {
            nombreParametro = "Marco";
        } else if (nombre.equals("Dracule Mihawk")) {
            nombreParametro = "Mihawk";
        } else if (nombre.equals("Vinsmoke Sanji")) {
            nombreParametro = "Sanji";
        } else if (nombre.equals("Roronoa Zoro")) {
            nombreParametro = "Zoro";
        }
        return nombreParametro;
    }
    
    protected Personaje getPersonajeElegido(String nombre){
        Personaje eleccion = null;
        for (Personaje i : listaPersonajes) {
            if (i.getNombre().equals(nombre)) {
                eleccion = i;
            }
        }
        return eleccion;
    }

    protected Image createImagePointer(String path) {
        File file = new File(path);
        return new Image(file.toURI().toString());
    }

    @FXML
    void entrarPelea(ActionEvent event) throws IOException {
        if(!nombreDerecha.getText().equalsIgnoreCase("") || !nombreIzquierda.getText().equalsIgnoreCase("")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPelea.fxml"));
            root = loader.load();

            Pelea scene2Controller = loader.getController();
            scene2Controller.setNobmrePJ1(nombreDerecha.getText());
            scene2Controller.setNombrePJ2(nombreIzquierda.getText());   
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            //mediaPlayer.stop();
            stage.setScene(scene);
            stage.show();
        }
    }

    private void cambiarImage(MouseEvent event, ImageView personaje1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anadirPersonajes();
        /*String bip = "src/juego/resources/musicaSeleccion.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();*/
    }
    
}
