/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.reservaDAO;
import br.com.fatec.SendSmsBasic;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private void btnSMS(ActionEvent event) throws IOException, SQLException {
        
        reservaDAO dao = new reservaDAO();
    
        String[] vendaInfo = dao.getUltimaVenda();
    
        if (vendaInfo != null) {
            String numeroCliente = vendaInfo[0];
            String nomeCliente = vendaInfo[1];
            String nomeFilme = vendaInfo[2];
            String hora = vendaInfo[3];
            String poltronas = vendaInfo[4];

           SendSmsBasic sendSmsBasic = new SendSmsBasic();
           sendSmsBasic.send(numeroCliente, nomeCliente, poltronas, nomeFilme, hora);
        }
            

        }
    
}
