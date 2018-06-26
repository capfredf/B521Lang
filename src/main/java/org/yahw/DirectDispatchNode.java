package org.yahw;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.Node;

public class DirectDispatchNode extends DispatchNode {
    private final CallTarget cachedCallTarget;

    @Node.Child
    private DirectCallNode callCachedTargetNode;
    @Node.Child
    private DispatchNode nextNode;

    public DirectDispatchNode(DispatchNode next, CallTarget callTarget) {
        this.cachedCallTarget = callTarget;
        this.callCachedTargetNode = Truffle.getRuntime().createDirectCallNode(
                this.cachedCallTarget);
        this.nextNode = next;
    }

    @Override
    protected Object executeDispatch(VirtualFrame frame, CallTarget callTarget,
            Object[] arguments) {
        if (this.cachedCallTarget == callTarget) {
            return this.callCachedTargetNode.call(frame, arguments);
        }
        return this.nextNode.executeDispatch(frame, callTarget, arguments);
    }
}
