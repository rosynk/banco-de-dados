package daoImp;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.LojaDAO;
import dao.VendedorDao;
import model.Loja;
import model.Vendedor;

public class LojaDAOImp implements LojaDAO{
        private Conexao conexao = null;
    public LojaDAOImp() throws MarketplaceException { 
        try { 
            conexao = Conexao.getInstance();
        } catch (Exception e) { 
            throw new MarketplaceException( e );
        }
    }

    @Override
    public void inserir(Loja l) throws MarketplaceException {
                    String inserirLoja = """
                INSERT INTO loja (
                        nome, descricao ) VALUES 
                        (?, ?)
                """;
                                String GetId = """
                SELECT UsuarioID FROM Vendedor WHERE CNPJ LIKE ? 
                """;
                String GetIdEndereco = """
                SELECT EnderecoId FROM Vendedor WHERE CNPJ LIKE ? 
                """;
        try { 
                Connection con = conexao.getConnection();
                String usuarioId;
                PreparedStatement psGetId = con.prepareStatement(GetId);
                ResultSet rs = psGetId.executeQuery(); //ARRUMAR PRA ADICIONAR O ID DO ENDERECO E DO VENDEDOR NA LOJA.
                if (rs.next()){
                    usuarioId = rs.getString("UsuarioId");
                } else {
                    throw new RuntimeException("Erro ao obter ID");
                }
                String EnderecoId;
                PreparedStatement psGetIdEndereco = con.prepareStatement(GetIdEndereco);
                rs = psGetIdEndereco.executeQuery();
                if (rs.next()){
                    EnderecoId = rs.getString("EnderecoId");
                } else {
                    throw new RuntimeException("Erro ao obter ID");
                }
                PreparedStatement psLoja = con.prepareStatement(inserirLoja);
            psLoja.setString(1, l.getNome());
            psLoja.setString(2, l.getDescricao());
                
                con.commit();
                con.close();
            } catch (SQLException err) { 
                err.printStackTrace();
            }
    }

    @Override
    public void atualizar(Loja l) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(Loja l) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public List<Loja> pesquisarPorNome(String nome) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarPorNome'");
    }

}