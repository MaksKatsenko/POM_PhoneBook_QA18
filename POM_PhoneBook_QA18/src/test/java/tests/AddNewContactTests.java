package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {

    @BeforeMethod
    public void preCondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder()
                .email("abc@def.com")
                .password("$Abchj12345")
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
                .submitContactForm();
    }

}
