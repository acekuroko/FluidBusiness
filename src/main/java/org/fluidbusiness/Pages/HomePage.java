package org.fluidbusiness.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{

    private By signInLinkLocator = By.cssSelector("a.login");
    private By productLinksLocator = By.cssSelector("a.product-name");
    private By contactUsLinkLocator = By.id("contact-link");

    private static HomePage instanceOfHomePageClass = null;

    private HomePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.elementToBeClickable(contactUsLinkLocator));
    }

    public static HomePage getInstanceOfHomePage(WebDriver driver){
        if(instanceOfHomePageClass == null){
            instanceOfHomePageClass = new HomePage(driver);
        }
        return instanceOfHomePageClass;
    }

    public LoginPage navigateToLoginPage() {
        WebElement signInLink = wait.
                until(ExpectedConditions.elementToBeClickable(signInLinkLocator));

        signInLink.click();
        return new LoginPage(driver);
    }

    public ProductDetailsPage selectProduct(int productIndex){
        List<WebElement> productList = getProductNameLinks();
        productList.get(productIndex).click();
        return new ProductDetailsPage(driver);
    }

    public ProductDetailsPage selectFirstProduct(){
        return selectProduct(0);
    }

    public List<WebElement> getProductNameLinks() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLinksLocator));
    }
}
