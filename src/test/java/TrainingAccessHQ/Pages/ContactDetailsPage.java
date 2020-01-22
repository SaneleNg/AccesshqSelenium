package TrainingAccessHQ.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactDetailsPage extends HomePage{
    private static final String Contact_Message_xpath = "//*[@id=\"app\"]/div[6]/main/div/div/div/div[1]/div/div[1]/h2";
    private static final String enter_forename_xpath = "forename";
    private static final String enter_forename_name = "forename";
    private static final String enter_surname_name = "surname";
    private static final String enter_email_name = "email";
    private static final String enter_phone_name = "telephone";
    private static final String enter_message_name = "message";
    private static final String enter_Submit_xpath = "<div class=\"v-btn__content\">Submit</div>";
    private static final String get_Submitmessage_xpath ="//*[@id=\"app\"]/div[6]/main/div/div/div/div[1]/div/div[1]/div[1]";

    private static final String get_fornameError_id = "forename-err";
    private static final String get_emailError_id = "email-err";
    private static final String get_messageError_id = "message-err";

    public void VerifFornameErrorMessage()
    {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement ContactDetailsFormMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(Contact_Message_xpath)));

        if (ContactDetailsFormMessage.isDisplayed()) {
            //enter first name
            WebElement forename = driver.findElement(By.name(enter_forename_name));
            forename.click();
            //Click Somewhere else on the page
            ContactDetailsFormMessage.click();
            //wait for error message to be displayed
//            WebElement fornameError = driver.findElement(By.id(get_fornameError_id));
            WebElement fornameError = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id(get_fornameError_id)));

            System.out.println("verify Error Forename field is displayed :  " +  fornameError.getText());

            Assert.assertTrue(fornameError.getText().contains("Forename is required"));

            assert(fornameError.getText().contains("Forename is required"));

        }

    }

    public void VerifyEmailErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement ContactDetailsFormMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(Contact_Message_xpath)));

        if (ContactDetailsFormMessage.isDisplayed()) {
            //enter first name
            WebElement Email = driver.findElement(By.name(enter_email_name));
            Email.click();
            //Click Somewhere else on the page
            ContactDetailsFormMessage.click();
            //wait for error message to be displayed
//            WebElement fornameError = driver.findElement(By.id(get_fornameError_id));
            WebElement EmailError = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id(get_emailError_id)));

            System.out.println("verify Error Email field is displayed " +  EmailError.getText());

            Assert.assertTrue(EmailError.getText().contains("Email is required"));

            assert(EmailError.getText().contains("Email is required"));

        }

    }

    public void VerifyMessageErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement ContactDetailsFormMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(Contact_Message_xpath)));

        if (ContactDetailsFormMessage.isDisplayed()) {
            //enter first name
            WebElement message = driver.findElement(By.name(enter_message_name));
            message.click();
            //Click Somewhere else on the page
            ContactDetailsFormMessage.click();
            //wait for error message to be displayed
            WebElement messageError = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id(get_messageError_id)));

            System.out.println("verify Error Message field is displayed :  " +  messageError.getText());

            Assert.assertTrue(messageError.getText().contains("Message is required"));

            assert(messageError.getText().contains("Message is required"));

        }

    }

    public void EnterForname()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement ContactDetailsFormMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(Contact_Message_xpath)));

        if (ContactDetailsFormMessage.isDisplayed()) {
            //enter first name
            WebElement forename = driver.findElement(By.name(enter_forename_name));
            forename.sendKeys("Dan");
            //wait for error message to be displayed

            int fornameError1 = driver.findElements(By.id(get_fornameError_id)).size();

            if(fornameError1 > 0)
            {
                System.out.println(" fornameError Is still displayed test failed");

            }else
            {
                System.out.println(" fornameError Is not displayed test passed");
            }

        }

    }

    public void EnterEmail()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement ContactDetailsFormMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(Contact_Message_xpath)));


        if (ContactDetailsFormMessage.isDisplayed()) {
            //enter first name
            WebElement forename = driver.findElement(By.name(enter_email_name));
            forename.sendKeys("dan@abc.com");
            //wait for error message to be displayed

            int EmailErrorCount = driver.findElements(By.id(get_emailError_id)).size();

            if(EmailErrorCount > 0)
            {
                WebElement EmailError = driver.findElement(By.id(get_emailError_id));

                System.out.println(" EmailError Is still displayed test failed");
                Assert.assertFalse(EmailError.getText().contains("Email is required"));

            }else
            {
                System.out.println(" EmailError Is not displayed test passed");
            }

        }

    }

    public void EnterMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement ContactDetailsFormMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(Contact_Message_xpath)));


        if (ContactDetailsFormMessage.isDisplayed()) {
            //enter first name
            WebElement forename = driver.findElement(By.name(enter_message_name));
            forename.sendKeys("Nice Pizza");
            //wait for error message to be displayed

            int MessageError1 = driver.findElements(By.id(get_messageError_id)).size();

            if(MessageError1 > 0)
            {
                System.out.println(" messageError Is still displayed test failed");

            }else
            {
                System.out.println(" messageError Is not displayed test passed");
            }

        }

    }

}
