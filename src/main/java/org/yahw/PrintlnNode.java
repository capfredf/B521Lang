package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

public class PrintlnNode extends B521LangNode {
    @Child private B521LangNode arg;

    public PrintlnNode(B521LangNode arg) {
        this.arg = arg;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        Object val = this.arg.execute(frame);
        System.out.println(val.toString());
        return null;
    }
}
