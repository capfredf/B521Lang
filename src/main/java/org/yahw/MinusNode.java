package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "-")
public class MinusNode extends B521LangNode {
    @Child private B521LangNode left, right;

    public MinusNode(B521LangNode x, B521LangNode y) {
        left = x;
        right = y;
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frame) {
        int r1 = (int) left.execute(frame);
        int r2 = (int) right.execute(frame);
        return r1 - r2;
    }

}
