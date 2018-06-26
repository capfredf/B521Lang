package org.yahw;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.source.Source;

import java.io.IOException;

@TruffleLanguage.Registration(name = "B521Lang", version = "0.1",
        mimeType = "application/B521-lang")
public class B521Lang extends TruffleLanguage<Object> {
    public static final B521Lang instance = new B521Lang();

    @Override
    protected Object createContext(Env env) {
        return null;
    }


    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }
}
