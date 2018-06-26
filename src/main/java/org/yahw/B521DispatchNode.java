package org.yahw;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.dsl.ReportPolymorphism;


@ReportPolymorphism
@TypeSystemReference(YAHWTypes.class)
public abstract class B521DispatchNode extends Node {
}
