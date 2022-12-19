package juego;

import Personaje.Personaje;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import static juego.SeleccionCampeon.nombre1;
import static juego.SeleccionCampeon.nombre2;
import static juego.SeleccionCampeon.listaPersonajes;

public class Pelea implements Initializable {

    //MediaPlayer mediaPlayer;
    static String personajeSeleccionado1 = nombre1, personajeSeleccionado2 = nombre2;
    protected Personaje personaje1, personaje2;

    protected static ArrayList<Personaje> lista = listaPersonajes;

    @FXML
    private ImageView imagenPJ1;

    @FXML
    private ImageView imagenPJ2;

    @FXML
    private Label labelPJ1;

    @FXML
    private Label labelPJ2;

    @FXML
    private ProgressBar pj1Vida;

    @FXML
    private ProgressBar pj2Vida;

    @FXML
    private Button ataque1;

    @FXML
    private Button ataque2;

    @FXML
    private ProgressBar pj1Especial;

    @FXML
    private ProgressBar pj2Especial;

    @FXML
    private Button especial1;

    @FXML
    private Button especial2;

    @FXML
    private ImageView imagenEspecial;

    private Stage stage;
    private Scene scene;
    private Parent root;

    protected static boolean isPJ1, ganadorPJ1;

    double progreso1 = 1, progreso2 = 1, progresoEspecial1 = 0, progresoEspecial2 = 0;

    @FXML
    public String getPersonajeSeleccionado1() {
        return personajeSeleccionado1;
    }

    public void setPersonajeSeleccionado1(String personajeSeleccionado1) {
        this.personajeSeleccionado1 = personajeSeleccionado1;
    }

    public String getPersonajeSeleccionado2() {
        return personajeSeleccionado2;
    }

    public void setPersonajeSeleccionado2(String personajeSeleccionado2) {
        this.personajeSeleccionado2 = personajeSeleccionado2;
    }

    public void setPersonaje1(Personaje personaje1) {
        this.personaje1 = personaje1;
    }

    public void setPersonaje2(Personaje personaje2) {
        this.personaje2 = personaje2;
    }

    void setNobmrePJ1(String nombrePJ1) {
        labelPJ1.setText(nombrePJ1);
    }

    void setNombrePJ2(String nombrePJ2) {
        labelPJ2.setText(nombrePJ2);
    }

    @FXML
    void especial1(ActionEvent event) throws IOException {
        if (isPJ1) {
            if (progresoEspecial1 >= 1) {
                imagenEspecial.setDisable(false);
                imagenEspecial.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/especialGif.gif"));
                delay(2200, () -> imagenEspecial.setImage(new Image("juego/cortar/" + personajeSeleccionado1)));
                imagenEspecial.setDisable(true);
                int valorDado = personaje2.getDanio();
                progreso1 -= valorDado * 0.015;
                progresoEspecial1 = 0;
                progresoEspecial2 += 0.4;
                if (progreso1 < 0.4) {
                    delay(700, () -> imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/cansado/cansadoGif.gif")));
                    estiloBarraDeVida(pj2Vida, "red");
                } else {
                    delay(700, () -> imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/parado/paradoGif.gif")));
                }
                if (progreso2 < 0.4) {
                    delay(700, () -> imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/cansado/cansadoGif.gif")));
                    estiloBarraDeVida(pj1Vida, "red");
                } else {
                    delay(700, () -> imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/parado/paradoGif.gif")));
                }
                pj2Vida.setProgress(progreso1);
                pj1Especial.setProgress(progresoEspecial1);
                pj2Especial.setProgress(progresoEspecial2);
                isPJ1 = false;
                especial1.setDisable(true);
                ataque1.setDisable(!isPJ1);
                ataque2.setDisable(isPJ1);
                if (progresoEspecial2 >= 1) {
                    especial2.setDisable(false);
                }
                if (progreso1 < 0) {
                    imagenEspecial.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/especialGif.gif"));
                    delay(2200, () -> {
                        try {
                            setGanadorPJ1(false);
                            ganador(event);
                        } catch (IOException ex) {
                            Logger.getLogger(Pelea.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        }
    }

    @FXML
    void especial2(ActionEvent event) throws IOException {
        if (!isPJ1) {
            if (progresoEspecial2 >= 1) {
                imagenEspecial.setDisable(false);
                imagenEspecial.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/especialGif.gif"));
                delay(2200, () -> imagenEspecial.setImage(new Image("juego/cortar/" + personajeSeleccionado2)));
                imagenEspecial.setDisable(true);
                int valorDado = personaje1.getDanio();
                progreso2 -= valorDado * 0.015;
                progresoEspecial2 = 0;
                progresoEspecial1 += 0.4;
                if (progreso2 < 0.4) {
                    delay(700, () -> imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/cansado/cansadoGif.gif")));
                    estiloBarraDeVida(pj1Vida, "red");
                } else {
                    delay(700, () -> imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/parado/paradoGif.gif")));
                }
                if (progreso1 < 0.4) {
                    delay(700, () -> imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/cansado/cansadoGif.gif")));
                    estiloBarraDeVida(pj2Vida, "red");
                } else {
                    delay(700, () -> imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/parado/paradoGif.gif")));
                }
                pj1Vida.setProgress(progreso2);
                pj1Especial.setProgress(progresoEspecial1);
                pj2Especial.setProgress(progresoEspecial2);
                isPJ1 = true;
                especial2.setDisable(true);
                ataque1.setDisable(!isPJ1);
                ataque2.setDisable(isPJ1);
                if (progresoEspecial1 >= 1) {
                    especial1.setDisable(false);
                }
                if (progreso2 < 0) {
                    imagenEspecial.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/especialGif.gif"));
                    delay(2200, () -> {
                        try {
                            setGanadorPJ1(true);
                            ganador(event);
                        } catch (IOException ex) {
                            Logger.getLogger(Pelea.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        }
    }

    @FXML
    void pelea(ActionEvent event) {
        ataque1.setDisable(isPJ1);
        ataque2.setDisable(!isPJ1);
        int decidirMasMenos = (int) (Math.random() * 2);
        int masMenosDanio = (int) (Math.random() * 10);

        if (progresoEspecial1 >= 1) {
            especial1.setDisable(false);
        }
        if (progresoEspecial2 >= 1) {
            especial2.setDisable(false);
        }
        int esquivar = (int) (Math.random() * 100);
        int critico = (int) (Math.random() * 100);
        if (isPJ1) {
            double danio = Double.parseDouble(personaje1.getDanio() + "");
            double vida = Double.parseDouble(personaje2.getVida() + "");
            double valorDado = (danio / vida);
            if (decidirMasMenos == 1) {
                double danioAlter = Double.parseDouble(masMenosDanio + "") * 0.001;
                valorDado += danioAlter;
            } else if (decidirMasMenos == 0) {
                double danioAlter = Double.parseDouble(masMenosDanio + "") * 0.001;
                valorDado -= danioAlter;
            }
            if (critico < personaje1.getProbCritico()) {
                if (esquivar > personaje2.getEvasion()) {
                    progreso1 -= valorDado * 2;
                    progresoEspecial1 += 0.4;
                    pj1Especial.setProgress(progresoEspecial1);
                    pj2Vida.setProgress(progreso1); 
                }
            } else {
                if (esquivar > personaje2.getEvasion()) {
                    progreso1 -= valorDado;
                    progresoEspecial1 += 0.4;
                    pj1Especial.setProgress(progresoEspecial1);
                    pj2Vida.setProgress(progreso1);
                }
            }
            imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/ataque/ataqueGif.gif"));
            if (progreso1 < 0.4) {
                delay(700, () -> imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/cansado/cansadoGif.gif")));
                estiloBarraDeVida(pj2Vida, "red");
            } else {
                delay(700, () -> imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/parado/paradoGif.gif")));
            }
            if (progreso2 < 0.4) {
                delay(700, () -> imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/cansado/cansadoGif.gif")));
                estiloBarraDeVida(pj1Vida, "red");
            } else {
                delay(700, () -> imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/parado/paradoGif.gif")));
            }
            isPJ1 = false;
        } else if (!isPJ1) {
            double danio = Double.parseDouble(personaje2.getDanio() + "");
            double vida = Double.parseDouble(personaje1.getVida() + "");
            double valorDado = danio / vida;
            if (decidirMasMenos == 1) {
                double danioAlter = Double.parseDouble(masMenosDanio + "") * 0.001;
                valorDado += danioAlter;
            } else if (decidirMasMenos == 0) {
                double danioAlter = Double.parseDouble(masMenosDanio + "") * 0.001;
                valorDado -= danioAlter;
            }
            if (critico < personaje2.getProbCritico()) {
                if (esquivar > personaje1.getEvasion()) {
                    progreso2 -= valorDado * 2;
                    progresoEspecial2 += 0.4;
                    pj2Especial.setProgress(progresoEspecial2);
                    pj1Vida.setProgress(progreso2); 
                }
            } else {
                if (esquivar > personaje1.getEvasion()) {
                    progreso2 -= valorDado;
                    progresoEspecial2 += 0.4;
                    pj2Especial.setProgress(progresoEspecial2);
                    pj1Vida.setProgress(progreso2);
                }
            }
            imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/ataque/ataqueGif.gif"));
            if (progreso2 < 0.4) {
                delay(700, () -> imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/cansado/cansadoGif.gif")));
                estiloBarraDeVida(pj1Vida, "red");
            } else {
                delay(700, () -> imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/parado/paradoGif.gif")));
            }
            if (progreso1 < 0.4) {
                delay(700, () -> imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/cansado/cansadoGif.gif")));
                estiloBarraDeVida(pj2Vida, "red");
            } else {
                delay(700, () -> imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/parado/paradoGif.gif")));
            }
            isPJ1 = true;
        }
        if (progreso1 < 0) {
            try {
                setGanadorPJ1(false);
                ganador(event);
            } catch (IOException ex) {
                Logger.getLogger(Pelea.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (progreso2 < 0) {
            try {
                setGanadorPJ1(true);
                ganador(event);
            } catch (IOException ex) {
                Logger.getLogger(Pelea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isGanadorPJ1() {
        return ganadorPJ1;
    }

    public void setGanadorPJ1(boolean ganadorPJ1) {
        this.ganadorPJ1 = ganadorPJ1;
    }

    public void ganador(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGanador.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //mediaPlayer.stop();
        stage.setScene(scene);
        stage.show();
    }

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }

    protected Personaje getPersonajeElegido(String nombre) {
        Personaje eleccion = null;
        for (Personaje i : listaPersonajes) {
            if (i.getNombre().equals(nombre)) {
                eleccion = i;
            }
        }
        return eleccion;
    }

    void estiloBarraDeVida(ProgressBar barra, String color) {
        barra.setStyle("-fx-accent: " + color + ";");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*String bip = "src/juego/resources/musicaPelea.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();*/
        estiloBarraDeVida(pj1Vida, "green");
        estiloBarraDeVida(pj2Vida, "green");
        int empieza = (int) (Math.random() * 2);
        if (empieza == 1) {
            ataque1.setDisable(false);
            isPJ1 = true;
        } else if (empieza == 0) {
            ataque2.setDisable(false);
            isPJ1 = false;
        }
        pj1Vida.setProgress(1);
        pj2Vida.setProgress(1);
        pj1Especial.setProgress(0);
        pj2Especial.setProgress(0);
        personajeSeleccionado1 = nombre1;
        personajeSeleccionado2 = nombre2;
        personaje1 = getPersonajeElegido(personajeSeleccionado1);
        personaje2 = getPersonajeElegido(personajeSeleccionado2);
        imagenPJ1.setImage(new Image("juego/cortar/" + personajeSeleccionado1 + "/parado/paradoGif.gif"));
        imagenPJ2.setImage(new Image("juego/cortar/" + personajeSeleccionado2 + "/parado/paradoGif.gif"));
    }

}
