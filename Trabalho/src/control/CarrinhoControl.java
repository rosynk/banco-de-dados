package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Carrinho;
import model.Produto;

public class CarrinhoControl {
    // Lista de produtos no carrinho
    private ObservableList<Carrinho> listaCarrinho = FXCollections.observableArrayList();
    int quantidade = 0;

    
    public void adicionarAoCarrinho(Produto produto) {
        for (Carrinho item : listaCarrinho) {
            if (item.getId().equals(produto.getId())) {
                quantidade += 1;
                return;
            }
        }
    }

    
    public void removerDoCarrinho(String produtoId) {
        listaCarrinho.removeIf(item -> item.getId().equals(produtoId));
    }

    
    public ObservableList<Carrinho> getListaCarrinho() {
        return listaCarrinho;
    }

    
    public void limparCarrinho() {
        listaCarrinho.clear();
    }

    // Método para calcular o valor total do carrinho
    public double calcularTotal(ProdutoControl produtoControl) {
        double total = 0.0;
        for (Carrinho item : listaCarrinho) {
            Produto produto = produtoControl.getProdutoPorId(item.getId());
            if (produto != null) {
                total += produto.getValor() * quantidade;
            }
        }
        return total;
    }
}
