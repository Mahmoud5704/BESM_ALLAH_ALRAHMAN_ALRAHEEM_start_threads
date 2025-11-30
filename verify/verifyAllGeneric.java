/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package verify;
import interface_abstract.check;
import interface_abstract.dublicates;
/**
 *
 * @author zeyad
 */
public class verifyAllGeneric<T extends dublicates & check> implements check{
    private int[][] board;
    private T verifier;
    public verifyAllGeneric(int[][] board, T verifier){
        this.board = board;
        this.verifier = verifier;
    }

    @Override
    public boolean checker() {
        boolean ok = true;
        for(int i = 0; i < 9; i++){
            verifier.setIndex(i);
            if(!verifier.checker()){
                ok = false;
            }
        }
        return ok;
    }
}
