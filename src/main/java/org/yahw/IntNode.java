package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class IntNode extends B521LangNode{
    private int _val;
    public IntNode(int val) {
        _val = val;
    }

    @Override
    public Object executeInt(VirtualFrame frame) {
        return _val;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return _val;
    }

}
