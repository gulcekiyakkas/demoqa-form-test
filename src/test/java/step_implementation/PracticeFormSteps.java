package step_implementation;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import pages.PracticeFormPage;
import utils.DriverManager;


public class PracticeFormSteps {
    private WebDriver driver = DriverManager.getDriver();
    private PracticeFormPage practiceFormPage = new PracticeFormPage(driver);

    @Step("Navigate to form page")
    public void navigateToFormPage() {
        practiceFormPage.navigateTo("https://demoqa.com/automation-practice-form");
    }

    @Step("Enter first name <name>")
    public void enterFirstName(String name) {
        practiceFormPage.enterFirstName(name);
    }

    @Step("Enter last name <lastName>")
    public void enterLastName(String lastName) {
        practiceFormPage.enterLastName(lastName);
    }

    @Step("Enter email <email>")
    public void enterEmail(String email) {
        practiceFormPage.enterEmail(email);
    }

    @Step("Select gender <gender>")
    public void selectGender(String gender) {
        practiceFormPage.selectGender(gender);
    }

    @Step("Enter phone number <phone>")
    public void enterPhone(String phone) {
        practiceFormPage.enterPhone(phone);
    }

    @Step("Set date of birth <day>, <month>, <year>")
    public void setDateOfBirth(String day, String month, String year) {
        practiceFormPage.setDateOfBirth(day, month, year);
    }

    @Step("Enter subject <subject>")
    public void enterSubject(String subject) {
        practiceFormPage.enterSubject(subject);
    }

    @Step("Enter multiple subjects <subjects>")
    public void enterMultipleSubjects(String subjects) {
        practiceFormPage.enterMultipleSubjects(subjects);
    }

    @Step("Select hobby <hobby>")
    public void selectHobby(String hobby) {
        practiceFormPage.selectHobby(hobby);
    }

    @Step("Select multiple hobbies <hobbies>")
    public void selectMultipleHobbies(String hobbies) {
        practiceFormPage.selectMultipleHobbies(hobbies);
    }

    @Step("Upload picture <path>")
    public void uploadPicture(String path) {
        practiceFormPage.uploadPicture(path);
    }

    @Step("Enter address <address>")
    public void enterAddress(String address) {
        practiceFormPage.enterAddress(address);
    }

    @Step("Select state <state>")
    public void selectState(String state) {
        practiceFormPage.selectState(state);
    }

    @Step("Select city <city>")
    public void selectCity(String city) {
        practiceFormPage.selectCity(city);
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        practiceFormPage.clickSubmit();
    }

    @Step("The submission should be successful")
    public void assertModalVisible() {
        practiceFormPage.assertModalVisible(true);
    }

    @Step("Modal should not be displayed")
    public void assertModalNotVisible() {
        practiceFormPage.assertModalVisible(false);
    }

    @Step("Close the browser")
    public void closeBrowser() {
        driver.quit();
    }
}
