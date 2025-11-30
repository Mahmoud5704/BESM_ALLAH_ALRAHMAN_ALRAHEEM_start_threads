package verify;

import java.util.ArrayList;

public class print {

    private ArrayList<String> rrr = new ArrayList<>();
    private ArrayList<String> ccc = new ArrayList<>();
    private ArrayList<String> bbb = new ArrayList<>();
    private static print instance = null;

    public synchronized static print get_instance() {
        if (instance == null) {
            instance = new print();
        }
        return instance;
    }

    public synchronized void setrow_toprint(String s) {
        rrr.add(s);
    }

    public synchronized void setcol_toprint(String s) {
        ccc.add(s);
    }

    public synchronized void setbox_toprint(String s) {
        bbb.add(s);
    }

    public void printResults() {
        System.out.println("Rows:");
        for (String s : rrr) {
            System.out.println(s);
        }
        System.out.println("***************************************************************");
        System.out.println("Columns:");
        for (String s : ccc) {
            System.out.println(s);
        }
        System.out.println("***************************************************************");

        System.out.println("Boxes:");
        for (String s : bbb) {
            System.out.println(s);
        }
        System.out.println("***************************************************************");
    }
}
