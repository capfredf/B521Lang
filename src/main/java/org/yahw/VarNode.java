package org.yahw;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

public class VarNode extends B521LangNode {
    String var;
    public VarNode (String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }

    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frame) {
        Object result = null;
        VirtualFrame scope = frame;

        while (result == null) {
            FrameDescriptor frameDescriptor = scope.getFrameDescriptor();
            FrameSlot slot = frameDescriptor.findFrameSlot(this.var);
            if (slot == null) {
                throw new IllegalArgumentException(String.format("identifier %s is not bound", var));
            }
            try {
                result = scope.getObject(slot);
            } catch (FrameSlotTypeException e) {
                throw new IllegalArgumentException("slot is null...");
            }

            scope = (VirtualFrame) scope.getArguments()[0];
        }
        return result;
//        return e.lookUp(var);
    }
}
