package control;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import model.Loja;
import model.Produto;
import dao.LojaDAO;
import daoImp.LojaDAOImp;
import daoImp.MarketplaceException;

public class LojaControl {
    private LojaDAO LDAO = null;
    private StringProperty id = new SimpleStringProperty("");
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty descricao = new SimpleStringProperty("");
    private ObservableList<Produto> observableList = ProdutoControl.lista;
    private ListProperty<Produto> prdts = new SimpleListProperty<Produto>(observableList);

    public LojaControl() throws MarketplaceException{
        try{
            LDAO = new LojaDAOImp();
        }catch (Exception e){
            throw new MarketplaceException(e);
        }
    }
    /*public void listarProdutos(){
        //listar produtos da lista
    }*/

	public void gravar (){
        Loja l = new Loja(
            this.nome.get(),
            this.descricao.get(), prdts
        );
        LDAO.inserir();
    }

    public void retirarProduto(){
        Loja l = new Loja (
            this.id.get(),
            this.nome.get(),
            this.descricao.get(), prdts
        );

        lista.remove(l);
    }
    //Criar uma forma de procurar o id da loja no produto
    public Produto procurarProdutoPorId(String idProduto) {
        for (Produto p : ProdutoControl.lista) {
            if (p.getId().equals(idProduto)) {
                return p;
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }
    
}
