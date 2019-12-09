/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Usuario
 */
public class PantallaPrincipañ extends javax.swing.JFrame {
    Grafo miGrafo = new Grafo();
    DefaultListModel modelo = new DefaultListModel();
    List<Object> ListaRecorrido = new ArrayList();
    /**
     * Creates new form PantallaPrincipañ
     */
    public PantallaPrincipañ() {
        initComponents();
        jList1.setModel(modelo);
        miGrafo.insertarVertice(new Vertice("Charruas y Setembrino"), true);
        miGrafo.insertarVertice(new Vertice("Charruas y 33"), true);
        miGrafo.insertarVertice(new Vertice("Uruguay y Setembrino"), true);
        miGrafo.insertarVertice(new Vertice("Uruguay y 33"), true);
         
        //Manzana 1 
	Arista Cuadra1 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Setembrino"), miGrafo.getVertice("Uruguay y Setembrino"), 1);
        Arista Cuadra2 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y Setembrino"), miGrafo.getVertice("Uruguay y 33"), 1);
        Arista Cuadra3 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y 33"), miGrafo.getVertice("Charruas y 33"), 1);
        Arista Cuadra4 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y 33"), miGrafo.getVertice("Charruas y Setembrino"), 1);
        POI Escuela_94 = new POI();
        Escuela_94.setCuadra(Cuadra3);
        Escuela_94.setEsquina_mas_cercana(Cuadra3.getVertice2());
        miGrafo.insertarPOI("Escuela 94", Escuela_94);
        
        //Manzana 2
        miGrafo.insertarVertice(new Vertice("Charruas y Montevideo"), true);
        miGrafo.insertarVertice(new Vertice("Montevideo y Uruguay"), true);
        
        Arista Cuadra5 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Montevideo"), miGrafo.getVertice("Montevideo y Uruguay"), 1);
        Arista Cuadra6 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y 33"),miGrafo.getVertice("Montevideo y Uruguay"), 1);
        Arista Cuadra6_2 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Montevideo"),miGrafo.getVertice("Charruas y 33"), 1);
        POI El_Jardin = new POI();
        El_Jardin.setCuadra(Cuadra5);
        El_Jardin.setEsquina_mas_cercana(Cuadra5.getVertice1());
        miGrafo.insertarPOI("El Jardin", El_Jardin);
        
        //Manzana 3 
        miGrafo.insertarVertice(new Vertice("Charruas y 19 de abril"),true);//6
        miGrafo.insertarVertice(new Vertice("Uruguay y 19 de abril"),true);//7
        
        Arista Cuadra7 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y 19 de abril"), miGrafo.getVertice("Charruas y Montevideo"), 1);
        Arista Cuadra8 = miGrafo.insertarArista(miGrafo.getVertice("Montevideo y Uruguay"), miGrafo.getVertice("Uruguay y 19 de abril"), 1);
        POI Juaro_motos = new POI();
        Juaro_motos.setCuadra(Cuadra8);
        Juaro_motos.setEsquina_mas_cercana(Cuadra8.getVertice2());
        miGrafo.insertarPOI("Juaro Motos", Juaro_motos);
        Arista Cuadra9 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y 19 de abril"), miGrafo.getVertice("Charruas y 19 de abril"), 1);
        
        //Manzana 4
        miGrafo.insertarVertice(new Vertice("Charruas y Herrera"), true);//10
        miGrafo.insertarVertice(new Vertice("Uruguay y Herrera"), true);//11
        Arista Cuadra10 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Herrera"), miGrafo.getVertice("Charruas y 19 de abril"), 1);
        Arista Cuadra11 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Herrera"), miGrafo.getVertice("Uruguay y Herrera"), 1);
        Arista Cuadra12 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y 19 de abril"), miGrafo.getVertice("Uruguay y Herrera"), 1);
        //Manzana 5
        miGrafo.insertarVertice(new Vertice("Herrera y Florida"), true);//12
        miGrafo.insertarVertice(new Vertice("Florida y 19 de abril"), true);//13
        Arista Cuadra13 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y Herrera"), miGrafo.getVertice("Herrera y Florida"), 1);
        POI ColegioYLiceo_Huerto = new POI();
        ColegioYLiceo_Huerto.setCuadra(Cuadra13);
        ColegioYLiceo_Huerto.setEsquina_mas_cercana(Cuadra13.getVertice2());
        miGrafo.insertarPOI("Colegio y Liceo Nuestra Señora del Huerto", ColegioYLiceo_Huerto);
        Arista Cuadra14 = miGrafo.insertarArista(miGrafo.getVertice("Herrera y Florida"), miGrafo.getVertice("Florida y 19 de abril"), 1);
        Arista Cuadra15 = miGrafo.insertarArista(miGrafo.getVertice("Florida y 19 de abril"), miGrafo.getVertice("Uruguay y 19 de abril"), 1);
        List<Object> lista = miGrafo.obtenerListadoPOI(miGrafo.htPOIxNombre);
        
        for (Object j : lista){
            jComboBox1.addItem(j.toString());
            jComboBox2.addItem(j.toString());
            
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ORIGEN");

        jLabel2.setText("DESTINO");

        jScrollPane1.setViewportView(jList1);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("RECORRIDO RECOMENDADO");

        jButton1.setBackground(new java.awt.Color(51, 255, 0));
        jButton1.setText("Calcular Recorrido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
    modelo.clear();
    ListaRecorrido = miGrafo.buscarRuta(jComboBox1.getSelectedItem().toString(), jComboBox2.getSelectedItem().toString());
    int cuadras=-1;
     for(Object r : ListaRecorrido){
         
         modelo.addElement(r);
         cuadras++;
         
     } 
     jLabel4.setText("El numero de cuadras es: "+cuadras);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipañ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipañ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipañ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipañ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public  void run() {
                new PantallaPrincipañ().setVisible(true);
                
                
                
                
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
