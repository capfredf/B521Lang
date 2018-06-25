package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "minus")
public class MinusNode extends B521LangNode {
    @Child private B521LangNode left, right;

    public MinusNode(B521LangNode x, B521LangNode y) {
        left = x;
        right = y;
    }

    @ExplodeLoop
    @Override
    public Value execute(VirtualFrame frame) {
        IntValue r1 = (IntValue) left.execute(frame);
        IntValue r2 = (IntValue) right.execute(frame);
        return new IntValue(r1.getVal() - r2.getVal());
    }

//     @Specialization
//     public IntValue add(IntValue r1, IntValue r2) {
//        return new IntValue(r1.getVal()+r2.getVal());
//     }
}
