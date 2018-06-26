package org.yahw;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class AppNode extends B521LangNode {
    @Child private B521LangNode _rator, _rand;
    @Child protected IndirectCallNode callNode;
    @Child protected DispatchNode dispatchNode;
    public AppNode (B521LangNode rator, B521LangNode rand) {
        _rator = rator;
        _rand = rand;
        dispatchNode = new UninitializedDispatchNode();

    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        ClosureValue clos;
        try {
            clos = (ClosureValue) _rator.executeClosureValue(frame);
        } catch (UnexpectedResultException e) {
            throw new UnsupportedSpecializationException(this,
                    new B521LangNode[] {_rator}, e);
        }
        this.callNode = Truffle.getRuntime().createIndirectCallNode();
        CompilerAsserts.compilationConstant(1);
//        if (this.callNode == null) {
//            CompilerDirectives.transferToInterpreterAndInvalidate();
//
//        }

//        if (clos.callTarget != this.callNode.getCallTarget()) {
//            CompilerDirectives.transferToInterpreterAndInvalidate();
//            throw new UnsupportedOperationException("need to implement a proper inline cache.");
//        }

        Object arg = _rand.execute(frame);
        clos.extendEnv(arg);
        Object[] arguments= {clos.getEnv()};
//        return this.dispatchNode.executeDispatch(frame,
//                clos.callTarget, arguments);
        return (Object) this.callNode.call(clos.callTarget, arguments);
    }

}
