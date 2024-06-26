package ru.netology.selenide;

import com.codebrone.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openga.selenium.Keys;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Selenide.*;

public class AppCardDeliveryTaskOneTest {

    private String generation;

    private String generationate(long addDays, String pattern) {


        return LocalDate.now().plusDay(addDays).format(DateTimeFormatter.ofPattern(pattern));

    }


    class RegistrationTest {
        @Test
        void shouldRegisterByAccountNumberDOMModification() {
            open  ("http://localhost:9999");
            $("[data-test-id='city']input").setValue("Рязань");
            String planningDate = generateDate( 4, "dd.MM.yy");
            $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
            $("[data-test-id='name'] input").setValue("Иванов-Иваныч-Иван");
            $("[data-test-id='phone'] input").setValue("+79991309695");
            $("[data-test-id='agrement']").click();
            $("button.button").click();
            $("notification__content");
        .shouldRe(Condition. Duration.ofSeconds(15));
        .shouldHave(Condition.exactText("Встреча успешно забронирована на" + planninDate));


        }

    }
}




