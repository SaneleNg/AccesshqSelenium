package TrainingAccessHQ.Test;

import TrainingAccessHQ.Base.Base;
import TrainingAccessHQ.Pages.ContactDetailsPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ContactDetails extends Base {
    ContactDetailsPage addDetails  = new ContactDetailsPage();

    @Test
    public void SendContactDetails()
    {
        WebElement ValidateWelcomeMessage =  BasePage.SelectContactPage();
        String Message = ValidateWelcomeMessage.getText();
        assert(Message.contains("We welcome your feedback"));
        //Check that forname Error is displayed
        addDetails.VerifFornameErrorMessage();
        //Check that Email error is displayed
        addDetails.VerifyEmailErrorMessage();
        //Check that message error is displayed
        addDetails.VerifyMessageErrorMessage();
        //Enter Forname
        addDetails.EnterForname();
        //Email
        addDetails.EnterEmail();
        //Enter Message
        addDetails.EnterMessage();
    }

}
