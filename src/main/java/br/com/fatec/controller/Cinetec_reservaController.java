/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.SendSmsBasic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_reservaController implements Initializable {

    @FXML
    private Button btnSMS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSMS(ActionEvent event) throws IOException {
        
        //consultar no banco o telefone, filme, poltrona e horario
        
        
        //SendSmsBasic sendSmsBasic = new SendSmsBasic();
       // sendSmsBasic.send("5511943195234", "A15", "Harry Potter: As reliquias da morte parte 1", "20/11/2023 as 20:30");
        
    }
    
}
