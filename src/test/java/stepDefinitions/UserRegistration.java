package stepDefinitions;

import Helper.Generator;
import PageObjects.SignUpPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UserRegistration {
    WebDriver driver;
    SignUpPage demoPage = new SignUpPage(driver);
    String url = "https://www.trivago.in";

    @Before
    public void setup() {
        String driverPath =  System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Given("I am in the homepage")
    public void i_am_in_the_homepage() throws Throwable {
        //  demoPage.setup();
    }

    @And("I click on the Login button")
    public void i_click_on_the_login_button() throws Throwable {
        demoPage.clickLogin();
    }

    @And("I enter the valid email address")
    public void i_enter_the_valid_email_address() throws Throwable {
        demoPage.enterEmailAddress(Generator.generateEmail());
    }

    @And("I click on next button")
    public void i_click_on_next_button() throws Throwable {
        demoPage.clickNext();
    }

    @And("I enter the valid password")
    public void i_enter_the_valid_password() throws Throwable {
        demoPage.enterPassword(Generator.generatePassword());
    }

    @When("I click on the Register button")
    public void i_click_on_the_register_button() throws Throwable {
        demoPage.clickRegister();
    }

    @Then("^I access the account settings$")
    public void i_access_the_account_settings() throws Throwable {
        demoPage.userIcon();
        demoPage.clickAccountSettings();
        demoPage.scrollDownToHelpCenter();
    }

    @And("^I select the topic$")
    public void i_select_the_topic() throws Throwable {
        demoPage.selectTopic();
    }

    @When("^I send a message by providing all the details$")
    public void i_send_a_message_by_providing_all_the_details() throws Throwable {
        demoPage.selectErrorType();
        demoPage.enterSubject();
        demoPage.enterDescription();
        demoPage.scrollDownToFullContactForm();
        demoPage.enterHotelName();
        demoPage.enterBookingSite();
        demoPage.fileUpload();
    }

    @Then("^I should see a confirmation message$")
    public void i_should_see_a_confirmation_message() throws Throwable {
        demoPage.getConfirmationMessage();
    }

    @And("^I store the ticket id$")
    public void i_store_the_ticket_id() throws Throwable {
        demoPage.storeTicketId();
    }

    @After
    public void close() throws Exception {
        driver.close();
    }
}
