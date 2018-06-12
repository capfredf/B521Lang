package org.yahw;

public class VarNode extends Node {
    String var;
    public VarNode (String initVar) {
        var = initVar;
    }

    public String getVar() {
        return var;
    }

    @Override
    public Value eval(Env e) {
        return e.lookUp(var);
    }
}
