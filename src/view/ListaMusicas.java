package view;

import controller.ListaMusicasController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Marina Savitzki
 */
public class ListaMusicas extends javax.swing.JDialog {

    private final ListaMusicasController conttroller;

    /**
     * Creates new form ListaMusicas
     *
     * @param parent
     * @param modal
     * @throws java.sql.SQLException
     */
    public ListaMusicas(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.conttroller = new ListaMusicasController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelListaMusicas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeDiscoJTF = new javax.swing.JTextField();
        anoLancamentoJTF = new javax.swing.JTextField();
        artista_bandaJTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMusicas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setName("listaMusicas"); // NOI18N
        setResizable(false);

        panelListaMusicas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de músicas do disco");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Nome do Disco:");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Ano de lançamento:");

        nomeDiscoJTF.setEditable(false);
        nomeDiscoJTF.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nomeDiscoJTF.setBorder(null);
        nomeDiscoJTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        anoLancamentoJTF.setEditable(false);
        anoLancamentoJTF.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        anoLancamentoJTF.setBorder(null);
        anoLancamentoJTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        artista_bandaJTF.setEditable(false);
        artista_bandaJTF.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        artista_bandaJTF.setBorder(null);
        artista_bandaJTF.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        listaMusicas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listaMusicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Duração"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listaMusicas);
        if (listaMusicas.getColumnModel().getColumnCount() > 0) {
            listaMusicas.getColumnModel().getColumn(0).setMinWidth(100);
            listaMusicas.getColumnModel().getColumn(0).setPreferredWidth(100);
            listaMusicas.getColumnModel().getColumn(0).setMaxWidth(100);
            listaMusicas.getColumnModel().getColumn(2).setMinWidth(150);
            listaMusicas.getColumnModel().getColumn(2).setPreferredWidth(150);
            listaMusicas.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Artista/Banda:");

        javax.swing.GroupLayout panelListaMusicasLayout = new javax.swing.GroupLayout(panelListaMusicas);
        panelListaMusicas.setLayout(panelListaMusicasLayout);
        panelListaMusicasLayout.setHorizontalGroup(
            panelListaMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaMusicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListaMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(panelListaMusicasLayout.createSequentialGroup()
                        .addGroup(panelListaMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelListaMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeDiscoJTF)
                            .addComponent(anoLancamentoJTF)
                            .addComponent(artista_bandaJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelListaMusicasLayout.setVerticalGroup(
            panelListaMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaMusicasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelListaMusicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListaMusicasLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelListaMusicasLayout.createSequentialGroup()
                        .addComponent(nomeDiscoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(anoLancamentoJTF)
                        .addGap(9, 9, 9)
                        .addComponent(artista_bandaJTF)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelListaMusicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelListaMusicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaMusicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaMusicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaMusicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaMusicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaMusicas dialog = null;
                try {
                    dialog = new ListaMusicas(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaMusicas.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoLancamentoJTF;
    private javax.swing.JTextField artista_bandaJTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaMusicas;
    private javax.swing.JTextField nomeDiscoJTF;
    private javax.swing.JPanel panelListaMusicas;
    // End of variables declaration//GEN-END:variables

    public JTextField getArtista_bandaJTF() {
        return artista_bandaJTF;
    }

    public void setArtista_bandaJTF(JTextField artista_bandaJTF) {
        this.artista_bandaJTF = artista_bandaJTF;
    }

    public JTable getListaMusicas() {
        return listaMusicas;
    }

    public void setListaMusicas(JTable listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    public JTextField getNomeDiscoJTF() {
        return nomeDiscoJTF;
    }

    public void setNomeDiscoJTF(JTextField nomeDiscoJTF) {
        this.nomeDiscoJTF = nomeDiscoJTF;
    }

    public JTextField getAnoLancamentoJTF() {
        return anoLancamentoJTF;
    }

    public void setAnoLancamentoJTF(JTextField anoLancamentoJTF) {
        this.anoLancamentoJTF = anoLancamentoJTF;
    }

}