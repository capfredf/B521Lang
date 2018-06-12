package org.yahw;

public class AppNode extends Node {
    Node _rator, _rand;
    public AppNode (Node rator, Node rand) {
        _rator = rator;
        _rand = rand;
    }
    @Override
    public Value eval(Env e) {
        ClosureValue clos = (ClosureValue) _rator.eval(e);
        Value arg = _rand.eval(e);
        return clos.apply(arg);
    }
}
