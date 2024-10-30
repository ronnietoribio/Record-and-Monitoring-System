/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoring_system;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author admin
 */
public class AlertMessage {
    private Alert alert;
    
    public void successMessage(String message){
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    public void errorMessage(String message){
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    public boolean confirmMessage(String message){
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        
        Optional<ButtonType> option = alert.showAndWait();
        
        return option.get().equals(ButtonType.OK);
        
    }
}

