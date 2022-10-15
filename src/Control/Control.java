/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Model;

/**
 *
 * @author pwn233
 */
public class Control {
    private String guessInput;
    Model m = new Model();
    private String status = "";
    public void start(String x) {
        this.guessInput = x;
    }
    public void checkGuess(){
        m.checkParent(guessInput);
    }
    public void generateParent() {
        m.generateParent();
    }
    public String returnStatus() {
       status = m.checkWin();
       return status;
    }
    public void roundUpdate() {
       m.round();
    }
    public String roundCheck() {
        return m.roundCheck();
    }
    public int getRoundCount() {
        return m.getRoundCount();
    }

    public void resetParent() {
        m.generateParent();
        m.resetRound();
    }
}
