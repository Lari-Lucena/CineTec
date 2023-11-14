/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.model.Poltronas;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private CheckBox a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, 
                    b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, 
                    c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, 
                    d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, 
                    e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, 
                    f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, 
                    g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, 
                    h1, h2, h3, h4, h5, h6, h7, h8, h9, h10;

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
    moveViewToModel(poltronas);

    List<String> poltronasSelecionadas = getPoltronasSelecionadas();

        if (poltronasSelecionadas.isEmpty()) {
            System.out.println("Nenhuma poltrona selecionada.");
        } else {
            String poltronasConcatenadas = String.join(", ", poltronasSelecionadas);
            msg_info("Você selecionou as poltronas: " + poltronasConcatenadas);

        }

    }

    private List<String> getPoltronasSelecionadas() {
    List<String> poltronasSelecionadas = new ArrayList<>();
    char row = 'A';

        for (char i = row; i <= 'H'; i++) {
            for (int j = 1; j <= 10; j++) {
                String checkBoxId = i + "" + j; 
                CheckBox checkBox = findCheckBoxById(checkBoxId); // Encontra o CheckBox pelo ID

                if (checkBox != null && checkBox.isSelected()) {
                    poltronasSelecionadas.add(checkBoxId.toUpperCase());
                }
            }
        }

        return poltronasSelecionadas;
    }

    private CheckBox findCheckBoxById(String id) {       
        // Mapeamento dos IDs para os CheckBoxes
        Map<String, CheckBox> checkBoxMap = new HashMap<>();
        
        checkBoxMap.put("A1", a1);checkBoxMap.put("A2", a2);checkBoxMap.put("A3", a3);checkBoxMap.put("A4", a4);checkBoxMap.put("A5", a5);checkBoxMap.put("A6", a6);checkBoxMap.put("A7", a7);checkBoxMap.put("A8", a8);checkBoxMap.put("A9", a9);checkBoxMap.put("A10", a10);
        
        checkBoxMap.put("B1", b1); checkBoxMap.put("B2", b2); checkBoxMap.put("B3", b3); checkBoxMap.put("B4", b4); checkBoxMap.put("B5", b5); checkBoxMap.put("B6", b6); checkBoxMap.put("B7", b7); checkBoxMap.put("B8", b8); checkBoxMap.put("B9", b9); checkBoxMap.put("B10", b10);

        checkBoxMap.put("C1", c1); checkBoxMap.put("C2", c2); checkBoxMap.put("C3", c3); checkBoxMap.put("C4", c4); checkBoxMap.put("C5", c5); checkBoxMap.put("C6", c6); checkBoxMap.put("C7", c7); checkBoxMap.put("C8", c8); checkBoxMap.put("C9", c9); checkBoxMap.put("C10", c10);

        checkBoxMap.put("D1", d1); checkBoxMap.put("D2", d2); checkBoxMap.put("D3", d3); checkBoxMap.put("D4", d4); checkBoxMap.put("D5", d5); checkBoxMap.put("D6", d6); checkBoxMap.put("D7", d7); checkBoxMap.put("D8", d8); checkBoxMap.put("D9", d9); checkBoxMap.put("D10", d10);

        checkBoxMap.put("E1", e1); checkBoxMap.put("E2", e2); checkBoxMap.put("E3", e3); checkBoxMap.put("E4", e4); checkBoxMap.put("E5", e5); checkBoxMap.put("E6", e6); checkBoxMap.put("E7", e7); checkBoxMap.put("E8", e8); checkBoxMap.put("E9", e9); checkBoxMap.put("E10", e10);

        checkBoxMap.put("F1", f1); checkBoxMap.put("F2", f2); checkBoxMap.put("F3", f3); checkBoxMap.put("F4", f4); checkBoxMap.put("F5", f5); checkBoxMap.put("F6", f6); checkBoxMap.put("F7", f7); checkBoxMap.put("F8", f8); checkBoxMap.put("F9", f9); checkBoxMap.put("F10", f10);

        checkBoxMap.put("G1", g1); checkBoxMap.put("G2", g2); checkBoxMap.put("G3", g3); checkBoxMap.put("G4", g4); checkBoxMap.put("G5", g5); checkBoxMap.put("G6", g6); checkBoxMap.put("G7", g7); checkBoxMap.put("G8", g8); checkBoxMap.put("G9", g9); checkBoxMap.put("G10", g10);

        checkBoxMap.put("H1", h1); checkBoxMap.put("H2", h2); checkBoxMap.put("H3", h3); checkBoxMap.put("H4", h4); checkBoxMap.put("H5", h5); checkBoxMap.put("H6", h6); checkBoxMap.put("H7", h7); checkBoxMap.put("H8", h8); checkBoxMap.put("H9", h9); checkBoxMap.put("H10", h10);
          
        return checkBoxMap.get(id);
    }
    
    private List<CheckBox> getCheckBoxes() {
        List<CheckBox> checkBoxes = new ArrayList<>();
        
        checkBoxes.add(a1); checkBoxes.add(a2); checkBoxes.add(a3); checkBoxes.add(a4); checkBoxes.add(a5); checkBoxes.add(a6); checkBoxes.add(a7); checkBoxes.add(a8); checkBoxes.add(a9); checkBoxes.add(a10);
        
        checkBoxes.add(b1); checkBoxes.add(b2); checkBoxes.add(b3); checkBoxes.add(b4); checkBoxes.add(b5); checkBoxes.add(b6); checkBoxes.add(b7); checkBoxes.add(b8); checkBoxes.add(b9); checkBoxes.add(b10);

        checkBoxes.add(c1); checkBoxes.add(c2); checkBoxes.add(c3); checkBoxes.add(c4); checkBoxes.add(c5); checkBoxes.add(c6); checkBoxes.add(c7); checkBoxes.add(c8); checkBoxes.add(c9); checkBoxes.add(c10);

        checkBoxes.add(d1); checkBoxes.add(d2); checkBoxes.add(d3); checkBoxes.add(d4); checkBoxes.add(d5); checkBoxes.add(d6); checkBoxes.add(d7); checkBoxes.add(d8); checkBoxes.add(d9); checkBoxes.add(d10);

        checkBoxes.add(e1); checkBoxes.add(e2); checkBoxes.add(e3); checkBoxes.add(e4); checkBoxes.add(e5); checkBoxes.add(e6); checkBoxes.add(e7); checkBoxes.add(e8); checkBoxes.add(e9); checkBoxes.add(e10);

        checkBoxes.add(f1); checkBoxes.add(f2); checkBoxes.add(f3); checkBoxes.add(f4); checkBoxes.add(f5); checkBoxes.add(f6); checkBoxes.add(f7); checkBoxes.add(f8); checkBoxes.add(f9); checkBoxes.add(f10);

        checkBoxes.add(g1); checkBoxes.add(g2); checkBoxes.add(g3); checkBoxes.add(g4); checkBoxes.add(g5); checkBoxes.add(g6); checkBoxes.add(g7); checkBoxes.add(g8); checkBoxes.add(g9); checkBoxes.add(g10);

        checkBoxes.add(h1); checkBoxes.add(h2); checkBoxes.add(h3); checkBoxes.add(h4); checkBoxes.add(h5); checkBoxes.add(h6); checkBoxes.add(h7); checkBoxes.add(h8); checkBoxes.add(h9); checkBoxes.add(h10);

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
    
    private void moveViewToModel(Poltronas poltronas) {
        poltronas.setPoltronasSelecionadas(getPoltronasSelecionadas());
    }
}
