/*
*
* * script to get image urls from wikipedia
*
 */



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
//    private static String url;
//    private static List<String>imageUrls = new ArrayList<String>();
//
//    public static void main(String[] args) throws IOException {
//        BirdSquareSession birdSquareSession = new BirdSquareSession();
//        List<String> birdScientificNames = new ArrayList<String>();
//        List<String> birdCommonNames = new ArrayList<String>();
//
//        for(long i=1; i<=1357;i++){
//            Bird bird = (Bird) birdSquareSession.get(Bird.class,i);
//            birdScientificNames.add(bird.getScientific_name());
//            birdCommonNames.add(bird.getCommon_name());
//        }
//
//
//        for(int i=0;i<1356;i++){
//
//            List<Page> wikiPages = getPageListOfWikiPagesForBird(birdScientificNames.get(i));
//
//            if(getImageUrl(wikiPages).equals("")){
//                wikiPages= getPageListOfWikiPagesForBird(birdCommonNames.get(i));
//            }
//            if(getImageUrl(wikiPages).equals("")){
//                imageUrls.add("/img/image_not_available.jpg");
//            }
//
//            else {
//                imageUrls.add(getImageUrl(wikiPages));
//            }
//        }
//        appendToFile(imageUrls);
//
//        for(String url:imageUrls){
//            System.out.println(url);
//        }
//    }
//
//    private static List<Page> getPageListOfWikiPagesForBird(String fileNameForBird) {
//        String pageName = "File:"+fileNameForBird+".jpg";
//
//        User user = new User("", "", "http://en.wikipedia.org/w/api.php");
//        Connector connector = new Connector();
//        user = connector.login(user);
//
////        System.out.println("PAGE-NAME: " + pageName);
//
//        return user.queryImageinfo(new String[] { pageName });
//    }
//
//    private static String getImageUrl(List<Page> pages) {
//        for (Page page : pages) {
//            if(page.getImageUrl().equals("")){
//                url= page.getImageUrl();
//            }
//            url=page.getImageUrl();
//            //send all these urls to bird tabl
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
