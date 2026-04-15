package com.thetestingacademy.Trimont.OldCode;

import org.testng.annotations.Test;

public class New_OC_Runner {

    /*@Test(description = "Running New OC flow (TC1 -> TC2 -> TC4) in single browser")
    public void runWorkflow2() throws InterruptedException {

        // 1. Initialize Login
        Login_Test login = new Login_Test();
        login.setUpAndLogin();

        try {
            // 2. Run TC1 - Initiate Legal Request (workflow method)
            Legal_Request_Initiation_Test tc1 = new Legal_Request_Initiation_Test();
            tc1.driver = login.driver;
            tc1.initiateLegalRequest();  // reusable method

            // 3. Run TC2 - Fill Legal Request Form (workflow method)
            Legal_Request_Form_Fields_Test tc2 = new Legal_Request_Form_Fields_Test();
            tc2.driver = login.driver;
            tc2.fillLegalRequestForm(); // reusable method

            // 4. Run TC4 - New OC Legal Request (workflow method)
            Legal_Request_NewOC_Test tc4 = new Legal_Request_NewOC_Test();
            tc4.driver = login.driver;
            tc4.fillNewOCRequest(); // call workflow-ready method from TC4

        } finally {
            // 5. Close browser after workflow finishes
            login.tearDown();
        }
    } */
}