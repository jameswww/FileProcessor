package main.java.communication.tibrv;

import main.java.communication.ISenderPool;
import main.java.config.FixSimulatorConfig;
import main.java.main.FixMsg;

public class MultiTibRvSenderPool implements ISenderPool {
    public MultiTibRvSenderPool(FixSimulatorConfig config) {
    }

    @Override
    public boolean send(FixMsg fixMsg) {
        // TODO: to be implemented
        return false;
    }
}
