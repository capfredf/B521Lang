package org.yahw;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;

public class DefineNode extends B521LangNode {
    @Child private B521LangNode valueNode;
    private String sym;

    public DefineNode(String sym, B521LangNode valueNode) {
        this.sym = sym;
        this.valueNode = valueNode;
    }
    @Override
    public Value execute(VirtualFrame frame) {
        FrameDescriptor fd = frame.getFrameDescriptor();
        FrameSlot slot = fd.addFrameSlot(this.sym);
        Value res = this.valueNode.execute(frame);
        frame.setObject(slot, res);
        return null;
    }
}
