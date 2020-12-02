package stepDefinitions;

import Helper.Generator;
import PageObjects.SignUpPage;
import PageObjects.HotelBookingPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelRegistration {
    SignUpPage demopage;
    HotelBookingPage hotelPage;
    String url = "https://www.trivago.in";
    private WebDriver driver;

    @Before
    public void setup() {
        String driverPath =  System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Given("^I am on the trivago homepage$")
    public void i_am_on_the_trivago_homepage() throws Throwable {
     //   driver.get(url);
    }

    @Then("^I click on the Login button and wait for sign in page$")
    public void i_click_on_the_Login_button_and_wait_for_sign_in_page() throws Throwable {
        demopage.clickLogin();
    }

    @When("^I enter the valid email address(\\d+)$")
    public void i_enter_the_valid_email_address(int arg1) throws Throwable {
        demopage.enterEmailAddress(Generator.generateEmail());
    }

    @When("^I click on next button(\\d+)$")
    public void i_click_on_next_button(int arg1) throws Throwable {
       demopage.clickNext();
    }

    @When("^I enter the valid password(\\d+)$")
    public void i_enter_the_valid_password(int arg1) throws Throwable {
        demopage.enterPassword(Generator.generatePassword());
    }

    @When("^click on the Register button(\\d+)$")
    public void click_on_the_Register_button(int arg1) throws Throwable {
        demopage.clickRegister();
    }

    @When("^I search for Goa destination$")
    public void i_search_for_Goa_destination() throws Throwable {
        hotelPage.enterDestination();
    }

    @When("^I select the checkin and checkout dates$")
    public void i_select_the_checkin_and_checkout_dates() throws Throwable {
        hotelPage.selectCheckIn();
        hotelPage.selectCheckOut();
    }

    @When("^I select the Adults count and search$")
    public void i_select_the_Adults_count_and_search() throws Throwable {
        hotelPage.selectGuests();
        hotelPage.clickSearch();
    }

    @Then("^I see Azaya Beach goa hotel is listed or not$")
    public void i_see_Azaya_Beach_goa_hotel_is_listed_or_not() throws Throwable {
        hotelPage.isHotelAvailable();
        hotelPage.searchHotel();
    }

    @Then("^I click on View Deal and see availability$")
    public void i_click_on_View_Deal_and_see_availability() throws Throwable {
        hotelPage.clickViewDeal();
        hotelPage.switchWindow();
        hotelPage.seeHotelAvailability();
    }

    @When("^I select villa with the customised options$")
    public void i_select_villa_with_the_customised_options() throws Throwable {
        hotelPage.navigateToAccommodation();
        hotelPage.selectVilla();
    }

    @Then("^I will reserve the villa and enter personal details$")
    public void i_will_reserve_the_villa_and_enter_personal_details() throws Throwable {
         hotelPage.reserveVilla();
         hotelPage.enterFirstName();
         hotelPage.enterLastName();
         hotelPage.enterEmailAddress();
         hotelPage.confirmEmailAddress();
         hotelPage.selectRadioButton();
    }

    @Then("^I will finalise the details$")
    public void i_will_finalise_the_details() throws Throwable {
        hotelPage.finaliseDetails();
    }

    @After
    public void close() throws Exception {
        driver.close();
    }
}
