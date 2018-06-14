package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class LambdaNode extends B521LangNode{
    VarNode var;
    B521LangNode body;
    public LambdaNode (String initVar, B521LangNode initBody) {
        var = new VarNode(initVar);
        body = initBody;
    }


    @Override
    public Value execute(VirtualFrame frame) {
        return null;
//        return new ClosureValue(var, body, e);
    }
}
