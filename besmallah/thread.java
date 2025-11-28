package besmallah;
import interfaces.check;


public class thread implements Runnable{

    boolean y;
    check c ;
    public thread(check c) {
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
