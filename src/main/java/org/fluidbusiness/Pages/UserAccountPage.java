package org.fluidbusiness.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class UserAccountPage extends BasePage{
    private By homeLinkLocator = By.cssSelector("a.home");

    public UserAccountPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLinkLocator));
    }

    public HomePage navigateBackToHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLinkLocator));
        WebElement homeLink = driver.findElement(homeLinkLocator);
        homeLink.click();
        return HomePage.getInstanceOfHomePage(driver);
    }
}
