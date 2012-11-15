package birdsquare.helper;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import javax.imageio.ImageReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class JsonReaderTest {

    @Test
    public void shouldReadString() throws Exception {

        String string = "some string";
        JsonReader jsonReader = new JsonReader();

        assertThat(string, is(jsonReader.readAll(new StringReader(string))));
    }

    @Test
    public void shouldConvertJsonStringIntoJsonObject() throws IOException, JSONException {
        String stubJsonstring = "{ 'id': '100004675148203','name': 'Dick Amdfgeadhbjc Sharpeson'}";
        InputStream in = new ByteArrayInputStream(stubJsonstring.getBytes());

        JsonReader jsonReader = new JsonReader();
        JSONObject jsonObject = jsonReader.readJsonFromInputStream(in);

        assertThat("100004675148203", is((String) jsonObject.get("id")));
        assertThat("Dick Amdfgeadhbjc Sharpeson", is( (String) jsonObject.get("name")));
    }
}
