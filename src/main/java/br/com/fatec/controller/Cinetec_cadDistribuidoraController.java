/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.DistribuidoraDAO;
import br.com.fatec.model.Distribuidora;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_cadDistribuidoraController implements Initializable {

    @FXML
    private Label lblNome;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_responsavel;
    @FXML
    private TextField txt_cnpj;
    @FXML
    private TextField txt_nome;
    @FXML
    private Button btn_cadastro;
    @FXML
    private TextField txt_celular;
    @FXML
    private TextField txt_whats;

    private Distribuidora distribuidora = new Distribuidora();
    @FXML
    private Button btn_alterar;
    @FXML
    private Button btn_deletar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_cadastro(ActionEvent event) {
        
        distribuidora = moveViewToModel();
        
        // Verifica se o e-mail é válido
        if (!isValidEmail(txt_email.getText())) {
            msg_alert("O e-mail informado não é válido.");
            return;  // Interrompe a execução do método
        }
        
        //VERIFICANDO      
        DistribuidoraDAO DistriDAO = new DistribuidoraDAO();

//        boolean contaJaExiste = DistriDAO.contaExiste(cadastro);
//        
//        if(contaJaExiste){
//            msg_alert("Já existe uma conta cadastrada com esse e-mail.");
//        } else{
//            //GRAVANDO
            try {
                if(DistriDAO.insertCadastro(distribuidora)){
                    msg_info("Cadastro concluido com sucesso!");               
                }
            } catch (SQLException ex) {
                System.out.println("Deu erro: " + 
                        ex.getMessage());
            }
//        }          
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
    
    private Distribuidora moveViewToModel(){
        
        //CRIA O OBJETO CADASTRO - (MODEL)
        distribuidora = new Distribuidora();
        distribuidora.setNome(txt_nome.getText());
        distribuidora.setCnpj(txt_cnpj.getText());
        distribuidora.setResponsavel(txt_responsavel.getText());
        distribuidora.setEmail(txt_email.getText());
        distribuidora.setCelular(txt_celular.getText());
        distribuidora.setWhats(txt_whats.getText());
                   
        //Devolve o model
        return distribuidora;     
    }
    
    public boolean isValidEmail(String txt_email) {
        String regexPattern = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(txt_email);
        return matcher.matches();
    }
}
