package besmallah;

import csv_files.CSVReader;
import modes.mod_0;
import modes.mod_27;
import modes.mod_3;

public class Besmallah {

    public static void main(String[] args) {
       
       /* int[][] board = {
            {5, 5, 4, 6, 7, 8, 9, 1, 2},
            {6, 6, 6, 6, 6, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {3, 3, 3, 4, 1, 9, 6, 3, 5},
            {3, 4, 3, 4, 4, 4, 3, 3, 9}
        };*/
        
      if (args.length != 2) {
            System.out.println("incorrect arguements!\nthe program accepts 2 arguments: csv file path, mode");
            return;
        }
        int mode;
        try {
            mode = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("mode must be integer number!");
            return;
        }
        if (mode != 0 && mode != 3 && mode != 27) {
            System.out.println("mode must be 0, 3 or 27!");
            return;
        }
        CSVReader reader = new CSVReader(args[0]);
        int[][] board = reader.read();
        if (board == null) {
            System.out.println("error reading file");
            return;
        }
        switch (mode) {
            case 0:
                 mod_0 m0 = new mod_0(board);
                 m0.verify();
                break;
            case 3:
                mod_3 m3 = new mod_3(board);
                m3.verify();
                break;
            case 27:
                mod_27 m27 = new mod_27(board);
                m27.verify();
                break;
        }
       
    }
}
