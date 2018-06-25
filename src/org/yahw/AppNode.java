package org.yahw;

public class AppNode extends B521LangNode {
    B521LangNode _rator, _rand;
    public AppNode(B521LangNode rator, B521LangNode rand) {
        _rator = rator;
        _rand = rand;
    }
    @Override
    public Object eval(Env e) {
        ClosureValue clos = (ClosureValue) _rator.eval(e);
        Object arg = _rand.eval(e);
        return clos.apply(arg);
    }
}
