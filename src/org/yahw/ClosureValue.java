package org.yahw;

public class ClosureValue extends Value {
    VarNode _var;
    Node _body;
    Env _env;

    public ClosureValue (VarNode var, Node body, Env e) {
        _var = var;
        _body = body;
        _env = e;
    }
    @Override
    public String show() {
        return null;
    }

    public Value apply(Value arg) {
        Env newEnv = _env.extend(_var.getVar(), arg);
        return _body.eval(newEnv);
    }
}
