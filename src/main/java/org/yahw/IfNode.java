package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName="if")
public class IfNode extends B521LangNode {
    @Child private B521LangNode condNode, thenNode, elseNode;

    public IfNode(B521LangNode condNode, B521LangNode thenNode, B521LangNode elseNode) {
        this.condNode = condNode;
        this.elseNode = elseNode;
        this.thenNode = thenNode;
    }
    @ExplodeLoop
    @Override
    public Object execute(VirtualFrame frame) {
        boolean condV = (boolean) condNode.execute(frame);
        if (condV) {
            return thenNode.execute(frame);
        } else {
            return elseNode.execute(frame);
        }
    }
}
