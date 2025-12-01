package verify;

import interface_abstract.check;
import interface_abstract.dublicates;
import java.util.List;
import java.util.ArrayList;
 
public class Row_verify extends dublicates implements  check {


    public Row_verify(int[][] board) {
        this.board = board;
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

    public boolean checker(int index) {
        int[] r = board[index];
        boolean ok = true;
        for (int x = 1; x <= 9; x++) {
            List<Integer> dups = find_dub(r, x);
            if (dups.size() > 1) {
                String s = "Duplicates of " + x + " in ROW " + index + " at cols: " + dups;
              //  System.out.println(s);
                print.get_instance().setrow_toprint(s);
                ok = false;
            }
        }
        return ok;
    }

}
