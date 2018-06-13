package org.yahw;
public class IntNode extends B521LangNode{
    private int val;
    public IntNode(int initVal) {
        val = initVal;
    }

    @Override
    public Value eval(Env _) {
        return new IntValue(val);
    }
}
