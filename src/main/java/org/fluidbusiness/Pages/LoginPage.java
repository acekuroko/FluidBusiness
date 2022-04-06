package org.fluidbusiness.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    private By emailAddressLocator = By.id("email");
    private By passwordTextboxLocator = By.id("passwd");
    private By signInButtonLocator = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
    }

    public void setEmailAddress(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
        WebElement emailTextbox = driver.findElement(emailAddressLocator);
        emailTextbox.clear();
        emailTextbox.sendKeys(emailAddress);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextboxLocator));
        WebElement passwordTextbox = driver.findElement(passwordTextboxLocator);
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));
        WebElement signInButton = driver.findElement(signInButtonLocator);
        signInButton.click();
    }
}
