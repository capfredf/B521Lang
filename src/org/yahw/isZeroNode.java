package org.yahw;

public class isZeroNode extends B521LangNode {
    private B521LangNode rand;

    public isZeroNode(B521LangNode rand) {
        this.rand = rand;
    }

    @Override
    public Object eval(Env env) {
        int val = (int) this.rand.eval(env);
        if (val == 0) {
            return true;
        } else {
            return false;
        }
    }
}
