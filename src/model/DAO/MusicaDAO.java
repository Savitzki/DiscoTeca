package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Musica;

/**
 *
 * @author Marina Savitzki
 */
public class MusicaDAO implements InterfaceDAO<Musica>{
    
    private static final List<Musica> listaMusicas = new ArrayList<>();

    @Override
    public boolean create(Musica objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Musica> read() throws SQLException {
        Connection conn = ConnectionFactory .conectar();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Musica> musicas = new ArrayList<>();
        
        String query = "SELECT * FROM musica;";
        try {
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            
            while(result.next()){
            Musica musica  = new Musica();
            
            //Obetendo os valores do Banco de dados da tabela Musica
            musica.setId(result.getInt("id_musica"));
            musica.setTitulo(result.getString("titulo"));
            musica.setDuracao(result.getString("duracao"));
            musicas.add(musica);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory .fecharConexao(conn, statement, result);
        }
        return musicas;
        
    }
    
    @Override
    public List<Musica> read(int id) throws SQLException{
        Connection conn = ConnectionFactory .conectar();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Musica> musicas = new ArrayList<>();
        
        String query = "select musica.id_musica, musica.titulo, musica.duracao from lista_musica as lista\n" +
                       "inner join disco  on lista.disco_id_disco = disco.id_disco\n" +
                       "inner join musica  on lista.musica_id_musica = musica.id_musica\n" +
                       "where disco.id_disco = ?;";
        try {
            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            
            result = statement.executeQuery();
            
            while(result.next()){
            Musica musica  = new Musica();
            
            //Obetendo os valores do Banco de dados da tabela Musica
            musica.setId(result.getInt("id_musica"));
            musica.setTitulo(result.getString("titulo"));
            musica.setDuracao(result.getString("duracao"));
            musicas.add(musica);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DiscoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory .fecharConexao(conn, statement, result);
        }
        return musicas;
        
    }

    @Override
    public boolean update(Musica objeto, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Musica> read(String string, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
