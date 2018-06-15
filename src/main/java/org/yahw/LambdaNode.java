package org.yahw;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "lambda")
public class LambdaNode extends B521LangNode{
    @Child private VarNode var;
    @Child private B521LangNode body;

    public LambdaNode (VarNode var, B521LangNode body) {
        this.var = var;
        this.body = body;
    }


    @Override
    public Value execute(VirtualFrame frame) {
        FrameDescriptor frameDescriptor = frame.getFrameDescriptor();
        return new ClosureValue(var, body, frame);
    }
}
