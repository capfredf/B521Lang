package org.yahw;

public class PredNode extends B521LangNode {
    B521LangNode node;
    public PredNode(B521LangNode node) {
        this.node = node;
    }

    @Override
    public Value eval(Env e) {
        Value result = this.node.eval(e);
        if (result instanceof IntValue) {
            int val = ((IntValue) result).getVal();
            if (val == 0) {
                return ((IntValue) result);
            } else {
                return new IntValue(val - 1);
            }
        }
        return null;
    }
}
