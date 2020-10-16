package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author Marina Savitzki
 */
public class ConnectionFactory  {

    public ConnectionFactory () {
    }

//Parametros da conexao ao Banco de dados    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/discoteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";

//Metodo conectar
    public static Connection conectar() throws SQLException {
//        System.out.println("Conectando ao banco...");

        try {
            Class.forName(DRIVER);
//            System.out.println("Conectado.");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexao ao Banco de dados: ", ex);
        }

    }

//Metodo fecharConexao simples
    public static void fecharConexao(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory .class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Metodo fecharConexao com transação aberta
    public static void fecharConexao(Connection conn, PreparedStatement statement) {
        fecharConexao(conn);
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory .class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Metodo fechar conexao, transacao e resultado da consulta
    public static void fecharConexao(Connection conn, PreparedStatement statement, ResultSet result) {
        fecharConexao(conn, statement);
        try {
            if (result != null) {
                result.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory .class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
