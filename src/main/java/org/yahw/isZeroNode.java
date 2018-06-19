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
    public Value execute(VirtualFrame frame) {
        Value result = this.rand.execute(frame);
        if (result instanceof IntValue) {
            int val = ((IntValue) result).getVal();
            if (val == 0) {
                return new BoolValue(true);
            } else {
                return new BoolValue(false);
            }
        }
        return null;
    }
}
