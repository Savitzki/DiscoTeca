package controller;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.DAO.MusicaDAO;
import model.bean.Musica;
import view.Discoteca;
import view.ListaMusicas;

/**
 *
 * @author Marina Savitzki
 */
public class ListaMusicasController {

    private final ListaMusicas view;
    Discoteca viewDiscoteca;


    public ListaMusicasController(ListaMusicas view) throws SQLException {
        this.view = view;
        this.viewDiscoteca = new Discoteca();
    }

    public void recuperaDados(int id) throws SQLException {
        if (id != -1) {
            view.getNomeDiscoJTF().setText(viewDiscoteca.getDiscos().getValueAt(id, 1).toString());
            view.getAnoLancamentoJTF().setText(viewDiscoteca.getDiscos().getValueAt(id, 2).toString());
            view.getArtista_bandaJTF().setText(viewDiscoteca.getDiscos().getValueAt(id, 3).toString());
        }
    }

    public void tabelaMusicas(int id) throws SQLException {
        DefaultTableModel modeloTabela = (DefaultTableModel) view.getListaMusicas().getModel();
        MusicaDAO musicaDAO = new MusicaDAO();

        modeloTabela.setNumRows(0);
        for (Musica musica : musicaDAO.read(id+1)) {
            modeloTabela.addRow(new Object[]{
                musica.getId(),
                musica.getTitulo(),
                musica.getDuracao()
            });
        }
    }
    
}
