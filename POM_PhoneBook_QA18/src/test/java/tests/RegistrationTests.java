package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationSuccess(){
        int i = new Random().nextInt(1000) + 1000;
        new AuthenticationScreen(driver)
                .fillEmail("emulator" + "_" + i + "@mail.com")
                .fillPassword("@AsFre266Gtr")
                .submitRegistration()
                .assertContactListActivityPresent();
    }

    @Test
    public void registrationSuccessModel() {
        int i = new Random().nextInt(1000) + 1000;
        new AuthenticationScreen(driver)
                .registration(Auth.builder()
                        .email("emulator" + "_" + i + "@mail.com")
                        .password("@AsFre266Gtr")
                        .build())
                .assertContactListActivityPresent();
    }

    @Test
    public void registrationWrongEmail(){
         new AuthenticationScreen(driver)
                .fillEmail("negativemail.com")
                .fillPassword("@AsFre266Gtr")
                .submitRegistrationNegative()
                .isErrorMessageContainsText("must be a well-formed email address");
    }
    @Test
    public void registrationWrongPassword() {
        new AuthenticationScreen(driver)
                .registrationNegative(Auth.builder()
                        .email("model@mail.com")
                        .password("AsFre266Gtr")
                        .build())
                .isErrorMessageContainsTextInAlert("passsword=");
    }


    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver).logout();
        new SplashScreen(driver);
    }


}
