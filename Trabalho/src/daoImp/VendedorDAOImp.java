package daoImp;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.VendedorDao;
import model.Vendedor;


public class VendedorDAOImp implements VendedorDao{
    private Conexao conexao = null;
    public VendedorDAOImp() throws MarketplaceException { 
        try { 
            conexao = Conexao.getInstance();
        } catch (Exception e) { 
            throw new MarketplaceException( e );
        }
    }
    @Override
    public void inserir(Vendedor v) throws MarketplaceException {
                String inserirUsuario = """
                        INSERT INTO Usuario (
                            nome, email, telefone, senha ) 
                        VALUES (?, ?, ?, ?, ?)
                        """;
                String GetId = """
                SELECT SCOPE_IDENTITY() AS UsuarioId
                """;
                String GetIdEndereco = """
                SELECT SCOPE_IDENTITY() AS EnderecoId
                """;
                String inserirVendedor = """
                INSER INTO Vendedor (UsuarioId, EnderecoId, CNPJ) VALUES (?,?,?)
                """;
        try { 
                Connection con = conexao.getConnection();
                PreparedStatement psUsuario = con.prepareStatement(inserirUsuario);
                psUsuario.setString(1, v.getNome());
                psUsuario.setString(2, v.getEmail());
                psUsuario.setString(3, v.getTelefone());
                psUsuario.setString(4, v.getSenha());
                psUsuario.executeUpdate();
                
                String usuarioId;
                PreparedStatement psGetId = con.prepareStatement(GetId);
                ResultSet rs = psGetId.executeQuery();
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

                PreparedStatement psVendedor = con.prepareStatement(inserirVendedor);
                psVendedor.setString(1, usuarioId);
                psVendedor.setString(2, EnderecoId);
                psVendedor.setString(3, v.getCnpj());
                psVendedor.executeUpdate();
                
                con.commit();
                con.close();
            } catch (SQLException err) { 
                err.printStackTrace();
            }
    }
    @Override
    public void atualizar(Vendedor v) throws MarketplaceException {
        
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }
    @Override
    public void excluir(Vendedor v) throws MarketplaceException {
       
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }
    @Override
    public List<Vendedor> pesquisarPorNome(String nome) throws MarketplaceException {
       
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarPorNome'");
    }
    
}
