/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import bdconnection.BDConnection;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author User
 */
public class TelaEditaLista extends javax.swing.JDialog {
    
    // variavel para alterar o eixo x a cada inserção
    int pos = 6;
    List<JLabel> labels = new ArrayList();
    BDConnection bd;
    /**
     * Creates new form TelaEditaLista
     * @param parent
     * @param modal
     */
    public TelaEditaLista(java.awt.Frame parent, boolean modal) throws ClassNotFoundException, SQLException {
        super(parent, modal);
        initComponents();
        inferior.setLayout(new FlowLayout(FlowLayout.LEFT));
        bd = new BDConnection();
        getCartas();
    }

    public void getCartas() throws SQLException{
        ResultSet rs = bd.searchBy("energia");
        
        
        while(rs.next()){
            JLabel label = new JLabel();
            label.setVisible(true); // torna ela visível
            label.setForeground(java.awt.Color.black);
            label.setSize(150,210); // tamanho
            label.setText(rs.getString("nome"));
            //separa por tipo de carta
            switch(rs.getString("tipo")){
                //se for um pokemon
                case "Pokemon":
                    label.setBackground(java.awt.Color.LIGHT_GRAY);
                    //muda a cor de acordo com o tipo de energia
                    switch(rs.getString("energia")){
                        case "Fogo":
                            label.setBorder(new LineBorder(java.awt.Color.red,2));
                            break;
                        case "Agua":
                            label.setBorder(new LineBorder(java.awt.Color.blue,2));
                            break;
                        case "Planta":
                            label.setBorder(new LineBorder(java.awt.Color.GREEN,2));
                            break;
                        case "Eletrica":
                            label.setBorder(new LineBorder(java.awt.Color.yellow,2));
                            break;
                        case "Psiquica":
                            label.setBorder(new LineBorder(new java.awt.Color(130, 0, 115),2));
                            break;
                        case "Luta":
                            label.setBorder(new LineBorder(new java.awt.Color(201, 101, 0),2));
                            break;
                        case "Noturna":
                            label.setBorder(new LineBorder(java.awt.Color.DARK_GRAY,2));
                            break;
                        case "Metal":
                            label.setBorder(new LineBorder(java.awt.Color.GRAY,2));
                            break;
                        case "Fada":
                            label.setBorder(new LineBorder(new java.awt.Color(255, 80, 210),2));
                            break;
                    }
                    break;
                case "Apoiador":
                case "Item":
                case "Estadio":
                    label.setBorder(new LineBorder(java.awt.Color.BLACK,1));
                    label.setBackground(java.awt.Color.LIGHT_GRAY);
                    break;
                //se for uma carta de energia muda a cor de acordo com ela
                case "Energia":
                    label.setBorder(new LineBorder(java.awt.Color.BLACK,1));
                    switch(rs.getString("energia")){
                        case "Fogo":
                            label.setForeground(java.awt.Color.red);
                            break;
                        case "Agua":
                            label.setForeground(java.awt.Color.blue);
                            break;
                        case "Planta":
                            label.setForeground(java.awt.Color.GREEN);
                            break;
                        case "Eletrica":
                            label.setForeground(java.awt.Color.yellow);
                            break;
                        case "Psiquica":
                            label.setForeground(new java.awt.Color(130, 0, 115));
                            break;
                        case "Luta":
                            label.setForeground(new java.awt.Color(201, 101, 0));
                            break;
                        case "Noturna":
                            label.setForeground(java.awt.Color.DARK_GRAY);
                            break;
                        case "Metal":
                            label.setForeground(java.awt.Color.GRAY);
                            break;
                        case "Fada":
                            label.setForeground(new java.awt.Color(255, 80, 210));
                            break;
                    }
            }
            labels.add(label);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        save_list = new javax.swing.JButton();
        search_cards = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();
        filtro_energia = new javax.swing.JLabel();
        filtro_pokemon = new javax.swing.JLabel();
        filtro_treinador = new javax.swing.JLabel();
        add_carta = new javax.swing.JButton();
        inferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editação da lista");

        background.setBackground(new java.awt.Color(225, 225, 225));

        save_list.setText("Salvar");
        save_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_listActionPerformed(evt);
            }
        });

        search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        filtro_energia.setBackground(new java.awt.Color(225, 112, 85));
        filtro_energia.setForeground(new java.awt.Color(225, 112, 85));
        filtro_energia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filtro_energia.setText("Energias");
        filtro_energia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 112, 85), 1, true));

        filtro_pokemon.setBackground(new java.awt.Color(116, 185, 255));
        filtro_pokemon.setForeground(new java.awt.Color(116, 185, 255));
        filtro_pokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filtro_pokemon.setText(" Pokémons");
        filtro_pokemon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(116, 185, 255), 1, true));

        filtro_treinador.setBackground(new java.awt.Color(253, 203, 110));
        filtro_treinador.setForeground(new java.awt.Color(253, 203, 110));
        filtro_treinador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filtro_treinador.setText("Treinadores");
        filtro_treinador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(253, 203, 110), 1, true));

        add_carta.setText("add");
        add_carta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_cartaActionPerformed(evt);
            }
        });

        inferior.setPreferredSize(new java.awt.Dimension(100, 215));

        javax.swing.GroupLayout inferiorLayout = new javax.swing.GroupLayout(inferior);
        inferior.setLayout(inferiorLayout);
        inferiorLayout.setHorizontalGroup(
            inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        inferiorLayout.setVerticalGroup(
            inferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap(217, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                .addComponent(filtro_pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(filtro_treinador, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(filtro_energia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(478, 478, 478)
                                .addComponent(search_cards, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(save_list, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_carta, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(inferior, javax.swing.GroupLayout.DEFAULT_SIZE, 1319, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filtro_treinador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtro_pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtro_energia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search_cards, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(search_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(269, 269, 269)
                .addComponent(add_carta)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save_list)
                .addContainerGap())
        );

        filtro_energia.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // função de adicionar label
    private void addLabel(){
        pos += 16; // att x da label
        /*filtro_energia.setBackground(new java.awt.Color(225, 112, 85));
        filtro_energia.setForeground(new java.awt.Color(225, 112, 85));
        filtro_energia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filtro_energia.setText("Energias");
        filtro_energia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 112, 85), 1, true));
        */
        
        /*
        JLabel label = new JLabel(); // instancia nova label
        
        
        label.setVisible(true); // torna ela visível
        label.setBackground(java.awt.Color.white);
        label.setForeground(java.awt.Color.black);
        //label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBorder(new javax.swing.border.LineBorder(java.awt.Color.black, 1, true));
        label.setText(String.valueOf(labels.size())); // seta o conteúdo
        label.setSize(150,210); // tamanho
        labels.add(label);*/
        //label.setLocation(return_location.getVerticalAlignment(),return_location.getHorizontalAlignment()); //localização
        for(int i=0; i < labels.size(); i++){
            if(i==0)
                inferior.add(labels.get(i));
            else
                inferior.add(labels.get(i));
        }
        pack();
        //getContentPane().add(label); // colocando o label no frame
        //initComponents(); // att frame
        background.repaint();
        inferior.repaint();
    }
    private void save_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_listActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_save_listActionPerformed

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_buttonActionPerformed

    private void add_cartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_cartaActionPerformed
        addLabel();
    }//GEN-LAST:event_add_cartaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditaLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditaLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditaLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditaLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaEditaLista dialog;
                try {
                    dialog = new TelaEditaLista(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_carta;
    private javax.swing.JPanel background;
    private javax.swing.JLabel filtro_energia;
    private javax.swing.JLabel filtro_pokemon;
    private javax.swing.JLabel filtro_treinador;
    private javax.swing.JPanel inferior;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton save_list;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField search_cards;
    // End of variables declaration//GEN-END:variables
}
