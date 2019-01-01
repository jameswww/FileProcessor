package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class Main {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {


        System.out.println("Hello World!");

        // https://corp-web.b2bits.com/fixanet/doc/html/html/464a7a55-67c0-483d-95e4-18aa083715b1.htm
        // http://tutorials.jenkov.com/java-nio/path.html#creating-a-relative-path
        String fileName = "/Users/Catherine/Projects/FileProcessor/FileProcessorJava/resources/FixTest1.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {


            stream.forEach(Main::processLine);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void processLine(String rawMsg){

        FixMsg fixMsg = processRawFix(rawMsg);

        sendFixMsg(fixMsg);
    }

    private static FixMsg processRawFix(String rawMsg){
        System.out.println(rawMsg);

        FixMsg fixMsg = new FixMsg();
        fixMsg.setId(counter.incrementAndGet());
        fixMsg.setRawMsg(rawMsg);

        return fixMsg;
    }

    private static void sendFixMsg(FixMsg fixMsg){
        System.out.println(fixMsg.getId() + ":  " + fixMsg.getRawMsg());
    }


}
