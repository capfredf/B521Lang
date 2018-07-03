package org.yahw;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.ReportPolymorphism;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;

@ReportPolymorphism
@TypeSystemReference(YAHWTypes.class)
public abstract class DispatchNode extends Node {
    protected static final int INLINE_CACHE_SIZE = 2;

    protected abstract Object executeDispatch(ClosureValue clos, Object[] argumentValues);

    @Specialization(limit = "INLINE_CACHE_SIZE", //
            guards = "function.getCallTarget() == cachedTarget")
//            assumptions = "callTargetStable"

//    @SuppressWarnings("unused")
    protected static Object doDirect(ClosureValue function, Object[] arguments,
                                     @Cached("function.getCallTarget()") RootCallTarget cachedTarget,
                                     @Cached("create(cachedTarget)") DirectCallNode callNode) {

        /* Inline cache hit, we are safe to execute the cached call target. */
        return callNode.call(arguments);
    }

    /**
     * Slow-path code for a call, used when the polymorphic inline cache exceeded its maximum size
     * specified in <code>INLINE_CACHE_SIZE</code>. Such calls are not optimized any further, e.g.,
     * no method inlining is performed.
     */
    @Specialization(replaces = "doDirect")
    protected static Object doIndirect(ClosureValue function, Object[] arguments,
                                       @Cached("create()") IndirectCallNode callNode) {
        /*
         * SL has a quite simple call lookup: just ask the function for the current call target, and
         * call it.
         */
        return callNode.call(function.getCallTarget(), arguments);
    }
}
