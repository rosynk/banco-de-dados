package control;

import javafx.scene.layout.GridPane;
import javafx.scene.control.ToggleGroup;
import view.*;
import daoImp.MarketplaceException;

public class MudarTela {
    public void mudarScene(GridPane pane, ToggleGroup group, String cena) throws MarketplaceException{
        pane.getChildren().clear();

        switch (cena) {
            case "LOGIN":
                Login login = new Login();
                login.telaLogin(pane, group);
                break;
            case "CADASTRAR":
                UsuarioBoundary cadastrar = new UsuarioBoundary();
                cadastrar.telaCadastrar(pane, group);
                break;
            case "CPF":
                ClienteBoundary cliente = new ClienteBoundary();
                cliente.telaCliente(pane, group);
                break;
            case "CNPJ":
                VendedorBoundary vendedor = new VendedorBoundary();
                vendedor.telaVendedor(pane, group);
                break;
            case "PRODUTO":
                ProdutoBoundary produto = new ProdutoBoundary();
                produto.telaProduto(pane, group);
                break;
            case "LOJA":
                LojaBoundary loja = new LojaBoundary();
                loja.telaLoja(pane, group);
            case "Carrinho":
                CarrinhoBoundary carrinho = new CarrinhoBoundary();
                carrinho.telaCarrinho(pane, group);
                break;
        }
    }
}
