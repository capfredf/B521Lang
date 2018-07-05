package org.yahw;

public class DefineNode extends B521LangNode {
    private VarNode symbol;
    private B521LangNode valueNode;

    public DefineNode(VarNode symbol, B521LangNode valueNode) {
        this.symbol = symbol;
        this.valueNode = valueNode;
    }

    public Env extendEnv(Env e) {
        return e.extend(this.symbol.getVar(), this.valueNode.eval(e));
    }

    @Override
    public Object eval(Env e) {
        return null;
    }
}
