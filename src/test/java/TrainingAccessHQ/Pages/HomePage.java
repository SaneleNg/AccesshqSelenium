package TrainingAccessHQ.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    protected static WebDriver driver;
    private static final String Menu_bar_xpath = "//*[@id=\"app\"]/div[6]/nav/div";
    private static final String Contact_button_xpath = "//*[@id=\"app\"]/div[6]/nav/div/div[2]/a[4]";
    private static final String Contact_Message_xpath = "//*[@id=\"app\"]/div[6]/main/div/div/div/div[1]/div/div[1]/h2";

    public static void setWebDriver(WebDriver driver) {
        HomePage.driver = driver;
    }

    public WebElement SelectContactPage(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,20);
            Thread.sleep(5000);
            WebElement MenuBar = driver.findElement(By.xpath(Menu_bar_xpath));

            if(MenuBar.isDisplayed())
            {
                System.out.println("Contact Menu item is displayed");
                WebElement ContactMenuItem = driver.findElement(By.xpath(Contact_button_xpath));

                if(ContactMenuItem.isDisplayed())
                {
                    System.out.println("Contact Menu item Button is displayed");
                    ContactMenuItem.click();

                    WebElement Contact_Page = driver.findElement(By.xpath(Contact_Message_xpath));

                    wait.until(
                            ExpectedConditions.visibilityOf(Contact_Page));

                    return Contact_Page;

                }else
                {
                    System.out.println("Contact Menu item is  Not displayed");
                }
            }else
            {
                System.out.println("Contact Menu bar is Not displayed");
            }

        }catch (InterruptedException e){
            System.out.println("could not select the item " + e.getCause());
        }
        return null;
    }


}
