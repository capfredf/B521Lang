package org.yahw;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;

public class ClosureValue extends Value {
    public final RootCallTarget callTarget;
    private MaterializedFrame lexicalScope;


    public ClosureValue (VarNode var, B521LangNode body, MaterializedFrame lexicalScope) {
        B521LangRootNode node = new B521LangRootNode(new B521LangNode[]{var, body}, new FrameDescriptor());
        this.callTarget = Truffle.getRuntime().createCallTarget(node);
        this.lexicalScope = lexicalScope;
    }

    public MaterializedFrame getLexicalScope() {
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
