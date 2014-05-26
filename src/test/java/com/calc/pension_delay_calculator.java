package com.calc;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static com.thoughtworks.selenium.SeleneseTestBase.fail;

/**
 * Created by cubanguy on 5/24/14.
 */
public class pension_delay_calculator {

    private int year;
    private int age;
    private int salary;
    private int monthlyContribution;
    private int expectedTaxRelease;
    private int afterTaxContribution;
    private WebDriver driver; //declared
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private List<String> selection;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.bestinvest.co.uk/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("^That I click on pension delay calculator link$")
    public void That_I_click_on_pension_delay_calculator_link() throws Throwable {

        driver.get(baseUrl + "investment-tools-and-calculators/pension-delay-calculator");

        driver.switchTo().frame(0);

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector("span.calc-title"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        assertTrue(isElementPresent(By.cssSelector("span.calc-title")));

    }

    @Given("^I was born in the year (\\d+)$")
    public void I_was_born_in_the_year(int year) throws Throwable {

        this.year=year;
        driver.findElement(By.id("XLEW_2_6_4")).clear();
        driver.findElement(By.id("XLEW_2_6_4")).sendKeys(new CharSequence[]{Integer.toString(year)});
    }

    @Given("^My retirement age is (\\d+)$")
    public void My_retirement_age_is(int age) throws Throwable {
        // Express the Regexp above with the code you wish you had
        this.age=age;
        driver.findElement(By.id("XLEW_2_7_4")).clear();
        driver.findElement(By.id("XLEW_2_7_4")).sendKeys(new CharSequence[]{Integer.toString(age)});

    }

    @Given("^My Annual salary before tax is (\\d+)$")
    public void My_Annual_salary_before_tax_is(int salary) throws Throwable {
        // Express the Regexp above with the code you wish you had
        this.salary=salary;
        driver.findElement(By.id("XLEW_2_8_4")).clear();
        driver.findElement(By.id("XLEW_2_8_4")).sendKeys(new CharSequence[]{Integer.toString(salary)});

    }

  @Given("^My gross pension contribution is (\\d+)  a <selection>:$")
  public void My_gross_pension_contribution_is_a_selection(int monthlyContribution,List<String> selection) throws Throwable {
        // Express the Regexp above with the code you wish you had
        this.monthlyContribution=monthlyContribution;
        this.selection=selection;

        driver.findElement(By.id("XLEW_2_9_4")).clear();
        driver.findElement(By.id("XLEW_2_9_4")).sendKeys(new CharSequence[]{Integer.toString(monthlyContribution)});

        for(String selectMonthOrYearly:selection){

            System.out.println("My Selection is " + selectMonthOrYearly);
            Select select = new Select(driver.findElement(By.id("XLEW_2_9_5")));
            select.selectByVisibleText(selectMonthOrYearly);
        }

    }

    @Then("^Tax relief from the taxman will be (\\d+)$")
    public void Tax_relief_from_the_taxman_will_be(int expectedTaxRelease) throws Throwable {
        // Express the Regexp above with the code you wish you had
        this.expectedTaxRelease=expectedTaxRelease;
        WebElement actualTaxRelief = driver.findElement(By.id("XLEW_2_10_3"));
        String showActualTaxRelief = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        ((JavascriptExecutor) driver).executeScript(showActualTaxRelief, actualTaxRelief);
        System.out.println("actualTaxRelief==" + actualTaxRelief.getAttribute("value"));

        int responseTaxCalc=(40*monthlyContribution/100);
        assertTrue(responseTaxCalc==Integer.parseInt(actualTaxRelief.getAttribute("value").substring(1)));
        if (expectedTaxRelease!=Integer.parseInt(actualTaxRelief.getAttribute("value").substring(1))){
            fail("Expected Result does Not Match the actual actualTaxRelief of " + actualTaxRelief.getAttribute("value"));
        }


    }

    @Then("^My contribution will be (\\d+)$")
    public void My_contribution_will_be(int afterTaxContribution) throws Throwable {
        // Express the Regexp above with the code you wish you had
        this.afterTaxContribution=afterTaxContribution;

        System.out.println("afterTaxContribution" + afterTaxContribution);

        WebElement actualAfterTaxContribution=driver.findElement(By.id("XLEW_2_11_3"));
        String showHiddenTaxContribution = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        ((JavascriptExecutor) driver).executeScript(showHiddenTaxContribution, actualAfterTaxContribution);

        int actualAfterTaxContributionInt=Integer.parseInt(actualAfterTaxContribution.getAttribute("value").substring(1));
        System.out.println("actualAfterTaxContribution=="+actualAfterTaxContribution.getAttribute("value"));

        int responseCalculation=(60*monthlyContribution/100);
        assertTrue(responseCalculation==actualAfterTaxContributionInt);

        if (afterTaxContribution!=actualAfterTaxContributionInt){
            fail("Expected Result does Not Match the actual afterTaxContribution of " + actualAfterTaxContribution.getAttribute("value"));
        }



    }

    @When("^I delay starting my pension by (\\d+) years$")
    public void I_delay_starting_my_pension_by_years(int delays) throws Throwable {
        // Express the Regexp above with the code you wish you had

        driver.findElement(By.id("XLEW_2_23_4")).sendKeys(new CharSequence[]{Integer.toString(delays)});

    }

    @Then("^My total pension pot could be (\\d+)$")
    public void My_total_pension_pot_could_be(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        WebElement potPension=driver.findElement(By.id("XLEW_2_19_3"));
        String showHiddenPotPension= "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        ((JavascriptExecutor) driver).executeScript(showHiddenPotPension, potPension);
        System.out.println("potPension=="+potPension.getAttribute("value"));
    }

    @Then("^Annual pension in real terms$")
    public void Annual_pension_in_real_terms() throws Throwable {
        // Express the Regexp above with the code you wish you had
        WebElement annualPensionTerms=driver.findElement(By.id("XLEW_2_20_3"));
        String showHiddenAnnualPensionTerms= "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        ((JavascriptExecutor) driver).executeScript(showHiddenAnnualPensionTerms, annualPensionTerms);
        System.out.println("annualPensionTerms=="+annualPensionTerms.getAttribute("value"));

    }

    @Then("^My total delayed pension pot could be$")
    public void My_total_delayed_pension_pot_could_be() throws Throwable {
        // Express the Regexp above with the code you wish you had

        WebElement delayPensionPot=driver.findElement(By.id("XLEW_2_25_3"));
        String showHiddenDelayPensionPot= "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        ((JavascriptExecutor) driver).executeScript(showHiddenDelayPensionPot, delayPensionPot);
        System.out.println("delayPensionPot=="+delayPensionPot.getAttribute("value"));
    }

    @Then("^Delayed annual pension in real terms$")
    public String Delayed_annual_pension_in_real_terms() throws Throwable {
        // Express the Regexp above with the code you wish you had

        WebElement delayedAnnualPensionPot=driver.findElement(By.id("XLEW_2_25_3"));
        String showHiddenDelayedAnnualPensionPot= "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
        ((JavascriptExecutor) driver).executeScript(showHiddenDelayedAnnualPensionPot, delayedAnnualPensionPot);
        System.out.println("delayedAnnualPensionPot=="+delayedAnnualPensionPot.getAttribute("value"));

      return delayedAnnualPensionPot.getAttribute("value");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
