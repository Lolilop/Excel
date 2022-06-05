package Interface;


import Class.Arithmetique;

import java.awt.Color;
import javax.swing.JButton;


import Class.Cellule;
import Class.Export;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface 
 * @author Johan
 */

public class Interface extends javax.swing.JFrame {

    Cellule[][] cellule;

    public Interface() {
        initComponents();
        
        
        this.setSize( 500, 350 );
        this.getContentPane().removeAll();
        this.setResizable(false);
        this.getContentPane().setLayout(new java.awt.BorderLayout());
        this.add(new excel(this));

       
        cellule = create_cellule();
        
        for (int i = 0; i < cellule.length; i++) {
            for (int j = 0 ; j < cellule[i].length; j++ ) {
                cellule[i][j].add_button(cellule[i][j], this);
            }
        }
        
        Arithmetique obj = new Arithmetique(cellule);
        

        
        JButton export  = new JButton("Export");
        export.setBounds(150, 250, 25, 25);
        export.setBackground(Color.WHITE);

        
         export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Export export = new Export(getCellule());
                
                Arithmetique arithmetique = new Arithmetique(cellule);
                
                for(int x = 0; x < cellule.length ; x++) {
                    for(int y = 0; y < cellule[x].length; y++){
                        if( cellule[x][y].getMsg() != null) {
                            arithmetique = new Arithmetique(cellule[x][y]); 
                           
                        }
                        
                    }
                }
            }
        });
         
         
        this.add(export);
        
        
        JButton actual  = new JButton("actualise");
        actual.setBounds(0, 250, 100, 25);
        actual.setBackground(Color.WHITE);
        
        actual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Arithmetique arithmetique = new Arithmetique(cellule);
                
                for(int x = 0; x < cellule.length ; x++) {
                    for(int y = 0; y < cellule[x].length; y++){
                        if( cellule[x][y].getMsg() != null) {
                            arithmetique = new Arithmetique(cellule[x][y]); 
                           
                        }
                        
                    }
                }
            }
        });
       
        this.add(actual);
        
        JButton imp  = new JButton("import");
        imp.setBounds(300, 250, 100, 25);
        imp.setBackground(Color.WHITE);
        
        imp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
               
            }
        });
       
        this.add(imp);
        
    
   
    this.setLayout(null);
    
     this.getContentPane().repaint();
        this.getContentPane().validate();
       
    
    
    
        
    }
    
    /**
     * renvoie la cellule
     * @return cellule
     */
    
    private Cellule[][] getCellule() {
        return this.cellule;
    }
    
    /**
     * crèation de la matrice de cellule
     * @return matrice cellule
     */
    
    private Cellule[][] create_cellule() {
        
        final int y = 7;
        final int x = 10;
        
        int interval_x = 0;
        int interval_y = 0;
        
        Cellule[][] cellule = new Cellule[x][y];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0 ; j < 7; j++ ) {
               cellule[i][j] = new Cellule(i,j,interval_x,interval_y,"");
               interval_x += 41; 
            }
            
            interval_x = 0;
            interval_y += 25;
        }
       
        return cellule;
    }
    
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 194, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        if (evt.getKeyChar() == 'r'){
            Export export = new Export(this.cellule);
        }
	
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Interface().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
