package view;

import control.ClienteControl;
import control.MudarTela;
import control.ProdutoControl;
import daoImp.MarketplaceException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Cliente;
import model.Produto;

public class ClienteBoundary {

    private Label lblId = new Label("ID: ");
    private Label lblNome = new Label("Nome: ");
    private Label lblDescricao = new Label("");
    private TextField txtNomeProduto = new TextField();

    private ProdutoControl controlProduto = new ProdutoControl();
    private TableView<Produto> tableView = new TableView<>();  
    private MudarTela mt = new MudarTela();

    private Cliente cliente = new Cliente();
    private ClienteControl control;

    private ObservableList<Produto> produtos = FXCollections.observableArrayList(); // Lista de produtos a ser exibida na tabela

    public void telaCliente (GridPane pane, ToggleGroup group){
        
        // Definir as colunas da tabela
        TableColumn<Produto, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<Produto, String>("id"));

        TableColumn<Produto, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("id"));

        TableColumn<Produto, String> colDescricao = new TableColumn<>("Descrição");
        colDescricao.setCellValueFactory(new PropertyValueFactory<Produto, String>("id"));

        TableColumn<Produto, Double> colValor = new TableColumn<>("Valor");
        colValor.setCellValueFactory(new PropertyValueFactory<Produto, Double>("id"));

        TableColumn<Produto, Integer> colQuantidade = new TableColumn<>("Quantidade");
        colQuantidade.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));

        // Adicionar as colunas à tabela
        tableView.getColumns().add(colId);
        tableView.getColumns().add(colNome);
        tableView.getColumns().add(colDescricao);
        tableView.getColumns().add(colValor);
        tableView.getColumns().add(colQuantidade);

        // Adicionar a tabela ao painel (pane)
        pane.add(tableView, 0, 5, 3, 1);  // A tabela será exibida na linha 5

        // Adicionar rótulos e campos de entrada
        pane.add(lblId, 0, 0);
        pane.add(lblNome, 1, 0);
        pane.add(lblDescricao, 2, 0);

        pane.add(new Label("Nome do Produto: "), 0, 2);
        pane.add(txtNomeProduto, 1, 2);

        // Botão de pesquisa
        Button btnPesquisarNomeProduto = new Button("Pesquisar Produto");
        btnPesquisarNomeProduto.setOnAction(e -> {
            try {
                control.pesquisarNomeProduto();  // Realiza a pesquisa dos produtos
                atualizarTabela();  // Atualiza a tabela com os produtos encontrados
            } catch (MarketplaceException ex) {
                ex.printStackTrace();
            }
        });
        pane.add(btnPesquisarNomeProduto, 1, 3);  // Adiciona o botão ao painel

        Button btnAdicionarCarrinho = new Button("Adicionar Carrinho");
        btnAdicionarCarrinho.setOnAction(e -> {
            try {
                mt.mudarScene(pane, group, null);
            } catch (MarketplaceException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        });
    }

    // Método para atualizar a tabela com os produtos encontrados
    private void atualizarTabela() {
        // Obter a lista de produtos do controlador
        ObservableList<Produto> produtosEncontrados = control.getListaProdutos();  // Assumindo que control possui um método que retorna a lista
        produtos.clear();  // Limpar a lista anterior
        produtos.addAll(produtosEncontrados);  // Adicionar os novos produtos

        // Atualizar a tabela com os produtos
        tableView.setItems(produtos);
    }
}
