package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class NowNode extends B521LangNode {

    @Override
    public Object execute(VirtualFrame frame) {
        return (int) System.currentTimeMillis();
    }
}
