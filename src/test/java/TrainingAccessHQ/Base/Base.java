package TrainingAccessHQ.Base;

import TrainingAccessHQ.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

public class Base {

    private static WebDriver webDriver;
    protected static HomePage BasePage;
    public static final String APP_URL = "https://d2a8fxs8dgm25.cloudfront.net/#/";

    @BeforeClass
    public static void LaunchApplication()
    {
        SetChromeDriverProperty();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("chrome.switches", Arrays.asList("--disable-local-storage"));
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        //Driver
        webDriver = new ChromeDriver(options);
        webDriver.get(APP_URL);
        BasePage = new HomePage();
        BasePage.setWebDriver(webDriver);

    }

    private static void SetChromeDriverProperty(){
        System.setProperty("webdriver.chrome.driver","C:\\MyDrivers\\chromedriver.exe");

    }

    @AfterClass
    public static void CloseApplication()
    {
        try {
            Thread.sleep(2000);
            webDriver.quit();
        }catch (InterruptedException e)
        {
          System.out.println("issue caught while closing " + e.getCause());
        }

    }


}
