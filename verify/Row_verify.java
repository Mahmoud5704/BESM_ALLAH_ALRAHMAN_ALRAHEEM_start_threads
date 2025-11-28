package verify;
import interfaces.*;
import java.util.List;
import java.util.ArrayList;

public class Row_verify implements dublicates,check  {

    int row;
    int[][] board;
   
    public Row_verify(int[][] board,int row) {
        this.row = row;
        this.board=board;
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
                System.out.println("Duplicates of " + x + " in ROW " + row + " at cols: " + dups);
                //rrr.
                ok = false;
            }
        }
        return ok;
    }

}
