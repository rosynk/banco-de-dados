package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoDaoImp implements ProdutoDAO {

    private Conexao conexao = null;

   public ProdutoDaoImp() throws MarketplaceException { 
        try { 
            conexao = Conexao.getInstance();
        } catch (Exception e) { 
            throw new MarketplaceException( e );
        }
    }

    
        @Override
        public void inserir(Produto p) throws MarketplaceException  {
            try { 
                String SQL = """
                        INSERT INTO produtos (
                            id, nome, descricao, valor, quantidade_estoque ) 
                        VALUES (?, ?, ?, ?, ?)
                        """;
                Connection con = Conexao.getInstance().getConnection();
                PreparedStatement stm = con.prepareStatement(SQL);
                stm.setString(1, p.getId());
                stm.setString(2, p.getNome());
                stm.setString(3, p.getDescricao());
                stm.setDouble(4, p.getValor());
                stm.setInt(5, p.getQuantidadeEstoque());
                stm.executeUpdate();
                con.close();
            } catch (SQLException err) { 
                err.printStackTrace();
            }
        }

            @Override
        public List<Produto> pesquisarTodos() throws MarketplaceException {
            List<Produto> listaProdutos = new ArrayList<>();
            try {
                String SQL = "SELECT * FROM produtos";
                Connection con = Conexao.getInstance().getConnection();
                PreparedStatement stm = con.prepareStatement(SQL);
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    Produto p = new Produto(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("valor"),
                        rs.getInt("quantidade_estoque")
                    );
                    listaProdutos.add(p);
                }
                con.close();
            } catch (SQLException err) {
                err.printStackTrace();  
            }
            return listaProdutos;
        }


        @Override
        public List<Produto> pesquisarPorProdutos(String nome) throws MarketplaceException {
            List<Produto> listaProdutos = new ArrayList<>();
            try {
                String SQL = "SELECT * FROM produtos WHERE nome LIKE ?";
                Connection con = Conexao.getInstance().getConnection();
                PreparedStatement stm = con.prepareStatement(SQL);

                
                stm.setString(1, "%" + nome + "%"); 

                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    Produto p = new Produto(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("valor"),
                        rs.getInt("quantidade_estoque")
                    );
                    listaProdutos.add(p);
                }
                con.close();
            } catch (SQLException err) {
                err.printStackTrace(); 
            return listaProdutos;
        }

    }
}
