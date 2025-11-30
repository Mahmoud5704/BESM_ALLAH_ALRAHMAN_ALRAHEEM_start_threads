package besmallah;

import modes.mod_27;
import csv_files.CSVReader;
import modes.Mode3;

public class Besmallah {


    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("incorrect arguements!\nthe program accepts 2 arguments: csv file path, mode");
            return;
        }
        int mode;
        try{
            mode = Integer.parseInt(args[1]);
        }
        catch(NumberFormatException e){
            System.out.println("mode must be 0, 3 or 27!");
            return;
        }
        CSVReader reader = new CSVReader(args[0]);
        int[][] board = reader.read();
        if(board == null){
            System.out.println("error reading file");
            return;
        }
        switch(mode){
            case 0:
                System.out.println("not done yet");
            case 3:
                Mode3 m3 = new Mode3(board);
                m3.verify();
            case 27:
                mod_27 m27 = new mod_27(board);
                m27.verify();
        }
    }
}
