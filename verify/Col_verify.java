package verify;

import interface_abstract.check;
import interface_abstract.dublicates;
import java.util.List;

public class Col_verify extends dublicates implements check {

    int col;
    int[][] board;
   

    public Col_verify(int[][] board, int col) {
        this.col = col;
        this.board = board;
        
    }

    public boolean checker() {
        int[] c = new int[9];
        for (int i = 0; i < 9; i++) {
            c[i] = board[i][col];
        }
        boolean ok = true;
        for (int x = 1; x <= 9; x++) {
            List<Integer> dups = find_dub(c, x);
            if (dups.size() > 1) {
                String s = "Duplicates of " + x + " in col " + col + " at rows: " + dups;
               // System.out.println(s);
                print.get_instance().setcol_toprint(s);
                ok = false;
            }
        }
        return ok;
    }

}
