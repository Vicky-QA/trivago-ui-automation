package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"js_navigation\"]/div/div[1]/button/span")
    WebElement loginButton;
    @FindBy(id = "check_email")
    WebElement emailAddress;
    @FindBy(id = "login_email_submit")
    WebElement nextButton;
    @FindBy(id = "register_password")
    WebElement password;
    @FindBy(id = "register_email_submit")
    WebElement registerButton;
    @FindBy(css = "span.icon-ic:nth-child(3)")
    WebElement userIcon;
    @FindBy(linkText = "Account settings")
    WebElement accountSettings;
    @FindBy(xpath = "//*[@id='js-homepage-title']/h1/span[2]")
    WebElement verifyText;
    @FindBy(linkText = "help center")
    WebElement helpCenter;
    @FindBy(linkText = "full contact form")
    WebElement fullContactForm;
    @FindBy(id = "error-topics")
    WebElement selectTopic;
    @FindBy(xpath = "//*[@id=\"error-topics\"]//*[contains(text(),'I found an error while using trivago')]")
    WebElement selectTopicValue;
    @FindBy(id = "error-encounter")
    WebElement clickErrorType;
    @FindBy(id = "subject")
    WebElement subjectField;
    @FindBy(id = "description")
    WebElement descriptionField;
    @FindBy(name = "hotelName")
    WebElement hotelNameField;
    @FindBy(name = "bookingSite")
    WebElement bookingSiteName;
    @FindBy(xpath = "//*[@id=\"support-center\"]/div/div[3]/form/div[8]/button")
    WebElement sendMessage;
    @FindBy(id = "fileInput")
    WebElement browseButton;
    @FindBy(xpath = "//*[@id=\\\"SIvCob\\\"]")
    WebElement confirmationMsg;

    String errorType = "Incorrect location";
    String topic = "I found an error while using Trivago";
    String enterSubject = "Hotels location filter is not working";
    String enterDescription = "All the hotels irrespective of the location are getting displayed";
    String hotelName = "Azaya Beach Resort Goa";
    String bookingSite = "trivago";
    String filePath = System.getProperty("user.dir") + "/files/file.txt";
    String url = "https://www.trivago.in";

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        clickOnElement(loginButton);
    }

    public void enterEmailAddress(String value) {
        setValueForElement(emailAddress,value);
    }

    public void clickNext() {
        clickOnElement(nextButton);
    }

    public void enterPassword(String value){
       setValueForElement(password,value);
    }

    public void clickRegister(){
       clickOnElement(registerButton);
    }
    public void userIcon(){
        clickOnElement(userIcon);
    }

    public void clickAccountSettings() {
       mouseOverClick(accountSettings);
    }

    public void getTextInHomePage(){
        getTextOfElement(verifyText);
    }
     public void scrollDownToHelpCenter(){
        scrollToSeeElement(helpCenter);
     }

    public void scrollDownToFullContactForm(){
        scrollToSeeElement(fullContactForm);
    }

     public void selectTopic(){
            setDropdownValue(selectTopic,topic);
     }
    public void selectErrorType(){
        selectDropdownByText(clickErrorType,errorType);
    }

    public void enterSubject(){
        setValueForElement(subjectField,enterSubject);
    }

    public void enterDescription(){
        setValueForElement(descriptionField,enterDescription);
    }

    public void enterHotelName(){
        setValueForElement(hotelNameField,hotelName);
    }

    public void enterBookingSite(){
        setValueForElement(bookingSiteName,bookingSite);
    }

    public void clickSendMessage(){
        clickOnElement(sendMessage);
    }

    public void getConfirmationMessage(){
        getTextOfElement(confirmationMsg);
    }

    public void storeTicketId() throws IOException {
        String output = driver.findElement(By.xpath("//*[@id=\"SIvCob\"]")).getText();
        FileWriter writer = new FileWriter(filePath, true);
        writer.write(output);
    }

    public void fileUpload() throws AWTException {
        String filePath = System.getProperty("user.dir") + "\\files\\file.txt";
        File file = new File(filePath);
        System.out.println("The absolute path name is: " + file.getAbsolutePath());
        Robot rb = new Robot();
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}

