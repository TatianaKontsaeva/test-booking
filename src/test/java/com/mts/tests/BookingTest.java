package com.mts.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import com.mts.pages.HomePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.*;

@Epic("Функциональность бронирования")
@Feature("Поиск отелей")
public class BookingTest {

    @BeforeAll
    public static void setupAll() {
        System.out.println("Настройка окружения...");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
    }

    @BeforeEach
    public void setup() {
        System.out.println("Запуск теста...");
        
    }

    @Test
    @DisplayName("Тест поиска отелей в Анталье")
    @Tag("critical")
    @Description("Тест поиска отелей с фильтром пятизвездочных отелей в Анталье")
    public void testBookingSearch() {
        new HomePage()
                .openHomePage()
                .enterSearchQuery("Анталья")
                .clickSearchButton()
                .verifySearchHeaderContains("Анталья")
                .applyFiveStarFilter()
                .verifyAllHotelsAreFiveStar();
    }
    
}
