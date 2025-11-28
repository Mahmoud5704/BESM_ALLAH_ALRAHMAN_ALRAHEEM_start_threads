package verify;

import interfaces.*;
import java.util.List;
import java.util.ArrayList;

public class Col_verify implements dublicates, check {

    int col;
    int[][] board;
    print p;

    public Col_verify(int[][] board, int col, print p) {
        this.col = col;
        this.board = board;
        this.p = p;
    }

    public List<Integer> find_dub(int[] col, int x) {
        List<Integer> ind = new ArrayList<>();
        for (int j = 0; j < col.length; j++) {
            if (col[j] == x) {
                ind.add(j);
            }
        }
        return ind;
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
                System.out.println(s);
                p.setcol_toprint(s);
                ok = false;
            }
        }
        return ok;
    }

}
