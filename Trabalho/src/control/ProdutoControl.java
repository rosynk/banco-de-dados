package control;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import daoImp.MarketplaceException;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import daoImp.MarketplaceException;
import model.Produto;

public class ProdutoControl {

    private StringProperty id = new SimpleStringProperty("");  
    private StringProperty nome = new SimpleStringProperty("");  
    private StringProperty descricao = new SimpleStringProperty("");  
    private DoubleProperty valor = new SimpleDoubleProperty(0.0);
    private IntegerProperty quantidadeEstoque = new SimpleIntegerProperty(0);  

    static ObservableList <Produto> lista = FXCollections.observableArrayList();

    
    public void gravar(){
        Produto p = new Produto(
            this.id.get(),
            this.nome.get(),
            this.descricao.get(),
            this.valor.get(),
            this.quantidadeEstoque.get()

        );

             lista.add(p);
        
    }

    public void excluirProduto (Produto p){
        System.out.println("Excluido contato com nome: " + p.getNome());
        lista.remove(p);
        produtoDAO.remover(p); 
        //pesquisarTodos();
    }

     public ObservableList<Produto> getListaProdutos() { 
        return this.lista;
    }

    public Produto getProdutoPorId(String id2) {
           Produto produto = null;
        try {
            produto = produtoDAO.pesquisarPorProdutos(nome);
        } catch (MarketplaceException e) {
            e.printStackTrace();
            MarketplaceException();
        }
        return produto;
    }
    }
    
    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public DoubleProperty valorProperty() {
        return valor;
    }

    public IntegerProperty quantidadeEstoqueProperty() {
        return quantidadeEstoque;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public void setValor(double valor) {
        this.valor.set(valor);
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque.set(quantidadeEstoque);
    }

    
}
