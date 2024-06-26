
/*
 * JDialogMenuConfiguracion.java
 *
 * Created on 04-ago-2011, 11:02:04
 */

package capaInterfaz.menuConfiguracion;

import capaInterfaz.JDialogOperacionFail;
import capaInterfaz.JDialogOperacionWarning;
import capaInterfaz.listados.ListadoEvaluacion;
import capaInterfaz.menuPrincipal.FrameMenuPrincipal;
import capaLogicaNegocio.Alumno;
import capaLogicaNegocio.Convocatoria;
import capaLogicaNegocio.Curso;
import capaLogicaNegocio.Evaluacion;
import capaLogicaNegocio.Examen;
import capaLogicaNegocio.GrupoPractica;
import capaLogicaNegocio.Practica;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/** Clase que gestiona el JDialog de configuración del sistema.
 *
 * @author Confiencial
 */
public class JDialogMenuConfiguracion extends javax.swing.JDialog {

    private boolean botonCambioConvocatoriaPulsado = false;
    private boolean botonCambioCursoPulsado = false;
    private boolean botonDeshacerUltimaDecisionPulsado = false;
   
    /** indica si se ha modificado la configuración con la Base de Datos*/
    public static boolean botonCammbioBaseDatosPulsado = false;
    /** contiene la nueva URL para la conexión con la Base de Datos  */
    public static String URL;
    /** contiene el nuevo usuario para la conexión con la Base de Datos */
    public static String User;
    /** contiene la nueva contraseña para la conexión con la Base de Datos */
    public static String Password;

    /** Crea e inicializa un nuevo JDialogMenuConfiguracion
     *
     * @param parent frame padre.
     * @param modal indica si el frame es modal respecto al frame padre o no.
     */
    public JDialogMenuConfiguracion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Convocatoria convocatoria = new Convocatoria();
        if (convocatoria.getConvocatoriaActual().equals("ordinaria")) {
            jButtonCambiarConvocatoria.setEnabled(true);
            jButtonCambiarCurso.setEnabled(false);
        } else {
            jButtonCambiarConvocatoria.setEnabled(false);
            jButtonCambiarCurso.setEnabled(true);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelConfiguracion = new javax.swing.JPanel();
        jButtonCambiarConvocatoria = new javax.swing.JButton();
        jButtonCambiarCurso = new javax.swing.JButton();
        jButtonBackUp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonSelectBBDD = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonCambiarConvocatoria.setText("Cambiar a convocatoria EXTRAORDINARIA");
        jButtonCambiarConvocatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarConvocatoriaActionPerformed(evt);
            }
        });

        jButtonCambiarCurso.setText("Cambiar de CURSO ");
        jButtonCambiarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarCursoActionPerformed(evt);
            }
        });

        jButtonBackUp.setBackground(new java.awt.Color(255, 0, 0));
        jButtonBackUp.setText("Deshacer última decisión");
        jButtonBackUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConfiguracionLayout = new javax.swing.GroupLayout(jPanelConfiguracion);
        jPanelConfiguracion.setLayout(jPanelConfiguracionLayout);
        jPanelConfiguracionLayout.setHorizontalGroup(
            jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfiguracionLayout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(jButtonBackUp, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfiguracionLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCambiarConvocatoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jButtonCambiarCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addGap(153, 153, 153))
        );
        jPanelConfiguracionLayout.setVerticalGroup(
            jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButtonBackUp, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButtonCambiarConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButtonCambiarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configuración", jPanelConfiguracion);

        jButtonSelectBBDD.setText("Seleccionar Base de Datos existente");
        jButtonSelectBBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectBBDDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jButtonSelectBBDD, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addGap(128, 128, 128))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jButtonSelectBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BDD", jPanel1);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonOK.setText("Aceptar");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonOK)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonOK))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        boolean convocatoria_cambiada = false;
        boolean curso_cambiado = false;
        boolean alumnos_dados_alta_convocatoria_extraoridinaria = false;
        boolean cod_examen_dado_alta = false;
        boolean cod_practica_dado_alta = false;
        Evaluacion evaluacion = new Evaluacion();
        Convocatoria convocatoria = new Convocatoria();
        Curso curso = new Curso();
        GrupoPractica grupo = new GrupoPractica();
        Practica practica = new Practica();
        Examen examen = new Examen();
        try {
            if (botonCambioConvocatoriaPulsado) {
                jButtonCambiarConvocatoria.setEnabled(false);
                jButtonCambiarCurso.setEnabled(true);
                botonCambioConvocatoriaPulsado = false;
                Alumno alumno = new Alumno();

                String convocatoria_actual = convocatoria.getConvocatoriaActual();

                int curso_actual = curso.getCursoActual();

                List<ListadoEvaluacion> resultado = evaluacion.consultarEvaluacion(null,
                                                                                   null,
                                                                                   null,
                                                                                   convocatoria_actual,
                                                                                   curso_actual);

                convocatoria.cambioConvocatoria();
                convocatoria_cambiada = true;
                convocatoria.recuperarConvocatoriaActual();

                practica.altaNuevoCodPractica();
                cod_practica_dado_alta = true;
                examen.altaNuevoCodExamen();
                cod_examen_dado_alta = true;

                alumno.cambioAConvocatoriaExtraordinaria(resultado);
                alumnos_dados_alta_convocatoria_extraoridinaria = true;
            }

            if (botonCambioCursoPulsado) {
                jButtonCambiarConvocatoria.setEnabled(true);
                jButtonCambiarCurso.setEnabled(false);
                botonCambioCursoPulsado = false;

                curso.cambioCurso();
                curso_cambiado = true;
                curso.recuperarCursoActual();

                convocatoria.cambioConvocatoria();
                convocatoria_cambiada = true;
                convocatoria.recuperarConvocatoriaActual();
              
                practica.altaNuevoCodPractica();
                cod_practica_dado_alta = true;

                examen.altaNuevoCodExamen();
                cod_examen_dado_alta = true;
            }

            
            if (botonCammbioBaseDatosPulsado) {
                botonCammbioBaseDatosPulsado = false;
            //    DataAccessObject.URL = this.URL;
             //   DataAccessObject.USER = this.User;
              //  DataAccessObject.PASS = this.Password;
                try {
                    BufferedWriter escritor = new BufferedWriter(new  OutputStreamWriter(new FileOutputStream("./config/config.txt"),"UTF8"));
                    String url, user, password;
                    url = this.URL;
                    user = this.User;
                    password = this.Password;
                    escritor.write(url);
                    escritor.newLine();
                    escritor.write(user);
                    escritor.newLine();
                    escritor.write(password);
                    escritor.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    throw new RuntimeException("Error al actualizar el archivo de configuración");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    System.out.println(e1.getMessage());
                    e1.printStackTrace();
                    throw new RuntimeException("Error al intentar acceder al archivo de configuración");
                } 
            }

            if (botonDeshacerUltimaDecisionPulsado) {
                if (convocatoria.getConvocatoriaActual().equals("ordinaria")){
                    curso.BackUpCurso();
                    jButtonCambiarConvocatoria.setEnabled(false);
                    jButtonCambiarCurso.setEnabled(true);
                } else {
                    convocatoria.BackUpConvocatoria();
                    jButtonCambiarConvocatoria.setEnabled(true);
                    jButtonCambiarCurso.setEnabled(false);
                }
            }
            dispose();
        } catch (RuntimeException e) {

            if (alumnos_dados_alta_convocatoria_extraoridinaria){
                evaluacion.eliminarEvaluacionesConvocatoriaActual();
            }

            if (cod_practica_dado_alta) {
                practica.bajaCodPracticaConvocatoriaActual();
            }

            if (cod_examen_dado_alta) {
                examen.bajaCodExamenConvocatoriaActual();
            }

            if (convocatoria_cambiada) {
                convocatoria.cambioConvocatoria();
                convocatoria.recuperarConvocatoriaActual();
                grupo.reactivarGruposPracticasEnUsoEnConvocatoriaActual();
            }
            if (curso_cambiado) {
                curso.cambioCursoAnterior();
                curso.recuperarCursoActual();
            }

            if (convocatoria.getConvocatoriaActual().equals("ordinaria")){
                jButtonCambiarConvocatoria.setEnabled(true);
                jButtonCambiarCurso.setEnabled(false);
            } else {
                jButtonCambiarConvocatoria.setEnabled(false);
                jButtonCambiarCurso.setEnabled(true);
            }
            jButtonBackUp.setEnabled(true);
            JDialogOperacionFail dialogFail = new JDialogOperacionFail(FrameMenuPrincipal.getFramePrincipal(),
                                                                       e.getMessage(), true);
            dialogFail.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonSelectBBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectBBDDActionPerformed
        JDialogMenuSeleccionarBDD jDialogMenuSeleccionarBDD = new JDialogMenuSeleccionarBDD(FrameMenuPrincipal.getFramePrincipal(),true);
        jDialogMenuSeleccionarBDD.setVisible(true);
}//GEN-LAST:event_jButtonSelectBBDDActionPerformed

    private void jButtonCambiarConvocatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarConvocatoriaActionPerformed
        JDialogOperacionWarning dialogWarning = new JDialogOperacionWarning(FrameMenuPrincipal.getFramePrincipal(),
                                                                            "¿Está seguro de que desea cambiar de convocatoria?",
                                                                            true);
        dialogWarning.setVisible(true);
        if (dialogWarning.operacionOK){
            jButtonBackUp.setEnabled(false);
            jButtonCambiarConvocatoria.setEnabled(false);
            this.botonCambioConvocatoriaPulsado = true;
        }
    }//GEN-LAST:event_jButtonCambiarConvocatoriaActionPerformed

    private void jButtonCambiarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarCursoActionPerformed
        JDialogOperacionWarning dialogWarning = new JDialogOperacionWarning(FrameMenuPrincipal.getFramePrincipal(),
                                                                            "¿Está seguro de que desea cambiar de curso?",
                                                                            true);
        dialogWarning.setVisible(true);
        if (dialogWarning.operacionOK){
            jButtonBackUp.setEnabled(false);
            jButtonCambiarCurso.setEnabled(false);
            this.botonCambioCursoPulsado = true;
        }
    }//GEN-LAST:event_jButtonCambiarCursoActionPerformed

    private void jButtonBackUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackUpActionPerformed
        JDialogOperacionWarning dialogWarning = new JDialogOperacionWarning(FrameMenuPrincipal.getFramePrincipal(),
                                                                            "Se perderán TODOS los datos de la convocatoria actual",
                                                                            "¿Desea continuar?",
                                                                            true);
        dialogWarning.setVisible(true);
        if (dialogWarning.operacionOK){
            jButtonBackUp.setEnabled(false);
            jButtonCambiarCurso.setEnabled(false);
            jButtonCambiarConvocatoria.setEnabled(false);
            this.botonDeshacerUltimaDecisionPulsado = true;
        }
    }//GEN-LAST:event_jButtonBackUpActionPerformed


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogMenuConfiguracion dialog = new JDialogMenuConfiguracion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackUp;
    private javax.swing.JButton jButtonCambiarConvocatoria;
    private javax.swing.JButton jButtonCambiarCurso;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonSelectBBDD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelConfiguracion;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    public static Color color;

} // fin de la clase JDialogConfiguracion