package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class EditContactScreen extends BaseScreen{

    public EditContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement nameEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    MobileElement lastNameEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement emailEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    MobileElement phoneEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    MobileElement addressEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    MobileElement descriptionEditText;
    @FindBy(id = "com.sheygam.contactapp:id/updateBtn")
    MobileElement updateButton;

    public ContactListScreen submitEditContactForm(){
        updateButton.click();
        return new ContactListScreen(driver);
    }

    public EditContactScreen updateName(String text){
        waitElement(nameEditText, 3);
        type(nameEditText, text);
        return this;
    }

//    type(lastNameEditText, contact.getLastName());
//    type(emailEditText, contact.getEmail());
//    type(phoneEditText, contact.getPhone());
//    type(addressEditText, contact.getAddress());
//    type(descriptionEditText, contact.getDescription());

}