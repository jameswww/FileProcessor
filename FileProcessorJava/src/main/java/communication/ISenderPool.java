package main.java.communication;

import main.java.main.FixMsg;

public interface ISenderPool {
    public boolean send(FixMsg fixMsg);
}
