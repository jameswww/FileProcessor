package main.java.config;

public class FixSimulatorConfig {

    // https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html
    // https://crunchify.com/java-properties-file-how-to-read-config-properties-values-in-java/

    public void digestConfigFile(String configFilePath) {
    }

    public SenderTypes getSenderType() {
        return null;
    }

    public int getSenderPoolSize() {
        return 0;
    }

    public String getRawFixFilePath() {
        // TODO: to implement with real config
        String filePath = "/Users/jameswang/Google Drive/Mac_Sync/Projects/FileProcessor/FileProcessorJava/resources/FixTest1.txt";
        return filePath;
    }

    public static enum SenderTypes {
        Socket,
        TibRV;
    }
}
