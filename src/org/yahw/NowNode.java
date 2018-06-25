package org.yahw;

public class NowNode extends B521LangNode {

    @Override
    public Object eval(Env e) {
        return (int) System.currentTimeMillis();
    }
}
