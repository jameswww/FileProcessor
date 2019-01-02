package main.java.communication.socket;

import main.java.communication.ISenderPool;
import main.java.config.FixSimulatorConfig;
import main.java.main.FixMsg;

public class MultiSocketSenderPool implements ISenderPool {

    public MultiSocketSenderPool(FixSimulatorConfig config) {
    }

    @Override
    public boolean send(FixMsg fixMsg) {
        // TODO: to be implemented
        return false;
    }
}
