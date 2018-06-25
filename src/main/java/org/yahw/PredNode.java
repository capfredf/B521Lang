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
    public Object execute(VirtualFrame frame) {
        int val = (int) this.node.execute(frame);
        if (val == 0) {
            return val;
        } else {
            return val - 1;
        }
    }
}
