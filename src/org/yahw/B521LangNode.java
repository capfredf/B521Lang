package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;


public abstract class B521LangNode extends Node{
//    public abstract Value eval(Env e);
    public abstract Value execute(VirtualFrame frame);

    public Value executeIntValue(VirtualFrame frame)  throws UnexpectedResultException {
        return YAHWTypesGen.YAHWTYPES.expectIntValue(this.execute(frame));
    }

    public Value executeClosureValue(VirtualFrame frame) throws UnexpectedResultException {
        return YAHWTypesGen.YAHWTYPES.expectClosureValue(this.execute(frame));
    }


}
