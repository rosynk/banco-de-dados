package dao;

import java.util.List;

import daoImp.MarketplaceException;
import model.Produto;

public interface ProdutoDAO {
     void inserir(Produto p) throws  MarketplaceException;
    // void atualizar(Produto p) throws MarketplaceException;
    void remover (Produto p) throws MarketplaceException;
    List<Produto> pesquisarTodos() throws MarketplaceException;
    List<Produto> pesquisarPorProdutos( String nome ) throws MarketplaceException;
}
