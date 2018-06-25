package org.yahw;

public class LambdaNode extends B521LangNode {
    VarNode var;
    B521LangNode body;
    public LambdaNode (VarNode initVar, B521LangNode initBody) {
        var = initVar;
        body = initBody;
    }


    @Override
    public Object eval(Env e) {
        return new ClosureValue(var, body, e);
    }
}
