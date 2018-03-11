/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;
import javafx.scene.control.ComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import triphop.ui.img.StretchIcon;

/**
 *
 * @author Freyja Sigurgísladóttir, frs24@hi.is
 * @author Henrietta Þóra Magnúsdóttir, hthm6@hi.is
 */
public class MainFrame extends javax.swing.JFrame {
    private Boolean flagLang = false;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        String lang = Locale.getDefault().toString();
        String en = new Locale("en_GB").toString();
        if(lang.equals(en)) {
            jTungumal.setSelectedIndex(1);
        }
        flagLang = true;
        
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
       
        StretchIcon solMynd = buaTilMynd("img/sol.png");
        jButton2.setIcon(solMynd);
        StretchIcon skidaMynd = buaTilMynd("img/ski.png");
        jButton3.setIcon(skidaMynd);
        StretchIcon golfMynd = buaTilMynd("img/golf.png");
        jButton4.setIcon(golfMynd);
        StretchIcon borgMynd = buaTilMynd("img/new.png");
        jButton9.setIcon(borgMynd);
    }
    
        /**
     * Aðferð sem sækir mynd og býr hana til með ImageIcon
     * @param path
     * @return 
     */
    private static StretchIcon buaTilMynd(String path) {
        java.net.URL imgURL = MainFrame.class.getResource(path);
        if (imgURL != null) {
            return new StretchIcon(imgURL);
        } else {
            System.err.println("Fann ekki skrána " + path);
            return null;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jAdalPanel = new javax.swing.JPanel();
        jNafn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTungumal = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBrott = new javax.swing.JTextField();
        jAfang = new javax.swing.JTextField();
        dateBrottfor = new datechooser.beans.DateChooserCombo();
        dateHeimkoma = new datechooser.beans.DateChooserCombo();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLeita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 225, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setBackground(new java.awt.Color(255, 225, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1450, 1000));

        jAdalPanel.setBackground(new java.awt.Color(255, 225, 255));
        jAdalPanel.setPreferredSize(new java.awt.Dimension(1450, 1000));

        jNafn.setFont(new java.awt.Font("Rosewood Std", 1, 58)); // NOI18N
        jNafn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jNafn.setText("T R I P H O P");

        jLabel1.setFont(new java.awt.Font("SignPainter", 1, 34)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("triphop/ui/resources/lang"); // NOI18N
        jLabel1.setText(bundle.getString("F i n n d u   p a k k a   f y r i r   þ i g")); // NOI18N

        jTungumal.setBackground(new java.awt.Color(255, 225, 255));
        jTungumal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Íslenska", "English" }));
        jTungumal.setToolTipText("");
        jTungumal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTungumalActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 225, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton2);

        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton3);

        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton4);

        jPanel2.setBackground(new java.awt.Color(255, 225, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton5.setText(bundle.getString("Tilboð")); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton5);

        jButton6.setText(bundle.getString("Sól")); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton6);

        jButton7.setText(bundle.getString("Skíði")); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton7);

        jButton8.setText(bundle.getString("Golf")); // NOI18N
        jButton8.setToolTipText("");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton8);

        jPanel3.setBackground(new java.awt.Color(255, 225, 255));
        jPanel3.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jButton9);

        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jButton10);

        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jButton11);

        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jButton12);

        jPanel4.setBackground(new java.awt.Color(255, 225, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 4, 16, 0));

        jButton13.setText(bundle.getString("Borg")); // NOI18N
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jButton13);

        jButton14.setText(bundle.getString("Viðburðir")); // NOI18N
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jButton14);

        jButton15.setText(bundle.getString("Útivist")); // NOI18N
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jButton15);

        jButton16.setText(bundle.getString("Fjölskylda")); // NOI18N
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jButton16);

        jPanel6.setBackground(new java.awt.Color(255, 225, 255));
        jPanel6.setLayout(new java.awt.GridLayout(2, 5));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText(bundle.getString("Brottfararstaður")); // NOI18N
        jPanel6.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText(bundle.getString("Áfangastaður")); // NOI18N
        jPanel6.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText(bundle.getString("Brottfarardagur")); // NOI18N
        jPanel6.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText(bundle.getString("Heimkomudagur")); // NOI18N
        jPanel6.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText(bundle.getString("Farþegar")); // NOI18N
        jPanel6.add(jLabel6);

        jBrott.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jBrott.setText(bundle.getString("Reykjavík")); // NOI18N
        jPanel6.add(jBrott);

        jAfang.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jAfang.setText(bundle.getString("Allir áfangastaðir")); // NOI18N
        jAfang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAfangActionPerformed(evt);
            }
        });
        jPanel6.add(jAfang);
        jPanel6.add(dateBrottfor);

        dateHeimkoma.setFormat(0);
        jPanel6.add(dateHeimkoma);
        dateHeimkoma.getAccessibleContext().setAccessibleName("");
        dateHeimkoma.getAccessibleContext().setAccessibleDescription("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel6.add(jComboBox1);

        jLeita.setText(bundle.getString("Leita")); // NOI18N
        jLeita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLeita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLeitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jAdalPanelLayout = new javax.swing.GroupLayout(jAdalPanel);
        jAdalPanel.setLayout(jAdalPanelLayout);
        jAdalPanelLayout.setHorizontalGroup(
            jAdalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAdalPanelLayout.createSequentialGroup()
                .addGroup(jAdalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jAdalPanelLayout.createSequentialGroup()
                        .addGap(778, 778, 778)
                        .addComponent(jTungumal, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jAdalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jAdalPanelLayout.createSequentialGroup()
                            .addGap(761, 761, 761)
                            .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jAdalPanelLayout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addGroup(jAdalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(544, 544, 544))
            .addGroup(jAdalPanelLayout.createSequentialGroup()
                .addGroup(jAdalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jAdalPanelLayout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jNafn, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jAdalPanelLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jAdalPanelLayout.setVerticalGroup(
            jAdalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jAdalPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jTungumal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jNafn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );

        jScrollPane1.setViewportView(jAdalPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLeitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLeitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLeitaActionPerformed

    private void jAfangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAfangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAfangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTungumalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTungumalActionPerformed
        if(flagLang) {    
            JComboBox cb = (JComboBox)evt.getSource();
            String tunga = (String)cb.getSelectedItem();

            if("English".equals(tunga)) {
                dispose();
                Locale l = new Locale("en_GB");
                Locale.setDefault(l); 
                MainFrame h;
                h = new MainFrame();
                h.setVisible(true);
            }
            else {
                dispose();
                Locale l = new Locale("is_IS");
                Locale.setDefault(l);
                MainFrame h;
                h = new MainFrame();
                h.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTungumalActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateBrottfor;
    private datechooser.beans.DateChooserCombo dateHeimkoma;
    private javax.swing.JPanel jAdalPanel;
    private javax.swing.JTextField jAfang;
    private javax.swing.JTextField jBrott;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLeita;
    private javax.swing.JLabel jNafn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jTungumal;
    // End of variables declaration//GEN-END:variables
}
