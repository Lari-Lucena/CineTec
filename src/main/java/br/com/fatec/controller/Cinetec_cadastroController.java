/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.CadastrarDAO;
import br.com.fatec.DAO.LoginDAO;
import br.com.fatec.database.Database;
import br.com.fatec.model.Cadastrar;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
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
    private Button btn_cadastro;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_apelido;
    @FXML
    private TextField txt_cpf;
    @FXML
    private TextField txt_celular;
    @FXML
    private DatePicker txt_bday;
    @FXML
    private ComboBox<String> cb_regiao;
    @FXML
    private TextField txt_email;
    @FXML
    private PasswordField txt_senha;
    @FXML
    private PasswordField txt_rsenha;
    @FXML
    private CheckBox chk_visualizar;
    
    
    private Cadastrar cadastro = new Cadastrar(); //indica nosso model
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cb_regiao.getItems().addAll("Zona Norte","Zona Sul", "Zona Leste", "Zona Oeste", "Centro");
        
    }    
    
    @FXML
    private void btn_cadastro(ActionEvent event) throws SQLException {
            
        cadastro = moveViewToModel();

        // Verifica se todos os campos estão preenchidos
        if (!todosCamposPreenchidos()) {
            msg_alert("Preencha todos os campos antes de cadastrar.");
            return;  // Interrompe a execução do método
        }

        // Verifica se o e-mail é válido
        if (!isValidEmail(txt_email.getText())) {
            msg_alert("O e-mail informado não é válido.");
            return;  // Interrompe a execução do método
        }
        
        //VERIFICANDO
        LoginDAO LogDAO = new LoginDAO();
        CadastrarDAO CadDAO = new CadastrarDAO();

        boolean contaJaExiste = CadDAO.contaExiste(cadastro);
        
        if(contaJaExiste){
            msg_alert("Já existe uma conta cadastrada com esse e-mail.");
        } else{
            //GRAVANDO
            try {
                if(CadDAO.insertCadastro(cadastro)){
                    msg_info("Cadastro concluido com sucesso!");               
                    LogDAO.insertlogin(cadastro);
                }
            } catch (SQLException ex) {
                System.out.println("Deu erro: " + 
                        ex.getMessage());
            }
        }               
    }     
    
    private void msg_info(String msg){    
        Alert alerta = new Alert (Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");
               
        alerta.showAndWait(); //exibe mensagem
    }
    
    private void msg_alert(String msg){     
        Alert alerta = new Alert (Alert.AlertType.WARNING);
        alerta.setTitle("Atenção!");
        alerta.setHeaderText(msg);
               
        alerta.showAndWait(); //exibe mensagem
    }

    @FXML
    private void options(ActionEvent event) {
    }

    @FXML
    private void visualizar(ActionEvent event) {
    }
    
    public boolean isValidEmail(String txt_email) {
        String regexPattern = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(txt_email);
        return matcher.matches();
    }


    private Cadastrar moveViewToModel(){
        
        //CRIA O OBJETO CADASTRO - (MODEL)
        cadastro = new Cadastrar();
        cadastro.setNome(txt_nome.getText());
        cadastro.setApelido(txt_apelido.getText());
        cadastro.setCpf(txt_cpf.getText());
        cadastro.setCelular(txt_celular.getText());
        cadastro.setRegiao(cb_regiao.getValue());
        cadastro.setEmail(txt_email.getText());
        cadastro.setSenha(txt_senha.getText());
        cadastro.setRsenha(txt_rsenha.getText());
             
        //Devolve o model
        return cadastro;     
    }
    
    private boolean todosCamposPreenchidos() {
    // Adicione todos os campos que você deseja verificar
    return !txt_nome.getText().isEmpty() &&
           !txt_apelido.getText().isEmpty() &&
           !txt_cpf.getText().isEmpty() &&
           !txt_celular.getText().isEmpty() &&
           txt_bday.getValue() != null &&  // Verifica se a data de nascimento foi selecionada
           cb_regiao.getValue() != null &&
           !txt_email.getText().isEmpty() &&
           !txt_senha.getText().isEmpty() &&
           !txt_rsenha.getText().isEmpty();
    }
}
