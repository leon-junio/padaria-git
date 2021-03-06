/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Produto;
import classes.Cardapio;
import dao.DAOCardapio;
import dao.DAOProdutos;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class FormProdutos extends javax.swing.JDialog {

    /**
     * Creates new form FormProdutos
     */
    DAOProdutos dao = new DAOProdutos();
    DAOCardapio daoc = new DAOCardapio();

    /**
     * Construtor da tela de cadastro de produtos
     *
     * @param parent Onde vai ser renderizado
     * @param modal Editavel ou não
     */
    public FormProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizaTabela();
    }

    /**
     * Método que atualiza a tabela e os lists
     */
    public void atualizaTabela() {
        DefaultComboBoxModel dft = new DefaultComboBoxModel(daoc.getLista().toArray());
        cbxCardapio.setModel(dft);
        listCardapio.clear();
        listCardapio.addAll(daoc.getLista());

        listProduto.clear();
        listProduto.addAll(dao.getLista());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listCardapio = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Cardapio>());
        listProduto = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Produto>());
        ;
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxCardapio = new javax.swing.JComboBox<>();
        btnAlterar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        spnQtd = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        jLabel1.setText("Digite o nome do produto:");

        txtNome.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        txtNome.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        jLabel2.setText("Digite o preço do produto:");

        txtPreco.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        txtPreco.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        jLabel3.setText("Digite o código de barras do produto:");

        jLabel5.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        jLabel5.setText("Cadastro de Produtos");

        btnSalvar.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        txtCodigo.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        txtCodigo.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        jLabel4.setText("Escolha o cardapio do produto cadastrado:");

        cbxCardapio.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        cbxCardapio.setEnabled(false);

        btnAlterar.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        jLabel7.setText("Escolha a quantidade:");

        spnQtd.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        spnQtd.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnQtd.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(spnQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(333, 333, 333)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(spnQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Cadastro", jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblProduto.setFont(new java.awt.Font("Haettenschweiler", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listProduto, tblProduto);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduto}"));
        columnBinding.setColumnName("Id Produto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidade}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${preco}"));
        columnBinding.setColumnName("Preço");
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${card}"));
        columnBinding.setColumnName("Cardápio");
        columnBinding.setColumnClass(classes.Cardapio.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(0).setResizable(false);
            tblProduto.getColumnModel().getColumn(1).setResizable(false);
            tblProduto.getColumnModel().getColumn(2).setResizable(false);
            tblProduto.getColumnModel().getColumn(3).setResizable(false);
        }

        btnExcluir.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtFind.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        jLabel6.setText("Digite um nome para localizar:");

        btnAtualizar.setFont(new java.awt.Font("Haettenschweiler", 0, 18)); // NOI18N
        btnAtualizar.setText("Atualizar tabela");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btnAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)))
                        .addGap(0, 398, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEditar)
                                .addComponent(btnExcluir))
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que inicia os campos para a inserção de dados
     *
     * @param evt Clique no botão novo
     */
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txtNome.setEnabled(true);
        spnQtd.setEnabled(true);
        cbxCardapio.setEnabled(true);
        txtPreco.setEnabled(true);
        txtCodigo.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnNovo.setEnabled(false);
        txtNome.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed
    /**
     * Método que limpa os campos
     */
    public void limpar() {
        txtNome.setText("");
        txtPreco.setText("");
        txtCodigo.setText("");

    }

    /**
     * Método que altera um produto do banco de dados
     *
     * @param evt Clique no botão alterar
     */
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhaSelecionada = tblProduto.getSelectedRow();
        Produto obj = listProduto.get(linhaSelecionada);
        obj.setPreco(Float.parseFloat(txtPreco.getText()));
        obj.setNome(txtNome.getText());
        obj.setQuantidade((int) spnQtd.getValue());
        obj.setCodigo(Integer.parseInt(txtCodigo.getText()));
        obj.setCardapio((cbxCardapio.getSelectedIndex() + 1));
        obj.setCard(obj.getCardapioObj(obj.getCardapio()));
        if (dao.alterar(obj)) {
            JOptionPane.showMessageDialog(null, "atualizado com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "não atualizado com sucesso");
        }
        atualizaTabela();
        limpar();
        spnQtd.setEnabled(!true);
        btnSalvar.setEnabled(false);
        btnNovo.setEnabled(!false);
        btnAlterar.setEnabled(!true);
        cbxCardapio.setEnabled(false);
        txtCodigo.setEnabled(false);
        txtNome.setEnabled(false);
        txtPreco.setEnabled(false);
    }//GEN-LAST:event_btnAlterarActionPerformed
    /**
     * Botao que salva um produto no banco de dados
     *
     * @param evt Clique no botao salvar
     */
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Produto obj = new Produto();
        obj.setPreco(Float.parseFloat(txtPreco.getText()));
        obj.setNome(txtNome.getText());
        obj.setQuantidade((int) spnQtd.getValue());
        obj.setCardapio((cbxCardapio.getSelectedIndex() + 1));
        obj.setCodigo(Integer.parseInt(txtCodigo.getText()));
        obj.setCard(obj.getCardapioObj(obj.getCardapio()));
        if (dao.incluir(obj)) {
            JOptionPane.showMessageDialog(null, "Incluido com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "Não incluido com sucesso");
        }
        atualizaTabela();
        limpar();
        spnQtd.setEnabled(!true);
        txtNome.setEnabled(!true);
        txtPreco.setEnabled(!true);
        txtCodigo.setEnabled(false);
        btnSalvar.setEnabled(!true);
        btnNovo.setEnabled(!false);
        cbxCardapio.setEnabled(false);
    }//GEN-LAST:event_btnSalvarActionPerformed
    /**
     * Método que exclui um produto do banco de dados
     *
     * @param evt Clique no botao excluir
     */
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tblProduto.getSelectedRow();
        Produto obj = listProduto.get(linhaSelecionada);
        dao.remover(obj);
        atualizaTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed
    /**
     * Método que atualiza a tabela
     *
     * @param evt Clique no botao atualizar
     */
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed
    /**
     * Método que prepara os campos para a edição de um produto
     *
     * @param evt Clique no botao editar
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linhaSelecionada = tblProduto.getSelectedRow();
        Produto obj = listProduto.get(linhaSelecionada);
        txtNome.setText(obj.getNome());
        txtPreco.setText("" + obj.getPreco());
        txtCodigo.setText("" + obj.getCodigo());
        cbxCardapio.setEnabled(true);
        spnQtd.setEnabled(true);
        cbxCardapio.setSelectedIndex(obj.getCardapio() - 1);
        txtNome.requestFocus();
        btnSalvar.setEnabled(false);
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(true);
        txtNome.setEnabled(true);
        txtPreco.setEnabled(true);
        txtCodigo.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed
    /**
     * Método que pesquisa por um nome com base no texto digitado
     *
     * @param evt Cada clique no teclado
     */
    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        if (evt.getKeyCode() == evt.VK_A || evt.getKeyCode() == evt.VK_B || evt.getKeyCode() == evt.VK_C || evt.getKeyCode() == evt.VK_D || evt.getKeyCode() == evt.VK_E
                || evt.getKeyCode() == evt.VK_F || evt.getKeyCode() == evt.VK_G || evt.getKeyCode() == evt.VK_H || evt.getKeyCode() == evt.VK_I || evt.getKeyCode() == evt.VK_J
                || evt.getKeyCode() == evt.VK_K || evt.getKeyCode() == evt.VK_L || evt.getKeyCode() == evt.VK_M || evt.getKeyCode() == evt.VK_N || evt.getKeyCode() == evt.VK_O
                || evt.getKeyCode() == evt.VK_P || evt.getKeyCode() == evt.VK_Q || evt.getKeyCode() == evt.VK_R || evt.getKeyCode() == evt.VK_S || evt.getKeyCode() == evt.VK_T
                || evt.getKeyCode() == evt.VK_U || evt.getKeyCode() == evt.VK_V || evt.getKeyCode() == evt.VK_X || evt.getKeyCode() == evt.VK_Y || evt.getKeyCode() == evt.VK_Z
                || evt.getKeyCode() == evt.VK_BACK_SPACE) {
            atualizar(txtFind.getText());
        }
    }//GEN-LAST:event_txtFindKeyReleased
    /**
     * Método que cancela as ações e limpa os campos
     *
     * @param evt Clique no botao cancelar
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpar();
        btnSalvar.setEnabled(false);
        btnNovo.setEnabled(!false);
        btnAlterar.setEnabled(!true);
        spnQtd.setEnabled(!true);
        txtNome.setEnabled(!true);
        txtPreco.setEnabled(!true);
        txtCodigo.setEnabled(false);
        cbxCardapio.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Método que atualiza a lista de produtos
     *
     * @param nome Nome digitado no campo de texto
     */
    public void atualizar(String nome) {
        listProduto.clear();
        listProduto.addAll(dao.localizarNome("select * from produto where nome like '" + nome + "%';"));
    }

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
            java.util.logging.Logger.getLogger(FormProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormProdutos dialog = new FormProdutos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCardapio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private java.util.List<Cardapio> listCardapio;
    private java.util.List<Produto> listProduto;
    private javax.swing.JSpinner spnQtd;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
