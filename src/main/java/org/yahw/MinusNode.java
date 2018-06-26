package org.yahw;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.InstrumentableNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;

@TypeSystemReference(YAHWTypes.class)
@NodeInfo(shortName = "-")
@NodeChildren({@NodeChild("leftNode"), @NodeChild("rightNode")})
@GenerateNodeFactory
public abstract class MinusNode extends B521LangNode {
    @Child private B521LangNode left, right;

    @Specialization
    public int minus(int left, int right) {
        return left - right;
    }

}
