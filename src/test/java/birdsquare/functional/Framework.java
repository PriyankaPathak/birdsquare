package birdsquare.functional;

import org.openqa.selenium.WebDriver;

public class Framework {

    public static WebDriver webDriver;
    public static boolean runningInGo() {
        return (System.getenv("GO_JOB_NAME") != null);

    }

}
