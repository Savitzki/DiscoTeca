package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAO.DiscoDAO;
import model.DAO.MusicaDAO;
import model.bean.Disco;
import model.bean.Musica;
import view.Discoteca;
import view.ListaMusicas;

/**
 *
 * @author Marina Savitzki
 */
public class DiscotecaController implements ActionListener {

    private final Discoteca view;
    private int linhaSelecionada = -1;

    public DiscotecaController(Discoteca view) throws SQLException {
        this.view = view;
        this.view.setLocationRelativeTo(null);

        this.view.getBtn_home().addActionListener(this);
        this.view.getBtnNovo().addActionListener(this);
        this.view.getBtnEditar().addActionListener(this);
        this.view.getBtnExcluir().addActionListener(this);
        this.view.getBtnAddMusica().addActionListener(this);
        this.view.getBtnCancelar().addActionListener(this);
        this.view.getBtnListaMusica().addActionListener(this);
        this.view.getBtnPesquisar().addActionListener(this);
        this.view.getBtnLimparPesquisa().addActionListener(this);
        this.view.getBtnSalvar().addActionListener(this);

        visibilidadePanel(false);
        atualizaTabela();
        carregarArtistaBanda();
        carregarAno();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtn_home()) {
            visibilidadePanel(false);
            try {
                atualizaTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "Erro ao atualizar a tabela: " + ex);
            }
        } else if (e.getSource() == view.getBtnNovo()) {
            visibilidadePanel(true);
            carregarMusicas();
        } else if (e.getSource() == view.getBtnEditar()) {
            e.setSource(null);
            linhaSelecionada = view.getDiscos().getSelectedRow();
            if (linhaSelecionada != -1) {
                visibilidadePanel(true);

                view.getIdDiscoJTD().setText((linhaSelecionada + 1) + "");
                view.getNomeDiscoJTF().setText(view.getDiscos().getValueAt(linhaSelecionada, 1).toString());
                view.getAnoLancJTF().setText(view.getDiscos().getValueAt(linhaSelecionada, 2).toString());
                view.getArtistaBandaJTF().setText(view.getDiscos().getValueAt(linhaSelecionada, 3).toString());

                //Carrega a lista de musicas disponiveis
                carregarMusicas();
            } else {
                JOptionPane.showMessageDialog(view, "Selecione uma linha");
            }
        } else if (e.getSource() == view.getBtnExcluir()) {
            //exclui disco
        } else if (e.getSource() == view.getBtnCancelar()) {
            //cancela operação
            visibilidadePanel(false);
        } else if (e.getSource() == view.getBtnListaMusica()) {
            //mostra lista de musicas do disco
            linhaSelecionada = view.getDiscos().getSelectedRow();
            if (linhaSelecionada != -1) {
                try {
                    ListaMusicas viewDialog = new ListaMusicas(null, true);
                    ListaMusicasController controller = new ListaMusicasController(viewDialog);
                    controller.recuperaDados(view.getDiscos().getSelectedRow());
                    controller.tabelaMusicas(view.getDiscos().getSelectedRow());
                    viewDialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DiscotecaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Selecione uma linha");
            }

        } else if (e.getSource() == view.getBtnAddMusica()) {
            //Adiciona uma nova musica para o novo Disco
            Musica musica = new  Musica();
             DefaultTableModel modeloTabela = (DefaultTableModel) view.getListaMusicasTable().getModel();
             musica.setId(view.getLsitaMusicasCB().getSelectedIndex());
             musica.setTitulo(view.getLsitaMusicasCB().getSelectedItem().toString());
             modeloTabela.addRow(new Object[]{
                musica.getId(),
                musica.getTitulo(),
            });
        } else if (e.getSource() == view.getBtnSalvar()) {
            //Captura os dados editados
            Disco disco = new Disco();
            DiscoDAO discoDAO = new DiscoDAO();
            disco = carregaDisco();
            //falta adicionar referencia de musicas
            try {
                discoDAO.create(disco);
                atualizaTabela();
            } catch (SQLException ex) {
                Logger.getLogger(DiscotecaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == view.getBtnPesquisar()) {
            //Filtros de pesquisa na tabela
            try {
                String artista = view.getArtista_bandaCB().getSelectedItem().toString();
                int ano = Integer.parseInt(view.getAnoLancCB().getSelectedItem().toString());
                atualizaTabela(artista, ano);
            } catch (SQLException ex) {
                Logger.getLogger(DiscotecaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (e.getSource() == view.getBtnLimparPesquisa()) {
            try {
                atualizaTabela();
            } catch (SQLException ex) {
                Logger.getLogger(DiscotecaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void atualizaTabela() throws SQLException {
        //Obtendo modelo da tabela Discos
        DefaultTableModel modeloTabela = (DefaultTableModel) view.getDiscos().getModel();

        DiscoDAO discoDAO = new DiscoDAO();
        modeloTabela.setNumRows(0);
        for (Disco disco : discoDAO.read()) {
            modeloTabela.addRow(new Object[]{
                disco.getId(),
                disco.getNome(),
                disco.getAno_lancamento(),
                disco.getArtista_banda()
            });
        }
        view.getDiscos().validate();
    }

    private void atualizaTabela(String artista, int ano) throws SQLException {
        DefaultTableModel modeloTabela = (DefaultTableModel) view.getDiscos().getModel();

        DiscoDAO discoDAO = new DiscoDAO();
        modeloTabela.setNumRows(0);
        for (Disco disco : discoDAO.read(artista, ano)) {
            modeloTabela.addRow(new Object[]{
                disco.getId(),
                disco.getNome(),
                disco.getAno_lancamento(),
                disco.getArtista_banda()
            });
        }
        view.getDiscos().validate();
    }

    private void visibilidadePanel(boolean bool) {
        view.getHomePanel().setVisible(!bool);
        view.getDadosDiscoPanel().setVisible(bool);
    }

    public void carregarMusicas() {
        try {
            MusicaDAO musicaDAO = new MusicaDAO();
            for (Musica musica : musicaDAO.read()) {
                view.getLsitaMusicasCB().addItem(musica.getTitulo());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiscotecaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Disco carregaDisco() {
        Disco disco = new Disco();
        disco.setId(view.getDiscos().getSelectedRow() + 1);
        disco.setNome(view.getNomeDiscoJTF().getText());
        disco.setArtista_banda(view.getArtistaBandaJTF().getText());
        disco.setAno_lancamento(Integer.parseInt(view.getAnoLancJTF().getText()));

        return disco;
    }

    public void carregarArtistaBanda() {
        try {
            DiscoDAO discoDAO = new DiscoDAO();
            for (Disco disco : discoDAO.read()) {
                view.getArtista_bandaCB().addItem(disco.getArtista_banda());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiscotecaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarAno() {
        try {
            DiscoDAO discoDAO = new DiscoDAO();
            for (Disco disco : discoDAO.read()) {
                view.getAnoLancCB().addItem(disco.getAno_lancamento() + "");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiscotecaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
