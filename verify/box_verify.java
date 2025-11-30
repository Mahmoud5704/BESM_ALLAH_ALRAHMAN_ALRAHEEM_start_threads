package verify;

import interface_abstract.check;
import interface_abstract.dublicates;
import java.util.List;
import java.util.ArrayList;

public class box_verify extends dublicates implements  check {

    int box;
    int[][] board;

    public box_verify(int[][] board, int box){
        this.box = box;
        this.board = board;
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
                print.get_instance().setbox_toprint(s);
            }
        }

        return ok;
    }
}
