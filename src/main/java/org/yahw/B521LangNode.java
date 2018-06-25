package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;


public abstract class B521LangNode extends Node{
//    public abstract Value eval(Env e);
    public abstract Object execute(VirtualFrame frame);

    public Object executeInt(VirtualFrame frame)  throws UnexpectedResultException {
        return YAHWTypesGen.expectInteger(this.execute(frame));
    }

    public Object executeClosureValue(VirtualFrame frame) throws UnexpectedResultException {
        return YAHWTypesGen.expectClosureValue(this.execute(frame));
    }


}
