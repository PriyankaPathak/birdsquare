package birdsquare.functional.framework;


public class Environments {
    public static final String LOCAL_BIRD_SQUARE_URL = "http://local.birdsquare.in:8080";

    public static String getHomePageUrl() {
        String homePageUrlOverride = System.getenv("BS_HOME_PAGE_URL");
        return homePageUrlOverride != null ? homePageUrlOverride : LOCAL_BIRD_SQUARE_URL;
    }
}

