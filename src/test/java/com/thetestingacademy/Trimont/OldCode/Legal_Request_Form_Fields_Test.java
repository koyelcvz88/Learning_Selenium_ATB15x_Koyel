/*package com.thetestingacademy.Trimont.OldCode;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Epic("VenReq Automation Suite")
@Feature("Legal Request Module")
@Story("Fill Legal Request Form")
public class Legal_Request_Form_Fields_Test extends Legal_Request_Initiation_Test {

    private WebDriverWait wait;
    private Actions actions;

    // Variables to store selected data for validation later
    protected String requestType;
    protected String requestSubType;
    protected String internalCounsel;
    protected String requestSegment;
    protected String ocFeesPayer;
    protected String dueDate;

    // Initialize wait and actions
    private void initUtils() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);
    }


     * Public method to fill the entire Legal Request Form
     * Can be called from workflow runner

    @Owner("Koyel")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testcase 2 - Verify user is able to Enter Legal Request Form Fields")
    public void fillLegalRequestForm() throws InterruptedException {
        initUtils();

        // Call TC1 logic to open the form
        initiateLegalRequest();

        selectRequestType();
        Thread.sleep(2000);

        selectRequestSubType();
        Thread.sleep(2000);

        selectInternalCounsel();
        Thread.sleep(2000);

        selectRequestSegment();
        Thread.sleep(2000);

        selectOCFeesPayer();
        Thread.sleep(2000);

        selectDueDate();
        Thread.sleep(2000);
    }
    // ------------------- Individual Steps -------------------

    public void selectRequestType() {
        Allure.step("Selecting Request Type from dropdown", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[normalize-space()='---Select Request Type---']]")));
            dropdown.click();
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            requestType = "Litigation";

            // Print to console
            System.out.println("'" + requestType + "' option selected.");
            // Also log in Allure
            Allure.step("'" + requestType + "' option selected.");
        });
    }

    public void selectRequestSubType() {
        Allure.step("Selecting Request SubType from dropdown", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[contains(text(),'Select Request Sub Type')]]")));
            dropdown.click();
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            requestSubType = "CMS";

            // Print to console
            System.out.println(requestSubType + " option selected.");
            // Also log in Allure
            Allure.step(requestSubType + " option selected.");
        });
    }

    public void selectInternalCounsel() {
        Allure.step("Selecting Internal Counsel from dropdown", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[contains(text(),'Search Internal Counsel')]]")));
            dropdown.click();
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            internalCounsel = "Annie George";

            // Print to console
            System.out.println(internalCounsel + " option selected.");
            // Also log in Allure
            Allure.step(internalCounsel + " option selected.");
        });
    }

    public void selectRequestSegment() {
        Allure.step("Selecting Request Segment from dropdown", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[contains(text(),'Select Request Segment')]]")));
            dropdown.click();
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            requestSegment = "Assumptions";

            // Print to console
            System.out.println(requestSegment + " option selected.");
            // Also log in Allure
            Allure.step(requestSegment + " option selected.");
        });
    }

    public void selectOCFeesPayer() {
        Allure.step("Selecting OC Fees Payer", () -> {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@role='combobox'][.//span[contains(text(),'---Select OC Fees Payer---')]]")));
            dropdown.click();
            dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            ocFeesPayer = "Trimont";

            // Print to console
            System.out.println(ocFeesPayer + " option selected.");
            // Also log in Allure
            Allure.step(ocFeesPayer + " option selected.");
        });
    }

    public void selectDueDate() {
        Allure.step("Selecting Due Date", () -> {

            // Open the calendar
            WebElement calendarBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.DatePickerWidget---calendar_btn")));
            calendarBtn.click();

            // Get today's date
            LocalDate today = LocalDate.now();
            String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., "Saturday"
            int dayOfMonth = today.getDayOfMonth(); // e.g., 28
            String month = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., "March"
            int year = today.getYear(); // e.g., 2026

            // Construct the aria-label exactly as in your date button
            String ariaLabel = String.format("Select %s, %s %dth %d", dayOfWeek, month, dayOfMonth, year);

            // Locate the date button dynamically
            WebElement todayDateBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@aria-label='" + ariaLabel + "']")));
            todayDateBtn.click();

            dueDate = String.format("%d %s %d", dayOfMonth, month, year);

            // Print to console
            System.out.println("Date selected today: " + dueDate);
            // Also log in Allure
            Allure.step("Date selected today: " + dueDate);
        });
    }

    /* public void selectDueDate() {
        Allure.step("Selecting Due Date", () -> {
            WebElement calendarBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.DatePickerWidget---calendar_btn")));
            calendarBtn.click();

            WebElement date28 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@aria-label='Select Saturday, March 28th 2026']")));
            date28.click();
            dueDate = "28 March 2026";
            System.out.println("Date selected: " + dueDate);
        });
    } */

    // Optional @Test if I want to run TC2 standalone

   /* @Test
    public void legalRequest_Form_Fields_Test_Run() throws InterruptedException {
        fillLegalRequestForm();
    }

    @Epic("VenReq Automation Suite")
    @Feature("Legal Request Module")
    @Story("Fill Legal Request Form")
    public static class Legal_Request_Form_Fields_Test extends Legal_Request_Initiation_Test {

        private WebDriverWait wait;
        private Actions actions;

        // Variables to store selected data for validation later
        protected String requestType;
        protected String requestSubType;
        protected String internalCounsel;
        protected String requestSegment;
        protected String ocFeesPayer;
        protected String dueDate;

        // Initialize wait and actions
        private void initUtils() {
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            actions = new Actions(driver);
        }

        /**
         * Public method to fill the entire Legal Request Form
         * Can be called from workflow runner
         */
        /*@Owner("Koyel")
        @Severity(SeverityLevel.CRITICAL)
        @Description("Testcase 2 - Verify user is able to Enter Legal Request Form Fields")
        public void fillLegalRequestForm() throws InterruptedException {
            initUtils();

            // Call TC1 logic to open the form
            initiateLegalRequest();

            selectRequestType();
            Thread.sleep(2000);

            selectRequestSubType();
            Thread.sleep(2000);

            selectInternalCounsel();
            Thread.sleep(2000);

            selectRequestSegment();
            Thread.sleep(2000);

            selectOCFeesPayer();
            Thread.sleep(2000);

            selectDueDate();
            Thread.sleep(2000);
        }
        // ------------------- Individual Steps -------------------

        public void selectRequestType() {
            Allure.step("Selecting Request Type from dropdown", () -> {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='combobox'][.//span[normalize-space()='---Select Request Type---']]")));
                dropdown.click();
                actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
                requestType = "Litigation";

                // Print to console
                System.out.println("'" + requestType + "' option selected.");
                // Also log in Allure
                Allure.step("'" + requestType + "' option selected.");
            });
        }

        public void selectRequestSubType() {
            Allure.step("Selecting Request SubType from dropdown", () -> {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='combobox'][.//span[contains(text(),'Select Request Sub Type')]]")));
                dropdown.click();
                dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
                requestSubType = "CMS";

                // Print to console
                System.out.println(requestSubType + " option selected.");
                // Also log in Allure
                Allure.step(requestSubType + " option selected.");
            });
        }

        public void selectInternalCounsel() {
            Allure.step("Selecting Internal Counsel from dropdown", () -> {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='combobox'][.//span[contains(text(),'Search Internal Counsel')]]")));
                dropdown.click();
                dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
                internalCounsel = "Annie George";

                // Print to console
                System.out.println(internalCounsel + " option selected.");
                // Also log in Allure
                Allure.step(internalCounsel + " option selected.");
            });
        }

        public void selectRequestSegment() {
            Allure.step("Selecting Request Segment from dropdown", () -> {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='combobox'][.//span[contains(text(),'Select Request Segment')]]")));
                dropdown.click();
                dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
                requestSegment = "Assumptions";

                // Print to console
                System.out.println(requestSegment + " option selected.");
                // Also log in Allure
                Allure.step(requestSegment + " option selected.");
            });
        }

        public void selectOCFeesPayer() {
            Allure.step("Selecting OC Fees Payer", () -> {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='combobox'][.//span[contains(text(),'---Select OC Fees Payer---')]]")));
                dropdown.click();
                dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
                ocFeesPayer = "Trimont";

                // Print to console
                System.out.println(ocFeesPayer + " option selected.");
                // Also log in Allure
                Allure.step(ocFeesPayer + " option selected.");
            });
        }

        public void selectDueDate() {
            Allure.step("Selecting Due Date", () -> {

                // Open the calendar
                WebElement calendarBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.DatePickerWidget---calendar_btn")));
                calendarBtn.click();

                // Get today's date
                LocalDate today = LocalDate.now();
                String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., "Saturday"
                int dayOfMonth = today.getDayOfMonth(); // e.g., 28
                String month = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., "March"
                int year = today.getYear(); // e.g., 2026

                // Construct the aria-label exactly as in your date button
                String ariaLabel = String.format("Select %s, %s %dth %d", dayOfWeek, month, dayOfMonth, year);

                // Locate the date button dynamically
                WebElement todayDateBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@aria-label='" + ariaLabel + "']")));
                todayDateBtn.click();

                dueDate = String.format("%d %s %d", dayOfMonth, month, year);

                // Print to console
                System.out.println("Date selected today: " + dueDate);
                // Also log in Allure
                Allure.step("Date selected today: " + dueDate);
            });
        }

        /* public void selectDueDate() {
            Allure.step("Selecting Due Date", () -> {
                WebElement calendarBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.DatePickerWidget---calendar_btn")));
                calendarBtn.click();

                WebElement date28 = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@aria-label='Select Saturday, March 28th 2026']")));
                date28.click();
                dueDate = "28 March 2026";
                System.out.println("Date selected: " + dueDate);
            });
        } */

        // Optional @Test if I want to run TC2 standalone

       /* @Test
        public void legalRequest_Form_Fields_Test_Run() throws InterruptedException {
            fillLegalRequestForm();
        }

    }  */

    /*@Epic("VenReq Automation Suite")
    @Feature("Legal Request Module")
    @Story("Initiate Legal Request")
    public static class Legal_Request_Initiation_Test extends Login_Test {


        /**
         * Reusable method to initiate a legal request
         */
       /* @Owner("Koyel")
        @Severity(SeverityLevel.CRITICAL)
        //@Test
        @Description("Testcase 1 - Verify user is able to Login & Initiate Legal Request")
        public void initiateLegalRequest() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            Allure.step("Click on Initiate Legal Request", () -> {

                System.out.println("Looking for Initiate Legal Request button...");

                // Wait until button is visible
                WebElement initiateBtn = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//button[.//span[text()='Initiate Legal Request']]")
                        )
                );

                // Scroll to button (prevents overlay issues)
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", initiateBtn);

                // Wait until clickable
                wait.until(ExpectedConditions.elementToBeClickable(initiateBtn));

                // Print to console
                System.out.println("Button found. Clicking now.");
                // Also log in Allure
                Allure.step("Button found. Clicking now.");

                try {
                    initiateBtn.click();
                } catch (Exception e) {
                    System.out.println("Normal click intercepted, using JS click fallback.");
                    js.executeScript("arguments[0].click();", initiateBtn);
                }

                // Wait for the form header
                WebElement legalRequestFormHeader = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//span[contains(text(),'Initiate Legal Matter Request')]")
                        )
                );

                // Print to console
                System.out.println("Initiate Legal Request clicked, form loaded: "
                        + legalRequestFormHeader.getText());
                // Also log in Allure
                Allure.step("Initiate Legal Request clicked, form loaded: " );
            });
        }

    }

    @Listeners({io.qameta.allure.testng.AllureTestNg.class})
    public static class Login_Test {

        protected WebDriver driver;
        protected WebDriverWait wait;

        @BeforeClass(alwaysRun = true)
        @Description("Setup WebDriver and perform login before tests")
        public void setUpAndLogin() throws InterruptedException {
            Allure.step("Initializing WebDriver and opening login page", () -> {
                driver = new EdgeDriver();
                driver.get("https://trimont-test.appiancloud.com/suite/portal/login.jsp");
                driver.manage().window().maximize();
                Thread.sleep(5000); // Wait for page to load
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            });

            Allure.step("Entering username", () -> {
                WebElement username = driver.findElement(By.id("un"));
                username.sendKeys("AM_CMSTest");
            });

            Allure.step("Entering password", () -> {
                WebElement password = driver.findElement(By.id("pw"));
                password.sendKeys("Maantic@2026");
            });

            Allure.step("Clicking on Signin button", () -> {
                WebElement signin_btn = driver.findElement(By.id("jsLoginButton"));
                signin_btn.click();
            });

            Allure.step("Verifying if Hello username banner is valid", () -> {
                WebElement banner = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//span[@class='SizedText---large SizedText---predefined']")
                        )
                );
                String bannerText = banner.getText();
                // Log the banner text directly in Allure
                Allure.step("Banner Text: " + bannerText);
                // Print to console
                System.out.println("Banner Text: " + bannerText);
                Thread.sleep(2000);
                //Assert.assertEquals(bannerText, "Hello, AM_CMS!");
                // Assertion with try-catch to log success/failure
                try {
                    Assert.assertEquals(bannerText, "Hello, AM_CMS!");
                    // Runs only if assertion passes
                    System.out.println("Validation PASSED: Banner text is correct.");
                    Allure.step("Validation PASSED: Banner text is correct.");
                } catch (AssertionError e) {
                    // Runs if assertion fails
                    System.out.println("Validation FAILED: Banner text is incorrect.");
                    Allure.step("Validation FAILED: Banner text is incorrect.");
                    throw e; // re-throw to make the test fail
                }
            });
        }

        @AfterClass(alwaysRun = true)
        @Description("Quit WebDriver after tests")
        public void tearDown() {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed.");
            }
        }
    }

    public static class New_OC_Runner {

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
        }
    }
} */