package modes;

import besmallah.CheckerThread;
import java.util.ArrayList;
import java.util.List;
import verify.Col_verify;
import verify.Row_verify;
import verify.box_verify;
import verify.print;

public class mod_27 {

    int[][] board;

    public mod_27(int[][] board) {
        this.board = board;
    }

    public void verify() {
        // print p=new print();
        List<Boolean> results = new ArrayList<>();
        List<CheckerThread> threads = new ArrayList<>();
        List<Thread> realthreads = new ArrayList<>();
        Row_verify rr = new Row_verify(board);
        Col_verify cc = new Col_verify(board);
        box_verify bb = new box_verify(board);
        for (int i = 0; i < 9; i++) {

            //for rows
            CheckerThread thr = new CheckerThread(rr,i);
            Thread tr = new Thread(thr);//real CheckerThread row bgd
            threads.add(thr);
            realthreads.add(tr);
            tr.start();

            // for cols
            CheckerThread thc = new CheckerThread(cc,i);
            Thread tc = new Thread(thc);//real CheckerThread col bgd
            threads.add(thc);
            realthreads.add(tc);
            tc.start();

            //for b
            CheckerThread thb = new CheckerThread(bb,i);
            Thread tb = new Thread(thb);//real CheckerThread box bgd
            threads.add(thb);
            realthreads.add(tb);
            tb.start();

        }

        for (Thread t : realthreads) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                 System.out.println("Thread interrupted!");
            }
        }

        for (int i = 0; i < threads.size(); i++) {
            results.add(threads.get(i).get_result());
        }
        boolean ok = true;

        for (Boolean b : results) {
            ok &= b;
        }

        if (ok) {
            System.out.println("***************************************************************");
            System.out.println("VALID");
            System.out.println("***************************************************************");

        } else {
            System.out.println("***************************************************************");
            System.out.println("INVALID");
            System.out.println("***************************************************************");
            print.get_instance().printResults();
        }

    }

}
