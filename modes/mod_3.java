/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modes;
   
import besmallah.CheckerThread;
import verify.Col_verify;
import verify.Row_verify;
import verify.box_verify;
import verify.print;
import verify.verifyAllGeneric;
public class mod_3 {
    private int[][] board;
    public mod_3(int[][] board){
        this.board = board;
    }
    public void verify(){
        verifyAllGeneric columnVerifier = new verifyAllGeneric(board, new Col_verify(board, 0));
        verifyAllGeneric rowVerifier = new verifyAllGeneric(board, new Row_verify(board, 0));
        verifyAllGeneric boxVerifier = new verifyAllGeneric(board, new box_verify(board, 0));
        CheckerThread checker1 = new CheckerThread(columnVerifier);
        Thread thread1 = new Thread(checker1);
        CheckerThread checker2 = new CheckerThread(rowVerifier);
        Thread thread2 = new Thread(checker2);
        CheckerThread checker3 = new CheckerThread(boxVerifier);
        Thread thread3 = new Thread(checker3);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException ex) {
            System.getLogger(mod_3.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        if(!checker1.get_result() || !checker2.get_result() || !checker3.get_result())
            print.get_instance().printResults();
        else
            System.out.println("VALID");
        
    }
}