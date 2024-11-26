package dao;

import daoImp.MarketplaceException;
import model.Loja;
import java.util.List;

public interface LojaDAO {
    void inserir(Loja l) throws  MarketplaceException;
    void atualizar(Loja l) throws MarketplaceException;
    void excluir(Loja l) throws MarketplaceException;
    List<Loja>pesquisarPorNome( String nome ) throws MarketplaceException;
}
