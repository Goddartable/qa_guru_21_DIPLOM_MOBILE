package tests.browserstack;


import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Condition.visible;
import static io.appium.java_client.AppiumBy.id;

public class AndroidTest extends TestBase {
    @Test
    @Tag("android")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка поиска \"Appium\"")
    void successfulAppiumSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("android")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ошибки открытия результатов поиска \"Wikipedia\"")
    void unsuccessfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });
        step("Open article", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click();
        });

        step("Checking for error text", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldBe(visible);
        });
    }

    @Test
    @Tag("android")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка нажатия кнопки \"Меню\"")
    void findSettingsTest() {
        step("Click Menu button", () -> {
            $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Verify \"Settings\" exists", () ->
                $(id("org.wikipedia.alpha:id/explore_overflow_settings")).shouldBe(visible));
    }
}



