package org.yahw;


public class LessThanEqual extends B521LangNode {
    private B521LangNode left, right;

    public LessThanEqual(B521LangNode left, B521LangNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object eval(Env e) {
        int l = (int)this.left.eval(e);
        int r = (int)this.right.eval(e);
        return l <= r;
    }
}
