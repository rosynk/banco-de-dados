package dao;

import java.util.List;

import daoImp.MarketplaceException;
import model.Cliente;

public interface ClienteDAO {
    void inserir(Cliente c) throws  MarketplaceException;
    void atualizar(Cliente c) throws MarketplaceException;
    void excluir(Cliente c) throws MarketplaceException;
    List<Cliente> pesquisarPorNome( String nome ) throws MarketplaceException;
}
