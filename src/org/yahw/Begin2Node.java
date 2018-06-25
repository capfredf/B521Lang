package org.yahw;

public class Begin2Node extends B521LangNode {
    private B521LangNode fst, snd;
    public Begin2Node(B521LangNode fst, B521LangNode snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public Object eval(Env e) {
        this.fst.eval(e);
        return this.snd.eval(e);
    }
}
