package org.fluidbusiness.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{

    private By signInLinkLocator = By.cssSelector("a.login");
    private By productLinksLocator = By.cssSelector("a.product-name");

    public HomePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator));
    }

    public void clickSignInButton() {
        WebElement signInLink = wait.
                until(ExpectedConditions.elementToBeClickable(signInLinkLocator));

        signInLink.click();
    }

    public List<WebElement> getProductNameLinks() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLinksLocator));
    }
}
