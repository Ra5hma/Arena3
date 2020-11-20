/* 
 * this frame is the GUI for a battle, it facilitates both multiplayer and
 * single player battles. The Multiplayer components have largely been 
 * commented out as changes in the the singler player game have broken is 
 * functionality.  As time permits they multiplayer aspects of the frame will 
 * be revisted.
 */
package frames;

import classes.*;
import utilities.FrameManipulator;
import arena3.Arena;
import collections.Items;
import collections.Roles;
import java.awt.Color;
import java.util.Map;
import java.util.Vector;
import javax.swing.ListModel;
import javax.swing.SwingWorker;
import online.ArenaClient;
import abilities.Ability;
import collections.Abilities;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import utilities.AudioPlayer;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public final class ArenaFrame extends javax.swing.JFrame {
    //Map used to return stats restored from items
    Map<String, Integer> restored = new HashMap<>();
    //battle object used handle calculations
    private final Battle battle = new Battle(); 
    //used to handle comminications withh the server for online play 
    private ArenaClient ac;
    //check for online play
    private boolean online = false;
    //string to to hold instructions from the server
    private String servReq; 
    //used to center the frame
    private final FrameManipulator frameManipulater = new FrameManipulator(); 
    //the round number
    private String cmd; 
    //check used to continue game loop
    private boolean gameOn;
    //audio player for more looped sounds
    private AudioPlayer audioPlayerOne;
    //audio player for soundeffects
    private AudioPlayer audioPlayer;

    //type of attack the mob does
    private int damage;
    //used to set the heroDamageAnimatedText
    private int heroPreviousHp;
    
    
   
    /**
     * Creates new Arena frame,initializes all frame components
     * and begins game loop for single player
     */
    public ArenaFrame(){
        
        initComponents();
        this.setAbilityList();
        frameManipulater.centeredFrame(this);
        magAtt.setOpaque(false);
        phyAtt.setOpaque(false);
        rngAtt.setOpaque(false);
        endPanel.setVisible(false);
        roundCard.setVisible(true);
        stationaryMob.setVisible(false);
        projectile.setVisible(false);
        mobProjectile.setVisible(false);
        try {
            audioPlayer = new AudioPlayer();
            audioPlayerOne = new AudioPlayer();
            Arena.BGM.stop();
            Arena.BGM.setTrack(10);
            Arena.BGM.play();
            Arena.BGM.volume(-10.0f);
            battle.startNewBattle();
            battle.startNewRound();
            battle.getOpp().setStaticImage();
            updateForm();
            raiseRoundCard();
        } 
        catch (UnsupportedAudioFileException | IOException | 
                LineUnavailableException |InterruptedException ex) {
                ex.printStackTrace();
        }
  }
     /**
     * Creates new Arena frame,initializes all frame components
     * and begins game loop for online matches
     * @param arenaClient handles communication with the server
     * @param multi a flag that indicates it is an online match
     */
//    public ArenaFrame(ArenaClient arenaClient, boolean multi){
//        ac = arenaClient;
//        online = multi;
//        initComponents();
////        initOnlineForm();
//        frameManipulater.centeredFrame(this);
//        magAtt.setOpaque(false);
//        phyAtt.setOpaque(false);
//        rngAtt.setOpaque(false);
//        endPanel.setVisible(false);
//        
//        
//        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
//            
//            @Override
//            protected Void doInBackground() throws Exception {
//                myTurn(false);
//                while(gameOn){
//                    servReq = ac.recieve();
//                    cmd = ac.procPack(servReq);
//                    System.out.println(cmd);
//                    switch(cmd){
//                        case "uhp":
//                            myTurn(true);
//                            break;
//                        case "uhs":
//                            myTurn(true);
//                            break;
//                        case "stt":
//                            myTurn(true);
//                            break;
//                        case "vhs":
//                            myTurn(false);
//                            gameOn = false;
//                            endPanel.setVisible(true);
//                            forfeitLabel.setVisible(false);
//                            break;
//                        case "dhp":
//                            myTurn(false);
//                            gameOn = false;
//                            endPanel.setVisible(true);
//                            heroImage.setIcon(new javax.swing.ImageIcon
//                                (getClass().getResource
//                                ("/images/bonepile-removebg.png")));
//                            victoryLabel.setVisible(false);
//                            victoryTextLabel.setVisible(false);
//                            forfeitLabel.setVisible(false);
//                            break;
//                        case "oqt":
//                            myTurn(false);
//                            gameOn = false;
//                            endPanel.setVisible(true);
//
//                            break;
//                    }
//                    updateForm();            
//                }
//                return null;
//            }
//        };
//        worker.execute();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        rngButtonLabel2 = new javax.swing.JLabel();
        magButtonLabel1 = new javax.swing.JLabel();
        magAtt = new javax.swing.JButton();
        mobFloatingDamageBox = new javax.swing.JLabel();
        stationaryMob = new javax.swing.JLabel();
        roundCard = new javax.swing.JLabel();
        downRoundCard = new javax.swing.JLabel();
        heroFloatingDmgBox = new javax.swing.JLabel();
        heroMpFloatingBx = new javax.swing.JLabel();
        heroImage = new javax.swing.JLabel();
        mob = new javax.swing.JLabel();
        projectile = new javax.swing.JLabel();
        mobProjectile = new javax.swing.JLabel();
        phyButtonLabel = new javax.swing.JLabel();
        phyAtt = new javax.swing.JButton();
        rngAtt = new javax.swing.JButton();
        abilityButton = new javax.swing.JButton();
        oppPanel = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        mobDexLabel = new javax.swing.JLabel();
        mbIntLabel = new javax.swing.JLabel();
        mobStrLabel = new javax.swing.JLabel();
        mobLevelLabel = new javax.swing.JLabel();
        mobRoleLabel = new javax.swing.JLabel();
        endPanel = new javax.swing.JPanel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        lobbyButton = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();
        victoryTextLabel = new javax.swing.JLabel();
        victoryLabel = new javax.swing.JLabel();
        forfeitLabel = new javax.swing.JLabel();
        mobHpBarLabel = new javax.swing.JLabel();
        heroXpBarLabel = new javax.swing.JLabel();
        heroMpBarLabel = new javax.swing.JLabel();
        heroHpBarLabel = new javax.swing.JLabel();
        mobMpBarLabel = new javax.swing.JLabel();
        heroXpBar = new javax.swing.JProgressBar();
        heroMpBar = new javax.swing.JProgressBar();
        heroHpBar = new javax.swing.JProgressBar();
        mobHpBar = new javax.swing.JProgressBar();
        mobMpBar = new javax.swing.JProgressBar();
        characterSheet = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        xpCreditsLabel = new javax.swing.JLabel();
        expLabel = new javax.swing.JLabel();
        goldAmountLabel = new javax.swing.JLabel();
        goldLabel = new javax.swing.JLabel();
        heroDexLabel = new javax.swing.JLabel();
        heroIntLabel = new javax.swing.JLabel();
        heroStrLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        abilityPanel = new javax.swing.JPanel();
        abilityScrollPane = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        eqipmentPanel = new javax.swing.JPanel();
        swordImageLabel = new javax.swing.JLabel();
        staffImageLabel = new javax.swing.JLabel();
        bowImageLabel2 = new javax.swing.JLabel();
        itemPanel3 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        potionQuantityLabel = new javax.swing.JLabel();
        healthPotionButton = new javax.swing.JButton();
        healthPotionLabel = new javax.swing.JLabel();
        abilityQuantityLabel = new javax.swing.JLabel();
        abilityPotionButton = new javax.swing.JButton();
        comboQuantityLabel = new javax.swing.JLabel();
        comboPotionButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        abilityPotionLabel = new javax.swing.JLabel();
        comboPotionLabel = new javax.swing.JLabel();
        wagerAmountLabel = new javax.swing.JLabel();
        wagerLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rngButtonLabel2.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        rngButtonLabel2.setForeground(new java.awt.Color(255, 255, 255));
        rngButtonLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rngButtonLabel2.setText("-phy");
        rngButtonLabel2.setToolTipText("");
        jLayeredPane1.add(rngButtonLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 30, 20));

        magButtonLabel1.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        magButtonLabel1.setForeground(new java.awt.Color(255, 255, 255));
        magButtonLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        magButtonLabel1.setText("-dex");
        magButtonLabel1.setToolTipText("");
        jLayeredPane1.add(magButtonLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 30, 20));

        magAtt.setBackground(new java.awt.Color(0, 0, 255));
        magAtt.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        magAtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blueCircle-removebg.png"))); // NOI18N
        magAtt.setText("MAG");
        magAtt.setBorder(null);
        magAtt.setBorderPainted(false);
        magAtt.setFocusPainted(false);
        magAtt.setFocusable(false);
        magAtt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        magAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magAttActionPerformed(evt);
            }
        });
        jLayeredPane1.add(magAtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 130, -1));

        mobFloatingDamageBox.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        mobFloatingDamageBox.setForeground(new java.awt.Color(255, 0, 0));
        mobFloatingDamageBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mobFloatingDamageBox.setMinimumSize(new java.awt.Dimension(25, 25));
        jLayeredPane1.add(mobFloatingDamageBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 220, 30));

        stationaryMob.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stationaryMob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Skeleton.png"))); // NOI18N
        jLayeredPane1.add(stationaryMob, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 360, 380));

        roundCard.setBackground(new java.awt.Color(51, 51, 0));
        roundCard.setFont(new java.awt.Font("Algerian", 1, 90)); // NOI18N
        roundCard.setForeground(new java.awt.Color(255, 255, 255));
        roundCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finalRoundCard.png"))); // NOI18N
        roundCard.setText("ROUND "+battle.getRound());
        roundCard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLayeredPane1.add(roundCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 220));

        downRoundCard.setBackground(new java.awt.Color(51, 51, 0));
        downRoundCard.setFont(new java.awt.Font("Algerian", 1, 90)); // NOI18N
        downRoundCard.setForeground(new java.awt.Color(255, 255, 255));
        downRoundCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        downRoundCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finalRoundCard.png"))); // NOI18N
        downRoundCard.setText("ROUND "+battle.getRound());
        downRoundCard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLayeredPane1.add(downRoundCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -250, 950, 220));

        heroFloatingDmgBox.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        heroFloatingDmgBox.setForeground(new java.awt.Color(255, 0, 0));
        heroFloatingDmgBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heroFloatingDmgBox.setMinimumSize(new java.awt.Dimension(25, 25));
        jLayeredPane1.add(heroFloatingDmgBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 260, 30));

        heroMpFloatingBx.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        heroMpFloatingBx.setForeground(new java.awt.Color(255, 0, 0));
        heroMpFloatingBx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heroMpFloatingBx.setMinimumSize(new java.awt.Dimension(25, 25));
        jLayeredPane1.add(heroMpFloatingBx, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 130, 30));

        heroImage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        heroImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SwordStick.png"))); // NOI18N
        heroImage.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLayeredPane1.add(heroImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 250, 360));

        mob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bat.png"))); // NOI18N
        mob.setMaximumSize(new java.awt.Dimension(209, 317));
        mob.setMinimumSize(new java.awt.Dimension(209, 317));
        mob.setName(""); // NOI18N
        mob.setPreferredSize(new java.awt.Dimension(209, 317));
        jLayeredPane1.add(mob, new org.netbeans.lib.awtextra.AbsoluteConstraints(-270, 110, 290, 380));
        jLayeredPane1.add(projectile, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 160, 70));
        jLayeredPane1.add(mobProjectile, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 250, 70));

        phyButtonLabel.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        phyButtonLabel.setForeground(new java.awt.Color(255, 255, 255));
        phyButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phyButtonLabel.setText("-mag");
        phyButtonLabel.setToolTipText("");
        jLayeredPane1.add(phyButtonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 30, 20));

        phyAtt.setBackground(new java.awt.Color(0, 0, 255));
        phyAtt.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        phyAtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/redCircle-removebg.png"))); // NOI18N
        phyAtt.setText("PHY");
        phyAtt.setBorder(null);
        phyAtt.setBorderPainted(false);
        phyAtt.setFocusPainted(false);
        phyAtt.setFocusable(false);
        phyAtt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        phyAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phyAttActionPerformed(evt);
            }
        });
        jLayeredPane1.add(phyAtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 130, -1));

        rngAtt.setBackground(new java.awt.Color(0, 0, 255));
        rngAtt.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        rngAtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/greenCircle-removebg.png"))); // NOI18N
        rngAtt.setText("RNG");
        rngAtt.setBorder(null);
        rngAtt.setBorderPainted(false);
        rngAtt.setFocusPainted(false);
        rngAtt.setFocusable(false);
        rngAtt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rngAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rngAttActionPerformed(evt);
            }
        });
        jLayeredPane1.add(rngAtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 130, -1));

        abilityButton.setBackground(new java.awt.Color(255, 204, 51));
        abilityButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        abilityButton.setForeground(new java.awt.Color(0, 0, 0));
        abilityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abilityButtonActionPerformed(evt);
            }
        });
        abilityButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                abilityButtonKeyPressed(evt);
            }
        });
        jLayeredPane1.add(abilityButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, 220, 60));

        oppPanel.setBackground(new java.awt.Color(0, 0, 0));
        oppPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, battle.getOpp().getName()
            , javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", 1, 24), new java.awt.Color(255, 255, 204))); // NOI18N
    oppPanel.setForeground(new java.awt.Color(255, 255, 204));

    jLayeredPane4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    mobDexLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    mobDexLabel.setForeground(new java.awt.Color(51, 153, 0));
    mobDexLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    mobDexLabel.setText("DEX: "+Integer.toString(battle.getOpp().getDex()));
    jLayeredPane4.add(mobDexLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 90, 40));

    mbIntLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    mbIntLabel.setForeground(new java.awt.Color(0, 51, 204));
    mbIntLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    mbIntLabel.setText("INT: "+Integer.toString(battle.getOpp().getMag()));
    jLayeredPane4.add(mbIntLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 90, 40));

    mobStrLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    mobStrLabel.setForeground(new java.awt.Color(255, 0, 51));
    mobStrLabel.setText("STR: "+Integer.toString(battle.getOpp().getStr())
    );
    jLayeredPane4.add(mobStrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 40));

    mobLevelLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    mobLevelLabel.setForeground(new java.awt.Color(255, 255, 255));
    mobLevelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    mobLevelLabel.setText("LEVEL: "+Integer.toString(battle.getOpp().getLevel()));
    jLayeredPane4.add(mobLevelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

    mobRoleLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    mobRoleLabel.setForeground(new java.awt.Color(255, 255, 255));
    mobRoleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    mobRoleLabel.setText(battle.getOpp().getRole());
    jLayeredPane4.add(mobRoleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 130, 40));

    javax.swing.GroupLayout oppPanelLayout = new javax.swing.GroupLayout(oppPanel);
    oppPanel.setLayout(oppPanelLayout);
    oppPanelLayout.setHorizontalGroup(
        oppPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLayeredPane4)
    );
    oppPanelLayout.setVerticalGroup(
        oppPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(oppPanelLayout.createSequentialGroup()
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    jLayeredPane1.add(oppPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 130));

    endPanel.setOpaque(false);

    jLayeredPane8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lobbyButton.setBackground(new java.awt.Color(102, 0, 0));
    lobbyButton.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
    lobbyButton.setForeground(new java.awt.Color(204, 204, 167));
    lobbyButton.setText("EXIT");
    lobbyButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    lobbyButton.setBorderPainted(false);
    lobbyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    lobbyButton.setMaximumSize(new java.awt.Dimension(92, 43));
    lobbyButton.setMinimumSize(new java.awt.Dimension(92, 43));
    lobbyButton.setPreferredSize(new java.awt.Dimension(92, 43));
    lobbyButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            lobbyButtonActionPerformed(evt);
        }
    });
    jLayeredPane8.add(lobbyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 170, 40));

    continueButton.setBackground(new java.awt.Color(102, 0, 0));
    continueButton.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
    continueButton.setForeground(new java.awt.Color(204, 204, 167));
    continueButton.setText("CONTINUE");
    continueButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    continueButton.setBorderPainted(false);
    continueButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    continueButton.setMaximumSize(new java.awt.Dimension(92, 43));
    continueButton.setMinimumSize(new java.awt.Dimension(92, 43));
    continueButton.setPreferredSize(new java.awt.Dimension(92, 43));
    continueButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            continueButtonActionPerformed(evt);
        }
    });
    jLayeredPane8.add(continueButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 170, 40));

    victoryTextLabel.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36)); // NOI18N
    victoryTextLabel.setForeground(new java.awt.Color(255, 204, 51));
    victoryTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    victoryTextLabel.setLabelFor(victoryLabel);
    victoryTextLabel.setText("VICTORY");
    jLayeredPane8.add(victoryTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 220, 40));

    victoryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/redBanner.png"))); // NOI18N
    jLayeredPane8.add(victoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 390, 130));

    forfeitLabel.setFont(new java.awt.Font("High Tower Text", 1, 48)); // NOI18N
    forfeitLabel.setForeground(new java.awt.Color(0, 0, 0));
    forfeitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    forfeitLabel.setText("OPPONENT YIELDS");
    forfeitLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLayeredPane8.add(forfeitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 560, 160));

    javax.swing.GroupLayout endPanelLayout = new javax.swing.GroupLayout(endPanel);
    endPanel.setLayout(endPanelLayout);
    endPanelLayout.setHorizontalGroup(
        endPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLayeredPane8, javax.swing.GroupLayout.Alignment.TRAILING)
    );
    endPanelLayout.setVerticalGroup(
        endPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(endPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLayeredPane8))
    );

    jLayeredPane1.add(endPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 800, 470));

    mobHpBarLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
    mobHpBarLabel.setForeground(new java.awt.Color(255, 255, 255));
    mobHpBarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    mobHpBarLabel.setLabelFor(mobHpBarLabel);
    mobHpBarLabel.setText(battle.getOpp().getCurHp()+"/"+battle.getOpp().getMaxHp());
    mobHpBarLabel.setAlignmentX(0.5F);
    mobHpBarLabel.setDoubleBuffered(true);
    mobHpBarLabel.setFocusable(false);
    mobHpBarLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLayeredPane1.add(mobHpBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 130, -1));

    heroXpBarLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
    heroXpBarLabel.setForeground(new java.awt.Color(255, 255, 255));
    heroXpBarLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    heroXpBarLabel.setLabelFor(heroXpBar);
    heroXpBarLabel.setText(arena3.Arena.CUR_PLAYER.getXp()+"/"+arena3.Arena.CUR_PLAYER.getTnl()
    );
    heroXpBarLabel.setAlignmentX(0.5F);
    jLayeredPane1.add(heroXpBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 690, 130, -1));

    heroMpBarLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
    heroMpBarLabel.setForeground(new java.awt.Color(255, 255, 255));
    heroMpBarLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    heroMpBarLabel.setLabelFor(heroMpBar);
    heroMpBarLabel.setText(arena3.Arena.CUR_PLAYER.getCurMp()+"/"+arena3.Arena.CUR_PLAYER.getMaxMp());
    heroMpBarLabel.setAlignmentX(0.5F);
    jLayeredPane1.add(heroMpBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 670, 130, -1));

    heroHpBarLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
    heroHpBarLabel.setForeground(new java.awt.Color(255, 255, 255));
    heroHpBarLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    heroHpBarLabel.setLabelFor(heroHpBar);
    heroHpBarLabel.setText(arena3.Arena.CUR_PLAYER.getCurHp()+"/"+arena3.Arena.CUR_PLAYER.getMaxHp());
    heroHpBarLabel.setAlignmentX(0.5F);
    heroHpBarLabel.setDoubleBuffered(true);
    heroHpBarLabel.setFocusable(false);
    jLayeredPane1.add(heroHpBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 650, 130, -1));

    mobMpBarLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
    mobMpBarLabel.setForeground(new java.awt.Color(255, 255, 255));
    mobMpBarLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    mobMpBarLabel.setLabelFor(mobMpBar);
    mobMpBarLabel.setText(battle.getOpp().getCurMp()+"/"+battle.getOpp().getMaxMp());
    mobMpBarLabel.setAlignmentX(0.5F);
    jLayeredPane1.add(mobMpBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 130, -1));

    heroXpBar.setBackground(new java.awt.Color(253, 122, 7));
    heroXpBar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
    heroXpBar.setForeground(new java.awt.Color(0, 0, 0));
    heroXpBar.setMaximum(arena3.Arena.CUR_PLAYER.getTnl());
    heroXpBar.setToolTipText("");
    heroXpBar.setValue(arena3.Arena.CUR_PLAYER.getTnl()-arena3.Arena.CUR_PLAYER.getXp()
    );
    heroXpBar.setAlignmentX(1.0F);
    heroXpBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    heroXpBar.setFocusable(false);
    heroXpBar.setOpaque(true);
    heroXpBar.setString("75/100");
    heroXpBar.setVerifyInputWhenFocusTarget(false);
    jLayeredPane1.add(heroXpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 690, 310, 20));

    heroMpBar.setBackground(new java.awt.Color(75, 27, 240));
    heroMpBar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
    heroMpBar.setForeground(new java.awt.Color(0, 0, 0));
    heroMpBar.setMaximum(arena3.Arena.CUR_PLAYER.getMaxMp());
    heroMpBar.setToolTipText("");
    heroMpBar.setValue(arena3.Arena.CUR_PLAYER.getMaxMp()-arena3.Arena.CUR_PLAYER.getCurMp());
    heroMpBar.setAlignmentX(1.0F);
    heroMpBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    heroMpBar.setFocusable(false);
    heroMpBar.setOpaque(true);
    heroMpBar.setString("75/100");
    heroMpBar.setVerifyInputWhenFocusTarget(false);
    jLayeredPane1.add(heroMpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 670, 310, 20));

    heroHpBar.setBackground(new java.awt.Color(206, 29, 29));
    heroHpBar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
    heroHpBar.setForeground(new java.awt.Color(0, 0, 0));
    heroHpBar.setMaximum(arena3.Arena.CUR_PLAYER.getMaxHp());
    heroHpBar.setToolTipText("");
    heroHpBar.setValue(arena3.Arena.CUR_PLAYER.getMaxHp()-arena3.Arena.CUR_PLAYER.getCurHp());
    heroHpBar.setAlignmentX(1.0F);
    heroHpBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    heroHpBar.setFocusable(false);
    heroHpBar.setOpaque(true);
    heroHpBar.setString("75/100");
    heroHpBar.setVerifyInputWhenFocusTarget(false);
    jLayeredPane1.add(heroHpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 650, 310, 20));

    mobHpBar.setBackground(new java.awt.Color(0, 0, 0));
    mobHpBar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
    mobHpBar.setForeground(new java.awt.Color(206, 29, 29));
    mobHpBar.setMaximum(battle.getOpp().getMaxHp());
    mobHpBar.setToolTipText("");
    mobHpBar.setValue(battle.getOpp().getCurHp());
    mobHpBar.setAlignmentX(1.0F);
    mobHpBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    mobHpBar.setFocusable(false);
    mobHpBar.setOpaque(true);
    mobHpBar.setString("75/100");
    mobHpBar.setVerifyInputWhenFocusTarget(false);
    jLayeredPane1.add(mobHpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 310, 20));

    mobMpBar.setBackground(new java.awt.Color(0, 0, 0));
    mobMpBar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
    mobMpBar.setForeground(new java.awt.Color(75, 27, 240));
    mobMpBar.setMaximum(battle.getOpp().getMaxMp());
    mobMpBar.setToolTipText("");
    mobMpBar.setValue(battle.getOpp().getCurMp());
    mobMpBar.setAlignmentX(1.0F);
    mobMpBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    mobMpBar.setFocusable(false);
    mobMpBar.setOpaque(true);
    mobMpBar.setString("75/100");
    mobMpBar.setVerifyInputWhenFocusTarget(false);
    jLayeredPane1.add(mobMpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 310, 20));

    characterSheet.setBackground(new java.awt.Color(0, 0, 0));
    characterSheet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, arena3.Arena.CUR_PLAYER.getName(), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Century Gothic", 1, 24), new java.awt.Color(255, 255, 204))); // NOI18N
    characterSheet.setForeground(new java.awt.Color(255, 255, 204));

    jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    xpCreditsLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    xpCreditsLabel.setForeground(new java.awt.Color(255, 255, 255));
    xpCreditsLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    xpCreditsLabel.setText(Integer.toString(arena3.Arena.CUR_PLAYER.getXpCredits()));
    jLayeredPane2.add(xpCreditsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 100, 40));

    expLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    expLabel.setForeground(new java.awt.Color(255, 255, 255));
    expLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    expLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smallHourGlass-removebg-preview.png"))); // NOI18N
    jLayeredPane2.add(expLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 50, 40));

    goldAmountLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    goldAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
    goldAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    goldAmountLabel.setText(Integer.toString(arena3.Arena.CUR_PLAYER.getGold()));
    jLayeredPane2.add(goldAmountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 100, 40));

    goldLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    goldLabel.setForeground(new java.awt.Color(255, 255, 255));
    goldLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    goldLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stacked-coin-14-removebg.png"))); // NOI18N
    jLayeredPane2.add(goldLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 80, 40));

    heroDexLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    heroDexLabel.setForeground(new java.awt.Color(51, 153, 0));
    heroDexLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    heroDexLabel.setText("DEX: "+Integer.toString(arena3.Arena.CUR_PLAYER.getDex()));
    jLayeredPane2.add(heroDexLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 90, 40));

    heroIntLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    heroIntLabel.setForeground(new java.awt.Color(0, 51, 204));
    heroIntLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    heroIntLabel.setText("INT: "+Integer.toString(arena3.Arena.CUR_PLAYER.getMag()));
    jLayeredPane2.add(heroIntLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 90, 40));

    heroStrLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    heroStrLabel.setForeground(new java.awt.Color(255, 0, 51));
    heroStrLabel.setText("STR: "+Integer.toString(arena3.Arena.CUR_PLAYER.getStr()));
    jLayeredPane2.add(heroStrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 40));

    levelLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    levelLabel.setForeground(new java.awt.Color(255, 255, 255));
    levelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    levelLabel.setText("LEVEL: "+Integer.toString(arena3.Arena.CUR_PLAYER.getLevel()));
    jLayeredPane2.add(levelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

    roleLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
    roleLabel.setForeground(new java.awt.Color(255, 255, 255));
    roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    roleLabel.setText(arena3.Arena.CUR_PLAYER.getRole());
    jLayeredPane2.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 130, 40));

    abilityPanel.setBackground(new java.awt.Color(0, 0, 0));
    abilityPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ABILITIES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 204))); // NOI18N
    abilityPanel.setForeground(new java.awt.Color(255, 255, 255));

    jList1.setBackground(new java.awt.Color(0, 0, 0));
    jList1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
    jList1.setForeground(new java.awt.Color(255, 255, 255));
    jList1.setModel(new javax.swing.AbstractListModel<String>() {
        String[] strings = { "Cure", "Barrier", "Magic Missle", "Slow", "Pinning Shot", "Kill Bill", "FIre Ball", "Cover" };
        public int getSize() { return strings.length; }
        public String getElementAt(int i) { return strings[i]; }
    });
    jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jList1MouseClicked(evt);
        }
    });
    abilityScrollPane.setViewportView(jList1);

    javax.swing.GroupLayout abilityPanelLayout = new javax.swing.GroupLayout(abilityPanel);
    abilityPanel.setLayout(abilityPanelLayout);
    abilityPanelLayout.setHorizontalGroup(
        abilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(abilityScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
    );
    abilityPanelLayout.setVerticalGroup(
        abilityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(abilityScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
    );

    jLayeredPane2.add(abilityPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 310, 160));

    eqipmentPanel.setBackground(new java.awt.Color(0, 0, 0));
    eqipmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EQUIPMENT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 204))); // NOI18N

    swordImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    swordImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notSoTinySword.png"))); // NOI18N
    swordImageLabel.setToolTipText(arena3.Arena.CUR_PLAYER.getEquip().get("PHYSICAL").getName().toUpperCase()+"     Str:"+arena3.Arena.CUR_PLAYER.getEquip().get("PHYSICAL").getStr()+" Mag:"+arena3.Arena.CUR_PLAYER.getEquip().get("PHYSICAL").getMag()+" Dex:"+arena3.Arena.CUR_PLAYER.getEquip().get("PHYSICAL").getDex()
    );
    swordImageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            swordImageLabelMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            swordImageLabelMouseExited(evt);
        }
    });

    staffImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    staffImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bowSecondGo-removebg.png"))); // NOI18N
    staffImageLabel.setToolTipText(Arena.CUR_PLAYER.getEquip().get("RANGED").getName().toUpperCase()+"     Str:"+arena3.Arena.CUR_PLAYER.getEquip().get("RANGED").getStr()+" Mag:"+arena3.Arena.CUR_PLAYER.getEquip().get("RANGED").getMag()+" Dex:"+arena3.Arena.CUR_PLAYER.getEquip().get("RANGED").getDex());
    staffImageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            staffImageLabelMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            staffImageLabelMouseExited(evt);
        }
    });

    bowImageLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    bowImageLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GemsfirstSecondgo.png"))); // NOI18N
    bowImageLabel2.setToolTipText(arena3.Arena.CUR_PLAYER.getEquip().get("MAGICAL").getName().toUpperCase()+"     Str:"+arena3.Arena.CUR_PLAYER.getEquip().get("MAGICAL").getStr()+" Mag:"+arena3.Arena.CUR_PLAYER.getEquip().get("MAGICAL").getMag()+" Dex:"+arena3.Arena.CUR_PLAYER.getEquip().get("MAGICAL").getDex());
    bowImageLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            bowImageLabel2MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            bowImageLabel2MouseExited(evt);
        }
    });

    javax.swing.GroupLayout eqipmentPanelLayout = new javax.swing.GroupLayout(eqipmentPanel);
    eqipmentPanel.setLayout(eqipmentPanelLayout);
    eqipmentPanelLayout.setHorizontalGroup(
        eqipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(eqipmentPanelLayout.createSequentialGroup()
            .addContainerGap(16, Short.MAX_VALUE)
            .addComponent(swordImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bowImageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(staffImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(14, 14, 14))
    );
    eqipmentPanelLayout.setVerticalGroup(
        eqipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(eqipmentPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(eqipmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(swordImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(staffImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bowImageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLayeredPane2.add(eqipmentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 310, 90));

    itemPanel3.setBackground(new java.awt.Color(0, 0, 0));
    itemPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ITEMS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(255, 255, 204))); // NOI18N

    jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    potionQuantityLabel.setForeground(new java.awt.Color(255, 255, 255));
    potionQuantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    potionQuantityLabel.setText(arena3.Arena.CUR_PLAYER.getItems().get(Items.ABILITY.getName()).getQuantity()+"");
    potionQuantityLabel.setToolTipText("");
    jLayeredPane3.add(potionQuantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 20));

    healthPotionButton.setBackground(new java.awt.Color(0, 0, 0));
    healthPotionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/healthPotionsm.png"))); // NOI18N
    healthPotionButton.setToolTipText("Restores "+arena3.Arena.CUR_PLAYER.getItems().get(Items.HEALTH.getName()).getHp()*100+"% of total HP"
    );
    healthPotionButton.setContentAreaFilled(false);
    healthPotionButton.setMaximumSize(new java.awt.Dimension(82, 82));
    healthPotionButton.setMinimumSize(new java.awt.Dimension(82, 82));
    healthPotionButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            healthPotionButtonActionPerformed(evt);
        }
    });
    jLayeredPane3.add(healthPotionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 80));

    healthPotionLabel.setToolTipText("Potion: <<Heals 10% of Max HP>>");
    healthPotionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    healthPotionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            healthPotionLabelMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            healthPotionLabelMouseExited(evt);
        }
    });
    jLayeredPane3.add(healthPotionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 80));

    abilityQuantityLabel.setForeground(new java.awt.Color(255, 255, 255));
    abilityQuantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    abilityQuantityLabel.setText(arena3.Arena.CUR_PLAYER.getItems().get(Items.HEALTH.getName()).getQuantity()+"");
    abilityQuantityLabel.setToolTipText("");
    jLayeredPane3.add(abilityQuantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 30, 20));

    abilityPotionButton.setBackground(new java.awt.Color(0, 0, 0));
    abilityPotionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/abilityPotion-removebg-.png"))); // NOI18N
    abilityPotionButton.setToolTipText("Restores "+arena3.Arena.CUR_PLAYER.getItems().get(Items.ABILITY.getName()).getMp()*100+"% of total MP"
    );
    abilityPotionButton.setContentAreaFilled(false);
    abilityPotionButton.setMaximumSize(new java.awt.Dimension(82, 82));
    abilityPotionButton.setMinimumSize(new java.awt.Dimension(82, 82));
    abilityPotionButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            abilityPotionButtonActionPerformed(evt);
        }
    });
    jLayeredPane3.add(abilityPotionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 80));

    comboQuantityLabel.setForeground(new java.awt.Color(255, 255, 255));
    comboQuantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    comboQuantityLabel.setText(arena3.Arena.CUR_PLAYER.getItems().get(Items.COMBO.getName()).getQuantity()+"");
    comboQuantityLabel.setToolTipText("");
    jLayeredPane3.add(comboQuantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 30, 20));

    comboPotionButton.setBackground(new java.awt.Color(0, 0, 0));
    comboPotionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ComboPotion.png"))); // NOI18N
    comboPotionButton.setToolTipText("Restores "+arena3.Arena.CUR_PLAYER.getItems().get(Items.ABILITY.getName()).getMp()*100+"% of total MP"
    );
    comboPotionButton.setContentAreaFilled(false);
    comboPotionButton.setMaximumSize(new java.awt.Dimension(82, 82));
    comboPotionButton.setMinimumSize(new java.awt.Dimension(82, 82));
    comboPotionButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboPotionButtonActionPerformed(evt);
        }
    });
    jLayeredPane3.add(comboPotionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 80, 80));

    jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    jLayeredPane3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 80, 80));

    jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    jLayeredPane3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 80, 80));

    jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    jLayeredPane3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 80, 80));

    abilityPotionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    jLayeredPane3.add(abilityPotionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 80));

    comboPotionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    comboPotionLabel.addAncestorListener(new javax.swing.event.AncestorListener() {
        public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
        }
        public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            comboPotionLabelAncestorAdded(evt);
        }
        public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
        }
    });
    jLayeredPane3.add(comboPotionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 80, 80));

    wagerAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
    wagerAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    wagerAmountLabel.setText(battle.getHero().getGoldWagered()+" G");
    wagerAmountLabel.setToolTipText("");
    jLayeredPane3.add(wagerAmountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 70, 20));

    wagerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PokerChips.png"))); // NOI18N
    wagerLabel.setToolTipText("Rounds Wagered: "+battle.getHero().getRoundsWagered()+"");
    wagerLabel.setBorder(null);
    jLayeredPane3.add(wagerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 80, 80));

    jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    jLayeredPane3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 80, 80));

    jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    jLayeredPane3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 80, 80));

    javax.swing.GroupLayout itemPanel3Layout = new javax.swing.GroupLayout(itemPanel3);
    itemPanel3.setLayout(itemPanel3Layout);
    itemPanel3Layout.setHorizontalGroup(
        itemPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(itemPanel3Layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(23, Short.MAX_VALUE))
    );
    itemPanel3Layout.setVerticalGroup(
        itemPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemPanel3Layout.createSequentialGroup()
            .addComponent(jLayeredPane3)
            .addContainerGap())
    );

    jLayeredPane2.add(itemPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 310, 280));

    javax.swing.GroupLayout characterSheetLayout = new javax.swing.GroupLayout(characterSheet);
    characterSheet.setLayout(characterSheetLayout);
    characterSheetLayout.setHorizontalGroup(
        characterSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLayeredPane2)
    );
    characterSheetLayout.setVerticalGroup(
        characterSheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLayeredPane2)
    );

    jLayeredPane1.add(characterSheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 320, 720));

    BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/interior.png"))); // NOI18N
    jLayeredPane1.add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 720));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLayeredPane1)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Magical Attack
     * Performs all calculations and animations associated with a player's 
     * magical attack
     * @param evt - left mouse click  
     */
    private void magAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magAttActionPerformed

        audioPlayer.playEffect(battle.getHero().getPlayerMagSounds());
//      if(online == false){
        myTurn(false);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
        @Override
        protected Void doInBackground() throws Exception {
            damage = battle.magAtt(battle.getHero(), battle.getOpp());
            playerOneMagAttAnimation();
            
            if(battle.getOpp().yaDead()){
                mobDefeated();
                return null;}
            mobTurn();            
            return null;
        }
    };
    worker.execute();
//        }
//        else{
//            
//            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
//                
//            @Override
//            protected Void doInBackground() throws Exception {
//                ac.send("mga");
//                return null;
//            }};
//            worker.execute();
//        }
    }//GEN-LAST:event_magAttActionPerformed
 
    /**
     * Physical Attack
     * Performs all calculations and animations associated with a player's 
     * Physical attack
     * @param evt - left mouse click
     */
    private void phyAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phyAttActionPerformed
        
        audioPlayer.playEffect(battle.getHero().getPhySounds());
//      if(online == false){         
        myTurn(false);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
                
        @Override
        protected Void doInBackground() throws Exception {                   
            damage = battle.phyAtt(battle.getHero(), battle.getOpp());
            playerOnePhyAttAnimation();
            if(battle.getOpp().yaDead()){
                mobDefeated();
                return null;}
            mobTurn();
            return null;
                }
        };
        worker.execute();
//        }       
//        else{
//            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
//            @Override
//            protected Void doInBackground() throws Exception {
//                ac.send("pha");
//                return null;
//            }};
//            worker.execute();
//        }
    }//GEN-LAST:event_phyAttActionPerformed
   
    /**
     * Ranged Attack
     * Performs all calculations and animations associated with a player's 
     * ranged attack
     * @param evt - left mouse click
     */
    private void rngAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rngAttActionPerformed

        audioPlayer.playEffect(battle.getHero().getPlayerRngSounds());
//      if(online == false){
        myTurn(false);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                
            damage = battle.rngAtt(battle.getHero(), battle.getOpp());
            playerOneRngAttAnimation();
            if(battle.getOpp().yaDead()){

                    myTurn(false);

                mobDefeated();
                return null;
            } 
            mobTurn();            
            return null;
        }
    };
    worker.execute();
//        }
//        else{
//            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
//            @Override
//            protected Void doInBackground() throws Exception {
//                ac.send("rga");
//                return null;
//            }};
//            worker.execute();
//        }
    }//GEN-LAST:event_rngAttActionPerformed
    
    /**
     * Ability
     * Uses ability loaded on the button, performs all calculations and 
     * animations relevant to the loaded ability.
     * @param evt - left mouse click
     */
    private void abilityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abilityButtonActionPerformed

//      if(online == false){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
                
            @Override
            protected Void doInBackground() throws Exception {
                
                if(!(abilityButton.getText().isEmpty())){
                    Map<String, Integer> abilityResult = battle.useAbility
                        (abilityButton.getText());
                    abilityButton.setText(null);
                    parseAbility(abilityResult);
                    updateForm();
                    if(battle.getOpp().yaDead()){
                        myTurn(false);
                        mobDefeated();
                        return null;
                    } 
                }
                mobTurn();
                return null;
            }
        };
        worker.execute();
//        }        
//        else{
//            ac.send("qut");
//            ArenaExtFrame g = new ArenaExtFrame();
//            g.setVisible(true);
//            dispose();
//        }
    }//GEN-LAST:event_abilityButtonActionPerformed
   
    /**
     * Move to Arena exterior frame.  Resets player stats to the state they were
     * when the player entered the arena
     * @param evt 
     */
    private void lobbyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lobbyButtonActionPerformed
        
        audioPlayer.playOnce(1);
//      if(online){
//            ac.closeSocket();
//            ac.getHero().setPlayerCurHp(ac.getHero().getPlayerMaxHp());
//            ArenaExtFrame aef = new ArenaExtFrame();
//            ac.getHero().setPlayerCurHp(ac.getHero().getPlayerMaxHp());
//            aef.setVisible(true);
//            dispose();
//        }
//        else{
        try {
            battle.endBattle();
            battle.getHero().setGoldWagered(0, 0);
            battle.getHero().setRoundsWagered(0, 0);
            battle.getHero().setBetActive(false);
            Arena.BGM.stop();
            Arena.BGM.setTrack(0);
            Arena.BGM.play();
            if(audioPlayerOne.getPlayStatus()){
                audioPlayerOne.stop();
            }
            ArenaExtFrame arenaExtFrame = new ArenaExtFrame();
            arenaExtFrame.setVisible(true);
            dispose();
        } 
        catch (UnsupportedAudioFileException | IOException | 
                LineUnavailableException ex) {
            ex.printStackTrace();
        }
//        }
    }//GEN-LAST:event_lobbyButtonActionPerformed

    private void swordImageLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_swordImageLabelMouseEntered

    }//GEN-LAST:event_swordImageLabelMouseEntered

    private void swordImageLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_swordImageLabelMouseExited

    }//GEN-LAST:event_swordImageLabelMouseExited

    private void staffImageLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffImageLabelMouseEntered

    }//GEN-LAST:event_staffImageLabelMouseEntered

    private void staffImageLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffImageLabelMouseExited

    }//GEN-LAST:event_staffImageLabelMouseExited

    private void bowImageLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bowImageLabel2MouseEntered

    }//GEN-LAST:event_bowImageLabel2MouseEntered

    private void bowImageLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bowImageLabel2MouseExited

    }//GEN-LAST:event_bowImageLabel2MouseExited

    private void healthPotionLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_healthPotionLabelMouseEntered

    }//GEN-LAST:event_healthPotionLabelMouseEntered

    private void healthPotionLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_healthPotionLabelMouseExited

    }//GEN-LAST:event_healthPotionLabelMouseExited
   
    /**
     * Use Health potion
     * performs all calculations, animations, and sounds effect when using a
     * health potion
     * @param evt - left mouse click 
     */
    private void healthPotionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healthPotionButtonActionPerformed

//      if(online == false){
        myTurn(false);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                restored = battle.useItem(Items.HEALTH.getName());
                audioPlayer.playEffect(Arena.CUR_PLAYER.getItems(). 
                        get(Items.HEALTH.getName()).getSoundFiles());
                heroDamageBoxAnimation(restored.get("hp")+"", Color.GREEN);
                mobTurn();
                return null;
            }
        };
        worker.execute();
//        }
        /**
        else{
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                ac.send("mga");
                return null;
            }};
            worker.execute();
        }
        */
    }//GEN-LAST:event_healthPotionButtonActionPerformed
    
    /**
     * Assigns the selected ability from the ability list to the ability button
     * if the current mp does not meet the cost of the ability the ability button 
     * is disabled.
     * @param evt 
     */
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        
        audioPlayer.playOnce(2);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            
            @Override
            protected Void doInBackground() throws Exception {

                if(jList1.getModel().getSize() > 0){
                    int selection = jList1.getSelectedIndex();
                    ListModel<String> lm = jList1.getModel();
                    String idk = lm.getElementAt(selection);
                    String[] modelText = idk.split(":");
                    String newText = modelText[0].trim();
                    abilityButton.setText(newText);
                    if(battle.getHero().getCurMp() < (int)
                            (battle.getHero().getAbilites().get(newText).
                            getCost()*battle.getHero().getMaxMp())){
                        abilityButton.setEnabled(false);
                        return null;
                    }  
                }
                abilityButton.setEnabled(true);
                return null;
            }
        };
        worker.execute();
    }//GEN-LAST:event_jList1MouseClicked

    private void abilityButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_abilityButtonKeyPressed

    }//GEN-LAST:event_abilityButtonKeyPressed
   
    /**
     * Use ability potion
     * performs all calculations, animations, and sounds effect when using an
     * ability potion
     * @param evt - left mouse click 
     */
    private void abilityPotionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abilityPotionButtonActionPerformed
//      if(online == false){
        myTurn(false);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                restored = battle.useItem(Items.ABILITY.getName());
                audioPlayer.playEffect(Arena.CUR_PLAYER.getItems().get(Items.HEALTH.getName()).getSoundFiles());
                heroMpBoxAnimation(restored.get("ap")+"", Color.BLUE);
                mobTurn();
                return null;
            }
        };
        worker.execute();
//      }
    }//GEN-LAST:event_abilityPotionButtonActionPerformed

    /**
     * Use combo potion
     * performs all calculations, animations, and sounds effect when using an
     * combo potion
     * @param evt - left mouse click 
     */
    private void comboPotionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPotionButtonActionPerformed
//      if(online == false){
        myTurn(false);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                restored = battle.useItem(Items.COMBO.getName());
                audioPlayer.playEffect(Arena.CUR_PLAYER.getItems().get(Items.HEALTH.getName()).getSoundFiles());
                heroDamageBoxAnimation(restored.get("hp")+"", Color.GREEN);
                heroMpBoxAnimation(restored.get("ap")+"", Color.BLUE);
                mobTurn();
                return null;
            }
        };    
        worker.execute();
//            }
    }//GEN-LAST:event_comboPotionButtonActionPerformed

    private void comboPotionLabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_comboPotionLabelAncestorAdded

    }//GEN-LAST:event_comboPotionLabelAncestorAdded

    /**
     * Allows the player to continue to the next round at the completion of a 
     * round
     * @param evt - left click 
     */
    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        battle.startNewRound();
        audioPlayer.playOnce(2);
        try {
            Arena.BGM.stop();
            Arena.BGM.setTrack(10);
            Arena.BGM.play();
            Arena.BGM.volume(-10.0f);
            audioPlayerOne.stop();
            battle.getOpp().setStaticImage();
            heroImage.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/images/SwordStick.png")));
            raiseRoundCard();
            updateForm();
        } catch (InterruptedException | UnsupportedAudioFileException | 
                IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_continueButtonActionPerformed
     
    /**
     * Main Method
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
        } 
        catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
             ex.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArenaFrame().setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JButton abilityButton;
    private javax.swing.JPanel abilityPanel;
    private javax.swing.JButton abilityPotionButton;
    private javax.swing.JLabel abilityPotionLabel;
    private javax.swing.JLabel abilityQuantityLabel;
    private javax.swing.JScrollPane abilityScrollPane;
    private javax.swing.JLabel bowImageLabel2;
    private javax.swing.JPanel characterSheet;
    private javax.swing.JButton comboPotionButton;
    private javax.swing.JLabel comboPotionLabel;
    private javax.swing.JLabel comboQuantityLabel;
    private javax.swing.JButton continueButton;
    private javax.swing.JLabel downRoundCard;
    private javax.swing.JPanel endPanel;
    private javax.swing.JPanel eqipmentPanel;
    private javax.swing.JLabel expLabel;
    private javax.swing.JLabel forfeitLabel;
    private javax.swing.JLabel goldAmountLabel;
    private javax.swing.JLabel goldLabel;
    private javax.swing.JButton healthPotionButton;
    private javax.swing.JLabel healthPotionLabel;
    private javax.swing.JLabel heroDexLabel;
    private javax.swing.JLabel heroFloatingDmgBox;
    private javax.swing.JProgressBar heroHpBar;
    private javax.swing.JLabel heroHpBarLabel;
    private javax.swing.JLabel heroImage;
    private javax.swing.JLabel heroIntLabel;
    private javax.swing.JProgressBar heroMpBar;
    private javax.swing.JLabel heroMpBarLabel;
    private javax.swing.JLabel heroMpFloatingBx;
    private javax.swing.JLabel heroStrLabel;
    private javax.swing.JProgressBar heroXpBar;
    private javax.swing.JLabel heroXpBarLabel;
    private javax.swing.JPanel itemPanel3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton lobbyButton;
    private javax.swing.JButton magAtt;
    private javax.swing.JLabel magButtonLabel1;
    private javax.swing.JLabel mbIntLabel;
    private javax.swing.JLabel mob;
    private javax.swing.JLabel mobDexLabel;
    private javax.swing.JLabel mobFloatingDamageBox;
    private javax.swing.JProgressBar mobHpBar;
    private javax.swing.JLabel mobHpBarLabel;
    private javax.swing.JLabel mobLevelLabel;
    private javax.swing.JProgressBar mobMpBar;
    private javax.swing.JLabel mobMpBarLabel;
    private javax.swing.JLabel mobProjectile;
    private javax.swing.JLabel mobRoleLabel;
    private javax.swing.JLabel mobStrLabel;
    private javax.swing.JPanel oppPanel;
    private javax.swing.JButton phyAtt;
    private javax.swing.JLabel phyButtonLabel;
    private javax.swing.JLabel potionQuantityLabel;
    private javax.swing.JLabel projectile;
    private javax.swing.JButton rngAtt;
    private javax.swing.JLabel rngButtonLabel2;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel roundCard;
    private javax.swing.JLabel staffImageLabel;
    private javax.swing.JLabel stationaryMob;
    private javax.swing.JLabel swordImageLabel;
    private javax.swing.JLabel victoryLabel;
    private javax.swing.JLabel victoryTextLabel;
    private javax.swing.JLabel wagerAmountLabel;
    private javax.swing.JLabel wagerLabel;
    private javax.swing.JLabel xpCreditsLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * Method that updates all appropriate form objects
     */
    public void updateForm(){
                                   
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
//        if(online){
//            heroHpBar.setMaximum(ac.getHero().getPlayerMaxHp());
//            heroHpBar.setValue(ac.getHero().getPlayerMaxHp()- 
//                    ac.getHero().getPlayerCurHp());
//            heroMpBar.setMaximum(ac.getHero().getPlayerMaxMp());
//            heroMpBar.setValue(ac.getHero().getPlayerMaxMp()- 
//                    ac.getHero().getPlayerCurMp());
//            heroXpBar.setMaximum(ac.getHero().getTnl());
//            heroXpBar.setValue(ac.getHero().getTnl() - ac.getHero().getXp());
//            heroHpBarLabel.setText(ac.getHero().getPlayerCurHp()+"/"
//                    +ac.getHero().getPlayerMaxHp());
//            heroMpBarLabel.setText(ac.getHero().getPlayerCurMp()+"/"
//                    +ac.getHero().getPlayerMaxMp());
//            heroXpBarLabel.setText(ac.getHero().getXp()+"/"
//                    +ac.getHero().getTnl());
//            heroStrLabel.setText("STR: "+ac.getHero().getPlayerStr());
//            heroIntLabel.setText("INT: "+ac.getHero().getPlayerMag());
//            heroDexLabel.setText("DEX: "+ac.getHero().getPlayerDex());
//            //mob GUI elements
//            mobStrLabel.setText("STR: "+ac.getOpp().getPlayerStr());
//            mbIntLabel.setText("INT: "+ac.getOpp().getPlayerMag());
//            mobDexLabel.setText("DEX: "+ac.getOpp().getPlayerDex());
//            mobHpBar.setMaximum(ac.getOpp().getPlayerMaxHp());
//            mobHpBar.setValue(ac.getOpp().getPlayerCurHp());
//            mobMpBar.setMaximum(ac.getOpp().getPlayerMaxMp());
//            mobMpBar.setValue(ac.getOpp().getPlayerCurMp()); 
//            mobHpBarLabel.setText(ac.getOpp().getPlayerCurHp()+"/"+ac.getOpp()
//                    .getPlayerMaxHp());
//            mobMpBarLabel.setText(ac.getOpp().getPlayerCurMp()+"/"+ac.getOpp()
//                    .getPlayerMaxMp());
//        }
//        
//        else{
                setAbilityList();
                wagerAmountLabel.setText(battle.getHero().getGoldWagered()+"");
                wagerLabel.setToolTipText("Rounds Wagared: "+battle.getHero()
                        .getRoundsWagered()+"");
                roleLabel.setText(battle.getHero().getRole());
                levelLabel.setText("LEVEL: "+battle.getHero().getLevel());
                heroHpBarLabel.setText(battle.getHero().getCurHp()+"/"
                        +battle.getHero().getMaxHp());
                heroMpBarLabel.setText(battle.getHero().getCurMp()+"/"
                        +battle.getHero().getMaxMp());
                heroXpBarLabel.setText(battle.getHero().getXp()+"/"
                        +battle.getHero().getTnl());
                heroHpBar.setMaximum(battle.getHero().getMaxHp());
                heroHpBar.setValue(battle.getHero().getMaxHp()- 
                        battle.getHero().getCurHp());
                heroMpBar.setMaximum(battle.getHero().getMaxMp());
                heroMpBar.setValue(battle.getHero().getMaxMp()- 
                        battle.getHero().getCurMp());
                heroXpBar.setMaximum(battle.getHero().getTnl());
                heroXpBar.setValue(battle.getHero().getTnl() - 
                        battle.getHero().getXp());
                heroStrLabel.setText("STR: "+battle.getHero().getStr());
                heroIntLabel.setText("INT: "+battle.getHero().getMag());
                heroDexLabel.setText("DEX: "+battle.getHero().getDex());
                potionQuantityLabel.setText(battle.getHero().getItems().
                        get(Items.HEALTH.getName()).getQuantity()+"");
                abilityQuantityLabel.setText(battle.getHero().getItems().
                        get(Items.ABILITY.getName()).getQuantity()+"");
                comboQuantityLabel.setText(battle.getHero().getItems().
                        get(Items.COMBO.getName()).getQuantity()+"");
                xpCreditsLabel.setText(battle.getHero().getXpCredits()+"");
                goldAmountLabel.setText(battle.getHero().getGold()+"");
                //mob GUI elements
                mob.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource(battle.getOpp().getStaticImage())));
                mob.repaint();
                stationaryMob.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource(battle.getOpp().getStaticImage())));
                stationaryMob.repaint();
                oppPanel.setBorder(javax.swing.BorderFactory.createTitledBorder
                (null, battle.getOpp().getName(),javax.swing.border.TitledBorder.
                        CENTER, javax.swing.border.TitledBorder.ABOVE_TOP,
                        new java.awt.Font
                ("Century Gothic", 1, 24), new java.awt.Color(255, 255, 204)));
                mobLevelLabel.setText("Level: "+battle.getOpp().getLevel());
                mobRoleLabel.setText(battle.getOpp().getRole());
                mobStrLabel.setText("STR: "+battle.getOpp().getStr());
                mbIntLabel.setText("INT: "+battle.getOpp().getMag());
                mobDexLabel.setText("DEX: "+battle.getOpp().getDex());
                mobHpBar.setMaximum(battle.getOpp().getMaxHp());
                mobHpBar.setValue(battle.getOpp().getCurHp());
                mobMpBar.setMaximum(battle.getOpp().getMaxMp());
                mobMpBar.setValue(battle.getOpp().getCurMp()); 
                mobHpBarLabel.setText(battle.getOpp().getCurHp()+"/"+battle.getOpp().getMaxHp());
                mobMpBarLabel.setText(battle.getOpp().getCurMp()+"/"+battle.getOpp().getMaxMp());
    //        }
                return null;
            }
        };
        worker.execute();
    }
//    public void initOnlineForm(){
//        oppPanel.setBorder(javax.swing.BorderFactory.createTitledBorder
//            (null, ac.getOpp().getName(),javax.swing.border.TitledBorder.CENTER,
//            javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font
//            ("Century Gothic", 1, 24), new java.awt.Color(255, 255, 204)));
//        mobLevelLabel.setText("Level: "+ac.getOpp().getPlayerLevel());
//        mobRoleLabel.setText(ac.getOpp().getPlayerRole());
//        mobStrLabel.setText("STR: "+ac.getOpp().getPlayerStr());
//        mbIntLabel.setText("INT: "+ac.getOpp().getPlayerMag());
//        mobDexLabel.setText("DEX: "+ac.getOpp().getPlayerDex());
//        mobHpBarLabel.setText(ac.getOpp().getPlayerCurHp()+"/"+ac.getOpp()
//                .getPlayerMaxHp());
//        mobMpBarLabel.setText(ac.getOpp().getPlayerCurMp()+"/"+ac.getOpp()
//                .getPlayerMaxMp());
//        mobHpBar.setMaximum(ac.getOpp().getPlayerMaxHp());
//        mobHpBar.setValue(ac.getOpp().getPlayerCurHp());
//        mobMpBar.setMaximum(ac.getOpp().getPlayerMaxMp());
//        mobMpBar.setValue(ac.getOpp().getPlayerCurMp());
//    }
  
    /**
     * Disables input buttons except the ability list on false,
     * Enables input buttons an true
     * Checks resources and disables the appropriate buttons if the player does
     * not have the resources to use the ability/potion
     * @param bol - false if not player's turn, true if it is player's turn
     */
    public void myTurn(Boolean bol){
        
        if(bol){
            magAtt.setEnabled(true);
            phyAtt.setEnabled(true);
            rngAtt.setEnabled(true);
            if(battle.getHero().getItems().get(Items.HEALTH.getName()).
                    getQuantity()>0){
                healthPotionButton.setEnabled(true);
            }    
            else{
                healthPotionButton.setEnabled(false);
            }
            if(battle.getHero().getItems().get(Items.ABILITY.getName()).
                    getQuantity()>0){
                abilityPotionButton.setEnabled(true);
            }
            else{
                abilityPotionButton.setEnabled(false);
            }
            if(battle.getHero().getItems().get(Items.COMBO.getName()).
                    getQuantity()>0){
                comboPotionButton.setEnabled(true);
            }
            else{
                comboPotionButton.setEnabled(false);
            }
            if(abilityButton.getText().length()>1){
                if(battle.getHero().getAbilites().get(abilityButton.getText()).
                        getCost()*battle.getHero().getMaxMp()<= battle.
                        getHero().getCurMp()){
                    abilityButton.setEnabled(true);
                }
            }   
        }
        else{
            magAtt.setEnabled(false);
            phyAtt.setEnabled(false);
            rngAtt.setEnabled(false);
            healthPotionButton.setEnabled(false);
            abilityPotionButton.setEnabled(false);
            comboPotionButton.setEnabled(false);
            abilityButton.setEnabled(false);
        }
    }
    
    /**
     * Executes the mob attack and 
     * Checks for player defeat condition
     */
    public void mobTurn(){
        heroPreviousHp = battle.getHero().getCurHp();
        updateForm();   
        myTurn(false);
        try {
            Thread.sleep(800);
        } 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        deterimneMobAnimation(battle.mobAttack());
        if(heroPreviousHp-battle.getHero().getCurHp() != 0){
                this.heroDamageBoxAnimation(heroPreviousHp-battle.getHero().
                    getCurHp()+"", Color.RED);
        }
        updateForm();
        if(battle.getHero().yaDead()){   
            playerDefeated();
            return;
          } 
        myTurn(true);   
    }
    
    /**
     * Evaluates the mob attack type and displays the appropriate animation
     * @param the type of condition sent from the battle class 
     */
    private void deterimneMobAnimation(String mobAttackType){
        switch(mobAttackType){
            case("phy"):
                mobPhyAnimation();
                break;
            case("mag"):
                mobMagAttAnimation();
                break;
            case("rng"):
                mobRngAttAnimation();
                break;
            case("phyExtra"):
                mobPhyAnimation();
                mobFloatingDamageBoxAnimation("Speed Attack", Color.BLACK);
                mobTurn();
                break;
            case("magExtra"):
                mobMagAttAnimation();
                mobFloatingDamageBoxAnimation("Speed Attack", Color.BLACK);
                mobTurn();
                break;
            case("rngExtra"):
                mobRngAttAnimation();
                mobFloatingDamageBoxAnimation("Speed Attack", Color.BLACK);
                mobTurn();
                break;
            case("Speed Attack"):
                heroDamageBoxAnimation("Speed Attack", Color.BLACK);
                break;
            case("skip"):
                break;
        }
    }
    /**
     * Sets the player's available abilities based on their current role. 
     */   
    public void setAbilityList(){
        Vector<String> abilityList = new Vector<>();
        if(battle.getHero().getRole().equals(Roles.PHYSICAL.getRole())){
            for(Map.Entry<String,Ability> entrySet: battle.getHero().
                    getAbilites().entrySet()){
                if(entrySet.getValue().getType().equals("Physical")){
                    abilityList.add(entrySet.getKey()+":        (AP  "+(int)
                            (battle.getHero().getMaxMp()*entrySet.getValue().
                                    getCost())+")");
                }    
            }    
        }
        else if(battle.getHero().getRole().equals(Roles.MAGICAL.getRole())){
            for(Map.Entry<String,Ability> entrySet: battle.getHero().
                    getAbilites().entrySet()){
                if(entrySet.getValue().getType().equals("Magical")){
                    abilityList.add(entrySet.getKey()+":        (AP  "+(int)
                            (battle.getHero().getMaxMp()*entrySet.getValue().
                                    getCost())+")");
                }    
            } 
        }
        else if(battle.getHero().getRole().equals(Roles.RANGED.getRole())){
            for(Map.Entry<String,Ability> entrySet: battle.getHero().
                    getAbilites().entrySet()){
                if(entrySet.getValue().getType().equals("Ranged")){
                    abilityList.add(entrySet.getKey()+":        (AP  "+(int)
                            (battle.getHero().getMaxMp()*entrySet.getValue()
                                    .getCost())+")");
                }    
            } 
        }
        else{
            for(Map.Entry<String,Ability> entrySet: battle.getHero().
                    getAbilites().entrySet()){
                if(entrySet.getValue().getType().equals("Balanced")){
                    abilityList.add(entrySet.getKey()+":        (AP  "+(int)
                            (battle.getHero().getMaxMp()*entrySet.getValue().
                                    getCost())+")");
                }    
            } 
        }
        jList1.setListData(abilityList);
    }
    
    /**
     * Changes images and pictures, sets messages, changes background music, 
     * and makes visible the appropriate objects for player defeated
     */
    private void playerDefeated(){
        
        try {
            myTurn(false);
            forfeitLabel.setText("DEFEATED!");
            lowerRoundCard();
            Arena.BGM.stop();
            Arena.BGM.setTrack(0);
            Arena.BGM.play();
            heroImage.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/images/stickLose.png")));
            lobbyButton.setVisible(true);
            victoryLabel.setVisible(false);
            victoryTextLabel.setVisible(false);
            forfeitLabel.setVisible(true); 
        } 
        catch (InterruptedException | UnsupportedAudioFileException | 
                IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Changes images and pictures, sets messages, changes background music, 
     * and makes visible the appropriate objects for player win
     * Checks level up, bet, and take appropriate actions for those conditions
     */
    private void mobDefeated(){
        
        try {
            myTurn(false);
            Thread.sleep(750);
            updateForm();
            lowerRoundCard();
            updateForm();
        } 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }   
    }
    
    /**
     * Retrieves the ability name and value from the Map. Plays the appropriate
     * animation for the ability, displays the value in the appropriate 
     * floating text box, and plays the appropriate sound effect
     * @param abilityResult - the Map containing the ability name and value
     *  value could be damage or health recovered based on ability.
     */
    private void parseAbility(Map<String, Integer> abilityResult){ 
        //retrieve key from the map
        Set<String> tempSet = abilityResult.keySet();
        Object[] tempArray = tempSet.toArray();
        String action = (String)tempArray[0];
        
        if(action.equals(Abilities.DOUBLE_ATTACK.getName())){
            battle.rngAtt(battle.getHero(), battle.getOpp());
            playerOneRngAttAnimation();
        }
        if(action.equals(Abilities.CRITICAL_ATTACK.getName())){
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    CRITICAL_ATTACK.getName()).getSoundFiles());
            playerOnePhyAttAnimation();
            damage = abilityResult.get(Abilities.CRITICAL_ATTACK.getName());
        }
        if(action.equals(Abilities.MAGIC_MISSILE.getName())){
            
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    MAGIC_MISSILE.getName()).getSoundFiles());
            playerOneMagAttAnimation();
            damage = abilityResult.get(Abilities.MAGIC_MISSILE.getName());
        }
        if(action.equals(Abilities.CURE.getName())){
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    CURE.getName()).getSoundFiles());
            heroDamageBoxAnimation(abilityResult.get(Abilities.CURE.
                    getName())+"", Color.GREEN);
        }
        if(action.equals(Abilities.BALANCED_MAGICAL_SHIFT.getName())){
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    BALANCED_MAGICAL_SHIFT.getName()).getSoundFiles());
        }
        if(action.equals(Abilities.BALANCED_PHYSICAL_SHIFT.getName())){
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    BALANCED_PHYSICAL_SHIFT.getName()).getSoundFiles());
        }
        if(action.equals(Abilities.BALANCED_RANGED_SHIFT.getName())){
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    BALANCED_RANGED_SHIFT.getName()).getSoundFiles());
        }
        if(action.equals(Abilities.MAGICAL_SHIFT.getName())){
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    MAGICAL_SHIFT.getName()).getSoundFiles());
        }
        if(action.equals(Abilities.PHYSICAL_SHIFT.getName())){
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    PHYSICAL_SHIFT.getName()).getSoundFiles());
        }
        if(action.equals(Abilities.RANGED_SHIFT.getName())){
            audioPlayer.playEffect(battle.getHero().getAbilites().get(Abilities.
                    RANGED_SHIFT.getName()).getSoundFiles());
        }
        updateForm();
    }
     
   ///////////ANIMATIONS/////////// 
    
    /**
     * The player's physical attack animation, also calls the mobs floating
     * damage box animation
     */
    public void playerOnePhyAttAnimation(){
        
        while(heroImage.getLocation().x > 400){
            heroImage.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/images/stickSword.png")));
            heroImage.repaint();
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException ex) {}
            heroImage.setLocation(heroImage.getLocation().
                    x-5, heroImage.getLocation().y-2);
        }
        heroImage.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/images/SwordStick.png")));
        heroImage.repaint();    
        mobFloatingDamageBoxAnimation(damage+"", Color.RED);
    }
    
    /**
     * The player's magic attack animation, also calls the mobs floating
     * damage box animation
     */
    public void playerOneMagAttAnimation(){
        
        heroImage.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/images/stickMagic.png")));
        projectile.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/images/mageFire.png")));
        projectile.setVisible(true);
        while(projectile.getLocation().x > 150){
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException ex) {
            ex.printStackTrace();
            }
            projectile.setLocation(projectile.getLocation().
                    x-5, projectile.getLocation().y-1);
        }
        projectile.setVisible(false);
        heroImage.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/images/SwordStick.png")));
        mobFloatingDamageBoxAnimation(damage+"", Color.RED);

    }    

    /**
     * The player's ranged attack animation, also calls the mobs floating
     * damage box animation
     */
    public void playerOneRngAttAnimation(){
        
        heroImage.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/images/stickBow.png")));
        heroImage.repaint();
        projectile.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/images/arrow.png")));
        projectile.setVisible(true);
        while(projectile.getLocation().x > 150){
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException ex) {}
            projectile.setLocation(projectile.getLocation().
                    x-5, projectile.getLocation().y-1);
        }
        projectile.setVisible(false);
        heroImage.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/images/SwordStick.png")));
        heroImage.repaint();
        mobFloatingDamageBoxAnimation(damage+"", Color.RED);
    } 
    
    /**
     * Animation that raises the round card at the beginning of each round,
     * also initiates the first turn
     * @throws InterruptedException 
     */
    public void raiseRoundCard() throws InterruptedException{
 
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                myTurn(false);
                roundCard.setText("Round "+battle.getRound());
                endPanel.setVisible(false);
                oppPanel.setVisible(true);
                roundCard.setVisible(true);
                Thread.sleep(2000);
                while(roundCard.getLocation().y > -250){
                    Thread.sleep(10);
                    mob.setLocation(mob.getLocation().x+2, mob.getLocation().y);
                    roundCard.setLocation(roundCard.getLocation().x, roundCard.
                            getLocation().y-2);
                }
                roundCard.setVisible(false);
                stationaryMob.setVisible(true);
                if(battle.isPlayerFirst()){
                    myTurn(true);
                    return null;
                }
                else{
                    myTurn(false);
                    mobTurn();
                    return null;
                }
            }
        };
        worker.execute();
    }
    
    /**
     * Lowers the round card at the end of a round, checks ending condition and
     * makes appropriate objects visible, sets music, distributes loot, checks
     * level up and bet conditions.
     * @throws InterruptedException 
     */
    public void lowerRoundCard() throws InterruptedException{
        
        Thread.sleep(1200);
        downRoundCard.setText("ROUND "+battle.getRound());
        if(!(battle.getHero().yaDead())){
            stationaryMob.setVisible(false);
        }
        downRoundCard.setVisible(true);
        while(downRoundCard.getLocation().y < 0){
            Thread.sleep(20);
            downRoundCard.setLocation(downRoundCard.getLocation().x, 
                    downRoundCard.getLocation().y+2);
        }
        if(battle.getHero().yaDead()){
            continueButton.setVisible(false);
        }
        oppPanel.setVisible(false);
        roundCard.setVisible(true);
        if(!(battle.getHero().yaDead())){
            try {
                Arena.BGM.stop();
            } catch (UnsupportedAudioFileException | IOException | 
                    LineUnavailableException ex) {
                System.out.println("Error 101");
            }
            audioPlayerOne.setTrack(21);
            audioPlayerOne.play();
            Arena.BGM.setTrack(19);
            Arena.BGM.play();
            heroImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stickWin.png")));
            if(battle.drops()){
                audioPlayer.playOnce(20);
                heroDamageBoxAnimation("LEVEL "+battle.getHero().getLevel(), Color.BLACK);
            }
            if(battle.winBet()){
                audioPlayer.playOnce(22);
                heroDamageBoxAnimation("WIN "+battle.payOut()+ " G", Color.yellow);
            }
            Thread.sleep(1000);
            heroDamageBoxAnimation(battle.getOpp().getGoldValue()+" G", Color.YELLOW);
            heroMpBoxAnimation(battle.getOpp().getXpValue()+" XP", Color.ORANGE);
        }
        lobbyButton.setVisible(true);
        forfeitLabel.setVisible(false);
        endPanel.setVisible(true);    
    }   
    
    /**
     * The mobs physical attack animation
     */
    private void mobPhyAnimation(){
        
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                stationaryMob.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource(battle.getOpp().getPhysicalImage())));
                audioPlayer.setTrack(battle.getOpp().getPhysicalSound());
                while(stationaryMob.getLocation().x < 400){
                    try {
                        Thread.sleep(10);
                    } 
                    catch (InterruptedException ex) {}
                    if(stationaryMob.getLocation().x == 200){
                        audioPlayer.playOnce();
                }
                stationaryMob.setLocation(stationaryMob.getLocation().
                        x+5, stationaryMob.getLocation().y);   
                }
                stationaryMob.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource(battle.getOpp().getStaticImage())));
                return null;
            }
        };
        worker.execute();
    }
    
    /**
     * Animation for the hero's damage box
     * @param hp string for any message to be displayed
     * @param color - color of the text to be displayed
     */
    private void heroDamageBoxAnimation(String hp, Color color){
        
        heroFloatingDmgBox.setText(hp+"");
        heroFloatingDmgBox.setForeground(color);
        heroFloatingDmgBox.setVisible(true);
        while(heroFloatingDmgBox.getY()>150){
            try {
                Thread.sleep(20);
            } 
            catch (InterruptedException ex) {}
            heroFloatingDmgBox.setLocation(heroFloatingDmgBox.getX(), 
                    heroFloatingDmgBox.getY()-5);
        }
        heroFloatingDmgBox.setVisible(false);
    }
    
    /**
     * Animation for the hero's floating MP text box
     * @param hp - text to be displayed
     * @param color - color of the displayed text
     */
    private void heroMpBoxAnimation(String hp, Color color){

        heroMpFloatingBx.setText(hp+"");
        heroMpFloatingBx.setForeground(color);
        heroMpFloatingBx.setVisible(true);
        while(heroMpFloatingBx.getY()>90){
            try {
                Thread.sleep(20);
            } 
            catch (InterruptedException ex) {}
            heroMpFloatingBx.setLocation(heroMpFloatingBx.getX(), 
                    heroMpFloatingBx.getY()-5);
        }
        heroMpFloatingBx.setVisible(false);
    }
    
    /**
     * Animation for the floating mob damage box
     * @param hp - the text to be displayed
     * @param color - the color of the text to be displayed
     */
    private void mobFloatingDamageBoxAnimation(String hp, Color color){

        mobFloatingDamageBox.setText(hp);
        mobFloatingDamageBox.setForeground(color);
        mobFloatingDamageBox.setVisible(true);
        while(mobFloatingDamageBox.getY()>30){
            try {
                Thread.sleep(20);
            } 
            catch (InterruptedException ex) {}
            mobFloatingDamageBox.setLocation(mobFloatingDamageBox.getX(), 
                    mobFloatingDamageBox.getY()-5);
        }
        mobFloatingDamageBox.setVisible(false);
    }
    
    /**
     * Mob ranged attack animation
     */
    public void mobRngAttAnimation(){
        
        stationaryMob.setIcon(new javax.swing.ImageIcon(getClass().
                getResource(battle.getOpp().getRangedImage())));
        mobProjectile.setIcon(new javax.swing.ImageIcon(getClass().
                getResource(battle.getOpp().getRangedProjectileImage())));
        mobProjectile.setVisible(true);
        audioPlayer.setTrack(battle.getOpp().getRangedSound());
        audioPlayer.playOnce();
        while(mobProjectile.getLocation().x < 750){
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException ex) {}
            mobProjectile.setLocation(mobProjectile.getLocation().x+5, 
                    mobProjectile.getLocation().y+1);
        }
        mobProjectile.setVisible(false);
        stationaryMob.setIcon(new javax.swing.ImageIcon(getClass().
                getResource(battle.getOpp().getStaticImage())));
    }
    
    /**
     * Mob Physical Attack Animation
     */
    public void mobMagAttAnimation(){

        stationaryMob.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource(battle.getOpp().getMagicalImage())));
        mobProjectile.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource(battle.getOpp().getMagicalProjectileImage())));
        mobProjectile.setVisible(true);
        audioPlayer.setTrack(battle.getOpp().getMagicalSound());
        audioPlayer.playOnce();
        while(mobProjectile.getLocation().x < 750){
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException ex) {}
            mobProjectile.setLocation(mobProjectile.getLocation()
                    .x+5, mobProjectile.getLocation().y+1);
        }
        mobProjectile.setVisible(false);
        stationaryMob.setIcon(new javax.swing.ImageIcon(getClass()
                .getResource(battle.getOpp().getStaticImage())));
    }
}
