///*
//*
//* * script to get image urls from wikipedia
//*
// */
//
//
//
//package WikiImages;
//
//import birdsquare.helper.BirdSquareSession;
//import birdsquare.model.Bird;
//import info.bliki.api.Connector;
//import info.bliki.api.Page;
//import info.bliki.api.User;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestWikiApi {
//    private static List<String>imageUrls = new ArrayList<String>();
//
//    public static void main(String[] args) throws IOException {
//        List<Bird>birdList;
//        birdList = new BirdSquareSession().getAll(Bird.class);
//        for(Bird bird:birdList){
//            List<Page> wikiPages = getPageListOfWikiPagesForBird(bird.getScientific_name());
//
//            if(getImageUrl(wikiPages).equals("")){
//                wikiPages= getPageListOfWikiPagesForBird(bird.getCommon_name());
//            }
//            if(getImageUrl(wikiPages).equals("")){
//                imageUrls.add("/img/image_not_available.jpg");
//            }
//            else {
//                imageUrls.add(getImageUrl(wikiPages));
//            }
//        }
//        appendToFile(imageUrls);
//
//    }
//
//    private static List<Page> getPageListOfWikiPagesForBird(String fileNameForBird) {
//        String pageName = "File:"+fileNameForBird+".jpg";
//        User user = new User("", "", "http://en.wikipedia.org/w/api.php");
//        Connector connector = new Connector();
//        user = connector.login(user);
//        return user.queryImageinfo(new String[] { pageName });
//    }
//
//    private static String getImageUrl(List<Page> pages) {
//        String url = null;
//        for (Page page : pages) {
//            url=page.getImageUrl();
//        }
//        return url;
//    }
//
//    public static void appendToFile (List<String> SarrayList) {
//
//        BufferedWriter bw = null;
//        boolean myappend = true;
//        try {
//            bw = new BufferedWriter(new FileWriter("myContent.txt", myappend));
//            for(String line: SarrayList ) {
//                bw.write(line);
//                bw.newLine();
//            }
//            bw.flush();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } finally {
//            if (bw != null) try {
//                bw.close();
//            } catch (IOException ioe2) {
//                // ignore it  or write notice
//            }
//        }
//    }
//}
