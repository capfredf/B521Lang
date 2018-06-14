package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class AppNode extends B521LangNode {
    B521LangNode _rator, _rand;
    public AppNode (B521LangNode rator, B521LangNode rand) {
        _rator = rator;
        _rand = rand;
    }
    @Override
    public Value execute(VirtualFrame frame) {
        return null;
//        ClosureValue clos = (ClosureValue) _rator.eval(e);
//        Value arg = _rand.eval(e);
//        return clos.apply(arg);
    }

}
