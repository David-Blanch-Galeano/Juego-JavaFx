package juego;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class PantallaPrincipal implements Initializable {

    @FXML
    private Button boton;

    @FXML
    private ImageView imagen;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    //MediaPlayer mediaPlayer;

    public void cambiar(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLseleccion.fxml"));
        root = loader.load();

        SeleccionCampeon scene2Controller = loader.getController();

        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));	
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        //mediaPlayer.stop();
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*String bip = "src/juego/resources/OnePieceInicial.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();*/
        
        observableAux.inicializar();
    }
}
