package org.yahw;

public class PlusNode extends B521LangNode {
    private B521LangNode oprand1, oprand2;
    public PlusNode(B521LangNode x, B521LangNode y) {
        oprand1 = x;
        oprand2 = y;
    }
    @Override
    public Value eval(Env e) {
        IntValue r1 = (IntValue) oprand1.eval(e);
        IntValue r2 = (IntValue) oprand2.eval(e);
        return new IntValue(r1.getVal()+r2.getVal());
    }
}
