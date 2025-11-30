package besmallah;
import interface_abstract.check;


public class CheckerThread implements Runnable{

    boolean y;
    check c ;
    public CheckerThread(check c) {
        this.c=c;
    }

    @Override
    public void run() {
        y = c.checker();
    }
    
    public boolean get_result() {
        return y;
    }
}
