package step_implementation;

import com.thoughtworks.gauge.Step;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class PracticeFormSteps {
    private static WebDriver driver;

    @Step("Navigate to form page")
    public void navigateToFormPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Step("Enter first name <firstName>")
    public void enterFirstName(String firstName) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    @Step("Enter last name <lastName>")
    public void enterLastName(String lastName) {
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    @Step("Enter email <email>")
    public void enterEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    @Step("Enter phone number <phone>")
    public void enterPhoneNumber(String phone) {
        driver.findElement(By.id("userNumber")).sendKeys(phone);
    }

    @Step("Select gender <gender>")
    public void selectGender(String gender) {
        driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
    }

    @Step("Select date of birth <date>")
    public void selectDateOfBirth(String date) {
        driver.findElement(By.id("dateOfBirthInput")).click();
        String[] parts = date.split(" ");
        Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByVisibleText(parts[2]);
        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByVisibleText(parts[1]);
        driver.findElement(By.xpath("//div[contains(@class,'day') and text()='" + parts[0] + "']")).click();
    }

    @Step("Select subjects <subject>")
    public void selectSubjects(String subject) {
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys(subject);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    @Step("Select hobbies <hobby>")
    public void selectHobbies(String hobby) {
        String[] hobbies = hobby.split(",");
        for (String h : hobbies) {
            driver.findElement(By.xpath("//label[text()='" + h.trim() + "']")).click();
        }

    }
    @Step("Upload picture <path>")
    public void uploadPicture(String path) {
        driver.findElement(By.id("uploadPicture")).sendKeys(new File(path).getAbsolutePath());
    }

    @Step("Enter current address <address>")
    public void enterCurrentAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    @Step("Select state <state>")
    public void selectState(String state) {
        WebElement stateDropdown = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateDropdown);
        stateDropdown.click();
        driver.findElement(By.xpath("//div[text()='" + state + "']")).click();
    }

    @Step("Select city <city>")
    public void selectCity(String city) {
        WebElement cityDropdown = driver.findElement(By.id("city"));
        cityDropdown.click();
        driver.findElement(By.xpath("//div[text()='" + city + "']")).click();
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
    }

    @Step("The submission should be successful")
    public void verifySubmission() {
        WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
        if (!modalTitle.isDisplayed() || !modalTitle.getText().contains("Thanks")) {
            throw new AssertionError("Form submission failed or modal not shown.");
        }
    }
    @Step("The submission should not be successful")
    public void verifySubmissionFailed() {
        try {
            WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
            if (modalTitle.isDisplayed()) {
                throw new AssertionError("Form submission was successful despite missing required fields.");
            }
        } catch (NoSuchElementException e) {
            // Beklenen durum: modal görünmedi
            System.out.println("Modal not displayed, as expected.");
        }
    }
    @Step("Modal should not be displayed")
    public void modalShouldNotBeDisplayed() {
        try {
            WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
            if (modalTitle.isDisplayed()) {
                throw new AssertionError("Modal appeared even though email was invalid.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Modal not displayed, as expected.");
        }
    }
    @Step("Close the browser")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
