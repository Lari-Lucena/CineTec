/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_ingressosController implements Initializable {

    @FXML
    private Label lbl_inteira;
    @FXML
    private Label lbl_meia;
    @FXML
    private ComboBox<?> cmb_inteira;
    @FXML
    private ComboBox<?> cmb_meia;
    @FXML
    private Button btn_reservar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
