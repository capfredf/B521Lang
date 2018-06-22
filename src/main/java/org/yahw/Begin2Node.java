package org.yahw;

import com.oracle.truffle.api.frame.VirtualFrame;

public class Begin2Node extends B521LangNode {
    @Child private B521LangNode fst, snd;
    public Begin2Node(B521LangNode fst, B521LangNode snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public Value execute(VirtualFrame frame) {
        this.fst.execute(frame);
        return this.snd.execute(frame);
    }
}
