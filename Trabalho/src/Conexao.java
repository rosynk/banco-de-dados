import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=trabalhoBancoDeDados;trustServerCertificate=true";
    private static final String USER = "BEATRIZ";
    private static final String PASSWORD = "scooby";

    private static Connection connection;

    private Conexao() {
        // Evitar instâncias da classe Conexao
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
