package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class MainPageTest {

    private WebDriver webDriver;
    private MainPage mainPage;

    @BeforeEach
    void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.seznam.cz/");
        mainPage = new MainPage(webDriver);
    }

    @Test
    void shouldFindItem() {
        //given
        String expectedResult = "Úvodní stránka - Česká pošta";
        mainPage.fillSearch("posta");
        mainPage.submitSearchButton();

        //when
        String actualResult = mainPage.getTitleByHref("https://www.ceskaposta.cz/index");

        //then
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void shutdown() {
        webDriver.quit();
    }

}