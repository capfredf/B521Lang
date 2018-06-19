package org.yahw;

public class IfNode extends B521LangNode {
    private B521LangNode condNode, thenNode, elseNode;

    public IfNode(B521LangNode condNode, B521LangNode thenNode, B521LangNode elseNode) {
        this.condNode = condNode;
        this.elseNode = elseNode;
        this.thenNode = thenNode;
    }

    @Override
    public Value eval(Env frame) {
        BoolValue condV = (BoolValue) condNode.eval(frame);
        if (condV.isTrue()) {
            return thenNode.eval(frame);
        } else {
            return elseNode.eval(frame);
        }
    }
}