//package birdsquare.service;
//
//import birdsquare.model.Bird;
//import org.apache.commons.io.IOUtils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//public class WikipediaImageService {
//
//    public String getImageFileForBird(Bird bird) throws IOException {
//        String birdName_temp=bird.getScientific_name();
//        String birdName = birdName_temp.trim().replaceAll(" +", "|");
//        System.out.println(birdName);
//        String urlString = "http://en.wikipedia.org/w/api.php?action=query&titles="+birdName+"&prop=images&imlimit=1";
//        URL url = new URL(urlString);
//        URLConnection connection=url.openConnection();
//        InputStream is =connection.getInputStream();
//        String myString = IOUtils.toString(is, "UTF-8");
//
//        return myString;
//    }
//}
