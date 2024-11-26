//Tela da Loja, onde aparecem os produtos, nome da Loja, Id e tal tal


package view;

import control.MudarTela;
import control.ProdutoControl;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class ProdutoBoundary {

    private Label lblId  = new Label();
    private TextField txtNome = new TextField();
    private TextField txtDescricao = new TextField();
    private TextField txtValor = new TextField();
    private TextField txtQuantidadeEstoque = new TextField();

    ProdutoControl control = new ProdutoControl();
    MudarTela mt = new MudarTela();

    public void telaProduto (GridPane pane, ToggleGroup group){

        pane.add(new Label("ID"), 0 ,0);
        pane.add(lblId, 0, 1);

        pane.add(new Label("Nome"), 0, 1);
        pane.add(txtNome, 1, 1);

        pane.add(new Label("Descrição"), 0, 2);
        pane.add(txtDescricao, 1, 2);

        pane.add(new Label("Valor"), 0, 3);
        pane.add(txtValor, 1, 3);

        pane.add(new Label("Quantidade em Estoque"), 0, 4);
        pane.add(txtQuantidadeEstoque, 1, 4);

        Button btnGravar = new Button("Gravar Produto");
        pane.add(btnGravar, 0, 5);

        btnGravar.setOnAction(e ->{
            control.gravar();
            mt.mudarScene(pane, group, "Vendedor");
        });

    }
    
}
