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
import java.sql.SQLException;
import javafx.scene.control.Alert;


/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_cadFilmesController implements Initializable {

    @FXML
    private ComboBox<String> cbSelecionar;
    @FXML
    private Button btn_deletar;
    @FXML
    private Button btn_alterar;
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
    @FXML
    private ComboBox<String> cb_distribuidora;
    @FXML
    private Button btn_upload;
    
    private File selectedFile;
    
    private String selectedImagePath;
    
    private CadFilmes cadfilmes = new CadFilmes();
    @FXML
    private Button btn_exibir;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherComboBoxDoDAO();
    }    

    @FXML
    private void cbSelecionar(ActionEvent event) {
    }

    @FXML
    private void btn_deletar(ActionEvent event) throws SQLException {
    CadFilmesDAO filmesDAO = new CadFilmesDAO();

        cadfilmes = moveViewToModel();
        
        try {
            if(filmesDAO.removeFilme(cadfilmes)){
                msg_info("Cadastro excluido.");
                limparCampos();
            }
        } catch (SQLException ex) {
            System.out.println("Deu erro: " + 
                    ex.getMessage());
        }
    }

    @FXML
    private void btn_alterar(ActionEvent event) {
        CadFilmesDAO filmesDAO = new CadFilmesDAO();

        cadfilmes = moveViewToModel();
        
        try {
            if(filmesDAO.alterFilme(cadfilmes)){
                msg_info("Cadastro alterado com sucesso!");
                limparCampos();
            }
        } catch (SQLException ex) {
            System.out.println("Deu erro: " + 
                    ex.getMessage());
        }
    }
    
    
    @FXML
    private void btn_exibir(ActionEvent event) {
        String nomeSelecionado = cbSelecionar.getValue();
        if (nomeSelecionado != null) {
            moveModelToView(nomeSelecionado);
        } else {
            msg_alert("Selecione algum dado.");
        } 
    }

    
    @FXML
    private void cb_distribuidora(ActionEvent event) {
    }

    @FXML
    private void btn_upload(ActionEvent event) {
        handleUploadImage(); // Invoca apenas a função de upload
    }

    @FXML
    private void btn_cadastro(ActionEvent event) throws SQLException {
        if (!todosCamposPreenchidos()) {
            return;
        }

        cadfilmes = moveViewToModel(); // Move os dados para o model somente se todos os campos estiverem preenchidos

        if (selectedImagePath != null) {
            saveImageToDatabase(selectedImagePath);
            msg_info("Filme cadastrado com sucesso.");
            limparCampos();
        } else {
            msg_info("Nenhuma imagem selecionada.");
        }
    }


    private void handleUploadImage() {
        FileChooser fileChooser = new FileChooser();

        // Define o diretório inicial
        String path = "C:\\Users\\Larica\\Desktop\\cinetec\\src\\main\\resources\\imagens"; // Substitua pelo caminho desejado
        File initialDirectory = new File(path);
        fileChooser.setInitialDirectory(initialDirectory);

        fileChooser.setTitle("Select Image");
        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            selectedImagePath = selectedFile.getAbsolutePath();
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
        }
    }

    private CadFilmes moveViewToModel(){ //leva da tela para o back
        //CRIA O OBJETO CADASTRO - (MODEL)
        cadfilmes = new CadFilmes();
        
        cadfilmes.setNome(txt_nome.getText());
        cadfilmes.setGenero(txt_genero.getText());
        cadfilmes.setClassificacao(txt_classificacao.getText());
        cadfilmes.setSinopse(txt_sinopse.getText());
        cadfilmes.setDistribuidora(cb_distribuidora.getValue());
        
        if (selectedFile != null) {
            String imagePath = selectedFile.getAbsolutePath();
            cadfilmes.setImage(imagePath);
        }
        
        //Devolve o model
        return cadfilmes;     
    }
    
    private void moveModelToView(String nome) { //leva o back para a tela
        try {
            CadFilmesDAO filmesDAO = new CadFilmesDAO();
            CadFilmes filmes = filmesDAO.buscarFilme(nome);
            if (filmes != null) {
                txt_nome.setText(String.valueOf(filmes.getNome()));
                txt_genero.setText(filmes.getGenero());
                txt_classificacao.setText(String.valueOf(filmes.getClassificacao()));
                txt_sinopse.setText(filmes.getSinopse());
                cb_distribuidora.setValue(filmes.getDistribuidora());
                
                // Obter o caminho da imagem do objeto CadFilmes
                String imagePath = filmes.getImage();

                // Carregar a imagem usando o caminho e definir no ImageView
                if (imagePath != null && !imagePath.isEmpty()) {
                    Image image = new Image("file:" + imagePath);
                    imageView.setImage(image);
                }
            } else {
                msg_alert("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    
    // O método para salvar a imagem no banco de dados
    private void saveImageToDatabase(String imagePath) throws SQLException {
        if (imagePath != null) {
            CadFilmesDAO filmesDAO = new CadFilmesDAO();
            filmesDAO.insertFilme(cadfilmes, imagePath);
        } else {
            // Trate aqui se nenhum arquivo foi selecionado
        }
    }
    
    public void preencherComboBoxDoDAO() {
        CadFilmesDAO filmesDAO = new CadFilmesDAO();
        filmesDAO.preencherComboBoxDistribuidora(cb_distribuidora);
        filmesDAO.preencherComboBox(cbSelecionar);
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
        if (cb_distribuidora.getValue() == null) {
            msg_alert("Escolha uma Distribuidora.");
            cb_distribuidora.requestFocus();
            return false;
        }

        return true;
    }
    
    private void limparCampos() {
        txt_nome.clear();
        txt_genero.clear();
        txt_classificacao.clear();
        txt_sinopse.clear();
        cb_distribuidora.getSelectionModel().clearSelection();
        cbSelecionar.getSelectionModel().clearSelection();
        imageView.setImage(null);
    }
}
