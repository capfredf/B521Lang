package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class IntNode extends B521LangNode{
    private IntValue _val;
    public IntNode(int val) {
        _val = new IntValue(val);
    }

    @Override
    public Value executeIntValue(VirtualFrame frame) {
        return _val;
    }

    @Override
    public Value execute(VirtualFrame frame) {
        return _val;
    }

}
