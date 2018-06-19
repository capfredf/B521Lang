package org.yahw;

public class isZeroNode extends B521LangNode {
    private B521LangNode rand;

    public isZeroNode(B521LangNode rand) {
        this.rand = rand;
    }

    @Override
    public Value eval(Env env) {
        Value result = this.rand.eval(env);
        if (result instanceof IntValue) {
            int val = ((IntValue) result).getVal();
            if (val == 0) {
                return new BoolValue(true);
            } else {
                return new BoolValue(false);
            }
        }
        return null;
    }
}
