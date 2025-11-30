/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package verify;

import interface_abstract.check;

/**
 *
 * @author zeyad
 */
public class verifyAllBoxes implements check{
    private int[][] board;
    private print printer;
    private boolean isValid = true;
    public verifyAllBoxes(int[][] board){
        this.board = board;
        this.printer = new print();
    }
    @Override
    public boolean checker() {
        box_verify boxVerifier;
        for(int i = 0; i < 9; i++){
            boxVerifier = new box_verify(board, i, printer);
            if(!boxVerifier.checker())
                isValid = false;
        }
        return isValid;
    }
    
}
