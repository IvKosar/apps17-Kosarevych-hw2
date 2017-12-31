package skipass.jsonProcessing;

import org.junit.Test;

import static org.junit.Assert.*;

public class JsonProcessorTest {
    @Test
    public void readJsonFile() throws Exception {
        assertEquals(4, JsonProcessor.readJsonFile(System.getProperty("user.dir") + "/data/exampleOfSkiPassParameters.json").size());
    }

}