package control;

import java.util.List;

import dao.ProdutoDAO;
import daoImp.MarketplaceException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import model.Cliente;
import model.Produto;
import daoImp.ProdutoDaoImp;

public class ClienteControl extends UsuarioControl {
    private ProdutoDAO produtoDAO = null;
    private StringProperty nome = new SimpleStringProperty("");

    public ClienteControl() throws MarketplaceException{
        produtoDAO = new ProdutoDaoImp();
    }

     private ObservableList<Produto> lista = FXCollections.observableArrayList();

    public void pesquisarNomeProduto() throws MarketplaceException{
        List<Produto> tempLista = 
                produtoDAO.pesquisarPorProdutos(nome.get());
        lista.clear();
        lista.addAll(tempLista);
    }

    public ObservableList<Produto> getListaProdutos() {
        return lista;
    }
    
}
