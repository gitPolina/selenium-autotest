package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By searchEditBox = By.xpath("(//input[@name=\"q\"])[2]");
    private By searchButton = By.xpath("//button[@data-dot=\"search-button\"]");


    public MainPage fillSearch(String searchString) {
        webDriver.findElement(searchEditBox).sendKeys(searchString);
        return this;
    }

    public MainPage submitSearchButton() {
        webDriver.findElement(searchButton).click();
        return this;
    }

    public String getTitleByHref(String href) {
        By searchWord = By.xpath("(//a[@href='" + href + "'])[1]");
        return webDriver.findElement(searchWord).getText();
    }


}
