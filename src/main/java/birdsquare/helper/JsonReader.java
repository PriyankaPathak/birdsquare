package birdsquare.helper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonReader {
    public String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromInputStream(InputStream inputStream) throws IOException, JSONException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String jsonText = readAll(reader);
        JSONObject json = new JSONObject(jsonText);
        return json;
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        return readJsonFromInputStream(new URL(url).openStream());
    }
}
