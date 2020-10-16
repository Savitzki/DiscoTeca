package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import connection.ConnectionFactory ;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Disco;

/**
 *
 * @author Marina Savitzki
 */
public class DiscoDAO implements InterfaceDAO<Disco>{
    
//Metodo create para salvar novos dados do model

    /**
     *
     * @param disco
     * @return
     * @throws SQLException
     */
    @Override
    public boolean create(Disco disco) throws SQLException{
        Connection conn = ConnectionFactory.conectar();
        PreparedStatement statement = null;
        
        try {
            String query = "INSERT INTO disco(nome_disco, ano_lancamento, artista_banda) VALUES(?,?,?);";
            statement = conn.prepareStatement(query);
            //Setando os parametros da query
            
            statement.setString(1, disco.getNome());
            statement.setInt(2, disco.getAno_lancamento());
            statement.setString(3, disco.getArtista_banda());
            
            //falta adicionar referencia a lista de musicas
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados");
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conn, statement);
        }
        
    }
    
    @Override
    public List<Disco> read() throws SQLException{
        Connection conn = ConnectionFactory.conectar();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Disco> discos = new ArrayList<>();
        
        String query = "SELECT * FROM disco;";
        try {
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            
            while(result.next()){
            Disco disco  = new Disco();
            
            //Obetendo os valores do Banco de dados da tabela Disco
            disco.setId(result.getInt("id_disco"));
            disco.setNome(result.getString("nome_disco"));
            disco.setAno_lancamento(result.getInt("ano_lancamento"));
            disco.setArtista_banda(result.getString("artista_banda"));
            discos.add(disco);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fecharConexao(conn, statement, result);
        }
        return discos;
    }
    @Override
    public List<Disco> read(String string, int id) throws SQLException {
         Connection conn = ConnectionFactory .conectar();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Disco> discos = new ArrayList<>();
        
        String query = "SELECT * FROM disco WHERE disco.nome_disco = ? OR disco.ano_lancamento = ?;";
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, string);
            statement.setInt(2, id);
            result = statement.executeQuery();
            
            while(result.next()){
            Disco disco  = new Disco();
            
            //Obetendo os valores do Banco de dados da tabela Disco
            disco.setId(result.getInt("id_disco"));
            disco.setNome(result.getString("nome_disco"));
            disco.setAno_lancamento(result.getInt("ano_lancamento"));
            disco.setArtista_banda(result.getString("artista_banda"));
            discos.add(disco);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fecharConexao(conn, statement, result);
        }
        return discos;
    }
    @Override
    public boolean update(Disco disco, int id) throws SQLException {
        Connection conn = ConnectionFactory.conectar();
        PreparedStatement statement = null;
        
        try {
            String query = "UPDATE disco SET nome_disco = ?, ano_lancamento = ?, artista_banda ? WHERE  id_disco = ?";
            statement = conn.prepareStatement(query);
            //Setando os parametros da query
            statement.setString(1, disco.getNome());
            statement.setInt(2, disco.getAno_lancamento());
            statement.setString(3, disco.getArtista_banda());
            statement.setInt(4, disco.getId());
            //falta adicionar referencia a lista de musicas
            statement.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conn, statement);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Disco> read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
