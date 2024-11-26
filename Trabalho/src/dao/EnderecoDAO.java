package dao;

import java.util.List;
import model.Endereco;
import daoImp.MarketplaceException;
public interface EnderecoDAO {
    void inserir(Endereco e) throws MarketplaceException;
    void atualizar(Endereco e) throws MarketplaceException;
    void excluir(Endereco e) throws MarketplaceException;
    List<Endereco> pesquisarTodos() throws MarketplaceException;
    List<Endereco> pesquisarPorLogradouro( String logradouro ) throws MarketplaceException;
}