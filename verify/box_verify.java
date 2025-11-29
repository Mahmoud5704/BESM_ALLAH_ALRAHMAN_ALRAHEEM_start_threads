package verify;

import interfaces.*;
import java.util.List;
import java.util.ArrayList;

public class box_verify implements dublicates, check {

    int box;
    int[][] board;
    print p;

    public box_verify(int[][] board, int box,print p) {
        this.box = box;
        this.board = board;
        this.p=p;
    }

    public List<Integer> find_dub(int[] box, int x) {
        List<Integer> ind = new ArrayList<>();
        for (int j = 0; j < box.length; j++) {
            if (box[j] == x) {
                ind.add(j);
            }
        }
        return ind;
    }

    public boolean checker() {
        int startRow = (box / 3) * 3;
        int startCol = (box % 3) * 3;
        boolean ok = true;

        for (int x = 1; x <= 9; x++) {
            List<String> positions = new ArrayList<>();
            int count = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[startRow + i][startCol + j] == x) {
                        positions.add("(" + (startRow + i) + "," + (startCol + j) + ")");
                        count++;
                    }
                }
            }

            if (count > 1) {
                ok = false;
                String s = "Duplicates of " + x + " in BOX " + box + " at positions: " + positions;
              //  System.out.println(s);
                p.setbox_toprint(s);
            }
        }

        return ok;
    }
}
