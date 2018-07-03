package org.yahw;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;

public class ClosureValue extends Value {
    public final RootCallTarget callTarget;
    private VirtualFrame lexicalScope;
    public String slotId;


    public ClosureValue (VarNode var, B521LangNode body, VirtualFrame lexicalScope) {
        this.slotId = var.getVar();

        FrameDescriptor frameDescriptor = lexicalScope.getFrameDescriptor();
        B521LangRootNode node = new B521LangRootNode(new B521LangNode[]{body}, frameDescriptor);

        this.callTarget = Truffle.getRuntime().createCallTarget(node);
        this.lexicalScope = lexicalScope;
    }

    public RootCallTarget getCallTarget() {
        return callTarget;
    }

    public void extendEnv(Object arg) {
        FrameDescriptor frameDescriptor = this.lexicalScope.getFrameDescriptor();
        FrameSlot slot = frameDescriptor.findOrAddFrameSlot(this.slotId);
        this.lexicalScope.setObject(slot, arg);
    }
    public VirtualFrame getEnv() {
        return lexicalScope;
    }

    @Override
    public String show() {
        return null;
    }



//    public Value apply(Value arg) {
//        Env newEnv = _env.extend(_var.getVar(), arg);
//        return _body.eval(newEnv);
//    }
}
