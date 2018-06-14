package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class VarNode extends B521LangNode {
    String var;
    int idx;
    public VarNode (String var) {
        this.var = var;
        this.idx = 0;
    }

    public String getVar() {
        return var;
    }

    @Override
    public Value execute(VirtualFrame frame) {
        return (Value) frame.getArguments()[this.idx+1];
//        return e.lookUp(var);
    }
}
