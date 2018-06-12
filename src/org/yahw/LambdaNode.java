package org.yahw;

public class LambdaNode extends Node{
    VarNode var;
    Node body;
    public LambdaNode (String initVar, Node initBody) {
        var = new VarNode(initVar);
        body = initBody;
    }


    @Override
    public Value eval(Env e) {
        return new ClosureValue(var, body, e);
    }
}
