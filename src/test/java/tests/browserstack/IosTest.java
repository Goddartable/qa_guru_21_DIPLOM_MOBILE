package tests.browserstack;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

public class IosTest extends TestBase {

    @Test
    @Tag("ios")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ввода \"hello@browserstack.com\"\"")
    void findHelloTextTest() {
        step("Input hello@browserstack.com", () -> {
            $(id("Text Button")).click();
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("hello@browserstack.com" + "\n");
        });
        step("Check hello@browserstack.com", () -> {
            assertThat($(id("Text Output")).getText())
                    .isEqualTo("hello@browserstack.com");
        });
    }
}