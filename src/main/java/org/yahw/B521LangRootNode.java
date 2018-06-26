package org.yahw;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;

public class B521LangRootNode extends RootNode{
    @Children private final B521LangNode[] bodyNodes;
    @CompilerDirectives.CompilationFinal public String name;

    public B521LangRootNode(B521LangNode[] bodyNodes,
                            FrameDescriptor frameDescriptor) {
        super(null, frameDescriptor);
        this.bodyNodes = bodyNodes;
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frame) {
        int last = bodyNodes.length - 1;
        for (int i = 0; i < last; i ++) {
            bodyNodes[i].execute(frame);
        }
        return bodyNodes[last].execute(frame);
    }
}
