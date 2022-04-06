package org.fluidbusiness.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToCartConfirmationPopup extends BasePage{
    private By proceedToCheckoutButtonLocator = By.xpath("//a[@title='Proceed to checkout']");

    public AddToCartConfirmationPopup(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButtonLocator));
    }

    public void clickProceedToCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButtonLocator));
        WebElement proceedToCheckoutButton = driver.findElement(proceedToCheckoutButtonLocator);
        proceedToCheckoutButton.click();
    }
}
