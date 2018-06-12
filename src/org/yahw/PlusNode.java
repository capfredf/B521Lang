package org.yahw;

public class PlusNode extends Node {
    private Node oprand1, oprand2;
    public PlusNode(Node x, Node y) {
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
