package com.mycompany.projecte_app;


import com.mycompany.projecte_app.model.GestioDades;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {
    //INICI DE SESSIÓ
    
    //Instanciar a la classe GestioDades
     GestioDades gestiodades = new GestioDades(); //MOLT IMPORTANT -- INSTANCIAR LA CLASSE
    
    @FXML
    TextField TextUsuari;
    @FXML
    PasswordField TextContrasenya;
    
    //Gestió de Controladors
    private void IniciSessio() throws IOException {
        App.setRoot("terciary");
    }
    
    @FXML
    private void Registrarse() throws IOException {
        App.setRoot("secondary");
    }
    
    public void ValidarCambrer() throws IOException { //Comprovar si l'usuari existeix a la BD
        if (!TextUsuari.getText().isEmpty() &&  !TextContrasenya.getText().isEmpty()) {
            String Nom = TextUsuari.getText();
            String Contrasenya = TextContrasenya.getText();
            boolean ok = gestiodades.consultarCambrer(Nom, Contrasenya);
        
            if (ok == true) { //Passar de pestanya a l'inici de sessió
                this.IniciSessio();
                
            } else{ //Mostrar missatge d'error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error en les dades d'usuari o contrasenya");
                alert.setHeaderText("Tornar a inici de sessió");
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Completa els camps buits");
            alert.setHeaderText("Tornar a inici de sessió");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
}
