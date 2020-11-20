/*
 * A class that holds all the sounds for the application
 */
package collections;

/**
 * @author Scott Underwood
 * @author Shawn Ferdig
 */
public enum SoundTracks {
    
    TRACK_ZERO(0, "Start Theme", "/music/TitleScreen.wav"),
    TRACK_ONE(1, "Crisp Click", "/soundEffects/crispClick.wav"),
    TRACK_TWO(2, "Chunky Click", "/soundEffects/chunkClick.wav"),
    TRACK_THREE(3, "Inn Music", "/music/Medley1.wav"),
    TRACK_FOUR(4, "Gulping", "/soundEffects/glups.wav"),
    TRACK_FIVE(5, "Healing Chime", "/soundEffects/levelup.wav"),
    TRACK_SIX(6, "Healing Power-Up", "/soundEffects/RocketPowerup.wav"),
    TRACK_SEVEN(7, "Crowed Noise", "/soundEffects/crowdNoise.wav"),
    TRACK_EIGHT(8, "Pysical Shift", "/soundEffects/Swoosh1.wav"),
    TRACK_NINE(9, "Critical Attack","/soundEffects/crit.wav"),
    TRACK_TEN(10, "Battle Music", "/music/epic-battle.wav"),
    TRACK_ELEVEN(11, "Training Jams", "/music/trainingTune.wav"),
    TRACK_TWELVE(12, "Hero Pyisical", "/soundEffects/heroPhysical.wav"),
    TRACK_THIRTEEN(13, "Hero Magical", "/soundEffects/heroMagical.wav"),
    TRACK_FOURTEEN(14, "Hero Ranged", "/soundEffects/heroRanged.wav"),
    TRACK_FIFTEEN(15, "Magic Missle", "/soundEffects/magicMissle.wav"),
    TRACK_SIXTEEN(16,"Failed Abiltiy", "/soundEffects/failedAbility.wav"),
    TRACK_SEVENTEEn(17, "BlackSmith Ambient", "/soundEffects/Blacksmith.wav"),
    TRACK_EIGHTEEN(18,"Brook Ambient", "/soundEffects/brook.wav"),
    TRACK_NINETEEN(19,"Winning", "/soundEffects/youWin.wav"),
    TRACK_TWENTY(20, "Level Up", "/soundEffects/actualLvlUP.wav"),
    TRACK_TWENTYONE(21, "Cheering Crowd", "/soundEffects/crowdCheering.wav"),
    TRACK_TWENTYTWO(22, "Coin Payout", "/soundEffects/poorPayout.wav"),
    TRACK_TWENTYTHREE(23, "Coin Drop", "/soundEffects/coin.wav"),
    TRACK_TWENTYFOUR(24, "Coin Bag Drop", "/soundEffects/coinBag.wav"),
    TRACK_TWENTYFIVE(25, "Buying Potion", "/soundEffects/potionBottle.wav"),
    TRACK_TWENTYSIX(26, "Cleaing Throat", "/soundEffects/throat.wav"),
    TRACK_TWENTYSEVEN(27, "Dream Harp", "/music/dreamHarp.wav"),
    TRACK_TWENTYEIGHT(28, "Fire", "/soundEffects/firePlace.wav"),
    TRACK_TWENTYNINE(29, "Ambient Inn Sounds", "/soundEffects/innAmbient.wav"),
    TRACK_THIRTY(30, "Learning Ability", "/soundEffects/bookclose.wav"),
    TRACK_THIRTYONE(31, "Gain Attribute", "/soundEffects/gong.wav"),
    TRACK_THIRTYTWO(32, "Open Parchment", "/soundEffects/pageTurn.wav");
    
    private final int number;
    private final String description;
    private final String filePath;
    
    private SoundTracks(int number, String description, String filePath){
        
        this.number = number;
        this.description = description;
        this.filePath = filePath;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public String getDescription() {
        return this.description;
    }

    public String getFilePath() {
        return this.filePath;
    }
}
