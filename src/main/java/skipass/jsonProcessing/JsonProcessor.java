package skipass.jsonProcessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonProcessor {
    public static HashMap<String, String> readJsonFile(String filename) throws IOException, ParseException {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filename));
        HashMap<String, String> params = new HashMap<>();
        params.put("counterType", (String) jsonObject.get("counterType"));
        params.put("forWorkDay", ((Boolean) jsonObject.get("forWorkDay")).toString());
        params.put("ridesNumber", (String) jsonObject.get("ridesNumber"));
        params.put("hourBound", ((Long)jsonObject.get("hourBound")).toString());
        return params;
    }
}
