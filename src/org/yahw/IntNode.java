package org.yahw;
public class IntNode extends B521LangNode {
    private int val;
    public IntNode(int initVal) {
        val = initVal;
    }

    @Override
    public Object eval(Env _) {
        return val;
    }
}
