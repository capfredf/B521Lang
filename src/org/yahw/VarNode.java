package org.yahw;

public class VarNode extends B521LangNode {
    String var;
    public VarNode (String initVar) {
        var = initVar;
    }

    public String getVar() {
        return var;
    }

    @Override
    public Object eval(Env e) {
        return e.lookUp(var);
    }
}
