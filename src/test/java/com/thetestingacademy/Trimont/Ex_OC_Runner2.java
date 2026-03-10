package com.thetestingacademy.Trimont;

import org.testng.annotations.Test;

public class Ex_OC_Runner2 {

    /*@Test(description = "Running Existing OC flow (TC1 -> TC2 -> TC3) in single browser")
    public void runWorkflow1() throws InterruptedException {

        // 1. Initialize Login
        Login_Test login = new Login_Test();
        login.setUpAndLogin();

        try {
            // 2. Run TC1 - Initiate Legal Request (workflow method)
            Legal_Request_Initiation_Test tc1 = new Legal_Request_Initiation_Test();
            tc1.driver = login.driver;
            tc1.initiateLegalRequest();  // reusable method, not @Test method

            // 3. Run TC2 - Fill Legal Request Form (workflow method)
            Legal_Request_Form_Fields_Test tc2 = new Legal_Request_Form_Fields_Test();
            tc2.driver = login.driver;
            tc2.fillLegalRequestForm(); // reusable method

            // 4. Run TC3 - Existing OC Legal Request (workflow method)
            Legal_Request_ExistingOC_Test tc3 = new Legal_Request_ExistingOC_Test();
            tc3.driver = login.driver;
            tc3.fillExistingOCRequest(); // call workflow-ready method from TC3

        } finally {
            // 5. Close browser after workflow finishes
            login.tearDown();
        }
    } */
}