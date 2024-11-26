package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ClienteDAO;
import model.Cliente;


public class ClienteDAOImp implements ClienteDAO {
    private Conexao conexao = null;
    public ClienteDAOImp() throws MarketplaceException { 
        try { 
            conexao = Conexao.getInstance();
        } catch (Exception e) { 
            throw new MarketplaceException( e );
        }
    }
    @Override
    public void inserir(Cliente c) throws MarketplaceException {
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
                String inserirCliente = """
                INSER INTO Cliente (UsuarioId, CPF) VALUES (?,?)
                """;
        try { 
                Connection con = conexao.getConnection();
                PreparedStatement psUsuario = con.prepareStatement(inserirUsuario);
                psUsuario.setString(1, c.getNome());
                psUsuario.setString(2, c.getEmail());
                psUsuario.setString(3, c.getTelefone());
                psUsuario.setString(4, c.getSenha());
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

                PreparedStatement psCliente = con.prepareStatement(inserirCliente);
                psCliente.setString(1, usuarioId);
                psCliente.setString(2, EnderecoId);
                psCliente.setString(3, c.getCpf());
                psCliente.executeUpdate();

                con.commit();
                con.close();
            } catch (SQLException err) { 
                err.printStackTrace();
            }
    }
    @Override
    public void atualizar(Cliente c) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }
    @Override
    public void excluir(Cliente c) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }
    @Override
    public List<Cliente> pesquisarPorNome(String nome) throws MarketplaceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarPorNome'");
    }

    }
