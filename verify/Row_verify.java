package verify;

import interfaces.*;
import java.util.List;
import java.util.ArrayList;
import modes.mod_27;

public class Row_verify implements dublicates, check {

    int row;
    int[][] board;
    print p;

    public Row_verify(int[][] board, int row, print p) {
        this.row = row;
        this.board = board;
        this.p = p;
    }

    public List<Integer> find_dub(int[] row, int x) {
        List<Integer> ind = new ArrayList<>();
        for (int j = 0; j < row.length; j++) {
            if (row[j] == x) {
                ind.add(j);
            }
        }
        return ind;
    }

    public boolean checker() {
        int[] r = board[row];
        boolean ok = true;
        for (int x = 1; x <= 9; x++) {
            List<Integer> dups = find_dub(r, x);
            if (dups.size() > 1) {
                String s = "Duplicates of " + x + " in ROW " + row + " at cols: " + dups;
              //  System.out.println(s);
                p.setrow_toprint(s);
                ok = false;
            }
        }
        return ok;
    }

}
