package online;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import arena3.Arena;
import classes.Player;


public class ArenaClient implements Runnable{
	
	private final static int  DEST_PORT = 5938;                             
	private final static String SERVER_NAME = "toolman.wiu.edu";            
        private InetAddress dstIP;
        private Socket clientSocket;
        private PrintWriter out;
        private Scanner in;
        private  Player hero = null;
        private  Player opp = null;

    public ArenaClient(){
        hero = Arena.CUR_PLAYER;
        opp = new Player();     
    }
    
//Get Methods ==================================================================
    
    /**
    * Gets the opponent player
    * @return opponent player
    */
    public Player getOpp(){return opp;}
    
    /**
    * Gets the current player
    * @return current player
    */   
    public Player getHero(){return hero;}
    
    
//Utility Methods ==============================================================
    
    /**
    * Connects to the server and sends player attributes
    */  
    @Override
    public void run(){
        
        try{
            dstIP = InetAddress.getByName(SERVER_NAME);                         	
            clientSocket = new Socket(dstIP, DEST_PORT);                        
            out = new PrintWriter(clientSocket.getOutputStream(), true);        
            in = new Scanner(clientSocket.getInputStream());                    
            
            out.println(hero.getName()+":"+hero.getRole()+":"+hero.getLevel()
                    +":"+hero.getCurHp()+":"+hero.getMaxHp()+":"+hero.getStr()+
                    ":"+hero.getMag()+":"+hero.getDex()+":");
        }     
        catch (Exception e){e.printStackTrace();}
        
    }
    /**
    * Sends a message to the receiver. 
    * @param x message with a AOP header
    */
    public void send(String x){out.println(x);}
    
    /**
    * Retrieves a message from the server. 
    * @return message with a AOP header
    */
    public String recieve(){
        String request = in.nextLine();
        return request;
    }
    
    /**
    * Parses server request and carries out appropriate actions based on the 
    * AOP header
    * @param x message from the server with a AOP header
    * @return not sure about his yet
    */
    public String procPack(String x){
        String request;                                                         
        String[] cmd;                                                              
        request = x;                                                            
        cmd = request.split(":");
        System.out.println(request);
        //process server output
        switch(cmd[0]){                                                                  
            case "oce":                                                                                                                    
                opp.setName(cmd[1]);
                opp.setRole(cmd[2]);
                opp.setLevel(Integer.parseInt(cmd[3]));
                opp.setCurHp(Integer.parseInt(cmd[4]));
                opp.setMaxHp(Integer.parseInt(cmd[5]));
                opp.setStr(Integer.parseInt(cmd[6]));
                opp.setMag(Integer.parseInt(cmd[7]));
                opp.setDex(Integer.parseInt(cmd[8]));
                return cmd[0];
            case "uhp":                                                         
                System.out.println(Arena.CUR_PLAYER.getName()+
                        " recieved uhp");
                hero.setCurHp(Integer.parseInt(cmd[1]));
                opp.setStr(Integer.parseInt(cmd[2]));
                opp.setMag(Integer.parseInt(cmd[3]));
                opp.setDex(Integer.parseInt(cmd[4]));
                return "uhp";
            case "dhp":                                                         
                System.out.println(Arena.CUR_PLAYER.getName()+
                        " recieved dhp");
                hero.setCurHp(Integer.parseInt(cmd[1]));
                opp.setStr(Integer.parseInt(cmd[2]));
                opp.setMag(Integer.parseInt(cmd[3]));
                opp.setDex(Integer.parseInt(cmd[4]));
                return "dhp";
            case "uhs":                                                         
                opp.setCurHp(Integer.parseInt(cmd[1]));
                hero.setStr(Integer.parseInt(cmd[2]));
                hero.setMag(Integer.parseInt(cmd[3]));
                hero.setDex(Integer.parseInt(cmd[4]));
                System.out.println(Arena.CUR_PLAYER.getName()+
                        " recieved uhs");
                return "uhs";
            case "vhs":                                                         
                opp.setCurHp(Integer.parseInt(cmd[1]));
                hero.setStr(Integer.parseInt(cmd[2]));
                hero.setMag(Integer.parseInt(cmd[3]));
                hero.setDex(Integer.parseInt(cmd[4]));
                System.out.println(Arena.CUR_PLAYER.getName()+
                        " recieved vhs");
                return "vhs";
            case "stt":                                                        
                return "stt";
            case "oqt":
                return "oqt";                                                   
        }
        return "Defult return for procPack";
    }
    /**
    * closes socket 
    */
    public void closeSocket(){
            try {
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}


 