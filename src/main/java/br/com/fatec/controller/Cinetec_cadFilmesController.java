/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.CadFilmesDAO;
import br.com.fatec.model.CadFilmes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.Base64;
import javafx.scene.control.Alert;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;


/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_cadFilmesController implements Initializable {

    @FXML
    private ComboBox<?> cbSelecionar;
    @FXML
    private Button btn_deletar;
    @FXML
    private Button btn_alterar;
    private TextField txt_distribuidora;
    @FXML
    private Button btn_cadastro;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_genero;
    @FXML
    private TextField txt_classificacao;
    @FXML
    private Label lblNome;
    @FXML
    private TextArea txt_sinopse;
    @FXML
    private ImageView imageView;
    
    private File selectedFile;
    
    private CadFilmes cadfilmes = new CadFilmes();
    @FXML
    private ComboBox<?> cb_distribuidora;
    @FXML
    private Button btn_upload;
   
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cbSelecionar(ActionEvent event) {
    }

    @FXML
    private void btn_deletar(ActionEvent event) {
    }

    @FXML
    private void btn_alterar(ActionEvent event) {
       //colocar no botao de selecionar img
        handleUploadImage();
    }

    @FXML
    private void btn_cadastro(ActionEvent event) throws SQLException {
        
        cadfilmes = moveViewToModel();
        
        if(!todosCamposPreenchidos()){
            return;
        }
        else{
            saveImageToDatabase();
            limparCampos();
        }
        
    }
    /////////////////////fazer a distribuidora de combobox (sendo assim nossa tela com banco e combobox)
    private CadFilmes moveViewToModel(){
        //CRIA O OBJETO CADASTRO - (MODEL)
        cadfilmes = new CadFilmes();
        
        cadfilmes.setNome(txt_nome.getText());
        cadfilmes.setGenero(txt_genero.getText());
        cadfilmes.setClassificacao(txt_classificacao.getText());
        cadfilmes.setSinopse(txt_sinopse.getText());
        cadfilmes.setDistribuidora(txt_distribuidora.getText());
                   
        //Devolve o model
        return cadfilmes;     
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
    
    private void handleUploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
        }
    }

    
    private String convertImageToBase64(ImageView imageView) throws IOException {
        // Extrai a imagem do ImageView
        Image image = imageView.getImage();

        if (image != null) {
            PixelReader pixelReader = image.getPixelReader();

            int width = (int) image.getWidth();
            int height = (int) image.getHeight();

            WritablePixelFormat<ByteBuffer> byteBuffer = PixelFormat.getByteBgraInstance();

            ByteBuffer byteBuf = ByteBuffer.allocate(4 * width * height);

            pixelReader.getPixels(0, 0, width, height, byteBuffer, byteBuf, width * 4);

            byte[] pixels = byteBuf.array();
            return Base64.getEncoder().encodeToString(pixels);
        }
        return null;
    }

    
    // O método para salvar a imagem no banco de dados
    private void saveImageToDatabase() throws SQLException {
        try {
            String base64Image = convertImageToBase64(imageView);
            
            CadFilmesDAO filmesDAO = new CadFilmesDAO();
            filmesDAO.insertFilme(cadfilmes, base64Image);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private boolean todosCamposPreenchidos() {
    // Adicione todos os campos que você deseja verificar
        if (txt_nome.getText().isEmpty()) {
            msg_alert("Preencha o campo Nome.");
            txt_nome.requestFocus();
            return false;
        }
        if (txt_genero.getText().isEmpty()) {
            msg_alert("Preencha o campo Gênero");
            txt_genero.requestFocus();
            return false;
        }
        if (txt_classificacao.getText().isEmpty()) {
            msg_alert("Preencha o campo Classificação indicativa.");
            txt_classificacao.requestFocus();
            return false;
        }
        if (txt_sinopse.getText().isEmpty()) {
            msg_alert("Preencha o campo Sinopse.");
            txt_sinopse.requestFocus();
            return false;
        }
        if (txt_distribuidora.getText().isEmpty()) {
            msg_alert("Preencha o campo Distribuidora.");
            txt_distribuidora.requestFocus();
            return false;
        }

        return true;
    }
    
    private void limparCampos() {
        txt_nome.clear();
        txt_genero.clear();
        txt_classificacao.clear();
        txt_sinopse.clear();
        txt_distribuidora.clear();
    }

    @FXML
    private void cb_distribuidora(ActionEvent event) {
    }

    @FXML
    private void btn_upload(ActionEvent event) {
    }
}
