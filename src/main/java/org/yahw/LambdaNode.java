package org.yahw;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeField(name = "var", type = VarNode.class)
@NodeField(name = "body", type = B521LangNode.class)
public abstract class LambdaNode extends B521LangNode{
    protected abstract VarNode getVar();
    protected abstract B521LangNode getBody();
    protected ClosureValue closValue;

    protected boolean isSet() {
        return this.closValue != null;
    }
    @Specialization(guards = "isSet()")
    public ClosureValue getCachedClosure(VirtualFrame frame) {
        return closValue;
    }
    @Specialization(replaces = {"getCachedClosure"})
    public Object getClosure(VirtualFrame frame) {

        this.closValue = new ClosureValue(getVar(), getBody(), frame);
        return this.closValue;
    }
}
