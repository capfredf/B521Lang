package org.yahw;

public class PredNode extends B521LangNode {
    B521LangNode node;
    public PredNode(B521LangNode node) {
        this.node = node;
    }

    @Override
    public Object eval(Env e) {
        int val = (int) this.node.eval(e);
        if (val == 0) {
            return val;
        } else {
            return val - 1;
        }
    }
}
