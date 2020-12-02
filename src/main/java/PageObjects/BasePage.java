package PageObjects;

import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    WebDriver driver;

    //wait time (seconds)
    private static final int WAIT_TIME = 60;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected String getTextOfElement(WebElement element) {
        waitElementVisibility(element);
        return element.getText();
    }

    protected void clickOnElement(WebElement element) {
        waitElementClickable(element);
        element.click();
    }
    protected void clearTextOfElement(WebElement element) {
        waitElementVisibility(element);
        element.clear();
    }

    protected void setValueForElement(WebElement element, String value) {
        clearTextOfElement(element);
        element.sendKeys(value);
    }
    protected void scrollToSeeElement(WebElement element) {
        waitElementVisibility(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void mouseOverClick(WebElement firstElement) {
        Actions action = new Actions(driver);
        waitElementVisibility(firstElement);
        action.moveToElement(firstElement);
        action.click().build().perform();
    }
    protected void selectDropdownByText(WebElement dropdown, String text) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    public  void setDropdownValue(WebElement dropdown, String fieldValue) {
        Select select = new Select(dropdown);
        int index = 0;
        for (WebElement option : select.getOptions()) {
            if (option.getText().equalsIgnoreCase(fieldValue))
                break;
            index++;
        }
        select.selectByIndex(index);
    }

    public void clearTextOfElementJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value = '';", element);
    }
}