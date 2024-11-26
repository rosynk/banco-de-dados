package view;

import control.MudarTela;
import control.ProdutoControl;
import daoImp.MarketplaceException;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import model.Produto;
import model.Loja;

public class VendedorBoundary {

    private Label lblId = new Label("");
    private Label lblNome = new Label("");
    private Label lblDescricao = new Label("");

    private TextField txtNomeProduto = new TextField();
    
    private ProdutoControl controlProduto = new ProdutoControl();
    private TableView<Produto> tableView = new TableView<>();  // Tabela de produtos

    private Button btnGravarProduto = new Button("Adicionar Produto");
    private MudarTela mt = new MudarTela();

    private Loja loja;

    // Método para renderizar a tela do vendedor
    public void telaVendedor(GridPane pane, ToggleGroup toggle) {
        pane.add(new Label("Id da Loja: " + loja.getId()), 0, 0);
        pane.add(lblNome, 1, 0);
        pane.add(lblId, 2, 0);
        pane.add(lblDescricao, 0, 1);
        pane.add(new Label("Nome do Produto: "), 0, 2);
        pane.add(txtNomeProduto, 1, 2);

        // Botão de adicionar produto
        btnGravarProduto.setOnAction(e -> {
            try {
                mt.mudarScene(pane, null, "PRODUTO");
            } catch (MarketplaceException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        // Adicionar botão na tela
        pane.add(btnGravarProduto, 0, 4);

        //Adicionar as tabelas
        pane.add(tableView, 0, 5, 3, 1);
        
        // Gerar as colunas da tabela de produtos
        generateColumns();
    }

    // Método para criar as colunas da tabela de produtos
    public void generateColumns() {
        
        TableColumn<Produto, String> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory(new PropertyValueFactory<Produto, String>("id"));

        TableColumn<Produto, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));

        TableColumn<Produto, String> col3 = new TableColumn<>("Descrição");
        col3.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));

        TableColumn<Produto, Void> col4 = new TableColumn<>("Ações");
        col4.setCellFactory(new Callback<TableColumn<Produto, Void>, TableCell<Produto, Void>>() {
            @Override
            public TableCell<Produto, Void> call(TableColumn<Produto, Void> param) {
                return new TableCell<Produto, Void>() {
                    private final Button btnExcluir = new Button("Excluir");

                    {
                        btnExcluir.setOnAction(e -> {
                            try {
                                Produto produto = tableView.getItems().get(getIndex());
                                controlProduto.excluirProduto(produto); // Método de excluir produto
                            } catch (Exception err) {
                                alert(AlertType.ERROR, "Erro ao excluir produto");
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnExcluir);
                        }
                    }
                };
            }
        });

        // Adicionar colunas à tabela
        tableView.getColumns().addAll(col1, col2, col3, col4);

        // Popula a tabela com a lista de produtos
        tableView.setItems(controlProduto.getListaProdutos());
        
    }

    // Método para mostrar alertas
    public void alert(AlertType tipo, String msg) {
        javafx.scene.control.Alert alertWindow = new javafx.scene.control.Alert(tipo);
        alertWindow.setHeaderText("Alerta");
        alertWindow.setContentText(msg);
        alertWindow.showAndWait();
    }
}
