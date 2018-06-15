package org.yahw;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class VarNode extends B521LangNode {
    String var;
    public VarNode (String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }

    @Override
    public Value execute(VirtualFrame frame) {
        VirtualFrame lexicalScope = (VirtualFrame) frame.getArguments()[0];
        try {
            FrameDescriptor frameDescriptor = lexicalScope.getFrameDescriptor();
            FrameSlot slot = frameDescriptor.findFrameSlot(this.var);
            return (Value) lexicalScope.getObject(slot);
        } catch (FrameSlotTypeException e) {
            e.printStackTrace();
        }
        return null;
//        return e.lookUp(var);
    }
}
