package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {

    @BeforeClass
    public void preCondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder()
                        .email("abc@def.com")
                        .password("$Abcdef12345")
                        .build());
    }

    @Test
    public void addNewContactPositive(){
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Add_" + i)
                .lastName("Positive")
                .email("add_" + i + "@mail.com")
                .phone("123456" + i)
                .address("Haifa")
                .description("New Contact_" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAdded(contact)
        ;
    }

    @Test
    public void addNewContactNegativeEmptyName() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
//                .name("")
                .lastName("Negative")
                .email("emptyName" + i + "@mail.com")
                .phone("123456" + i)
                .address("Haifa")
                .description("New Contact_" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorContainsText("name=must not be blank")
        ;
    }
    @Test
    public void addNewContactNegativeEmptyPhone() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Add_" + i)
                .lastName("Negative")
                .email("emptyPhone" + i + "@mail.com")
//                .phone("")
                .address("Haifa")
                .description("New Contact_" + i)
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactFormNegative()
                .isErrorContainsText("phone=Phone number must")
        ;
    }

    @AfterClass
    public void postCondition(){
        new ContactListScreen(driver).logout();
    }

}