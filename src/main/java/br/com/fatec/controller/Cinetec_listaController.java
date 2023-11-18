/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.CadFilmesDAO;
import br.com.fatec.model.CadFilmes;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class Cinetec_listaController implements Initializable {

    @FXML
    private TableView<CadFilmes> tbLista;
    @FXML
    private TableColumn<CadFilmes, Integer> colNome;
    @FXML
    private TableColumn<CadFilmes, String> colGenero;
    @FXML
    private TableColumn<CadFilmes, String> colClassificacao;
    @FXML
    private TableColumn<CadFilmes, String> colSinopse;
    @FXML
    private TableColumn<CadFilmes, String> colDistribuidora;
    @FXML
    private TableColumn<CadFilmes, String> colImagem;

     private CadFilmesDAO filmesDAO;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filmesDAO = new CadFilmesDAO(); // Inicializa o DAO

        // Configura as colunas para exibição dos dados
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
        colSinopse.setCellFactory(column -> new WrappingTextCell<>());
        colSinopse.setCellValueFactory(new PropertyValueFactory<>("sinopse"));
        colDistribuidora.setCellValueFactory(new PropertyValueFactory<>("distribuidora"));
        colImagem.setCellFactory(column -> new ImageTableCell<>());
        colImagem.setCellValueFactory(new PropertyValueFactory<>("image"));


        // Chama o método para carregar os dados do banco na TableView
        try {
            Collection<CadFilmes> filmes = filmesDAO.lista(null); // Pode passar um critério de filtro, se necessário
            tbLista.setItems(FXCollections.observableArrayList(filmes));
        } catch (SQLException e) {
            e.printStackTrace();
            // Lida com exceções, se necessário
        }
    }    


    public class ImageTableCell<CadFilmes> extends TableCell<CadFilmes, String> {
        private final ImageView imageView = new ImageView();

        public ImageTableCell() {
            setGraphic(imageView);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }

        @Override
        protected void updateItem(String imagePath, boolean empty) {
            super.updateItem(imagePath, empty);

            if (empty || imagePath == null || imagePath.isEmpty()) {
                imageView.setImage(null);
                imageView.setFitWidth(60); // Define a largura da imagem
                imageView.setFitHeight(60); // Define a altura da imagem
            } else {
                Image image = new Image("file:" + imagePath);
                imageView.setImage(image);
                imageView.setFitWidth(60); // Define a largura da imagem
                imageView.setFitHeight(60); // Define a altura da imagem
            }
        }
    }


    public class WrappingTextCell<CadFilmes, String> extends TableCell<CadFilmes, String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                tbLista.setFixedCellSize(80); // Define a altura fixa da célula
                setText(item.toString());
                setWrapText(true); // Habilita a quebra de texto
            }
        }
    }


    
    @FXML
    private void tbLista(SortEvent<CadFilmes> event) {
    }

   
    
}
