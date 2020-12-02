package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;

public class HotelBookingPage extends BasePage {

    String destinationValue = "Goa";
    String adultsCount = "1";
    String hotelName = "Azaya Beach Resort Goa";
    String lastname = "User";
    String firstname = "tourist";
    String email = "sample@qa.com";

    @FindBy(css = "#querytext")
    WebElement destinationName;

    @FindBy(xpath = "//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div/div[2]/button[3]")
    WebElement checkIn;

    @FindBy(xpath = "//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div/div[3]/button[3]/span")
    WebElement checkOut;

    @FindBy(xpath = "//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div/button[1]/span[2]")
    WebElement guestSelector;

    @FindBy(css = "#adults-input")
    WebElement guestInput;

    @FindBy(xpath = "//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div/div[4]/fieldset/ul/li[2]/button")
    WebElement applyGuestChanges;

    @FindBy(xpath = "//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div/button[2]/span[2]")
    WebElement clickOnSearch;

    @FindBy(xpath = "//*[contains(@title, 'Azaya Beach Resort Goa')]")
    WebElement searchHotel;

    @FindBy(xpath = "//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div/button[2]")
    WebElement searchResult;

    @FindBy(xpath = "//*[@id=\"8237762\"]/div/article/div[1]/div[2]/section/div[1]/article/div")
    WebElement viewDeal;

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[3]/div/div/div/div/div[2]/div[2]/div/div/div/a")
    WebElement seeAvailability;

    @FindBy(xpath = "//*[@id=\"hprt-table\"]/thead/tr/th[5]")
    WebElement navigateToReserve;

    @FindBy(xpath = "//*[@id=\"hprt-table\"]/tbody/tr[1]/td[5]/div")
    WebElement selectVillaDropDown;

    @FindBy(xpath = "//*[@id=\"hprt_nos_select_258891808_279440628_2_41_0\"]/option[2]")
    WebElement selectVillaCount;

    @FindBy(css = "div.hprt-block:nth-child(4) > div:nth-child(7) > button:nth-child(1)")
    WebElement clickIllReserve;

    @FindBy(css = "#firstname")
    WebElement firstName;

    @FindBy(css = "##lastname")
    WebElement lastName;

    @FindBy(css = "//*[@id=\"email\"]")
    WebElement emailAddress;

    @FindBy(id = "email_confirm")
    WebElement confirmEmail;

    @FindBy(xpath = "//*[@id=\"bookForm\"]/div[1]/div[3]/fieldset/label[2]")
    WebElement radioButton;

    @FindBy(xpath = "//span[contains(text(),'Next: Final details')]")
    WebElement finalDetails;

    public HotelBookingPage(WebDriver driver) {
        super(driver);
    }

    public void enterDestination() {
        setValueForElement(destinationName, destinationValue);
    }

    public void selectCheckIn() {
        clickOnElement(checkIn);
        // setValueForElement(checkIn,startDate);
    }

    public void selectCheckOut() {
        clickOnElement(checkOut);
        //   setValueForElement(checkOut,endDate);
    }

    public void selectGuests() {
        clickOnElement(guestSelector);
        clearTextOfElementJS(guestInput);
        setValueForElement(guestInput, adultsCount);
        clickOnElement(applyGuestChanges);
    }

    public void clickSearch() {
        clickOnElement(clickOnSearch);
    }

    public void isHotelAvailable() {
        WebElement element =
                driver.findElement(By.xpath("//*[contains(@title, 'Azaya Beach Resort Goa')]"));
        if (element.getText().equals("Azaya Beach Resort Goa"))
            System.out.println("Match found");
        else
            System.out.println("Match Not found");
        Assert.assertEquals(element.getText(), "Azaya Beach Resort Goa");
    }

    public void searchHotel() {
        clearTextOfElement(destinationName);
        setValueForElement(destinationName, hotelName);
        clickOnElement(searchResult);
    }

    public void clickViewDeal() {
        clickOnElement(viewDeal);
    }

    public void switchWindow() throws InterruptedException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(15000);
    }

    public void seeHotelAvailability() {
        clickOnElement(seeAvailability);
    }

    public void navigateToAccommodation() {
        scrollToSeeElement(navigateToReserve);
    }

    public void selectVilla() {
        clickOnElement(selectVillaDropDown);
        clickOnElement(selectVillaCount);
    }

    public void reserveVilla() {
        clickOnElement(clickIllReserve);
    }

    public void enterFirstName() {
        waitElementClickable(firstName);
        setValueForElement(firstName, firstname);
    }

    public void enterLastName() {
        waitElementClickable(lastName);
        setValueForElement(lastName, lastname);
    }

    public void enterEmailAddress() {
        waitElementClickable(emailAddress);
        setValueForElement(emailAddress, email);
    }

    public void confirmEmailAddress() {
        waitElementClickable(confirmEmail);
        setValueForElement(confirmEmail, email);
    }

    public void selectRadioButton() {
        scrollToSeeElement(radioButton);
        clickOnElement(radioButton);
    }

    public void finaliseDetails() {
        scrollToSeeElement(finalDetails);
        clickOnElement(finalDetails);
    }
}


