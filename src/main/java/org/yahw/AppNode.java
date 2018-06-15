package org.yahw;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;

public class AppNode extends B521LangNode {
    @Child private B521LangNode _rator, _rand;
    @Child protected IndirectCallNode callNode;
    public AppNode (B521LangNode rator, B521LangNode rand) {
        _rator = rator;
        _rand = rand;
        this.callNode = Truffle.getRuntime().createIndirectCallNode();
    }

    @ExplodeLoop
    @Override
    public Value execute(VirtualFrame frame) {
        ClosureValue clos = (ClosureValue) _rator.execute(frame);
        Value arg = _rand.execute(frame);
        clos.extendEnv(arg);
        Object[] arguments= {clos.getEnv()};
        return (Value) this.callNode.call(frame, clos.callTarget, arguments);
    }

}
