package com.mts.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;

public class HomePage {
    private SelenideElement searchField = $("[name='ss']");
    private SelenideElement searchButton = $("[type='submit']");

    public HomePage openHomePage() {
        open("https://booking.com/");
        searchField.shouldBe(visible); 
        return this;
    }

    public HomePage enterSearchQuery(String query) {
        searchField.shouldBe(visible).setValue(query);
        return this;
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage();
    }
}
