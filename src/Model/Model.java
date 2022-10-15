/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author pwn233
 */
public class Model {
    protected char[] parent = new char[6];
    private char[] colorList = {'R', 'G','Y','B', 'P', 'O'};
    private char[] gi = new char[6];
    private String dummy = "";
    private int roundCount = 1;

    public void generateParent(){
        Random rd = new Random();
        for(int i=0; i < 6; i++) {
           parent[i] = colorList[rd.nextInt(6)];
           System.out.print(parent[i]);
        }
        System.out.println("\nGenerate Parent Complete");
    }
    public char[] getParrent() {
        return parent;
    }    
    public void checkParent(String guessInput) {
        //take input
        dummy = "";
        for(int i = 0; i < gi.length; i ++) {
            gi[i] = guessInput.charAt(i);
        }
        //check
        boolean checkVal = false;
        for(int i = 0; i < guessInput.length(); i++ ) {
            if(gi[i] == parent[i]) {
                dummy  += "B";
                checkVal = true;
            } else {
                for(int j = i+1; j < 6; j++) {
                    if(gi[i] == parent[j]) {
                        dummy += "W";
                        checkVal = true;
                    }   
                }
                if(checkVal == false) {
                    dummy += "-";
                }
            }
        }
    }
    public String checkWin() {
        String status = "";
        if(dummy.equals("BBBBBB")) {
            status = "You win! : "+dummy+" "+roundCheck();
            generateParent();
            resetRound();
        } 
        else {
            status = "Not yet, but this might help : "+dummy+" and "+roundCheck();
        }
        return status;
    }

    public void round() {
        roundCount++;
    }
    public void resetRound() {
        roundCount = 0;
    }
    public String roundCheck() {
        if(roundCount == 9) {
          return "Game Over!, out of rounds to play.\nColors and rounds has been reseted.";
        } else
        return "Played "+roundCount+"/8.";   
    }
    public int getRoundCount() {
        return roundCount;
    }
}
