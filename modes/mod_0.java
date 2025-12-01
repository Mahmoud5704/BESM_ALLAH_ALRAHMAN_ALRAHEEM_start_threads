package modes;

import java.util.ArrayList;
import java.util.List;
import verify.Col_verify;
import verify.Row_verify;
import verify.box_verify;
import verify.print;

public class mod_0 {

    int[][] board;

    public mod_0(int[][] board) {
        this.board = board;
    }

    public void verify() {
        List<Boolean> results = new ArrayList<>();
        Row_verify rr = new Row_verify(board);
        Col_verify cc = new Col_verify(board);
        box_verify bb = new box_verify(board);
        for (int i = 0; i < 9; i++) {
            results.add(rr.checker(i));
            results.add(cc.checker(i));
            results.add(bb.checker(i));
        }

        boolean ok = true;
        for (boolean b : results) {
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
