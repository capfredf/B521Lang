package org.yahw;

public class LambdaNode extends B521LangNode{
    VarNode var;
    B521LangNode body;
    public LambdaNode (String initVar, B521LangNode initBody) {
        var = new VarNode(initVar);
        body = initBody;
    }


    @Override
    public Value eval(Env e) {
        return new ClosureValue(var, body, e);
    }
}
