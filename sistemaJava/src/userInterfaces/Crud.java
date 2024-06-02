/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userInterfaces;

import crudjava_2.Querys;
import crudjava_2.UserServices;
import javax.swing.JOptionPane;



/**
 *
 * @author Nog
 * Matéria: Banco de Dados || Professor: Edilson
 * Atividade: Sistema JAVA || Valendo: 7 Pontos.
 * Universidade: UniCeuma Campus Renascença || Curso: Engenharia de Computação || Período: Terceiro.
 */
public class Crud extends javax.swing.JFrame {
    //Classe main do código. Execute por aqui!
    public Crud() {
        initComponents(); // Inicia os componentes gráficos
        UserServices.setListar(""); // Define a query SELECT ALL para listar na nossa tabela.
        editAndDeleteButton.add(menu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editAndDeleteButton = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        pesquisarField = new javax.swing.JTextField();
        pesquisarTitle = new javax.swing.JLabel();
        criarButton = new javax.swing.JButton();
        deletarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userDashboard = new javax.swing.JTable();

        menu.setBackground(new java.awt.Color(255, 255, 255));

        editButton.setBackground(new java.awt.Color(51, 51, 51));
        editButton.setFont(new java.awt.Font("Sora ExtraBold", 0, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDITAR");
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
        });
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(51, 51, 51));
        deleteButton.setFont(new java.awt.Font("Sora ExtraBold", 0, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETAR");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        Title.setFont(new java.awt.Font("Sora ExtraBold", 0, 18)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("CRUD EM JAVA");

        pesquisarField.setBackground(new java.awt.Color(102, 102, 102));
        pesquisarField.setForeground(new java.awt.Color(255, 255, 255));
        pesquisarField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                pesquisarFieldInputMethodTextChanged(evt);
            }
        });
        pesquisarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFieldActionPerformed(evt);
            }
        });
        pesquisarField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarFieldKeyReleased(evt);
            }
        });

        pesquisarTitle.setForeground(new java.awt.Color(255, 255, 255));
        pesquisarTitle.setText("pesquisar");

        criarButton.setBackground(new java.awt.Color(102, 102, 102));
        criarButton.setForeground(new java.awt.Color(255, 255, 255));
        criarButton.setText("criar");
        criarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarButtonActionPerformed(evt);
            }
        });

        deletarButton.setBackground(new java.awt.Color(102, 102, 102));
        deletarButton.setForeground(new java.awt.Color(255, 255, 255));
        deletarButton.setText("deletar tudo");
        deletarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pesquisarField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(criarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletarButton))
                    .addComponent(pesquisarTitle))
                .addContainerGap(565, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisarTitle)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(criarButton)
                    .addComponent(deletarButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        userDashboard.setBackground(new java.awt.Color(51, 51, 51));
        userDashboard.setForeground(new java.awt.Color(255, 255, 255));
        userDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "nome", "user", "password"
            }
        ));
        userDashboard.setComponentPopupMenu(editAndDeleteButton);
        userDashboard.setGridColor(new java.awt.Color(153, 153, 153));
        userDashboard.setSelectionBackground(new java.awt.Color(51, 51, 51));
        userDashboard.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(userDashboard);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Adiciona um event listener para monitorar uma ação no botão de delete.
    private void deletarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarButtonActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deletar todos os Registro?", "", 
                 JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            if (UserServices.deleteAll()) {
                UserServices.setListar("");
                JOptionPane.showMessageDialog(this, "All Data Deleted Succesfully", "Informação", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error while deleting the data.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deletarButtonActionPerformed

    // Adiciona um event listener para monitorar uma ação no botão de edit
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int fila = userDashboard.getSelectedRow();
        FormUpdate formUpdate = new FormUpdate(this, true);
        
        formUpdate.inputName.setText(userDashboard.getValueAt(fila, 1).toString());
        formUpdate.inputUser.setText(userDashboard.getValueAt(fila, 2).toString());
        formUpdate.inputPassword.setText(userDashboard.getValueAt(fila, 3).toString());
        formUpdate.idUserLabel.setText(userDashboard.getValueAt(fila, 0).toString());
        
        formUpdate.setVisible(true);
        
    }//GEN-LAST:event_editButtonActionPerformed

    //LISTENERS NÃO UTILIZADOS ABAIXO
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int fila = userDashboard.getSelectedRow();
        
        Querys q = new Querys();
        
        q.setId(userDashboard.getValueAt(fila, 0).toString());
        
       if (JOptionPane.showConfirmDialog(this, "Delete user?", "",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
           if(UserServices.delete(q)){
               UserServices.setListar("");
               JOptionPane.showMessageDialog(this,"User deleted with success.", "info", JOptionPane.INFORMATION_MESSAGE);
           }
       }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void pesquisarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarFieldActionPerformed

    private void pesquisarFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_pesquisarFieldInputMethodTextChanged
      
    }//GEN-LAST:event_pesquisarFieldInputMethodTextChanged

    private void pesquisarFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarFieldKeyReleased
         UserServices.setListar(this.pesquisarField.getText());
    }//GEN-LAST:event_pesquisarFieldKeyReleased

    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonMouseClicked
    
   // Event listener para o botão de criar usuário!
    private void criarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarButtonActionPerformed
        // TODO add your handling code here:
        FormCreate formCreate = new FormCreate(this, true);
        formCreate.setVisible(true);
        
    }//GEN-LAST:event_criarButtonActionPerformed
    
    // Método main da nossa aplicação.
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton criarButton;
    private javax.swing.JButton deletarButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPopupMenu editAndDeleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menu;
    private javax.swing.JTextField pesquisarField;
    private javax.swing.JLabel pesquisarTitle;
    public static javax.swing.JTable userDashboard;
    // End of variables declaration//GEN-END:variables
}
