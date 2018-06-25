package org.yahw;

public class MinusNode extends B521LangNode {
    private B521LangNode left, right;

    public MinusNode(B521LangNode x, B521LangNode y) {
        left = x;
        right = y;
    }

    @Override
    public Object eval(Env e) {
        int r1 = (int) left.eval(e);
        int r2 = (int) right.eval(e);
        return r1 - r2;
    }

}
