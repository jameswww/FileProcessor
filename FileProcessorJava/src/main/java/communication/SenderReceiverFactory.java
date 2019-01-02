package main.java.communication;

import main.java.communication.socket.MultiSocketSenderPool;
import main.java.communication.socket.SingleSocketSenderPool;
import main.java.communication.tibrv.MultiTibRvSenderPool;
import main.java.communication.tibrv.SingleTibRvSenderPool;
import main.java.config.FixSimulatorConfig;
import main.java.config.FixSimulatorConfig.SenderTypes;

import java.util.Map;

public class SenderReceiverFactory {


    public ISenderPool createSenderPool(FixSimulatorConfig config){

        ISenderPool result = null;
        if (config.getSenderType() == SenderTypes.Socket){
            if (config.getSenderPoolSize() == 1) {
                result = new SingleSocketSenderPool(config);
            } else {
                result = new MultiSocketSenderPool(config);
            }

        } else if (config.getSenderType() == SenderTypes.TibRV){
            if (config.getSenderPoolSize() == 1) {
                result = new SingleTibRvSenderPool(config);
            } else {
                result = new MultiTibRvSenderPool(config);
            }
        }

        return result;
    }

    public IReceiverPool createReceiverPool(Map<String, String> configPropertiesMap){
        return null;
    }
}
