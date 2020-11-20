/*
 * The first frame of the GUI.
 *
 */
package frames;

import arena3.Arena;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import utilities.*;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public class StartFrame extends javax.swing.JFrame{
    
    FrameManipulator frameManipulator = new FrameManipulator();
    SessionHandler sessionHandler = new SessionHandler();
    AudioPlayer audioPlayer;
    
    /**
     * Creates new form StartMenu
     */
    public StartFrame() {
        
        initComponents();
        sessionHandler.load();
        frameManipulator.centeredFrame(this);
        try {
            audioPlayer = new AudioPlayer();
        } 
        catch (UnsupportedAudioFileException | IOException | 
                LineUnavailableException ex) {
            System.out.println("Error 109");}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        StartButton = new javax.swing.JButton();
        ToturialButton = new javax.swing.JButton();
        CharacterCreationButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLayeredPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLayeredPane1.setDoubleBuffered(true);
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StartButton.setBackground(new java.awt.Color(102, 0, 0));
        StartButton.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        StartButton.setForeground(new java.awt.Color(204, 204, 167));
        StartButton.setText("START");
        StartButton.setFocusable(false);
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 170, 40));

        ToturialButton.setBackground(new java.awt.Color(102, 0, 0));
        ToturialButton.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        ToturialButton.setForeground(new java.awt.Color(204, 204, 167));
        ToturialButton.setText("TUTORIAL");
        ToturialButton.setFocusable(false);
        ToturialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToturialButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(ToturialButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, 170, 40));

        CharacterCreationButton.setBackground(new java.awt.Color(102, 0, 0));
        CharacterCreationButton.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        CharacterCreationButton.setForeground(new java.awt.Color(204, 204, 167));
        CharacterCreationButton.setText("NEW GAME");
        CharacterCreationButton.setFocusable(false);
        CharacterCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CharacterCreationButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(CharacterCreationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 170, 40));

        ExitButton.setBackground(new java.awt.Color(102, 0, 0));
        ExitButton.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(204, 204, 167));
        ExitButton.setText("EXIT");
        ExitButton.setFocusable(false);
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(ExitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 650, 170, 40));

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/StartScreen2.PNG"))); // NOI18N
        BackGround.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLayeredPane1.add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Navigates to the Tutorial Frame
     * @param evt - on left mouse click
     */
    private void ToturialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToturialButtonActionPerformed
 
        audioPlayer.playOnce(2);
        TutorialFrame g = new TutorialFrame();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_ToturialButtonActionPerformed
    
    /**
     * Navigates the player to the appropriate starting location. If the player
     * is continuing the Inn Frame is opened, if not the character creation
     * frame is opened.
     * @param evt - on left mouse click
     */
    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
  
        audioPlayer.playOnce(2);
        if(Arena.CUR_PLAYER.getName().equals("New")){
            CharacterCreationFrame g = new CharacterCreationFrame();
            g.setVisible(true);
            dispose();
        }
        else{
            InnFrame g = new InnFrame();
            g.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_StartButtonActionPerformed

    /**
     * Opens the character creation frame
     * @param evt - left mouse click
     */
    private void CharacterCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CharacterCreationButtonActionPerformed

        audioPlayer.playOnce(2);
        CharacterCreationFrame g = new CharacterCreationFrame();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_CharacterCreationButtonActionPerformed
    /**
     * Exits the game and closes the application
     * @param evt - left mouse click
     */
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed

        audioPlayer.setTrack(1);
        audioPlayer.playOnce();
        System.exit(19);
    }//GEN-LAST:event_ExitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JButton CharacterCreationButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton ToturialButton;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
