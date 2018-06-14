package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class VarNode extends B521LangNode {
    String var;
    public VarNode (String initVar) {
        var = initVar;
    }

    public String getVar() {
        return var;
    }

    @Override
    public Value execute(VirtualFrame frame) {
        return null;
//        return e.lookUp(var);
    }
}
