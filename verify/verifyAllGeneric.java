
package verify;
import interface_abstract.check;

public class verifyAllGeneric<T extends check> implements check{
    private int[][] board;
    private T verifier;
    public verifyAllGeneric(int[][] board, T verifier){
        this.board = board;
        this.verifier = verifier;
    }

    @Override
    public boolean checker(int index) {
        boolean ok = true;
        for(int i = 0; i < 9; i++){
            if(!verifier.checker(i)){
                ok = false;
            }
        }
        return ok;
    }
}
