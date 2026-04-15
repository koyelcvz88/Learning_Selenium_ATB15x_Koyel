package com.thetestingacademy.Trimont.POM_Code.tests;

import com.thetestingacademy.Trimont.POM_Code.base.BaseTest;
import com.thetestingacademy.Trimont.POM_Code.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    @Feature("Login Module")
    @Story("Valid Login Flow")
    @Description("Verify user can login successfully")
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterUsername("AM_CMSTest")
                .enterPassword("Maantic@2026");

        loginPage.clickSignin();
    }
}