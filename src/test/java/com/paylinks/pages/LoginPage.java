package com.paylinks.pages;

import com.paylinks.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.paylinks.utilities.CommonUtils.VALID_USER;
import static com.paylinks.utilities.CommonUtils.VALID_USER_PSW;

public class LoginPage extends DriverManager {

    @FindBy(id = "username-i")
    private WebElement emailInputField;

    @FindBy(id = "password-i")
    private WebElement passwordInputField;

    @FindBy(id = "login-btn")
    private WebElement logInButton;

    @FindBy(id = "logout")
    private WebElement logOutIcon;

    @FindBy(css = ".alert-danger")
    private WebElement inValidUesrValidationError;

    @FindBy(css = ".info-block")
    private WebElement emailOrPasswordRequiredError;

    public void enterValidEmailAndPassword(String userType) {
        System.out.println(getUserName(userType));
        clearAndSendKeys(emailInputField, getUserName(userType));
        clearAndSendKeys(passwordInputField, getPassword(userType));
    }

    public void enterValidEmail(String email) {
        clearAndSendKeys(emailInputField, email);
    }

    public void enterValidPassword(String password) {
        clearAndSendKeys(passwordInputField, password);
    }

    public void enterIncorrectEmailAndPassword(String email, String password) {
        clearAndSendKeys(emailInputField, email);
        clearAndSendKeys(passwordInputField, password);
    }

    public void clickOnLogInButton() {
        clickOnElement(logInButton);
    }

    public boolean checkLogOutIconIsDisplayed() {
        return checkElementIsDisplayed(logOutIcon);
    }

    public String getUserName(String userType) {
        switch (userType) {
            case "Valid User":
                return VALID_USER;
            default:
                throw new IllegalStateException("Unexpected user type: " + userType);
        }
    }

    public String getPassword(String userType) {
        switch (userType) {
            case "Valid User":
                return VALID_USER_PSW;
            default:
                throw new IllegalStateException("Unexpected user type: " + userType);
        }
    }

    public String getValidationErrorMsg() {
        waitForElementVisibility(inValidUesrValidationError, 10, "Element is not visible");
        return getElementText(inValidUesrValidationError);
    }

    public String getEmailOrPasswordRequiredErrorMsg() {
        waitForElementVisibility(emailOrPasswordRequiredError, 5, "Element is not visible");
        return getElementText(emailOrPasswordRequiredError);
    }
}
