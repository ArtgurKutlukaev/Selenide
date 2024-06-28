package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class RegistrationTest {
    @Test
    void shouldRegisterByAccountNumberDOModification() {
        open("http://localhost:9999");
        $("[data-test-id='city']input").setValue("Казань");
        String planninDate = generateDate(4, "dd.MM.yy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date')input").setValue(planninDate);
        $("[data-test-id='name'] input").setValue("Иванов-Иваныч-Иван");
        $("[data-test-id='phone'] input").setValue("+79991309695");
        $("[data-test-id='agrement']").click();
        $("button.button").click();
        $("notification__content");
        shouldRegisterByAccountNumberDOModification(Condition.visible, Duration.ofSeconds(20));
        shouldRegisterByAccountNumberDOModification(Condition.exactText("Встреча успешно забронирована на" + planninDate));
    }

    private String generateDate(int i, String s) {

        return s;
    }

    private void shouldRegisterByAccountNumberDOModification(Condition condition) {
    }

    private void shouldRegisterByAccountNumberDOModification(Condition visible, Duration duration) {
    }


}








