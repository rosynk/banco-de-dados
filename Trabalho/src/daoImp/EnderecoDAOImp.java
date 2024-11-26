package daoImp;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.EnderecoDAO;
import model.Endereco;

public class EnderecoDAOImp implements EnderecoDAO{
        private Conexao conexao = null;
    public EnderecoDAOImp() throws MarketplaceException { 
        try { 
            conexao = Conexao.getInstance();
        } catch (Exception e) { 
            throw new MarketplaceException( e );
        }
    }

    @Override
    public void inserir(Endereco e) throws MarketplaceException {
                String inserirEndereco = """
                INSERT INTO Endereco (
                        logradouro, numero, complemento, bairro,
                        cidade, estado, cep ) VALUES 
                        (?, ?, ?, ?, ?, ?, ?)
                """;
        try { 
                Connection con = conexao.getConnection();
                PreparedStatement psEndereco = con.prepareStatement(inserirEndereco);
            psEndereco.setString(1, e.getLogradouro());
            psEndereco.setLong(2, e.getNumero());
            psEndereco.setString(3, e.getComplemento());
            psEndereco.setString(4, e.getBairro());
            psEndereco.setString(5, e.getCidade());
            psEndereco.setString(6, e.getEstado());
            psEndereco.setString(7, e.getCep());
                
                con.commit();
                con.close();
            } catch (SQLException err) { 
                err.printStackTrace();
            }
    }

    @Override
    public void atualizar(Endereco e) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(Endereco e) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public List<Endereco> pesquisarTodos() throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarTodos'");
    }

    @Override
    public List<Endereco> pesquisarPorLogradouro(String logradouro) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarPorLogradouro'");
    }

}