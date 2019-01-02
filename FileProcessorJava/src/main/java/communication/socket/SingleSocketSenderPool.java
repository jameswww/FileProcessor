package main.java.communication.socket;

import main.java.communication.ISenderPool;
import main.java.config.FixSimulatorConfig;
import main.java.main.FixMsg;

public class SingleSocketSenderPool implements ISenderPool {

    public SingleSocketSenderPool(FixSimulatorConfig config) {
    }

    @Override
    public boolean send(FixMsg fixMsg) {
        // TODO: to be implemented with real socket send
        System.out.println("<SingleSocketSenderPool> sending: " + fixMsg.getId() + ":  " + fixMsg.getRawMsg());
        return false;
    }
}
