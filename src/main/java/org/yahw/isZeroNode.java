package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName="zero?")
public class isZeroNode extends B521LangNode {
    @Child private B521LangNode rand;

    public isZeroNode(B521LangNode rand) {
        this.rand = rand;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        int val = (int) this.rand.execute(frame);
        if (val == 0) {
            return true;
        } else {
            return false;
        }
//
//        return null;
    }
}
