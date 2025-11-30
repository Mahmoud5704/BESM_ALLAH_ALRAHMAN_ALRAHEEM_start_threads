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
public class verifyAllColumns implements check{
    private int[][] board;
    private print printer;
    public verifyAllColumns(int[][] board){
        this.board = board;
        this.printer = new print();
    }
    @Override
    public boolean checker() {
    }
    
}
