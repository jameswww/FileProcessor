package main.java.main;

import main.java.communication.ISenderPool;
import main.java.communication.SenderReceiverFactory;
import main.java.config.FixSimulatorConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class Main {

    private static final String CONFIG_FILE_PATH = "/Users/jameswang/Google Drive/Mac_Sync/Projects/FileProcessor/FileProcessorJava/resources/FixSimulatorConfig.properties";
    static AtomicInteger counter = new AtomicInteger(0);


    public static void main(String[] args) {
        System.out.println("Hello World!");

        // 1. load config
        FixSimulatorConfig config = new FixSimulatorConfig();
        config.digestConfigFile(CONFIG_FILE_PATH);

        // 2. get the sender pool
        SenderReceiverFactory factory = new SenderReceiverFactory();
        ISenderPool senderPool = factory.createSenderPool(config);

        // https://corp-web.b2bits.com/fixanet/doc/html/html/464a7a55-67c0-483d-95e4-18aa083715b1.htm
        // http://tutorials.jenkov.com/java-nio/path.html#creating-a-relative-path
//        String fileName = "/Users/Catherine/Projects/FileProcessor/FileProcessorJava/resources/FixTest1.txt";
//        String fileName = "/Users/jameswang/Google Drive/Mac_Sync/Projects/FileProcessor/FileProcessorJava/resources/FixTest1.txt";

        // 3. send all the messages
        String rawFixMsgFilePath = config.getRawFixFilePath();
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(rawFixMsgFilePath))) {
            stream.forEach(rawline -> {
                FixMsg fixMsg = processRawFix(rawline);
                senderPool.send(fixMsg);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static FixMsg processRawFix(String rawMsg){
        System.out.println("processing: " + rawMsg);

        FixMsg fixMsg = new FixMsg();
        fixMsg.setId(counter.incrementAndGet());
        fixMsg.setRawMsg(rawMsg);

        return fixMsg;
    }


}
