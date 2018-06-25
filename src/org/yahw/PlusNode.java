package org.yahw;

public class PlusNode extends B521LangNode {
    private B521LangNode oprand1, oprand2;
    public PlusNode(B521LangNode x, B521LangNode y) {
        oprand1 = x;
        oprand2 = y;
    }
    @Override
    public Object eval(Env e) {
        int r1 = (int) oprand1.eval(e);
        int r2 = (int) oprand2.eval(e);
        return r1 + r2;
    }
}
