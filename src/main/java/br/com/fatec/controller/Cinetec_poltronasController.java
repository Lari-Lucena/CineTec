/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.model.Poltronas;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_poltronasController implements Initializable {

    @FXML
    private CheckBox h1, h2, h3, h4, h5, g1, g2, g3, g4, g5, e1, e2, e3, e4, e5, f1, f2, f3, f4, f5, d1, d2, d3, d4, d5, c1, c2, c3, c4, c5, b1, b2, b3, b4, b5, a1, a2, a3, a4, a5;
    @FXML
    private Button btn_prosseguir;
    
    private Poltronas poltronas = new Poltronas();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void btn_prosseguir(ActionEvent event) {
    poltronas = moveViewToModel();

    List<String> poltronasSelecionadas = poltronas.getPoltronasSelecionadas();

        if (poltronasSelecionadas.isEmpty()) {
            System.out.println("Nenhuma poltrona selecionada.");
        } else {
            System.out.print("Poltronas selecionadas: ");
            String poltronasConcatenadas = String.join(", ", poltronasSelecionadas);
            System.out.println(poltronasConcatenadas);
        }

    }
    
    private List<String> getPoltronasSelecionadas() {
        List<String> poltronasSelecionadas = new ArrayList<>();

        for (CheckBox checkbox : getCheckBoxes()) {
            if (checkbox.isSelected()) {
                poltronasSelecionadas.add(checkbox.getText());
            }
        }

        return poltronasSelecionadas;
    }


    private Poltronas moveViewToModel() {
        Poltronas poltronasSelecionadas = new Poltronas();
        poltronasSelecionadas.setPoltronasSelecionadas(getPoltronasSelecionadas());

        return poltronasSelecionadas;
    }
    
        private List<CheckBox> getCheckBoxes() {
        List<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(a1);
        checkBoxes.add(a2);
        checkBoxes.add(a3);
        // falta adc todos aqui

        return checkBoxes;
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
}
