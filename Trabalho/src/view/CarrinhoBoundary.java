package view;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.cell.PropertyValueFactory;
import control.CarrinhoControl;
import control.PedidoControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Carrinho;
import model.Produto;

public class CarrinhoBoundary {

   
    private TableView<Carrinho> tableCarrinho = new TableView<>();

    private TableColumn<Carrinho, String> colProduto = new TableColumn<>("Produto");
    private TableColumn<Carrinho, Integer> colQuantidade = new TableColumn<>("Quantidade");
    private TableColumn<Carrinho, Double> colValorTotal = new TableColumn<>("Valor Total");
    private TableColumn<Carrinho, Void> colAcoes = new TableColumn<>("Ações");

  
    private Button btnComprar = new Button("Comprar");

   
    private ObservableList<Carrinho> listaCarrinho = FXCollections.observableArrayList();

    CarrinhoControl control = new CarrinhoControl();
    PedidoControl controlPedido = new PedidoControl();

    public void telaCarrinho(GridPane pane, ToggleGroup group) {

        colProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));

        colAcoes.setCellFactory(col -> new TableCell<Carrinho, Void>() {
            private final Button btnRemover = new Button("Remover");
            Carrinho carrinhoSelecionado = getTableView().getItems().get(getIndex());

            {
                btnRemover.setOnAction(e -> {                   
                    listaCarrinho.remove(carrinhoSelecionado);
                    tableCarrinho.refresh();
                });
            }

            private Button btnAdicionar = new Button("Adicionar");
            {
                btnAdicionar.setOnAction(e -> {
                    Carrinho carrinhoSelecionado = getTableView().getItems().get(getIndex());
                    
                    // Incrementa a quantidade do produto
                    carrinhoSelecionado.setQuantidadeProdutos(carrinhoSelecionado.getQuantidadeProdutos() + 1);
                    
                    //Atualizar o valor total assim q vc criar a entidade pedido
                    
                    
                    // Atualiza a tabela
                    tableCarrinho.refresh();
                
                });
            }

            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btnRemover);
                }
            }
        });

       
        tableCarrinho.getColumns().add(colProduto);
        tableCarrinho.getColumns().add(colQuantidade);
        tableCarrinho.getColumns().add(colValorTotal);
        tableCarrinho.getColumns().add(colAcoes);
        
        tableCarrinho.setItems(listaCarrinho);
       
        pane.add(new Label("Carrinho de Compras"), 0, 0);
        pane.add(tableCarrinho, 0, 1, 2, 1); 

        
        btnComprar.setOnAction(e -> {
            //levar para tela de pedido
            controlPedido.compra();
        });

        pane.add(btnComprar, 0, 2); 
    }
}
