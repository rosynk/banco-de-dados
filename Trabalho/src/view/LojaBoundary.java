//Cadastro da Loja, assim que o usuario aperta o botão gravar, ele vai para o VendedorBOundary


package view;

import control.LojaControl;
import control.MudarTela;
import daoImp.MarketplaceException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;


public class LojaBoundary{

    private Label lblId = new Label();
    private TextField txtNome = new TextField();
    private TextField txtDescricao = new TextField();


    MudarTela mt = new MudarTela();

    LojaControl lcontrol = null;


    public void telaLoja(GridPane pane, ToggleGroup group) throws MarketplaceException {
        Button btnGravar = new Button("Gravar Loja");

        pane.add(new Label("Nome da Loja"), 0, 1);
        pane.add(txtNome, 1, 1);

        pane.add(new Label("Descrição da Loja"), 0, 2);
        pane.add(txtDescricao, 1, 2);

        pane.add(btnGravar, 0, 3);
        
        btnGravar.setOnAction(e -> {
            lcontrol.gravar();
            try {
                mt.mudarScene(pane, null, "VENDEDOR");
            } catch (MarketplaceException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

       
    }

}
