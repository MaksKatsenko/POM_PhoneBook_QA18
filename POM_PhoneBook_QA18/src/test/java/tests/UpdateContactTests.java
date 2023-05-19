package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class UpdateContactTests extends AppiumConfig {

    @BeforeClass
    public void precondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder()
                        .email("abc@def.com")
                        .password("$Abcdef12345")
                        .build());
    }

    @Test
    public void updateOneContact(){
        int i = new Random().nextInt(1000) + 1000;
        new ContactListScreen(driver)
                .updateOneContact()
                .updateName("Update " + i)
                .submitEditContactForm()
                .isContactContains("Update " + i);
    }

}
