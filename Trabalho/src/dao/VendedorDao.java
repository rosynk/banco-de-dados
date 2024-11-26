package dao;

import java.util.List;
import daoImp.MarketplaceException;
import model.Vendedor;

public interface VendedorDao {
    void inserir(Vendedor v) throws  MarketplaceException;
    void atualizar(Vendedor v) throws MarketplaceException;
    void excluir(Vendedor v) throws MarketplaceException;
    List<Vendedor> pesquisarPorNome( String nome ) throws MarketplaceException;
}
