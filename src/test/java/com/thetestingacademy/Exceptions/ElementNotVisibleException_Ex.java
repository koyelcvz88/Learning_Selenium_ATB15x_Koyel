package com.thetestingacademy.Exceptions;

public class ElementNotVisibleException_Ex {
    /*EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify ElementNotVisible Exception")
    @Test
    public void test_actions() {
        try {
            driver.get("https://google.com");
            driver.manage().window().maximize();
            // Wait until the search box is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("hidden-element"))); // wrong xpath

            WebElement hiddenElement = driver.findElement(By.id("hidden-element"));
            hiddenElement.click();

        } catch (ElementNotVisibleException e) {
            System.out.println("ElementNotVisibleException caught!");
            System.out.println("Element not visible: " + e);
        }
        System.out.println("End of the Program");
    }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    } */

}
