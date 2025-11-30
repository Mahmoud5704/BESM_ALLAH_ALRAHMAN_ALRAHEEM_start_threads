
package modes;

import besmallah.CheckerThread;
import verify.Col_verify;
import verify.verifyAllBoxes;
import verify.verifyAllColumns;
import verify.verifyAllRows;
public class Mode3 {
    private int[][] board;
    public Mode3(int[][] board){
        this.board = board;
    }
    public void verify(){
        verifyAllColumns columnVerifier = new verifyAllColumns(board);
        verifyAllRows rowVerifier = new verifyAllRows(board);
        verifyAllBoxes boxVerifier = new verifyAllBoxes(board);
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
            System.getLogger(Mode3.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
}
