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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_cadastroController implements Initializable {

    @FXML
    private Button btn_cadastrar;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_apelido;
    @FXML
    private TextField txt_cpf;
    @FXML
    private TextField txt_celular;
    @FXML
    private TextField txt_birth;
    @FXML
    private ComboBox<?> cmb_regiao;
    @FXML
    private TextField txt_email;
    @FXML
    private PasswordField pwd_senha;
    @FXML
    private PasswordField pwd_confirmar;
    @FXML
    private CheckBox chk_visualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
