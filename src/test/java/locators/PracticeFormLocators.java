package locators;

import org.openqa.selenium.By;

public class PracticeFormLocators {
    public static final By FIRST_NAME = By.id("firstName");
    public static final By LAST_NAME = By.id("lastName");
    public static final By EMAIL = By.id("userEmail");
    public static By getGenderLocator(String gender) {
        return By.xpath("//label[text()='" + gender + "']");
    }
    public static final By PHONE = By.id("userNumber");
    public static final By DATE_OF_BIRTH = By.id("dateOfBirthInput");
    public static final By SUBJECTS = By.id("subjectsInput");
    public static By getHobbyLocator(String hobby) {
        return By.xpath("//label[text()='" + hobby + "']");
    }
    public static final By UPLOAD_PICTURE = By.id("uploadPicture");
    public static final By ADDRESS = By.id("currentAddress");
    public static final By STATE = By.id("react-select-3-input");
    public static final By CITY = By.id("react-select-4-input");
    public static final By SUBMIT = By.id("submit");
    public static final By MODAL = By.className("modal-content");
}
