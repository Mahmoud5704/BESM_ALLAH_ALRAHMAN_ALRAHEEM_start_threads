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
public class verifyAllRows implements check{
    private int[][] board;
    private print printer;
    private boolean isValid = true;
    public verifyAllRows(int[][] board){
        this.board = board;
        this.printer = new print();
    }
    @Override
    public boolean checker() {
        Row_verify rowVerifier;
        for(int i = 0; i < 9; i++){
            rowVerifier = new Row_verify(board, i, printer);
            if(!rowVerifier.checker())
                isValid = false;
        }
        return isValid;
    }
}
