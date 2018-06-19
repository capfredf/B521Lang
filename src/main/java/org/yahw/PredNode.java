package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

public class PredNode extends B521LangNode {
    @Child B521LangNode node;
    public PredNode(B521LangNode node) {
        this.node = node;
    }

    @ExplodeLoop
    @Override
    public Value execute(VirtualFrame frame) {
        Value result = this.node.execute(frame);
        if (result instanceof IntValue) {
            int val = ((IntValue) result).getVal();
            if (val == 0) {
                return ((IntValue) result);
            } else {
                return new IntValue(val - 1);
            }
        }
        return null;
    }
}
