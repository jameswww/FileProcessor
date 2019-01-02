package main.java.communication.tibrv;

import main.java.communication.ISenderPool;
import main.java.config.FixSimulatorConfig;
import main.java.main.FixMsg;

public class SingleTibRvSenderPool implements ISenderPool {
    public SingleTibRvSenderPool(FixSimulatorConfig config) {
    }

    @Override
    public boolean send(FixMsg fixMsg) {
        // TODO: to be implemented
        return false;
    }
}
