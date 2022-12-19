/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static juego.SeleccionCampeon.listaPersonajes;
import static juego.Pelea.personajeSeleccionado1;
import static juego.Pelea.personajeSeleccionado2;
import static juego.Pelea.ganadorPJ1;

public class Gandor implements Initializable{
    
    protected String personaje1 = personajeSeleccionado1.toLowerCase(), personaje2 = personajeSeleccionado2.toLowerCase();
    String Pganador, Pperdedor;
    int indiceGanador;
    
    @FXML
    private TableColumn ganador;

    @FXML
    private Label habla;

    @FXML
    private ImageView imagenGanador;

    @FXML
    private TableColumn jugador;

    @FXML
    private TableColumn pelea;

    @FXML
    private Button remach;

    @FXML
    private Button seleccionCampeon;

    @FXML
    private TableView<infoJugador> tablaGanadores;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    protected void fraseAokiji(String personajeGanador, String personajePerdedor){
        if(personajePerdedor.equals("luffy")){
            habla.setText("Te dije que llevar a esa mujer contigo no te traeria nada bueno, ya ves los resultados");
        }else if(personajePerdedor.equals("zoro")){
            habla.setText("Tu cabeza no me interesa tanto como la de tu capitan, cazador de piratas");
        }else if(personajePerdedor.equals("ace")){
            habla.setText("Hijo de Roger, Akainu sabra que hacer contigo");
        }else if(personajePerdedor.equals("sanji")){
            habla.setText("¿Pensaste que podrias conmigo pierna negra?");
        }else{
            habla.setText("¿Como podrias tu ganar a un almirante de la marina?");
        }
    }
    
    protected void fraseAce(String personajeGanador, String personajePerdedor){
        if(personajePerdedor.equals("luffy")){
            habla.setText("Espero verte de nuevo, hermano");
        }else if(personajePerdedor.equals("zoro")){
            habla.setText("Con ese nivel no serias de estar en la banda de mi hermano, debes mejorar");
        }else if(personajePerdedor.equals("aokiji")){
            habla.setText("Un almirante no es nada para un hijo de Shirohige");
        }else if(personajePerdedor.equals("sanji")){
            habla.setText("Con ese nivel no serias de estar en la banda de mi hermano, debes mejorar");
        }else{
            habla.setText("Mi padre sera el rey de los piratas");
        }
    }
    
    protected void fraseBrook(String personajeGanador, String personajePerdedor){
        if(personajePerdedor.equals("luffy")){
            habla.setText("Le mandare a Laboon recuerdos tuyos");
        }else if(personajePerdedor.equals("sanji")){
            habla.setText("Tu cocina nunca me gusto, pero es porque no tengo estomago YOHOHOHOHO");
        }else if(personajePerdedor.equals("zoro")){
            habla.setText("Ya sabemos quien es el mejor espadachin");
        }else{
             habla.setText("Ni la muerte es escusa para cumplir mi promesa, volvere a ver a Laboon");
        }
    }
    
    protected void fraseDoffy(String personajeGanador, String personajePerdedor){
        if(personajePerdedor.equals("luffy")){
            habla.setText("Seguire controlando los hilos de Dressrosa, y tu no me detendras");
        }else if(personajePerdedor.equals("aokiji")){
            habla.setText("Tu, de nuevo");
        }else if(personajePerdedor.equals("zoro")){
            habla.setText("No serias capaz de cortar mis hilos");
        }else{
            habla.setText("¡Ahora entiendes lo diferentes que somos en términos de poder! ¿Estás satisfecho?");
        }
    }
    
    protected void fraseEnel(String personajeGanador, String personajePerdedor){
        if(personajePerdedor.equals("luffy")){
            habla.setText("Ni tu goma es capaz de parar mi electricidad, soy ... un Dios");
        }else if(personajePerdedor.equals("sanji")){
            habla.setText("Tu sacrificio no sirvio de nada");
        }else{
            habla.setText("Tener un poco de esperanza falsa, es lo mismo que morir");
        }
    }
    
    protected void fraseLuffy(String personajeGanador, String personajePerdedor){
        if(personajePerdedor.equals("zoro")){
            habla.setText("Buscare a otro vize capitan, alguien mejor");
        }else if(personajePerdedor.equals("sanji")){
            habla.setText("Un cocinero no podria parar mi sueño");
        }else if(personajePerdedor.equals("brook")){
            habla.setText("Lo siento por Laboon pero mi sueño es mas importante");
        }else if(personajePerdedor.equals("enel")){
            habla.setText("Pensabas que serias capaz de ganar a alguien hecho de goma");
        }else if(personajePerdedor.equals("ace")){
            habla.setText("Lo siento hermano, pero yo sere el rey de los piratas no tu padre");
        }else if(personajePerdedor.equals("aokiji")){
            habla.setText("Yo sere el que proteja a Robin, aunque me cueste la vida");
        }else if(personajePerdedor.equals("doffy")){
            habla.setText("Cortare tus hilos y Dressrosa sera libre al fin");
        }else{
            habla.setText("Cumplire mi sueño y sere el rey de los piratas");
        }
    }
    
    protected void fraseSanji(String personajeGanador, String personajePerdedor){
        if(personajePerdedor.equals("zoro")){
            habla.setText("Parece que la banda tiene un nuevo vizecapitan");
        }else if(personajePerdedor.equals("luffy")){
            habla.setText("Encontrare el AllBlue y no me detendras");
        }else if(personajePerdedor.equals("enel")){
            habla.setText("Gracias por el fuego");
        }else if(personajePerdedor.equals("ace")){
            habla.setText("Gracias por el fuego");
        }else{
            habla.setText("Encontrare el All Blue, y tu no me detendras");
        }
    }
    
    protected void fraseZoro(String personajeGanador, String personajePerdedor){
        if(personajePerdedor.equals("luffy")){
            habla.setText("Ya te lo dije cuando se fue Usopp de la banda, si pierdes la seriedad que necesita un capitan terminaria contigo");
        }else if(personajePerdedor.equals("sanji")){
            habla.setText("Tendremos que buscar un nuevo cocinero");
        }else if(personajePerdedor.equals("ace")){
            habla.setText("Aunque seas el hermano de mi capitan no dejare que pases por encima de mi sueño");
        }else if(personajePerdedor.equals("doffy")){
            habla.setText("Cortare tus hilos Doffy, terminare contigo");
        }else{
            habla.setText("Un hombre forja su destino, nadie te da nada, tienes que cogerlo");
        }
    }
    
    protected void frases(String personajeGanador, String personajePerdedor){
        if(personajeGanador.equals("aokiji")){
            fraseAokiji(personajeGanador, personajePerdedor);
        }else if(personajeGanador.equals("ace")){
            fraseAce(personajeGanador, personajePerdedor);
        }else if(personajeGanador.equals("brook")){
           fraseBrook(personajeGanador, personajePerdedor);
        }else if(personajeGanador.equals("doffy")){
            fraseDoffy(personajeGanador, personajePerdedor);
        }else if(personajeGanador.equals("enel")){
            fraseEnel(personajeGanador, personajePerdedor);
        }else if(personajeGanador.equals("luffy")){
            fraseLuffy(personajeGanador, personajePerdedor);
        }else if(personajeGanador.equals("sanji")){
            fraseSanji(personajeGanador, personajePerdedor);
        }else if(personajeGanador.equals("zoro")){
            fraseZoro(personajeGanador, personajePerdedor);
        }
    }
    
    @FXML
    void volverASeleccion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLseleccion.fxml"));
        root = loader.load();
	
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void volverCombate(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPelea.fxml"));
        root = loader.load();
  
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!ganadorPJ1){
            imagenGanador.setImage(new Image("juego/One Piece/hablar/"+personaje1+".jpg"));
            frases(personaje1, personaje2);
            Pganador = personaje1.toUpperCase();
            Pperdedor = personaje2;
            indiceGanador = 1;
        }else if(ganadorPJ1){
            imagenGanador.setImage(new Image("juego/One Piece/hablar/"+personaje2+".jpg"));
            frases(personaje2, personaje1);
            Pganador = personaje2.toUpperCase();
            Pperdedor = personaje1;
            indiceGanador = 2;
        }
        
        
        String personasPelea = personaje1.toUpperCase() + " VS " + personaje2.toUpperCase();
        
        jugador.setCellValueFactory(new PropertyValueFactory("jugadorGanador"));
        ganador.setCellValueFactory(new PropertyValueFactory("nombreGanador"));
        pelea.setCellValueFactory(new PropertyValueFactory("nombrePelea"));

        observableAux.add(new infoJugador(Pganador,personasPelea,indiceGanador));
        
        tablaGanadores.setItems(observableAux.getAux());
    }
    
    
    
}
