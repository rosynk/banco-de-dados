package daoImp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=trabalhoBancoDeDados;trustServerCertificate=true";
    private static final String DB_USER = "BEATRIZ";
    private static final String DB_PASS = "scooby";

    private static Conexao instancia;
    private Connection connection;

    private Conexao() throws MarketplaceException {
        try {
            Class.forName(DB_CLASS);
        } catch (ClassNotFoundException e) { 
            throw new MarketplaceException( e );
        }
    }

    public static Conexao getInstance() throws MarketplaceException { 
        if (instancia == null) { 
            instancia = new Conexao();
        }
        return instancia;
    }

    public Connection getConnection() throws MarketplaceException {
        try { 
            if (this.connection == null || 
                this.connection.isClosed() || 
                !this.connection.isValid(5000)) { 
                    this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            }
        } catch (SQLException e) { 
            throw new MarketplaceException(e);
        }
        return this.connection;
    }
    
}


