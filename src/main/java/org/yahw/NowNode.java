package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class NowNode extends B521LangNode {

    @Override
    public IntValue execute(VirtualFrame frame) {
        return new IntValue((int) System.currentTimeMillis());
    }
}
