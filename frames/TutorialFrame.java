/* 
 * This frame communicates with the player the game fundementals by displaying
 * instructions when rolling over elements on the GUI
 */
package frames;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import utilities.AudioPlayer;
import utilities.FrameManipulator;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public class TutorialFrame extends javax.swing.JFrame {

    AudioPlayer audioPlayer;
    
    /**
     * Creates new form TutorialFrame
     */
    public TutorialFrame() {
        initComponents();
        try {
            audioPlayer = new AudioPlayer();
        } 
        catch (UnsupportedAudioFileException | IOException | 
                LineUnavailableException ex) {
            System.out.println("Error 117");
        }
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
        FrameManipulator g = new FrameManipulator();
        g.centeredFrame(this);
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
        ArenaExteriorButton = new javax.swing.JButton();
        abilityTutor = new javax.swing.JLabel();
        tutorOutput = new javax.swing.JTextArea();
        scrollTutorialOutput = new javax.swing.JLabel();
        playerInfo = new javax.swing.JLabel();
        itemsTutor = new javax.swing.JLabel();
        physicalAttackTutor = new javax.swing.JLabel();
        rangeAttackTutor = new javax.swing.JLabel();
        playerStuff = new javax.swing.JLabel();
        magicAttackTutor = new javax.swing.JLabel();
        enemyStuff = new javax.swing.JLabel();
        temporaryTagAbilityBar = new javax.swing.JLabel();
        equipmentTutor = new javax.swing.JLabel();
        enemyInfo = new javax.swing.JLabel();
        BackGround = new javax.swing.JLabel();
        abilityBarTutorial = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ArenaExteriorButton.setBackground(new java.awt.Color(102, 0, 0));
        ArenaExteriorButton.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        ArenaExteriorButton.setForeground(new java.awt.Color(204, 204, 167));
        ArenaExteriorButton.setText("GOT IT");
        ArenaExteriorButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 1, true));
        ArenaExteriorButton.setFocusPainted(false);
        ArenaExteriorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ArenaExteriorButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArenaExteriorButtonMouseClicked(evt);
            }
        });
        ArenaExteriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArenaExteriorButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(ArenaExteriorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 640, 140, 40));

        abilityTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abilityTutorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abilityTutorMouseExited(evt);
            }
        });
        jLayeredPane1.add(abilityTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 150, 300, 170));

        tutorOutput.setBackground(new java.awt.Color(0, 0, 0));
        tutorOutput.setColumns(20);
        tutorOutput.setFont(new java.awt.Font("Goudy Old Style", 0, 18)); // NOI18N
        tutorOutput.setForeground(new java.awt.Color(255, 255, 255));
        tutorOutput.setLineWrap(true);
        tutorOutput.setRows(5);
        tutorOutput.setBorder(null);
        tutorOutput.setOpaque(false);
        jLayeredPane1.add(tutorOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 250, 280));

        scrollTutorialOutput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/scrollTry.png"))); // NOI18N
        jLayeredPane1.add(scrollTutorialOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 390, 480));

        playerInfo.setBackground(new java.awt.Color(0, 0, 0));
        playerInfo.setForeground(new java.awt.Color(255, 255, 255));
        playerInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playerInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playerInfoMouseExited(evt);
            }
        });
        jLayeredPane1.add(playerInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 300, 170));

        itemsTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                itemsTutorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                itemsTutorMouseExited(evt);
            }
        });
        jLayeredPane1.add(itemsTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 430, 260, 260));

        physicalAttackTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                physicalAttackTutorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                physicalAttackTutorMouseExited(evt);
            }
        });
        jLayeredPane1.add(physicalAttackTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 120, 110));

        rangeAttackTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rangeAttackTutorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rangeAttackTutorMouseExited(evt);
            }
        });
        jLayeredPane1.add(rangeAttackTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 100, 110));

        playerStuff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playerStuffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playerStuffMouseExited(evt);
            }
        });
        jLayeredPane1.add(playerStuff, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 640, 370, 80));

        magicAttackTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                magicAttackTutorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                magicAttackTutorMouseExited(evt);
            }
        });
        jLayeredPane1.add(magicAttackTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 430, 120, 100));

        enemyStuff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enemyStuffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                enemyStuffMouseExited(evt);
            }
        });
        jLayeredPane1.add(enemyStuff, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 5, 310, 60));

        temporaryTagAbilityBar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        temporaryTagAbilityBar.setForeground(new java.awt.Color(0, 0, 0));
        temporaryTagAbilityBar.setText("ABILITY BAR ");
        temporaryTagAbilityBar.setToolTipText("");
        temporaryTagAbilityBar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLayeredPane1.add(temporaryTagAbilityBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 650, 110, 40));

        equipmentTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                equipmentTutorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                equipmentTutorMouseExited(evt);
            }
        });
        jLayeredPane1.add(equipmentTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 300, 90));

        enemyInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enemyInfoMouseEntered(evt);
            }
        });
        jLayeredPane1.add(enemyInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 5, 320, 130));

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TutorialScreen.PNG"))); // NOI18N
        BackGround.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackGroundMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackGroundMouseExited(evt);
            }
        });
        jLayeredPane1.add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        abilityBarTutorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abilityBarTutorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abilityBarTutorialMouseExited(evt);
            }
        });
        jLayeredPane1.add(abilityBarTutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 230, 60));
        jLayeredPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 190, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Return player to the start screen
    * @param evt - on button click
    */
    private void ArenaExteriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArenaExteriorButtonActionPerformed

        StartFrame g = new StartFrame();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_ArenaExteriorButtonActionPerformed

    private void ArenaExteriorButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArenaExteriorButtonMouseClicked

    }//GEN-LAST:event_ArenaExteriorButtonMouseClicked

    private void BackGroundMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackGroundMouseEntered

    }//GEN-LAST:event_BackGroundMouseEntered

    private void abilityTutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abilityTutorMouseEntered
        
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This box contains a list of Abilities \ncurrently "
                + "available to the player. \nAs your STATS change so will "
                + "\nyour abilites. \nONLY abilities that you have \n"
                + "trained will appear here. \nAnd only abilities currently "
                + "available \n to your class will appear. ");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_abilityTutorMouseEntered

    private void abilityTutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abilityTutorMouseExited
        scrollTutorialOutput.setVisible(true);
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_abilityTutorMouseExited

    private void playerInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerInfoMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This box contains the current\nplayers name, "
                + "level, and current class. \nPlayers class is determined by "
                + "the \nhighest attribue, STR INT DEX. \nIt also shows the "
                + "players current \namount of gold and experience points. ");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_playerInfoMouseEntered

    private void playerInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerInfoMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_playerInfoMouseExited

    private void itemsTutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTutorMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This box contains the current\n potions in the "
                + "players inventory. \n Potions can be purchased through \n "
                + "the InnKeeper. \n There are 3 types of potions \n available "
                + "to all players: \n HEALTH \n MANA \n COMBINATION \n In the "
                + "lower right corner \n the players current gambling \n chips "
                + "are represented.");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_itemsTutorMouseEntered

    private void itemsTutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTutorMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_itemsTutorMouseExited

    private void physicalAttackTutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_physicalAttackTutorMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This is your physical attack. \n Physical attacks "
                + "reduce your INT \n while increasing STR. \n Having a hight "
                + "STR attribute will \nincrease your damage from physical "
                + "\nattacks.");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_physicalAttackTutorMouseEntered

    private void physicalAttackTutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_physicalAttackTutorMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_physicalAttackTutorMouseExited

    private void magicAttackTutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_magicAttackTutorMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This is your magical attack. \n Magical attacks "
                + "reduce your DEX \n while increasing your INT. \nHaving a "
                + "hight INT attribute will \nincrease your "
                + "damage from magical \nattacks.");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_magicAttackTutorMouseEntered

    private void magicAttackTutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_magicAttackTutorMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_magicAttackTutorMouseExited

    private void rangeAttackTutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rangeAttackTutorMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This is your ranged attack. \n Ranged attacks"
                + " reduce your STR \n while increasing your DEX. \nHaving "
                + "a high DEX nattribute will \nincrease your  "
                + "damage from ranged \nattacks.");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_rangeAttackTutorMouseEntered

    private void rangeAttackTutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rangeAttackTutorMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_rangeAttackTutorMouseExited

    private void playerStuffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerStuffMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This area shows your health bar, your ability bar, "
                + "and your experience bar. If your experience bar fills you "
                + "can go buy a level. Your ability bar shows \n your current "
                + "ability point level.  \n Different abilities cost "
                + "different \n amounts.  Your health bar represents \nyour "
                + "hitpoints, if this reaches 0, \n you're sad.");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_playerStuffMouseEntered

    private void playerStuffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerStuffMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_playerStuffMouseExited

    private void enemyStuffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enemyStuffMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This is the enemy's health and ability \nbar. "
                + "Watching this will greatly help \n your chances of winning "
                + "in \n The Arena!");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_enemyStuffMouseEntered

    private void enemyStuffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enemyStuffMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_enemyStuffMouseExited

    private void equipmentTutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipmentTutorMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This is the players current gear.\nNew gear can "
                + "be purchased at the \nblacksmith.");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_equipmentTutorMouseEntered

    private void equipmentTutorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipmentTutorMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_equipmentTutorMouseExited

    private void abilityBarTutorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abilityBarTutorialMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This is your ability bar. \n When you select an "
                + "ability from your \nlist you will then select this button "
                + "when you are ready to use that ability.");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_abilityBarTutorialMouseEntered

    private void abilityBarTutorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abilityBarTutorialMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_abilityBarTutorialMouseExited

    private void enemyInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enemyInfoMouseEntered
        scrollTutorialOutput.setVisible(true);
        audioPlayer.playOnce(32);
        tutorOutput.setText("This area contains the information \nabout your"
                + " adversary in the Arena. \nHere you will see the type of "
                + "creature \nyou are fighting, their level, stats, and "
                + "\ncurrent class.  If you are playing Arena 3 online, "
                + "that means we fixed it and \nyou "
                + " will see the other player's name on the top.");
        tutorOutput.setVisible(true);
    }//GEN-LAST:event_enemyInfoMouseEntered

    private void BackGroundMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackGroundMouseExited
        tutorOutput.setVisible(false);
        scrollTutorialOutput.setVisible(false);
    }//GEN-LAST:event_BackGroundMouseExited

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
            java.util.logging.Logger.getLogger(TutorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TutorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TutorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TutorialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TutorialFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArenaExteriorButton;
    private javax.swing.JLabel BackGround;
    private javax.swing.JLabel abilityBarTutorial;
    private javax.swing.JLabel abilityTutor;
    private javax.swing.JLabel enemyInfo;
    private javax.swing.JLabel enemyStuff;
    private javax.swing.JLabel equipmentTutor;
    private javax.swing.JLabel itemsTutor;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel magicAttackTutor;
    private javax.swing.JLabel physicalAttackTutor;
    private javax.swing.JLabel playerInfo;
    private javax.swing.JLabel playerStuff;
    private javax.swing.JLabel rangeAttackTutor;
    private javax.swing.JLabel scrollTutorialOutput;
    private javax.swing.JLabel temporaryTagAbilityBar;
    private javax.swing.JTextArea tutorOutput;
    // End of variables declaration//GEN-END:variables
}