package com.thetestingacademy.DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest_Ex {

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin@gmail.com", "pass123"}
        };
    }

    @Test(dataProvider = "getData")
    public void loginTest(String email, String password) {
        System.out.println(email + " | " + password);
    }
}