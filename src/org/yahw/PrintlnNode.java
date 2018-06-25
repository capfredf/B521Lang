package org.yahw;


public class PrintlnNode extends B521LangNode {
    private B521LangNode arg;

    public PrintlnNode(B521LangNode arg) {
        this.arg = arg;
    }

    @Override
    public Object eval(Env e) {
        Object val = this.arg.eval(e);
        System.out.println(val.toString());
        return null;
    }
}
