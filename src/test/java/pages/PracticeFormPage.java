package pages;

import locators.PracticeFormLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PracticeFormPage {
    private final WebDriver driver;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void enterFirstName(String name) {
        driver.findElement(PracticeFormLocators.FIRST_NAME).sendKeys(name);
    }

    public void enterLastName(String lastName) {
        driver.findElement(PracticeFormLocators.LAST_NAME).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(PracticeFormLocators.EMAIL).sendKeys(email);
    }

    public void selectGender(String gender) {
        driver.findElement(PracticeFormLocators.getGenderLocator(gender)).click();
    }

    public void enterPhone(String phone) {
        driver.findElement(PracticeFormLocators.PHONE).sendKeys(phone);
    }

    public void setDateOfBirth(String day, String month, String year) {
        driver.findElement(By.id("dateOfBirthInput")).click();

        Select monthSelect = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        monthSelect.selectByVisibleText(month);

        Select yearSelect = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByVisibleText(year);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + Integer.parseInt(day) + "']")));

        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + Integer.parseInt(day) + "']")).click();
    }


    public void enterSubject(String subject) {
        WebElement subjectInput = driver.findElement(PracticeFormLocators.SUBJECTS);
        subjectInput.sendKeys(subject);
        subjectInput.sendKeys(Keys.ENTER);
    }

    public void enterMultipleSubjects(String subjects) {
        WebElement subjectInput = driver.findElement(PracticeFormLocators.SUBJECTS);
        for (String s : subjects.split(",")) {
            subjectInput.sendKeys(s.trim());
            subjectInput.sendKeys(Keys.ENTER);
        }
    }

    public void selectHobby(String hobby) {
        WebElement hobbyCheckbox = driver.findElement(PracticeFormLocators.getHobbyLocator(hobby));
        hobbyCheckbox.click();
    }


    public void selectMultipleHobbies(String hobbies) {
        for (String h : hobbies.split(",")) {
            WebElement hobbyCheckbox = driver.findElement(By.xpath("//label[text()='" + h.trim() + "']"));
            hobbyCheckbox.click();
        }
    }

    public void uploadPicture(String path) {
        driver.findElement(PracticeFormLocators.UPLOAD_PICTURE).sendKeys(new File(path).getAbsolutePath());
    }

    public void enterAddress(String address) {
        driver.findElement(PracticeFormLocators.ADDRESS).sendKeys(address);
    }

    public void selectState(String state) {
        // 1. Reklam iframe'lerini ve engelleyici div'leri kaldır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('iframe, .adplus-anchor, .elementor-popup').forEach(el => el.remove());");

        // 2. Devam et: state alanına veri gönder
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
    }


    public void selectCity(String city) {
        driver.findElement(PracticeFormLocators.CITY).click();
        WebElement cityOption = driver.findElement(By.xpath("//div[text()='" + city + "']"));
        cityOption.click();
    }

    public void clickSubmit() {
        WebElement submitButton = driver.findElement(PracticeFormLocators.SUBMIT);

        // Reklam veya başka bir öğe butonun önünde olabilir, JS ile scroll + tıklama yap
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }

    public void assertModalVisible(boolean expectedVisible) {
        boolean isVisible = !driver.findElements(PracticeFormLocators.MODAL).isEmpty();
        if (isVisible != expectedVisible) {
            throw new AssertionError("Modal visibility expected: " + expectedVisible + ", but was: " + isVisible);
        }
    }
}

