package org.yahw;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.ExplodeLoop;

@NodeField(name = "var", type = String.class)
public abstract class VarNode extends B521LangNode {
    protected abstract String getVar();

    public static interface FrameGet<T> {
        public T get(Frame frame, FrameSlot slot) throws FrameSlotTypeException;
    }

    protected FrameSlot getSlot(VirtualFrame frame) {
        return frame.getFrameDescriptor().findFrameSlot(getVar());
    }
    @Specialization(guards = "isInt(frame)")
    protected long readInt(VirtualFrame frame) {
        return (int) readVar(Frame::getInt, frame);
//        return FrameUtil.getIntSafe(frame, getSlot(frame));
    }

    @Specialization(guards = "isBoolean(frame)")
    protected boolean readBoolean(VirtualFrame frame) {
        return (boolean) readVar(Frame::getBoolean, frame);
//        return FrameUtil.getBooleanSafe(frame, getSlot(frame));
    }

    @Specialization(rewriteOn = ClassCastException.class)
    protected ClosureValue readClosure(VirtualFrame frame) {
        return (ClosureValue) readVar(Frame::getObject, frame);
    }

    protected boolean isInt(VirtualFrame frame) {
        return getSlot(frame).getKind() == FrameSlotKind.Int;
    }

    protected boolean isBoolean(VirtualFrame frame) {
        return getSlot(frame).getKind() == FrameSlotKind.Boolean;
    }

    @ExplodeLoop
    protected <T> T readVar(FrameGet<T> getter, VirtualFrame frame) {
        T result = null;
        while (result == null) {
            FrameSlot slot = getSlot(frame);
            if (slot == null) {
                throw new IllegalArgumentException(String.format("identifier %s is not bound", getVar()));
            } else {
//                if (!frame.isObject(slot)) {
//                    CompilerDirectives.transferToInterpreter();
//                    result = frame.getValue(slot);
//                    frame.setObject(slot, result);
//                    return result;
//                }
                try {
                    result = getter.get(frame, slot);
                } catch (FrameSlotTypeException e) {
                    throw new IllegalArgumentException("the slot is null");
                }
                frame = (VirtualFrame) frame.getArguments()[0];
            }
        }
        return result;
    }

    @Specialization(replaces = { "readInt", "readBoolean", "readClosure"})
    protected Object readObject(VirtualFrame frame){
        return this.readVar(Frame::getValue, frame);
    }


}
