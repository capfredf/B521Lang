package org.yahw;

public class LetNode extends B521LangNode {
    private B521LangNode valueNode;
    private B521LangNode bodyNode;
    private String sym;

    public LetNode(String sym, B521LangNode valueNode, B521LangNode bodyNode) {
        this.sym = sym;
        this.valueNode = valueNode;
        this.bodyNode = bodyNode;
    }
    @Override
    public Object eval(Env e) {
        Env new_e = e.extend(sym, this.valueNode.eval(e));
        return this.bodyNode.eval(new_e);
    }

}
