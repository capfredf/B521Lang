package org.yahw;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;

public class AppNode extends B521LangNode {
    @Child private B521LangNode _rator, _rand;
    @Child protected DirectCallNode callNode;
    public AppNode (B521LangNode rator, B521LangNode rand) {
        _rator = rator;
        _rand = rand;

    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        ClosureValue clos = (ClosureValue) _rator.execute(frame);
        if (this.callNode == null) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            this.callNode = Truffle.getRuntime().createDirectCallNode(clos.callTarget);
        }

//        if (clos.callTarget != this.callNode.getCallTarget()) {
//            CompilerDirectives.transferToInterpreterAndInvalidate();
//            throw new UnsupportedOperationException("need to implement a proper inline cache.");
//        }

        Object arg = _rand.execute(frame);
        clos.extendEnv(arg);
        Object[] arguments= {clos.getEnv()};
        return (Object) this.callNode.call(frame, arguments);
    }

}
