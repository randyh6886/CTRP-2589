package com.example.Steps;

import com.example.Base.BaseClass;
import com.example.PageObjects.A_LoginPage;
import com.example.PageObjects.B_TrialsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class searchActiveTrialsCTRP extends BaseClass {
    static WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.chrome.driver","/users/hildebrandrr/IdeaProjects/chromedriver");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("^Open Chrome and launch application$")
    public void open_chrome_and_launch_application() throws Throwable{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver();
        driver.get("https://trials-int.nci.nih.gov/");
        Thread.sleep(3000);
    }
    @When("^I enter Username and password$")
    public void i_enter_username_and_password() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        //objLoginPage=new A_LoginPage(driver);
        Thread.sleep(3000);
        loginPage.setUserName();
        loginPage.setPassword();
    }

    @When("^the website opens$")
    public void the_website_opens() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickSigninSubmit();
        Thread.sleep(4000);
    }

    @When("^I click on Protocol Abstraction$")
    public void i_click_on_protocol_abstraction() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickProtocolAbstraction();
        loginPage.clickAccept();
        Thread.sleep(4500);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

    }
    @Given("^I click on Trials Menu option$")
    public void iClickOnTrialsMenuOption() {
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickTrialsMenu();
    }

    @When("^I type active into current trial status$")
    public void i_type_active_into_current_trial_status() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.typeActiveInCurrentTrialStatus();
    }

    @Then("^I click on search$")
    public void i_click_on_search() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.clickSearch();
    }

    @Then("^I assert search results match search results$")
    public void i_assert_search_results_match_search_results() throws Throwable{
        B_TrialsPage trialsPage=new B_TrialsPage(driver);
        trialsPage.assertStep();
    }
}