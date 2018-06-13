package org.yahw;

public class Env {
    String _var;
    Value _val;
    private Env _parent;
    public Env() {
        _parent = null;
    }

    public Env(Env parent) {
        this();
        _parent = parent;
    }
    public Env extend(String var, Value val) {
        Env newEnv = new Env(this);
        newEnv._var = var;
        newEnv._val = val;
        return newEnv;
    }

    public Value lookUp(String var) {
        if (_parent == null) {
            throw new IllegalArgumentException(String.format("identifier %s is not bound", var));
        } else {
            if (var == _var) {
                return _val;
            } else {
                return _parent.lookUp(var);
            }
        }
    }
}
