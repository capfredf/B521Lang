package org.yahw;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "plus")
@TypeSystemReference(YAHWTypes.class)
@NodeChildren({@NodeChild("leftNode"), @NodeChild("rightNode")})
@GenerateNodeFactory
public abstract class PlusNode extends B521LangNode {
    @Child private B521LangNode left, right;

    @Specialization
    public int plus(int left, int right) {
        return left + right;
    }

}
